package pe.gadolfolozano.mvvmlogin.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import pe.gadolfolozano.mvvmlogin.ui.login.LoginActivity;
import pe.gadolfolozano.mvvmlogin.ui.login.LoginActivityModule;
import pe.gadolfolozano.mvvmlogin.ui.login.createaccount.CreateAccountFragmentProvider;
import pe.gadolfolozano.mvvmlogin.ui.login.signin.SignInFragmentProvider;
import pe.gadolfolozano.mvvmlogin.ui.main.MainActivity;
import pe.gadolfolozano.mvvmlogin.ui.main.MainActivityModule;
import pe.gadolfolozano.mvvmlogin.ui.splash.SplashActivity;
import pe.gadolfolozano.mvvmlogin.ui.splash.SplashActivityModule;

/**
 * Created by adolfo on 9/03/18.
 */
@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = {
            LoginActivityModule.class,
            SignInFragmentProvider.class,
            CreateAccountFragmentProvider.class})
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();
}
