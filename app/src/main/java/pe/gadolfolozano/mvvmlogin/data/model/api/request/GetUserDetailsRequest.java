package pe.gadolfolozano.mvvmlogin.data.model.api.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by adolfo on 11/03/18.
 */

public class GetUserDetailsRequest implements Serializable {
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
