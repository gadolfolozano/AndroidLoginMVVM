package pe.gadolfolozano.mvvmlogin.ui.login.createaccount;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by adolfo on 10/03/18.
 */
@Module
public abstract class CreateAccountFragmentProvider {
    @ContributesAndroidInjector(modules = CreateAccountFragmentModule.class)
    abstract CreateAccountFragment provideCreateAccountFragmentFactory();
}
