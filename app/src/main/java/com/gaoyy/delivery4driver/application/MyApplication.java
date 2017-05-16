package com.gaoyy.delivery4driver.application;

import android.app.Application;

import com.gaoyy.delivery4driver.api.RetrofitService;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;


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

        initJPush();


    }

    /**
     * 初始化极光推送服务
     */
    private void initJPush()
    {
        //初始化sdk
        JPushInterface.setDebugMode(true);//正式版的时候设置false，关闭调试
        JPushInterface.init(this);

        Set<String> set = new HashSet<>();
        set.add("demo");//名字任意，可多添加几个
        JPushInterface.setTags(this, set, null);//设置标签
    }


}
