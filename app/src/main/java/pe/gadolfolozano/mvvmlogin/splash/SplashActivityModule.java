package pe.gadolfolozano.mvvmlogin.splash;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adolfo on 10/03/18.
 */

@Module
public class SplashActivityModule {
    @Provides
    SplashViewModel provideSplashViewModel() {
        return new SplashViewModel();
    }
}
