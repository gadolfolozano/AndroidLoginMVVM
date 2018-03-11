package pe.gadolfolozano.mvvmlogin.login.createaccount;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import pe.gadolfolozano.mvvmlogin.BR;
import pe.gadolfolozano.mvvmlogin.R;
import pe.gadolfolozano.mvvmlogin.base.BaseFragment;
import pe.gadolfolozano.mvvmlogin.databinding.FragmentCreateAccountBinding;

/**
 * Created by adolfo on 10/03/18.
 */

public class CreateAccountFragment extends BaseFragment<FragmentCreateAccountBinding, CreateAccountViewModel> implements CreateAccountNavigator {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    private CreateAccountViewModel mCreateAccountViewModel;

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
}
