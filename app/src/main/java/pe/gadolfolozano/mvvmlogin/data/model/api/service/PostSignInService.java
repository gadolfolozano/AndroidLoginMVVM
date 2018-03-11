package pe.gadolfolozano.mvvmlogin.data.model.api.service;

import pe.gadolfolozano.mvvmlogin.data.model.api.request.SignInRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.BaseResponse;
import pe.gadolfolozano.mvvmlogin.data.remote.ServiceBase;
import retrofit2.Call;

/**
 * Created by adolfo on 10/03/18.
 */

public class PostSignInService extends ServiceBase<BaseResponse> {

    SignInRequest body;

    public PostSignInService() {

    }

    public void setBody(SignInRequest body) {
        this.body = body;
    }

    @Override
    protected Call<BaseResponse> createCall() {
        return getAPIInterface().postSignIn(body);
    }
}
