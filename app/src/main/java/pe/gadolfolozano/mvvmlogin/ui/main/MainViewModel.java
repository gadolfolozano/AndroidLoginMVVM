package pe.gadolfolozano.mvvmlogin.ui.main;

import android.arch.lifecycle.LiveData;

import pe.gadolfolozano.mvvmlogin.base.BaseViewModel;
import pe.gadolfolozano.mvvmlogin.data.DataManager;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.GetUserDetailsSuccessResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.UpdateUserDetailsSuccessResponse;
import pe.gadolfolozano.mvvmlogin.ui.model.BaseModelLiveData;

/**
 * Created by adolfo on 10/03/18.
 */

public class MainViewModel extends BaseViewModel<MainNavigator> {
    public MainViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public LiveData<BaseModelLiveData<GetUserDetailsSuccessResponse>> loadUserInfo() {
        String token = getDataManager().getUserToken();
        return getDataManager().getUserDetails(token);
    }

    public void signOut() {
        getDataManager().saveUserToken(null);
        getNavigator().openLoginActivity();
    }

    public LiveData<BaseModelLiveData<UpdateUserDetailsSuccessResponse>> updateUserInfo(String firstName, String lastName, String password) {
        String token = getDataManager().getUserToken();
        return getDataManager().updateUserDetails(token, firstName, lastName, password);
    }
}
