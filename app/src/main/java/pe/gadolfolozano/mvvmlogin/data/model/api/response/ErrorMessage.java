package pe.gadolfolozano.mvvmlogin.data.model.api.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by adolfo on 10/03/18.
 */

public class ErrorMessage implements Serializable {
    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
