package pe.gadolfolozano.mvvmlogin.data.model.api.service;

import pe.gadolfolozano.mvvmlogin.data.model.api.request.CreateAccountRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.request.GetUserDetailsRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.request.SignInRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.request.UpdateUserDetailsRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.CreateAccountSuccessResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.GetUserDetailsSuccessResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.SignInSuccesResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.UpdateUserDetailsSuccessResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by adolfo on 10/03/18.
 */

public interface ApiInterface {
    @POST("auth/authUser")
    Call<SignInSuccesResponse> postSignIn(@Body SignInRequest request);

    @POST("user/create")
    Call<CreateAccountSuccessResponse> postCreateAccount(@Body CreateAccountRequest request);

    @POST("user/getDetails")
    Call<GetUserDetailsSuccessResponse> postGetUserDetails(@Body GetUserDetailsRequest request);

    @POST("user/update")
    Call<UpdateUserDetailsSuccessResponse> postUpdateUserDetails(@Body UpdateUserDetailsRequest request);
}
