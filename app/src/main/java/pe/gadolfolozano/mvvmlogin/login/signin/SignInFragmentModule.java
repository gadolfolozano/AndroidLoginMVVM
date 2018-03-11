package pe.gadolfolozano.mvvmlogin.login.signin;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import pe.gadolfolozano.mvvmlogin.ViewModelProviderFactory;

/**
 * Created by adolfo on 10/03/18.
 */

@Module
public class SignInFragmentModule {
    @Provides
    SignInViewModel signInViewModel() {
        return new SignInViewModel();
    }

    @Provides
    ViewModelProvider.Factory providesignInViewModel(SignInViewModel signInViewModel) {
        return new ViewModelProviderFactory<>(signInViewModel);
    }
}
