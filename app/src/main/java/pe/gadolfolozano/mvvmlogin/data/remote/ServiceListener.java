package pe.gadolfolozano.mvvmlogin.data.remote;

/**
 * Created by adolfo on 10/03/18.
 */

public interface ServiceListener<T> {
    void onSucess(T response);

    void onError(Throwable t);
}