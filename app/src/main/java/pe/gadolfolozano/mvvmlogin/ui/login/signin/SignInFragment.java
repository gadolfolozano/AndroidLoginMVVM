package pe.gadolfolozano.mvvmlogin.ui.login.signin;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import pe.gadolfolozano.mvvmlogin.BR;
import pe.gadolfolozano.mvvmlogin.R;
import pe.gadolfolozano.mvvmlogin.base.BaseFragment;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.SignInSuccesResponse;
import pe.gadolfolozano.mvvmlogin.databinding.FragmentSignInBinding;
import pe.gadolfolozano.mvvmlogin.ui.login.LoginActivity;
import pe.gadolfolozano.mvvmlogin.ui.model.BaseModelLiveData;

/**
 * Created by adolfo on 10/03/18.
 */

public class SignInFragment extends BaseFragment<FragmentSignInBinding, SignInViewModel> implements SignInNavigator {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    private SignInViewModel mSignInViewModel;

    private FragmentSignInBinding mBinding;

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

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        mBinding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSingInClicked();
            }
        });
        mBinding.btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateAccountClicked();
            }
        });
    }

    private void onSingInClicked() {
        showLoading();
        hideKeyboard();
        String username = mBinding.edtUserName.getText().toString();
        String password = mBinding.edtPassword.getText().toString();
        mSignInViewModel.singIn(username, password).observe(this, new Observer<BaseModelLiveData<SignInSuccesResponse>>() {
            @Override
            public void onChanged(@Nullable BaseModelLiveData<SignInSuccesResponse> liveData) {
                hideLoading();
                if(liveData.isSuccesfull()){
                    mSignInViewModel.saveToken(liveData.getData().getSession().getToken());
                } else if(liveData.getErrorMessage()!=null){
                    Toast.makeText(getContext(), liveData.getErrorMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), R.string.error_message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void onCreateAccountClicked() {
        navigateToCreateAccount();
    }


    @Override
    public void navigateToCreateAccount() {
        if (getActivity() instanceof LoginActivity) {
            ((LoginActivity) getActivity()).goToCreateAccount();
        }
    }

    @Override
    public void navigatetoMain() {
        if (getActivity() instanceof LoginActivity) {
            ((LoginActivity) getActivity()).openMainActivity();
        }
    }
}
