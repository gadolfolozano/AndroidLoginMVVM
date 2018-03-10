package pe.gadolfolozano.mvvmlogin.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import pe.gadolfolozano.mvvmlogin.splash.SplashActivity;
import pe.gadolfolozano.mvvmlogin.splash.SplashActivityModule;

/**
 * Created by adolfo on 9/03/18.
 */
@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();
}
