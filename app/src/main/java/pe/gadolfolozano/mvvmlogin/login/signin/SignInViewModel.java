package pe.gadolfolozano.mvvmlogin.login.signin;

import android.util.Log;

import pe.gadolfolozano.mvvmlogin.base.BaseViewModel;
import pe.gadolfolozano.mvvmlogin.data.model.api.request.SignInRequest;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.BaseResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.service.PostSignInService;
import pe.gadolfolozano.mvvmlogin.data.remote.ServiceListener;

/**
 * Created by adolfo on 10/03/18.
 */

public class SignInViewModel extends BaseViewModel<SignInNavigator> {
    public SignInViewModel() {
        super();
    }

    public void singIn(String username, String password) {
        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setUsername(username);
        signInRequest.setPassword(password);
        PostSignInService postSignInService = new PostSignInService();
        postSignInService.setBody(signInRequest);
        postSignInService.setServiceListener(new ServiceListener<BaseResponse>() {
            @Override
            public void onSucess(BaseResponse response) {
                getNavigator().singInSucces();
            }

            @Override
            public void onError(Throwable t) {
                getNavigator().singInError();
            }
        });
        postSignInService.execute();
    }
}
