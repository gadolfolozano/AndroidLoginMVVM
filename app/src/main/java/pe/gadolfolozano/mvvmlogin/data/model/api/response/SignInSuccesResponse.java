package pe.gadolfolozano.mvvmlogin.data.model.api.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by adolfo on 11/03/18.
 */

public class SignInSuccesResponse implements Serializable {
    @SerializedName("session")
    private SessionResponse session;

    public SessionResponse getSession() {
        return session;
    }

    public void setSession(SessionResponse session) {
        this.session = session;
    }
}
