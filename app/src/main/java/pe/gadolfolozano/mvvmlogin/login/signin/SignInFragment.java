package pe.gadolfolozano.mvvmlogin.login.signin;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import pe.gadolfolozano.mvvmlogin.BR;
import pe.gadolfolozano.mvvmlogin.R;
import pe.gadolfolozano.mvvmlogin.base.BaseFragment;
import pe.gadolfolozano.mvvmlogin.databinding.FragmentSignInBinding;

/**
 * Created by adolfo on 10/03/18.
 */

public class SignInFragment extends BaseFragment<FragmentSignInBinding, SignInViewModel> implements SignInNavigator{

    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    private SignInViewModel mSignInViewModel;

    public static SignInFragment newInstance() {
        Bundle args = new Bundle();
        SignInFragment fragment = new SignInFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_sign_in;
    }

    @Override
    public SignInViewModel getViewModel() {
        mSignInViewModel = ViewModelProviders.of(this, mViewModelFactory).get(SignInViewModel.class);
        return mSignInViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSignInViewModel.setNavigator(this);
    }
}
