package com.gaoyy.delivery4driver.login;


import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.api.RetrofitService;
import com.gaoyy.delivery4driver.api.bean.DriverInfo;
import com.gaoyy.delivery4driver.base.BaseFragment;
import com.gaoyy.delivery4driver.base.CustomDialogFragment;
import com.gaoyy.delivery4driver.main.MainActivity;
import com.gaoyy.delivery4driver.service.PollingService;
import com.gaoyy.delivery4driver.util.CommonUtils;
import com.gaoyy.delivery4driver.util.DialogUtils;
import com.gaoyy.delivery4driver.util.PollingUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class LoginFragment extends BaseFragment implements LoginContract.View, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
    private static final String LOG_TAG = LoginFragment.class.getSimpleName();
    private LoginContract.Presenter mLoginPresenter;

    private TextInputLayout loginUsernameTextinputlayout;
    private TextInputEditText loginUsername;
    private TextInputLayout loginPasswordTextinputlayout;
    private TextInputEditText loginPassword;
    private AppCompatButton loginBtn;
    private LinearLayout loginLayout;
    private CheckBox loginAutoCb;
    private Call<DriverInfo> call;

    private CustomDialogFragment loading;


    public LoginFragment()
    {

    }

    public static LoginFragment newInstance()
    {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    protected int getFragmentLayoutId()
    {
        return R.layout.fragment_login;
    }

    @Override
    protected void assignViews(View rootView)
    {
        super.assignViews(rootView);
        loginUsernameTextinputlayout = (TextInputLayout) rootView.findViewById(R.id.login_username_textinputlayout);
        loginUsername = (TextInputEditText) rootView.findViewById(R.id.login_username);
        loginPasswordTextinputlayout = (TextInputLayout) rootView.findViewById(R.id.login_password_textinputlayout);
        loginPassword = (TextInputEditText) rootView.findViewById(R.id.login_password);
        loginBtn = (AppCompatButton) rootView.findViewById(R.id.login_btn);
        loginAutoCb = (CheckBox) rootView.findViewById(R.id.login_auto_cb);
        loginLayout = (LinearLayout) rootView.findViewById(R.id.login_layout);
    }

    @Override
    protected void configViews()
    {
        super.configViews();


        SharedPreferences account = activity.getSharedPreferences("account", Activity.MODE_PRIVATE);
        int isAutoLogin = account.getInt("isAutoLogin", -1);

        if (isAutoLogin == Constant.AUTO_LOGIN)
        {
            loginLayout.setVisibility(View.GONE);
            loginPassword.setText(CommonUtils.getPwd(activity));
            Map<String, String> params = new HashMap<>();
            params.put("loginName", CommonUtils.getLoginName(activity));
            params.put("pwd", CommonUtils.getPwd(activity));
            params.put("appType", "0");
            CommonUtils.httpDebugLogger("自动登录==" + params.toString());
            call = RetrofitService.sApiService.login(params);
            mLoginPresenter.login(call, params);
        }
        else
        {
            loginLayout.setVisibility(View.VISIBLE);
            loginPassword.setText("");
        }
    }


    @Override
    protected void setListener()
    {
        super.setListener();
        loginUsername.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                if (editable.toString() != null || !editable.toString().equals(""))
                {
                    loginUsernameTextinputlayout.setError(null);
                    loginUsernameTextinputlayout.setErrorEnabled(false);
                }
            }
        });

        loginPassword.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                if (editable.toString() != null || !editable.toString().equals(""))
                {
                    loginPasswordTextinputlayout.setError(null);
                    loginPasswordTextinputlayout.setErrorEnabled(false);
                }
            }
        });
        loginBtn.setOnClickListener(this);
        loginAutoCb.setOnCheckedChangeListener(this);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if (mLoginPresenter == null) return;
        mLoginPresenter.start();
    }

    @Override
    public boolean isActive()
    {
        return isAdded();
    }

    @Override
    public void showLoading()
    {
        loading = DialogUtils.showLoadingDialog(activity, activity.getResources().getString(R.string.logining));
    }

    @Override
    public void hideLoading()
    {
        if (loading != null)
        {
            loading.dismissAllowingStateLoss();
        }
    }

    @Override
    public void showToast(String msg)
    {
        CommonUtils.showToast(activity, msg);
    }

    @Override
    public void showToast(int msgId)
    {
        CommonUtils.showToast(activity, msgId);
    }


    @Override
    public void setAutoLoginToFalse()
    {
        CommonUtils.setUpAutoLogin(activity, false);
        //同时跳转登录界面
        Intent intent = new Intent();
        intent.setClass(activity, LoginActivity.class);
        startActivity(intent);

    }

    @Override
    public void saveUserInfo(DriverInfo.BodyBean.UserBean user)
    {
        SharedPreferences account = activity.getSharedPreferences("account", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = account.edit();
        editor.putString("id", user.getId());
        editor.putString("loginName", user.getLoginName());
        editor.putString("pwd", loginPassword.getText().toString());
        editor.putString("name", Html.fromHtml(user.getName()).toString());
        editor.putString("email", user.getEmail());
        editor.putString("phone", user.getPhone());
        editor.putString("mobile", user.getMobile());
        editor.putString("randomCode", user.getRandomCode());
        editor.putString("roleNames", user.getRoleNames());
        editor.apply();
    }

    @Override
    public void saveCourierInfo(DriverInfo.BodyBean.CourierBean courier)
    {
        SharedPreferences courierInfo = activity.getSharedPreferences("courier", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = courierInfo.edit();
        editor.putString("id", courier.getId());
        editor.putString("remarks", courier.getRemarks());
        editor.putString("name", courier.getName());
        editor.putString("sex", courier.getSex());
        editor.putString("userName", courier.getUserName());
        editor.putString("age", courier.getAge() + "");
        editor.putString("orderCount", courier.getOrderCount() + "");
        editor.putString("tel", courier.getTel());
        editor.putString("idCard", courier.getIdCard());
        editor.putString("addr", courier.getAddr());
        editor.putString("longitude", courier.getLongitude());
        editor.putString("latitude", courier.getLatitude());
        editor.putString("isOnline", courier.getIsOnline());
        editor.putString("carNumber", courier.getCarNumber());
        editor.putString("driverNumber", courier.getDriverNumber());
        editor.putString("driverDate", courier.getDriverDate());
        editor.putString("carInsurance", courier.getCarInsurance());
        editor.apply();
    }


    @Override
    public void redirectToMain(List<DriverInfo.BodyBean.DictStatusBean> dictStatus)
    {
        Intent intent = new Intent();
        intent.putExtra("dictStatus", (Serializable) dictStatus);
        intent.setClass(activity, MainActivity.class);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void saveOrderTime(int orderTime)
    {
        SharedPreferences orderTimeInfo = activity.getSharedPreferences("orderTime", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = orderTimeInfo.edit();
        editor.putInt("orderTime", orderTime);
        editor.apply();
    }

    @Override
    public void uploadLocation()
    {
        CommonUtils.setJpushAlias(activity, CommonUtils.getLoginName(activity));
        //5秒执行一次
        PollingUtils.startPollingService(activity, 5, PollingService.class, PollingService.ACTION);
    }


    @Override
    public void setPresenter(LoginContract.Presenter presenter)
    {
        Log.i(Constant.TAG, LOG_TAG + "  setPresenter");
        if (presenter != null)
        {
            mLoginPresenter = presenter;
        }
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.login_btn:
//                CrashReport.testJavaCrash();
                //再做一次判断用户是否打开定位权限
                if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                {
                    Log.d(Constant.TAG, "没有打开定位权限");
                    new AlertDialog.Builder(activity)
                            .setTitle(R.string.dialog_reminder)
                            .setMessage(R.string.dialog_reminder_message)
                            .setCancelable(false)
                            .setPositiveButton(R.string.dialog_setting, new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i)
                                {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE)
                                    {
                                        // 进入设置系统应用权限界面
                                        Intent intent = new Intent(Settings.ACTION_SETTINGS);
                                        startActivity(intent);
                                    }
                                    else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                                    {
                                        // 运行系统在5.x环境使用
                                        // 进入设置系统应用权限界面
                                        Intent intent = new Intent(Settings.ACTION_SETTINGS);
                                        startActivity(intent);
                                    }
                                    return;
                                }
                            })
                            .show();
                }
                else
                {
                    Log.d(Constant.TAG, "已经打开定位权限");
                    validate();
                    if (loginUsernameTextinputlayout.isErrorEnabled() || loginPasswordTextinputlayout.isErrorEnabled())
                        return;
                    Map<String, String> params = new HashMap<>();
                    params.put("loginName", loginUsername.getText().toString());
                    params.put("pwd", loginPassword.getText().toString());
                    //appType=0司机端
                    params.put("appType", "0");
                    call = RetrofitService.sApiService.login(params);
                    mLoginPresenter.login(call, params);

                }
                break;
        }
    }

    /**
     * 校验输入
     */
    private void validate()
    {
        CommonUtils.textInputLayoutSetting(loginUsername, loginUsernameTextinputlayout, getResources().getString(R.string.check_user));
        CommonUtils.textInputLayoutSetting(loginPassword, loginPasswordTextinputlayout, getResources().getString(R.string.check_pwd));
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked)
    {
        CommonUtils.setUpAutoLogin(activity, checked);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        if (call != null) call.cancel();
    }
}
