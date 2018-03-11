package pe.gadolfolozano.mvvmlogin.ui.splash;

import pe.gadolfolozano.mvvmlogin.base.BaseViewModel;
import pe.gadolfolozano.mvvmlogin.data.DataManager;

/**
 * Created by adolfo on 10/03/18.
 */

public class SplashViewModel extends BaseViewModel<SplashNavigator> {
    public SplashViewModel(DataManager dataManager) {
        super(dataManager);
    }

    private void decideNextActivity() {
        getNavigator().openLoginActivity();
    }


    public void startApp() {
        String token = getDataManager().getUserToken();

        if(token == null){
            getNavigator().openLoginActivity();
        }else {
            getNavigator().openMainActivity();
        }
    }
}
