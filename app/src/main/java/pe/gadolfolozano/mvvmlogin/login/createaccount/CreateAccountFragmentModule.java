package pe.gadolfolozano.mvvmlogin.login.createaccount;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import pe.gadolfolozano.mvvmlogin.ViewModelProviderFactory;

/**
 * Created by adolfo on 10/03/18.
 */

@Module
public class CreateAccountFragmentModule {
    @Provides
    CreateAccountViewModel createAccountViewModel() {
        return new CreateAccountViewModel();
    }

    @Provides
    ViewModelProvider.Factory provideCreateAccountViewModel(CreateAccountViewModel createAccountViewModel) {
        return new ViewModelProviderFactory<>(createAccountViewModel);
    }
}
