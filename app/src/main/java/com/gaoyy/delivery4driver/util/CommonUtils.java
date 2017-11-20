package com.gaoyy.delivery4driver.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.gaoyy.delivery4driver.api.Constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;


/**
 * Created by gaoyy on 2017/5/6 0006.
 */

public class CommonUtils
{
    public static boolean isEmpty(String str)
    {
        if (str == null || str.length() == 0 || str.equalsIgnoreCase("null") || str.isEmpty() || str.equals(""))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * showToast
     *
     * @param context
     * @param msg
     */
    public static void showToast(Context context, String msg)
    {
        if (null != msg && !CommonUtils.isEmpty(msg))
        {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * showToast
     *
     * @param context
     * @param msgId
     */
    public static void showToast(Context context, int msgId)
    {
        Toast.makeText(context, msgId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取用户的名字
     *
     * @param context
     * @return
     */
    public static String getName(Context context)
    {
        SharedPreferences account = context.getSharedPreferences("account", Activity.MODE_PRIVATE);
        String name = account.getString("name", "");
        return name;
    }

    /**
     * 获取用户的登录账户名
     *
     * @param context
     * @return
     */
    public static String getLoginName(Context context)
    {
        SharedPreferences account = context.getSharedPreferences("account", Activity.MODE_PRIVATE);
        String loginName = account.getString("loginName", "");
        return loginName;
    }

    /**
     * 获取用户的登录密码
     *
     * @param context
     * @return
     */
    public static String getPwd(Context context)
    {
        SharedPreferences account = context.getSharedPreferences("account", Activity.MODE_PRIVATE);
        String pwd = account.getString("pwd", "");
        return pwd;
    }

    /**
     * 获取用户的随机码
     *
     * @param context
     * @return
     */
    public static String getRandomCode(Context context)
    {
        SharedPreferences account = context.getSharedPreferences("account", Activity.MODE_PRIVATE);
        String loginName = account.getString("randomCode", "");
        return loginName;
    }

    /**
     * 获取接单倒计时
     *
     * @param context
     * @return
     */
    public static int getOrderTime(Context context)
    {
        SharedPreferences account = context.getSharedPreferences("orderTime", Activity.MODE_PRIVATE);
        int orderTime = account.getInt("orderTime", 0);
        return orderTime;
    }


    /**
     * 获取角色标识
     *
     * @param context
     * @return 1-司机，2-饭店，-1-无角色信息
     */
    public static int getRoleFlag(Context context)
    {
        int flag = -1;
        SharedPreferences account = context.getSharedPreferences("account", Activity.MODE_PRIVATE);
        String name = account.getString("roleNames", "");
        Log.e(Constant.TAG, "==>" + name);
        if (name.equals("司机"))
        {
            flag = 1;
        }
        else if (name.equals("饭店"))
        {
            flag = 2;
        }
        return flag;
    }


    /**
     * input layout 设置
     *
     * @param ed
     * @param layout
     * @param msg
     */
    public static void textInputLayoutSetting(TextInputEditText ed, TextInputLayout layout, String msg)
    {
        if (ed.getText().toString().equals(""))
        {
            layout.setErrorEnabled(true);
            layout.setError(msg);
        }
        else
        {
            layout.setError(null);
            layout.setErrorEnabled(false);
        }
    }

    /**
     * 获取当前时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentTime()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * 判断是否是在配送时间内
     *
     * @param startDeliveryTime
     * @param endDeliveryTime
     * @return
     */
    public static boolean isDeliveryTimezone(String startDeliveryTime, String endDeliveryTime)
    {
        SimpleDateFormat commonFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date commonDate = new Date(System.currentTimeMillis());
        String common = commonFormat.format(commonDate);
        Log.d(Constant.TAG, "=common=>" + common);
        String start = common + " " + startDeliveryTime + ":00";
        String end = common + " " + endDeliveryTime + ":00";
        Log.d(Constant.TAG, "=start=>" + start);
        Log.d(Constant.TAG, "=end=>" + end);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = null;
        Date endDate = null;
        try
        {
            startDate = format.parse(start);
            endDate = format.parse(end);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        Log.d(Constant.TAG, "=startDate=>" + startDate.getTime());
        Log.d(Constant.TAG, "=endDate=>" + endDate.getTime());
        Log.d(Constant.TAG, "=System.currentTimeMillis()=>" + System.currentTimeMillis());
        long s = startDate.getTime();
        long e = endDate.getTime();
        long currentTimeMillis = System.currentTimeMillis();
        boolean isRightTime = (currentTimeMillis > s && currentTimeMillis < e);
        return isRightTime;
    }

    /**
     * @param view
     * @param msg
     */
    public static void showSnackBar(View view, String msg)
    {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * 设置下拉刷新loading颜色
     *
     * @param context
     * @param layout
     */
    public static void setSwipeLayoutProgressBackgroundColor(Context context, SwipeRefreshLayout layout)
    {
        layout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        layout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        layout.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, context.getResources()
                        .getDisplayMetrics()));
    }

    /**
     * 【DEBUG】用于输出http请求信息
     *
     * @param msg
     */
    public static void httpDebugLogger(String msg)
    {
        Log.d(Constant.TAG, "[-HTTP LOG-]" + "==========" + msg + "==========");
    }

    /**
     * 【ERROR】用于输出http请求错误信息
     *
     * @param msg
     */
    public static void httpErrorLogger(String msg)
    {
        Log.e(Constant.TAG, "[-HTTP LOG-]" + "==========" + msg + "==========");
    }


    /**
     * 获取系统language，en（英语）、zh(中文)、fr(法文)
     * 出现除以上3种语言外，默认en
     *
     * @return
     */
    public static String getSysLanguage()
    {
        String language = Locale.getDefault().getLanguage();
        Log.e(Constant.TAG,"系统语言："+language);
        if (language.equals("zh"))
        {
            return language;
        }
        else if (language.equals("en"))
        {
            return language;
        }
        else if (language.equals("fr"))
        {
            return language;
        }
        else
        {
            return "en";
        }
    }

    /**
     * 保留2位小数
     * @return
     */
    public static String deci2(Object d)
    {
        Double b = (Double) d;
        return String.format("%.2f",b);
    }

    public static void setUpAutoLogin(Context context, boolean checked)
    {
        SharedPreferences account = context.getSharedPreferences("account", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = account.edit();
        if (checked)
        {
            editor.putInt("isAutoLogin", Constant.AUTO_LOGIN);
        }
        else
        {
            editor.putInt("isAutoLogin", Constant.NOT_AUTO_LOGIN);
        }
        editor.apply();
    }

    public static boolean getAutoLogin(Context context)
    {
        SharedPreferences account = context.getSharedPreferences("account", Activity.MODE_PRIVATE);
        int autoLogin = account.getInt("isAutoLogin", -1);
        if (autoLogin == Constant.AUTO_LOGIN)
        {
            return true;
        }
        else if (autoLogin == Constant.NOT_AUTO_LOGIN)
        {
            return false;
        }
        return false;
    }

    /**
     * 设置Jpush别名
     *
     * @param context
     * @return
     */
    public static void setJpushAlias(Context context,String alias)
    {
        JPushInterface.setAlias(context, alias, new TagAliasCallback()
        {
            @Override
            public void gotResult(int i, String s, Set<String> set)
            {
                if(s.equals(""))
                {
                    Log.d(Constant.TAG, "[JPUSH TagAliasCallback]set Alias to empty");
                }
                else
                {
                    Log.d(Constant.TAG, "[JPUSH TagAliasCallback]--i->" + i);
                    Log.d(Constant.TAG, "[JPUSH TagAliasCallback]--s->" + s);
                }

            }
        });
    }

}
