package com.gaoyy.delivery4driver.login;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
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
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

public class LoginFragment extends BaseFragment implements LoginContract.View, View.OnClickListener
{
    private static final String LOG_TAG = LoginFragment.class.getSimpleName();
    private LoginContract.Presenter mLoginPresenter;

    private TextInputLayout loginUsernameTextinputlayout;
    private TextInputEditText loginUsername;
    private TextInputLayout loginPasswordTextinputlayout;
    private TextInputEditText loginPassword;
    private AppCompatButton loginBtn;

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
    }

    @Override
    protected void configViews()
    {
        super.configViews();
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
    }

    @Override
    public void onResume()
    {
        super.onResume();
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
        loading = DialogUtils.showLoadingDialog(activity);
    }

    @Override
    public void hideLoading()
    {
        if (loading != null)
        {
            loading.dismiss();
        }
    }

    @Override
    public void showToast(String msg)
    {
        CommonUtils.showToast(activity, msg);
    }

    @Override
    public void saveUserInfo(DriverInfo.BodyBean.UserBean user)
    {
        SharedPreferences account = activity.getSharedPreferences("account", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = account.edit();
        editor.putString("id", user.getId());
        editor.putString("loginName", user.getLoginName());
        editor.putString("name", user.getName());
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
        editor.putString("age",courier.getAge()+"");
        editor.putString("orderCount",courier.getOrderCount()+"");
        editor.putString("tel",courier.getTel());
        editor.putString("idCard",courier.getIdCard());
        editor.putString("addr",courier.getAddr());
        editor.putString("longitude",courier.getLongitude());
        editor.putString("latitude",courier.getLatitude());
        editor.putString("isOnline",courier.getIsOnline());
        editor.putString("carNumber",courier.getCarNumber());
        editor.putString("driverNumber",courier.getDriverNumber());
        editor.putString("driverDate",courier.getDriverDate());
        editor.putString("carInsurance",courier.getCarInsurance());
        editor.apply();
    }


    @Override
    public void redirectToMain(List<DriverInfo.BodyBean.DictStatusBean> dictStatus)
    {
        Intent intent = new Intent();
        intent.putExtra("dictStatus",(Serializable) dictStatus);
        intent.setClass(activity, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void uploadLocation()
    {

        PollingUtils.startPollingService(activity,1000, PollingService.class,PollingService.ACTION);

        //设置JPush别名
        //建议添加tag标签，发送消息的之后就可以指定tag标签来发送了
        JPushInterface.setAlias(activity, CommonUtils.getLoginName(activity), new TagAliasCallback()
        {
            @Override
            public void gotResult(int i, String s, Set<String> set)
            {
                Log.d(Constant.TAG,"[JPUSH TagAliasCallback]--i->"+i);
                Log.d(Constant.TAG,"[JPUSH TagAliasCallback]--s->"+s);
            }
        });
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
                validate();
                if (loginUsernameTextinputlayout.isErrorEnabled() || loginPasswordTextinputlayout.isErrorEnabled())
                    return;
                Map<String, String> params = new HashMap<>();
                params.put("loginName", loginUsername.getText().toString());
                params.put("pwd", loginPassword.getText().toString());
                //appType=0司机端
                params.put("appType", "0");
                mLoginPresenter.login(params);
                break;
        }
    }

    /**
     * 校验输入
     */
    private void validate()
    {
        CommonUtils.textInputLayoutSetting(loginUsername, loginUsernameTextinputlayout, "username mustn't be empty");
        CommonUtils.textInputLayoutSetting(loginPassword, loginPasswordTextinputlayout, "password mustn't be empty");
    }

}
