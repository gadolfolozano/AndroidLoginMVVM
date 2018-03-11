package pe.gadolfolozano.mvvmlogin.data.remote;

import android.arch.lifecycle.LiveData;

import pe.gadolfolozano.mvvmlogin.data.model.api.response.CreateAccountSuccessResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.SignInSuccesResponse;
import pe.gadolfolozano.mvvmlogin.ui.model.BaseModelLiveData;

/**
 * Created by adolfo on 11/03/18.
 */

public interface ApiHelper {
    LiveData<BaseModelLiveData<SignInSuccesResponse>> singIn(String username, String password);

    LiveData<BaseModelLiveData<CreateAccountSuccessResponse>> createAccount(String username, String password);
}
