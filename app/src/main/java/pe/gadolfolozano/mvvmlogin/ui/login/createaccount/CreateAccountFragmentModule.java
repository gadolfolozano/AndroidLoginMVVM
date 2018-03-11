package pe.gadolfolozano.mvvmlogin.ui.login.createaccount;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import pe.gadolfolozano.mvvmlogin.ViewModelProviderFactory;
import pe.gadolfolozano.mvvmlogin.data.DataManager;

/**
 * Created by adolfo on 10/03/18.
 */

@Module
public class CreateAccountFragmentModule {
    @Provides
    CreateAccountViewModel createAccountViewModel(DataManager dataManager) {
        return new CreateAccountViewModel(dataManager);
    }

    @Provides
    ViewModelProvider.Factory provideCreateAccountViewModel(CreateAccountViewModel createAccountViewModel) {
        return new ViewModelProviderFactory<>(createAccountViewModel);
    }
}
