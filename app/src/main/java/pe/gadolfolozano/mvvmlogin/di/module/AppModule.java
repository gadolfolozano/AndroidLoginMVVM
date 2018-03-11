package pe.gadolfolozano.mvvmlogin.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pe.gadolfolozano.mvvmlogin.data.DataManager;
import pe.gadolfolozano.mvvmlogin.data.DataManagerImplements;
import pe.gadolfolozano.mvvmlogin.data.local.preferences.PreferenceHelper;
import pe.gadolfolozano.mvvmlogin.data.local.preferences.PreferenceHelperImplements;
import pe.gadolfolozano.mvvmlogin.data.remote.ApiHelper;
import pe.gadolfolozano.mvvmlogin.data.remote.ApiHelperImplements;
import pe.gadolfolozano.mvvmlogin.di.PreferenceInfo;
import pe.gadolfolozano.mvvmlogin.util.Constants;

/**
 * Created by adolfo on 9/03/18.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiHelperImplements apiHelperImplements) {
        return apiHelperImplements;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DataManagerImplements dataManagerImplements) {
        return dataManagerImplements;
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return Constants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferenceHelper(PreferenceHelperImplements preferenceHelperImplements) {
        return preferenceHelperImplements;
    }

}
