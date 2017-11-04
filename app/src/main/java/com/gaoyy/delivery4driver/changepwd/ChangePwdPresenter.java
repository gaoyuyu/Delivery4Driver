package com.gaoyy.delivery4driver.changepwd;


import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.RetrofitService;
import com.gaoyy.delivery4driver.api.bean.CommonInfo;
import com.gaoyy.delivery4driver.util.CommonUtils;

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
    public void changePwd(Call<CommonInfo> call, Map<String, String> params)
    {
        CommonUtils.httpDebugLogger("修改密码请求");

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
                    CommonUtils.httpDebugLogger("[isSuccess=" + commonInfo.isSuccess() + "][errorCode=" + errorCode + "][msg=" + msg + "]");
                    mChangePwdView.showToast(msg);

                    if (errorCode.equals("-1"))
                    {
                        mChangePwdView.redirectToLogin();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonInfo> call, Throwable t)
            {
                if (!mChangePwdView.isActive())
                {
                    return;
                }
                mChangePwdView.hideLoading();
                CommonUtils.httpErrorLogger(t.toString());
                mChangePwdView.showToast(R.string.network_error);
            }
        });
    }
}
