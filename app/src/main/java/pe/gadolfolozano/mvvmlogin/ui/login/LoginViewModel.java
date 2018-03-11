package pe.gadolfolozano.mvvmlogin.ui.login;

import pe.gadolfolozano.mvvmlogin.base.BaseViewModel;
import pe.gadolfolozano.mvvmlogin.data.DataManager;

/**
 * Created by adolfo on 10/03/18.
 */

public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    public LoginViewModel(DataManager dataManager) {
        super(dataManager);
    }
}
