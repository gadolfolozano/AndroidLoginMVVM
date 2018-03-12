package pe.gadolfolozano.mvvmlogin.data.model.api.service;

import pe.gadolfolozano.mvvmlogin.data.model.api.request.GetUserDetailsRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.GetUserDetailsSuccessResponse;
import retrofit2.Call;

/**
 * Created by adolfo on 11/03/18.
 */

public class PostGetUserDetailsService extends ServiceBase<GetUserDetailsSuccessResponse> {

    GetUserDetailsRequest body;

    public PostGetUserDetailsService() {

    }

    public void setBody(GetUserDetailsRequest body) {
        this.body = body;
    }

    @Override
    protected Call<GetUserDetailsSuccessResponse> createCall() {
        return getAPIInterface().postGetUserDetails(body);
    }
}
