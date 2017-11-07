package com.gaoyy.delivery4driver.login;

import android.util.Log;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.api.bean.DriverInfo;
import com.gaoyy.delivery4driver.util.CommonUtils;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter
{
    private LoginContract.View mLoginView;

    public LoginPresenter(LoginContract.View mLoginView)
    {
        this.mLoginView = mLoginView;
        mLoginView.setPresenter(this);
    }

    @Override
    public void start()
    {
        Log.i(Constant.TAG, "Login start");
    }

    @Override
    public void login(Call<DriverInfo> call, Map<String, String> params)
    {
        CommonUtils.httpDebugLogger("登录请求");
        mLoginView.showLoading();
        call.enqueue(new Callback<DriverInfo>()
        {
            @Override
            public void onResponse(Call<DriverInfo> call, Response<DriverInfo> response)
            {
                if (!mLoginView.isActive())
                {
                    return;
                }
                mLoginView.hideLoading();
                if (response.isSuccessful() && response.body() != null)
                {
                    DriverInfo driverInfo = response.body();
                    String msg = driverInfo.getMsg();
                    String errorCode = driverInfo.getErrorCode();
                    mLoginView.showToast(msg);
                    CommonUtils.httpDebugLogger("[isSuccess=" + driverInfo.isSuccess() + "][errorCode=" + errorCode + "][msg=" + msg + "]");

                    if (errorCode.equals("-1"))
                    {
                        //保存用户信息
                        mLoginView.saveUserInfo(driverInfo.getBody().getUser());

                        //保存司机信息
                        mLoginView.saveCourierInfo(driverInfo.getBody().getCourier());

                        //保存orderTime
                        mLoginView.saveOrderTime(driverInfo.getBody().getOrderTime());


                        List<DriverInfo.BodyBean.DictStatusBean> dictStatus = driverInfo.getBody().getDictStatus();
                        mLoginView.redirectToMain(dictStatus);

                        Log.i(Constant.TAG, "driver lng-->" + driverInfo.getBody().getCourier().getLongitude());
                        Log.i(Constant.TAG, "driver lat-->" + driverInfo.getBody().getCourier().getLatitude());
                        Log.i(Constant.TAG, "isOnline-->" + driverInfo.getBody().getCourier().getIsOnline());


                        Log.i(Constant.TAG, "loginName-->" + driverInfo.getBody().getUser().getLoginName());
                        Log.i(Constant.TAG, "RandomCode-->" + driverInfo.getBody().getUser().getRandomCode());

                        mLoginView.uploadLocation();

                    }
                    else
                    {
                        //登录失败，无论是否自动登陆，都将自动登陆标识置为false，重新登陆
                        mLoginView.setAutoLoginToFalse();

                    }
                }
            }

            @Override
            public void onFailure(Call<DriverInfo> call, Throwable t)
            {
                if (!mLoginView.isActive())
                {
                    return;
                }
                mLoginView.hideLoading();
                CommonUtils.httpErrorLogger(t.toString());
                if(!call.isCanceled())
                {
                    mLoginView.showToast(R.string.network_error);
                }
            }
        });
    }

}
