package pe.gadolfolozano.mvvmlogin.data.model.api.service;

import pe.gadolfolozano.mvvmlogin.data.model.api.request.UpdateUserDetailsRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.UpdateUserDetailsSuccessResponse;
import retrofit2.Call;

/**
 * Created by adolfo on 11/03/18.
 */

public class PostUpdateUserDetailsService extends ServiceBase<UpdateUserDetailsSuccessResponse> {

    UpdateUserDetailsRequest body;

    public PostUpdateUserDetailsService() {

    }

    public void setBody(UpdateUserDetailsRequest body) {
        this.body = body;
    }

    @Override
    protected Call<UpdateUserDetailsSuccessResponse> createCall() {
        return getAPIInterface().postUpdateUserDetails(body);
    }
}
