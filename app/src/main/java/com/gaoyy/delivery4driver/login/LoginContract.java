package com.gaoyy.delivery4driver.login;


import com.gaoyy.delivery4driver.api.bean.DriverInfo;
import com.gaoyy.delivery4driver.base.BasePresenter;
import com.gaoyy.delivery4driver.base.BaseView;

import java.util.List;
import java.util.Map;

public class LoginContract
{
    interface View extends BaseView<Presenter>
    {
        boolean isActive();

        void showLoading();
        void hideLoading();
        void showToast(String msg);

        /**
         * 保存用户信息
         * @param user
         */
        void saveUserInfo(DriverInfo.BodyBean.UserBean user);

        /**
         *保存司机信息
         * @param courier
         */
        void saveCourierInfo(DriverInfo.BodyBean.CourierBean courier);

        /**
         * 跳转到MainActivity
         */
        void redirectToMain(List<DriverInfo.BodyBean.DictStatusBean> dictStatus);

        /**
         * 登录完成开启上传位置
         */
        void uploadLocation();
    }

    interface Presenter extends BasePresenter
    {
        void login(Map<String, String> params);
    }
}
