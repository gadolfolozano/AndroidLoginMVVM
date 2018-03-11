package pe.gadolfolozano.mvvmlogin.ui.login.signin;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import pe.gadolfolozano.mvvmlogin.ViewModelProviderFactory;
import pe.gadolfolozano.mvvmlogin.data.DataManager;

/**
 * Created by adolfo on 10/03/18.
 */

@Module
public class SignInFragmentModule {
    @Provides
    SignInViewModel signInViewModel(DataManager dataManager) {
        return new SignInViewModel(dataManager);
    }

    @Provides
    ViewModelProvider.Factory providesignInViewModel(SignInViewModel signInViewModel) {
        return new ViewModelProviderFactory<>(signInViewModel);
    }
}
