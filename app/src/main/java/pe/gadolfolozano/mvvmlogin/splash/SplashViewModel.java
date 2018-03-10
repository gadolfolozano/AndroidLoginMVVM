package pe.gadolfolozano.mvvmlogin.splash;

import android.os.Handler;

import pe.gadolfolozano.mvvmlogin.base.BaseViewModel;

/**
 * Created by adolfo on 10/03/18.
 */

public class SplashViewModel extends BaseViewModel<SplashNavigator> {
    public SplashViewModel() {
        super();
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
