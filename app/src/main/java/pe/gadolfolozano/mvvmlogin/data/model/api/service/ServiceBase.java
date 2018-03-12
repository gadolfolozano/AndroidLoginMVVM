package pe.gadolfolozano.mvvmlogin.data.model.api.service;

import android.util.Log;

import com.google.gson.Gson;

import pe.gadolfolozano.mvvmlogin.data.model.api.response.ErrorMessage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by adolfo on 10/03/18.
 */

public abstract class ServiceBase<T> {

    private ServiceListener<T> serviceListener;

    public ServiceListener<T> getServiceListener() {
        return serviceListener;
    }

    public void setServiceListener(ServiceListener<T> serviceListener) {
        this.serviceListener = serviceListener;
    }

    protected ServiceBase() {
        //Do Nothing
    }

    public void execute() {
        Call<T> call = createCall();
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (serviceListener != null) {
                    if (response.isSuccessful() && response.body() != null) {
                        serviceListener.onSucess(response.body());
                    } else if (response.errorBody() != null) {

                        ErrorMessage errorMessage = null;
                        try {
                            errorMessage = new Gson().fromJson(response.errorBody().charStream(), ErrorMessage.class);
                            errorMessage.setCode(response.code());
                        } catch (Exception e) {
                            Log.d("singIn", "Exception " + e);
                            //Do nothing
                        }
                        if (errorMessage == null) {
                            serviceListener.onError(new Exception());
                        } else {
                            serviceListener.onErrorHandled(errorMessage);
                        }
                    } else {
                        serviceListener.onError(new Exception());
                    }
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                call.cancel();
                if (serviceListener != null) {
                    serviceListener.onError(t);
                }
            }
        });
    }

    protected abstract Call<T> createCall();

    protected ApiInterface getAPIInterface() {
        return ApiClient.getClient().create(ApiInterface.class);
    }
}