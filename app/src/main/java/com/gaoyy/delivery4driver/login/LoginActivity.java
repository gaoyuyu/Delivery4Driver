package com.gaoyy.delivery4driver.login;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.base.BaseActivity;
import com.gaoyy.delivery4driver.util.ActivityUtils;
import com.gaoyy.delivery4driver.util.CommonUtils;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.List;


public class LoginActivity extends BaseActivity
{
    private LinearLayout activityLogin;
    private Toolbar loginToolbar;
    private FrameLayout loginContent;

    @Override
    protected void initContentView()
    {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void assignViews()
    {
        super.assignViews();
        activityLogin = (LinearLayout) findViewById(R.id.activity_login);
        loginToolbar = (Toolbar) findViewById(R.id.login_toolbar);
        loginContent = (FrameLayout) findViewById(R.id.login_content);
    }

    @Override
    protected void initToolbar()
    {
        super.initToolbar(loginToolbar, R.string.login, false, -1);
    }

    @Override
    protected void configViews()
    {
        super.configViews();


        AndPermission.with(this)
                .requestCode(Constant.REQUEST_CODE_PERMISSION_SINGLE)
                .permission(Permission.LOCATION)
                .callback(permissionListener)
                .rationale(new RationaleListener()
                {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale)
                    {
                        AndPermission.rationaleDialog(LoginActivity.this, rationale).show();
                    }
                })
                .start();

        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.login_content);
        if (loginFragment == null)
        {
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.login_content);
        }
        new LoginPresenter(loginFragment);
    }

    /**
     * 回调监听。
     */
    private PermissionListener permissionListener = new PermissionListener()
    {
        @Override
        public void onSucceed(int requestCode, @NonNull List<String> grantPermissions)
        {
            switch (requestCode)
            {
                case Constant.REQUEST_CODE_PERMISSION_SINGLE:
                    CommonUtils.showToast(LoginActivity.this, R.string.permission_location_success);
                    break;
            }
        }

        @Override
        public void onFailed(int requestCode, @NonNull List<String> deniedPermissions)
        {
            switch (requestCode)
            {
                case Constant.REQUEST_CODE_PERMISSION_SINGLE:
                    CommonUtils.showToast(LoginActivity.this, R.string.permission_location_fail);
                    break;
            }

            if (AndPermission.hasAlwaysDeniedPermission(LoginActivity.this, deniedPermissions))
            {
                AndPermission.defaultSettingDialog(LoginActivity.this, Constant.REQUEST_CODE_SETTING)
                        .setTitle(R.string.dialog_permission_title)
                        .setMessage(R.string.permission_already_deny)
                        .setPositiveButton(R.string.dialog_permission_grant)
                        .show();
            }
        }
    };
}
