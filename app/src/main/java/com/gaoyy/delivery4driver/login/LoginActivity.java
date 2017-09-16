package com.gaoyy.delivery4driver.login;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
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
import com.gaoyy.delivery4driver.base.CustomDialogFragment;
import com.gaoyy.delivery4driver.util.ActivityUtils;
import com.gaoyy.delivery4driver.util.CommonUtils;
import com.gaoyy.delivery4driver.util.DialogUtils;


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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                Log.e(Constant.TAG, "==Login==申请权限=====");

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION))
                {
                    Log.e(Constant.TAG, "==Login==ACCESS_FINE_LOCATION again=====");
                    showRequestPermissionDialog();
                }
                else if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION))
                {
                    Log.e(Constant.TAG, "==Login==ACCESS_COARSE_LOCATION again=====");
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
                CommonUtils.showToast(this, getResources().getString(R.string.permission_grant));
            }
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
                Log.e(Constant.TAG, "==Login==PERMISSION_GRANTED=====");
            }
            else
            {
                CommonUtils.showToast(this,getResources().getString(R.string.permission_already_deny));
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    private void showRequestPermissionDialog()
    {
//        new AlertDialog.Builder(this)
//                .setTitle(R.string.dialog_permission_title)
//                .setMessage(R.string.dialog_permission_message)
//                .setCancelable(false)
//                .setPositiveButton(R.string.dialog_permission_grant, new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i)
//                    {
//                        ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
//                                Manifest.permission.ACCESS_COARSE_LOCATION}, Constant.REQUEST_ACCESS_FINE_COARSE_LOCATION);
//                    }
//                })
//                .setNegativeButton(R.string.dialog_permission_deny, new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i)
//                    {
//                        //拒绝授权
//                        dialogInterface.dismiss();
//                    }
//                })
//                .show();

        CustomDialogFragment dialog = DialogUtils.showAlertDialog(this, getResources().getString(R.string.dialog_permission_title),
                getResources().getString(R.string.dialog_permission_message),
                getResources().getString(R.string.dialog_permission_deny), getResources().getString(R.string.dialog_permission_grant));
        dialog.setOnAlertDialogClickListener(new CustomDialogFragment.OnAlertDialogClickListener()
        {
            @Override
            public void onButtonClick(DialogInterface dialog, int which)
            {
                switch (which)
                {
                    case AlertDialog.BUTTON_NEGATIVE:
                        dialog.dismiss();
                        break;
                    case AlertDialog.BUTTON_POSITIVE:
                        dialog.dismiss();
                        ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION}, Constant.REQUEST_ACCESS_FINE_COARSE_LOCATION);
                        break;
                    default:
                        break;
                }

            }
        });
    }
}
