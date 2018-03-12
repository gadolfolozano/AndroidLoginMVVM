package pe.gadolfolozano.mvvmlogin.ui.login.createaccount;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import pe.gadolfolozano.mvvmlogin.BR;
import pe.gadolfolozano.mvvmlogin.R;
import pe.gadolfolozano.mvvmlogin.base.BaseFragment;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.CreateAccountSuccessResponse;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.SignInSuccesResponse;
import pe.gadolfolozano.mvvmlogin.databinding.FragmentCreateAccountBinding;
import pe.gadolfolozano.mvvmlogin.ui.login.LoginActivity;
import pe.gadolfolozano.mvvmlogin.ui.model.BaseModelLiveData;

/**
 * Created by adolfo on 10/03/18.
 */

public class CreateAccountFragment extends BaseFragment<FragmentCreateAccountBinding, CreateAccountViewModel> implements CreateAccountNavigator {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    private CreateAccountViewModel mCreateAccountViewModel;
    FragmentCreateAccountBinding mBinding;

    public static CreateAccountFragment newInstance() {
        Bundle args = new Bundle();
        CreateAccountFragment fragment = new CreateAccountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_create_account;
    }

    @Override
    public CreateAccountViewModel getViewModel() {
        mCreateAccountViewModel = ViewModelProviders.of(this, mViewModelFactory).get(CreateAccountViewModel.class);
        return mCreateAccountViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCreateAccountViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        mBinding.btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateAccountClicked();
            }
        });
        mBinding.edtPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                hideKeyboard();
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    onCreateAccountClicked();
                }
                textView.clearFocus();
                return false;
            }
        });
    }

    private void onCreateAccountClicked() {
        showLoading();
        hideKeyboard();
        String username = mBinding.edtUserName.getText().toString();
        String password = mBinding.edtPassword.getText().toString();
        mCreateAccountViewModel.createAccount(username, password).observe(this, new Observer<BaseModelLiveData<CreateAccountSuccessResponse>>() {
            @Override
            public void onChanged(@Nullable BaseModelLiveData<CreateAccountSuccessResponse> liveData) {
                if (liveData.isSuccesfull()) {
                    Toast.makeText(getContext(), liveData.getData().getMessage(), Toast.LENGTH_LONG).show();
                    signIn();
                } else if (liveData.getErrorMessage() != null) {
                    hideLoading();
                    Toast.makeText(getContext(), liveData.getErrorMessage(), Toast.LENGTH_LONG).show();
                } else {
                    hideLoading();
                    Toast.makeText(getContext(), R.string.error_message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void signIn() {
        String username = mBinding.edtUserName.getText().toString();
        String password = mBinding.edtPassword.getText().toString();
        mCreateAccountViewModel.singIn(username, password).observe(this, new Observer<BaseModelLiveData<SignInSuccesResponse>>() {
            @Override
            public void onChanged(@Nullable BaseModelLiveData<SignInSuccesResponse> liveData) {
                hideLoading();
                if (liveData.isSuccesfull()) {
                    mCreateAccountViewModel.saveToken(liveData.getData().getSession().getToken());
                } else if (liveData.getErrorMessage() != null) {
                    Toast.makeText(getContext(), liveData.getErrorMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), R.string.error_message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void navigatetoMain() {
        if (getActivity() instanceof LoginActivity) {
            ((LoginActivity) getActivity()).openMainActivity();
        }
    }
}
