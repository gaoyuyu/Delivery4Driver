package com.gaoyy.delivery4driver.application;

/**
 * Created by gaoyy on 2017/5/20 0020.
 */


import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 * ExitApplication类（存储每一个Activity，并实现关闭所有Activity操作）
 *
 * @author 使用单例模式创建一个Activity管理对象，该对象中有一个Activity容器（具体实现自己处理，使用LinkedList等）
 *         专门负责存储新开启的每一个Activity，并且易于理解，易于操作.
 */
public class ExitApplication extends Application
{
    private List<Activity> activityList = new LinkedList<Activity>();
    private static ExitApplication instance;

    private ExitApplication()
    {

    }

    // 单例模式中获取唯一的MyApplication实例
    public static ExitApplication getInstanse()
    {
        if (instance == null)
        {
            instance = new ExitApplication();
        }
        return instance;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity)
    {
        activityList.add(activity);
    }

    // 遍历所有Activity并finish
    public void exit()
    {
        for (Activity activity : activityList)
        {
            activity.finish();
        }
//		System.exit(0);
    }
}
