package pe.gadolfolozano.mvvmlogin.ui.model;

/**
 * Created by adolfo on 11/03/18.
 */

public class BaseModelLiveData<T> {
    private boolean succesfull;
    private String errorMessage;
    private T data;

    public boolean isSuccesfull() {
        return succesfull;
    }

    public void setSuccesfull(boolean succesfull) {
        this.succesfull = succesfull;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
