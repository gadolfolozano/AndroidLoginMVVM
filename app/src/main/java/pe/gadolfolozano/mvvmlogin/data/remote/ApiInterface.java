package pe.gadolfolozano.mvvmlogin.data.remote;

import pe.gadolfolozano.mvvmlogin.data.model.api.request.SignInRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.BaseResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by adolfo on 10/03/18.
 */

public interface ApiInterface {
    @POST("auth/authUser")
    Call<BaseResponse> postSignIn(@Body SignInRequest signInRequest);
}
