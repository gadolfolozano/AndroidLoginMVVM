package pe.gadolfolozano.mvvmlogin.data.model.api.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by adolfo on 10/03/18.
 */

public class BaseResponse implements Serializable {
    @SerializedName("message")
    private String message;
}
