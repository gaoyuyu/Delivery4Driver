package com.gaoyy.delivery4driver.changepwd;


import com.gaoyy.delivery4driver.base.BasePresenter;
import com.gaoyy.delivery4driver.base.BaseView;

import java.util.Map;

/**
 * Created by gaoyy on 2017/5/7 0007.
 */

public class ChangePwdContract
{
    interface View extends BaseView<Presenter>
    {
        boolean isActive();

        void showLoading();
        void hideLoading();
        void showToast(String msg);

    }

    interface Presenter extends BasePresenter
    {
        void changePwd(Map<String, String> params);
    }
}