package pe.gadolfolozano.mvvmlogin.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adolfo on 10/03/18.
 */

@Module
public class LoginActivityModule {
    @Provides
    LoginViewModel provideLoginViewModel() {
        return new LoginViewModel();
    }
}
