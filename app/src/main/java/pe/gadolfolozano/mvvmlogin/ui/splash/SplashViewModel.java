package pe.gadolfolozano.mvvmlogin.ui.splash;

import android.os.Handler;

import pe.gadolfolozano.mvvmlogin.base.BaseViewModel;
import pe.gadolfolozano.mvvmlogin.data.DataManager;

/**
 * Created by adolfo on 10/03/18.
 */

public class SplashViewModel extends BaseViewModel<SplashNavigator> {
    public SplashViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void startApp() {
        int secondsDelayed = 2;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                decideNextActivity();
            }
        }, secondsDelayed * 1000l);
    }

    private void decideNextActivity() {
        getNavigator().openLoginActivity();
    }

}
