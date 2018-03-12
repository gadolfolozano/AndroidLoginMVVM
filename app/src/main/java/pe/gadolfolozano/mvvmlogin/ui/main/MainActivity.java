package pe.gadolfolozano.mvvmlogin.ui.main;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import pe.gadolfolozano.mvvmlogin.BR;
import pe.gadolfolozano.mvvmlogin.R;
import pe.gadolfolozano.mvvmlogin.base.BaseActivity;
import pe.gadolfolozano.mvvmlogin.data.model.api.response.GetUserDetailsSuccessResponse;
import pe.gadolfolozano.mvvmlogin.databinding.ActivityMainBinding;
import pe.gadolfolozano.mvvmlogin.ui.login.LoginActivity;
import pe.gadolfolozano.mvvmlogin.ui.model.BaseModelLiveData;
import pe.gadolfolozano.mvvmlogin.util.Constants;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator {

    @Inject
    MainViewModel mMainViewModel;
    ActivityMainBinding mBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mMainViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        mMainViewModel.setNavigator(this);

        setUp();
    }

    private void setUp(){
        setSupportActionBar(mBinding.toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.main_title);
        }

        showLoading();
        mMainViewModel.loadUserInfo().observe(this, new Observer<BaseModelLiveData<GetUserDetailsSuccessResponse>>() {
            @Override
            public void onChanged(@Nullable BaseModelLiveData<GetUserDetailsSuccessResponse> liveData) {
                hideLoading();
                if(liveData.isSuccesfull()){
                    mBinding.edtFirstName.setText(Constants.EMPTY);
                    mBinding.edtFirstName.append(liveData.getData().getUser().getFirstName());
                    mBinding.edtLastName.setText(Constants.EMPTY);
                    mBinding.edtLastName.setText(liveData.getData().getUser().getLastName());
                } else if(liveData.getErrorMessage()!=null){
                    Toast.makeText(MainActivity.this, liveData.getErrorMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.error_message, Toast.LENGTH_LONG).show();
                }
            }
        });

        mBinding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBtnSaveClicked();
            }
        });
    }

    private void onBtnSaveClicked(){
        showLoading();
        String firstName = mBinding.edtFirstName.getText().toString();
        String lastName = mBinding.edtLastName.getText().toString();
        String password = mBinding.edtPassword.getText().toString();
        mMainViewModel.updateUserInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            mMainViewModel.signOut();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.newIntent(MainActivity.this);
        startActivity(intent);
        finish();
    }
}
