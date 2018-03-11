package pe.gadolfolozano.mvvmlogin.data;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import pe.gadolfolozano.mvvmlogin.data.model.api.response.CreateAccountSuccessResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.SignInSuccesResponse;
import pe.gadolfolozano.mvvmlogin.data.remote.ApiHelper;
import pe.gadolfolozano.mvvmlogin.ui.model.BaseModelLiveData;

/**
 * Created by adolfo on 11/03/18.
 */
@Singleton
public class DataManagerImplements implements DataManager {

    private ApiHelper mApiHelper;
    private Context mContext;

    @Inject
    public DataManagerImplements(Context context, ApiHelper apiHelper) {
        this.mContext = context;
        this.mApiHelper = apiHelper;
    }

    @Override
    public LiveData<BaseModelLiveData<SignInSuccesResponse>> singIn(String username, String password) {
        return mApiHelper.singIn(username, password);
    }

    @Override
    public LiveData<BaseModelLiveData<CreateAccountSuccessResponse>> createAccount(String username, String password) {
        return mApiHelper.createAccount(username, password);
    }


}
