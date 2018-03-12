package pe.gadolfolozano.mvvmlogin.data.model.api.service;

import pe.gadolfolozano.mvvmlogin.data.model.api.request.CreateAccountRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.CreateAccountSuccessResponse;
import retrofit2.Call;

/**
 * Created by adolfo on 11/03/18.
 */

public class PostCreateAccountService extends ServiceBase<CreateAccountSuccessResponse> {

    CreateAccountRequest body;

    public void setBody(CreateAccountRequest body) {
        this.body = body;
    }

    @Override
    protected Call<CreateAccountSuccessResponse> createCall() {
        return getAPIInterface().postCreateAccount(body);
    }
}
