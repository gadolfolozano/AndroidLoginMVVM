package pe.gadolfolozano.mvvmlogin.data.model.api.service;

import pe.gadolfolozano.mvvmlogin.data.model.api.request.SignInRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.SignInSuccesResponse;
import retrofit2.Call;

/**
 * Created by adolfo on 10/03/18.
 */

public class PostSignInService extends ServiceBase<SignInSuccesResponse> {

    SignInRequest body;

    public void setBody(SignInRequest body) {
        this.body = body;
    }

    @Override
    protected Call<SignInSuccesResponse> createCall() {
        return getAPIInterface().postSignIn(body);
    }
}
