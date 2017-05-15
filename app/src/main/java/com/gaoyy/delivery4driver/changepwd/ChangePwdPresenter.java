package com.gaoyy.delivery4driver.changepwd;


import com.gaoyy.delivery4driver.api.RetrofitService;
import com.gaoyy.delivery4driver.api.bean.CommonInfo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gaoyy on 2017/5/7 0007.
 */

public class ChangePwdPresenter implements ChangePwdContract.Presenter
{

    private ChangePwdContract.View mChangePwdView;

    public ChangePwdPresenter(ChangePwdContract.View mChangePwdView)
    {
        this.mChangePwdView = mChangePwdView;
        mChangePwdView.setPresenter(this);
    }
    @Override
    public void start()
    {

    }


    @Override
    public void changePwd(Map<String, String> params)
    {
        Call<CommonInfo> call = RetrofitService.sApiService.changePwd(params);
        mChangePwdView.showLoading();
        call.enqueue(new Callback<CommonInfo>()
        {
            @Override
            public void onResponse(Call<CommonInfo> call, Response<CommonInfo> response)
            {
                if (!mChangePwdView.isActive())
                {
                    return;
                }
                mChangePwdView.hideLoading();
                if (response.isSuccessful() && response.body() != null)
                {
                    CommonInfo commonInfo = response.body();
                    String msg = commonInfo.getMsg();
                    String errorCode = commonInfo.getErrorCode();
                    mChangePwdView.showToast(msg);

                    if(errorCode.equals("-1"))
                    {

                    }
                    else if(errorCode.equals("-2"))
                    {
                        //登录失败
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonInfo> call, Throwable t)
            {

            }
        });
    }
}
