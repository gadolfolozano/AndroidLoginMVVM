package pe.gadolfolozano.mvvmlogin.ui.main;

import dagger.Module;
import dagger.Provides;
import pe.gadolfolozano.mvvmlogin.data.DataManager;

/**
 * Created by adolfo on 10/03/18.
 */

@Module
public class MainActivityModule {
    @Provides
    MainViewModel provideMainViewModel(DataManager dataManager) {
        return new MainViewModel(dataManager);
    }
}
