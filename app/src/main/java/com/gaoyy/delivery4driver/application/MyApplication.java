package com.gaoyy.delivery4driver.application;

import android.app.Application;

import com.gaoyy.delivery4driver.api.RetrofitService;


/**
 * Created by gaoyy on 2016/12/28.
 */

public class MyApplication extends Application
{
    private static final String LOG_TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate()
    {
        super.onCreate();

        RetrofitService.init(this);
    }



}
