package pe.gadolfolozano.mvvmlogin.login.createaccount;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import pe.gadolfolozano.mvvmlogin.login.signin.SignInFragment;
import pe.gadolfolozano.mvvmlogin.login.signin.SignInFragmentModule;

/**
 * Created by adolfo on 10/03/18.
 */
@Module
public abstract class CreateAccountFragmentProvider {
    @ContributesAndroidInjector(modules = CreateAccountFragmentModule.class)
    abstract CreateAccountFragment provideCreateAccountFragmentFactory();
}
