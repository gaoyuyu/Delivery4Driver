package com.gaoyy.delivery4driver.login;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.base.BaseActivity;
import com.gaoyy.delivery4driver.util.ActivityUtils;
import com.gaoyy.delivery4driver.util.CommonUtils;


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

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            Log.e(Constant.TAG, "====申请权限=====");
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
//                    Manifest.permission.ACCESS_COARSE_LOCATION}, Constant.REQUEST_ACCESS_FINE_COARSE_LOCATION);

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION))
            {
                CommonUtils.showToast(this, "ACCESS_FINE_LOCATION again");
                // TODO: 2017/6/1 0001 弹出对话框再次申请权限
                showRequestPermissionDialog();
            }
            else if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION))
            {
                CommonUtils.showToast(this, "ACCESS_COARSE_LOCATION again");
                // TODO: 2017/6/1 0001 弹出对话框再次申请权限
                showRequestPermissionDialog();
            }
            else
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION}, Constant.REQUEST_ACCESS_FINE_COARSE_LOCATION);
            }
        }
        else
        {
            CommonUtils.showToast(this, "定位服务已授权");
        }


        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.login_content);
        if (loginFragment == null)
        {
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.login_content);
        }
        new LoginPresenter(loginFragment);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if (requestCode == Constant.REQUEST_ACCESS_FINE_COARSE_LOCATION)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Log.d(Constant.TAG, "====PERMISSION_GRANTED===");
            }
            else
            {
                CommonUtils.showToast(this,"已拒绝定位权限的申请，可在设置界面中打开");
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    /**
     * 申请打电话的权限得的对话框,之前被勾选不再提醒申请权限
     */
    private void showRequestPermissionDialog()
    {
        new AlertDialog.Builder(this)
                .setTitle("申请定位权限")
                .setMessage("应用缺失定位权限")
                .setPositiveButton("同意", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION}, Constant.REQUEST_ACCESS_FINE_COARSE_LOCATION);
                    }
                })
                .setNegativeButton("拒绝", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        //拒绝授权
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }
}
