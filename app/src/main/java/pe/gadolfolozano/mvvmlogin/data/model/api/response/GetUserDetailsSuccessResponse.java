package pe.gadolfolozano.mvvmlogin.data.model.api.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by adolfo on 11/03/18.
 */

public class GetUserDetailsSuccessResponse implements Serializable {
    @SerializedName("user")
    private UserResponse user;

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
