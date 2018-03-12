package pe.gadolfolozano.mvvmlogin.ui.login.createaccount;

import android.arch.lifecycle.LiveData;

import pe.gadolfolozano.mvvmlogin.base.BaseViewModel;
import pe.gadolfolozano.mvvmlogin.data.DataManager;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.CreateAccountSuccessResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.SignInSuccesResponse;
import pe.gadolfolozano.mvvmlogin.ui.model.BaseModelLiveData;

/**
 * Created by adolfo on 10/03/18.
 */

public class CreateAccountViewModel extends BaseViewModel<CreateAccountNavigator> {
    public CreateAccountViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public LiveData<BaseModelLiveData<CreateAccountSuccessResponse>> createAccount(String username, String password) {
        return getDataManager().createAccount(username, password);
    }

    public LiveData<BaseModelLiveData<SignInSuccesResponse>> singIn(String username, String password) {
        return getDataManager().singIn(username, password);
    }

    public void saveToken(String token) {
        getDataManager().saveUserToken(token);
        getNavigator().navigatetoMain();
    }
}
