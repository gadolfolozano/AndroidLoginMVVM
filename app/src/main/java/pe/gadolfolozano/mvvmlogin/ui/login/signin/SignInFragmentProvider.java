package pe.gadolfolozano.mvvmlogin.ui.login.signin;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by adolfo on 10/03/18.
 */
@Module
public abstract class SignInFragmentProvider {
    @ContributesAndroidInjector(modules = SignInFragmentModule.class)
    abstract SignInFragment provideSignInFragmentFactory();
}
