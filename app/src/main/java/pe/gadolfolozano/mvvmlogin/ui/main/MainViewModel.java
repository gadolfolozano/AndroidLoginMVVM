package pe.gadolfolozano.mvvmlogin.ui.main;

import pe.gadolfolozano.mvvmlogin.base.BaseViewModel;
import pe.gadolfolozano.mvvmlogin.data.DataManager;

/**
 * Created by adolfo on 10/03/18.
 */

public class MainViewModel extends BaseViewModel<MainNavigator> {
    public MainViewModel(DataManager dataManager) {
        super(dataManager);
    }
}
