package pe.gadolfolozano.mvvmlogin.data.model.api.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by adolfo on 10/03/18.
 */

public class SignInRequest implements Serializable {
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
