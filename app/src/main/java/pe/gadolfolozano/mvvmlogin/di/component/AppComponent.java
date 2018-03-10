package pe.gadolfolozano.mvvmlogin.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import pe.gadolfolozano.mvvmlogin.MVVMLoginApp;
import pe.gadolfolozano.mvvmlogin.di.builder.ActivityBuilder;
import pe.gadolfolozano.mvvmlogin.di.module.AppModule;

/**
 * Created by adolfo on 9/03/18.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MVVMLoginApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
