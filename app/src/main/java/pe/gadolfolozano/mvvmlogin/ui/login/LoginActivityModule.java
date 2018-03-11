package pe.gadolfolozano.mvvmlogin.ui.login;

import dagger.Module;
import dagger.Provides;
import pe.gadolfolozano.mvvmlogin.data.DataManager;

/**
 * Created by adolfo on 10/03/18.
 */

@Module
public class LoginActivityModule {
    @Provides
    LoginViewModel provideLoginViewModel(DataManager dataManager) {
        return new LoginViewModel(dataManager);
    }
}
