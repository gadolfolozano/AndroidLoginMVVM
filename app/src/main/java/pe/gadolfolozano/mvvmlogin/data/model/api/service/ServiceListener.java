package pe.gadolfolozano.mvvmlogin.data.model.api.service;

import pe.gadolfolozano.mvvmlogin.data.model.api.response.ErrorMessage;

/**
 * Created by adolfo on 10/03/18.
 */

public interface ServiceListener<T> {
    void onSucess(T response);

    void onError(Throwable t);

    void onErrorHandled(ErrorMessage errorHandle);
}