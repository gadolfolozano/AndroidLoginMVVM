package pe.gadolfolozano.mvvmlogin.ui.splash;

import dagger.Module;
import dagger.Provides;
import pe.gadolfolozano.mvvmlogin.data.DataManager;

/**
 * Created by adolfo on 10/03/18.
 */

@Module
public class SplashActivityModule {
    @Provides
    SplashViewModel provideSplashViewModel(DataManager dataManager) {
        return new SplashViewModel(dataManager);
    }
}
