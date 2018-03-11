package pe.gadolfolozano.mvvmlogin.data.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import javax.inject.Inject;
import javax.inject.Singleton;

import pe.gadolfolozano.mvvmlogin.data.model.api.request.CreateAccountRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.request.SignInRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.CreateAccountSuccessResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.ErrorMessage;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.SignInSuccesResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.service.PostCreateAccountService;
import pe.gadolfolozano.mvvmlogin.data.model.api.service.PostSignInService;
import pe.gadolfolozano.mvvmlogin.data.model.api.service.ServiceListener;
import pe.gadolfolozano.mvvmlogin.ui.model.BaseModelLiveData;

/**
 * Created by adolfo on 11/03/18.
 */
@Singleton
public class ApiHelperImplements implements ApiHelper {

    @Inject
    public ApiHelperImplements() {

    }

    @Override
    public LiveData<BaseModelLiveData<SignInSuccesResponse>> singIn(String username, String password) {
        final MutableLiveData<BaseModelLiveData<SignInSuccesResponse>> data = new MutableLiveData<>();

        final BaseModelLiveData<SignInSuccesResponse> liveDataObj = new BaseModelLiveData<>();

        SignInRequest request = new SignInRequest();
        request.setPassword(password);
        request.setUsername(username);
        PostSignInService service = new PostSignInService();
        service.setBody(request);
        service.setServiceListener(new ServiceListener<SignInSuccesResponse>() {
            @Override
            public void onSucess(SignInSuccesResponse response) {
                liveDataObj.setSuccesfull(true);
                liveDataObj.setData(response);
                data.setValue(liveDataObj);
            }

            @Override
            public void onErrorHandled(ErrorMessage errorHandle) {
                liveDataObj.setSuccesfull(false);
                liveDataObj.setErrorMessage(errorHandle.getMessage());
                data.setValue(liveDataObj);
            }

            @Override
            public void onError(Throwable t) {
                liveDataObj.setSuccesfull(false);
                data.setValue(liveDataObj);
            }
        });
        service.execute();
        return data;
    }

    @Override
    public LiveData<BaseModelLiveData<CreateAccountSuccessResponse>> createAccount(String username, String password) {
        final MutableLiveData<BaseModelLiveData<CreateAccountSuccessResponse>> data = new MutableLiveData<>();

        final BaseModelLiveData<CreateAccountSuccessResponse> liveDataObj = new BaseModelLiveData<>();

        CreateAccountRequest request = new CreateAccountRequest();
        request.setPassword(password);
        request.setUsername(username);
        PostCreateAccountService service = new PostCreateAccountService();
        service.setBody(request);
        service.setServiceListener(new ServiceListener<CreateAccountSuccessResponse>() {
            @Override
            public void onSucess(CreateAccountSuccessResponse response) {
                liveDataObj.setSuccesfull(true);
                liveDataObj.setData(response);
                data.setValue(liveDataObj);
            }

            @Override
            public void onErrorHandled(ErrorMessage errorHandle) {
                liveDataObj.setSuccesfull(false);
                liveDataObj.setErrorMessage(errorHandle.getMessage());
                data.setValue(liveDataObj);
            }

            @Override
            public void onError(Throwable t) {
                liveDataObj.setSuccesfull(false);
                data.setValue(liveDataObj);
            }
        });
        service.execute();
        return data;
    }
}
