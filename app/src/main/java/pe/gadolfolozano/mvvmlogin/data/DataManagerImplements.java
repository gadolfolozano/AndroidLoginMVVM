package pe.gadolfolozano.mvvmlogin.data;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import pe.gadolfolozano.mvvmlogin.data.local.preferences.PreferenceHelper;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.CreateAccountSuccessResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.GetUserDetailsSuccessResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.SignInSuccesResponse;
import pe.gadolfolozano.mvvmlogin.data.remote.ApiHelper;
import pe.gadolfolozano.mvvmlogin.ui.model.BaseModelLiveData;

/**
 * Created by adolfo on 11/03/18.
 */
@Singleton
public class DataManagerImplements implements DataManager {

    private ApiHelper mApiHelper;
    private PreferenceHelper mPreferenceHelper;
    private Context mContext;

    @Inject
    public DataManagerImplements(Context context, ApiHelper apiHelper, PreferenceHelper preferenceHelper) {
        this.mContext = context;
        this.mApiHelper = apiHelper;
        this.mPreferenceHelper = preferenceHelper;
    }

    @Override
    public LiveData<BaseModelLiveData<SignInSuccesResponse>> singIn(String username, String password) {
        return mApiHelper.singIn(username, password);
    }

    @Override
    public LiveData<BaseModelLiveData<CreateAccountSuccessResponse>> createAccount(String username, String password) {
        return mApiHelper.createAccount(username, password);
    }

    @Override
    public LiveData<BaseModelLiveData<GetUserDetailsSuccessResponse>> getUserDetails(String token) {
        return mApiHelper.getUserDetails(token);
    }


    @Override
    public String getUserToken() {
        return mPreferenceHelper.getUserToken();
    }

    @Override
    public void saveUserToken(String token) {
        mPreferenceHelper.saveUserToken(token);
    }
}
