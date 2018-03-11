package pe.gadolfolozano.mvvmlogin.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import pe.gadolfolozano.mvvmlogin.BR;
import pe.gadolfolozano.mvvmlogin.R;
import pe.gadolfolozano.mvvmlogin.base.BaseActivity;
import pe.gadolfolozano.mvvmlogin.databinding.ActivityLoginBinding;
import pe.gadolfolozano.mvvmlogin.login.createaccount.CreateAccountFragment;
import pe.gadolfolozano.mvvmlogin.login.signin.SignInFragment;

/**
 * Created by adolfo on 10/03/18.
 */

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    LoginViewModel mLoginViewModel;

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        return mLoginViewModel;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginViewModel.setNavigator(this);
        setUp();
    }

    private void setUp() {
        goToSignIn();
    }

    @Override
    public void openMainActivity() {

    }

    @Override
    public void goToSignIn() {
        SignInFragment signInFragment = SignInFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, signInFragment)
                .commitAllowingStateLoss();
    }

    @Override
    public void goToCreateAccount() {
        CreateAccountFragment createAccountFragment = CreateAccountFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, createAccountFragment)
                .commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment != null && fragment instanceof CreateAccountFragment) {
            goToSignIn();
            return;
        }

        super.onBackPressed();
    }
}
