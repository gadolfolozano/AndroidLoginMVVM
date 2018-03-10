package pe.gadolfolozano.mvvmlogin.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

/**
 * Created by adolfo on 10/03/18.
 */

public abstract class BaseViewModel<N> extends ViewModel {

    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);
    private N mNavigator;

    public BaseViewModel() {
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public N getNavigator() {
        return mNavigator;
    }

    public void setNavigator(N navigator) {
        this.mNavigator = navigator;
    }
}
