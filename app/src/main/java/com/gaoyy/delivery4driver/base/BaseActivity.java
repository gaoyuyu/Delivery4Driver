package com.gaoyy.delivery4driver.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.application.ExitApplication;
import com.gaoyy.delivery4driver.main.MainActivity;
import com.gaoyy.delivery4driver.service.PollingService;
import com.gaoyy.delivery4driver.util.CommonUtils;
import com.gaoyy.delivery4driver.util.PollingUtils;
import com.gaoyy.delivery4driver.util.UpdateManager;
import com.jaeger.library.StatusBarUtil;


public abstract class BaseActivity extends AppCompatActivity
{
    private long firstTime = 0;
    private int toolbarColor = R.color.colorPrimary;
    public static boolean isForeground = false;
    private UpdateManager updateManager = new UpdateManager(BaseActivity.this, Constant.DOWNLOAD_DRIVER_APK_URL,Constant.DRIVER_APK_NAME);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //加载布局
        initContentView();
        if(!(this instanceof MainActivity))
        {
            StatusBarUtil.setColorNoTranslucent(this,getResources().getColor(R.color.colorPrimary));
        }
        //初始化view
        assignViews();
        //初始化toolbar
        initToolbar();
        //配置views
        configViews();
        setListener();


    }


    protected abstract void initContentView();

    protected void assignViews()
    {

    }

    protected void initToolbar()
    {

    }

    protected void configViews()
    {

    }
    protected void setListener()
    {

    }


    /**
     * @param toolbar
     * @param titleId      string id
     * @param enabled      toolbar返回键是否可用，true-可用，false-不可用
     * @param toolbarColor toolbar背景颜色，-1为默认色
     */
    public void initToolbar(Toolbar toolbar, int titleId, boolean enabled, int toolbarColor)
    {
        if (-1 == toolbarColor)
        {
            toolbarColor = this.toolbarColor;
        }
        //设置toolbat标题
        toolbar.setTitle(titleId);
        //设置toolbar背景色
        toolbar.setBackgroundColor(getResources().getColor(toolbarColor));
        setSupportActionBar(toolbar);
        //设置toolbar返回键是否可用
        getSupportActionBar().setHomeButtonEnabled(enabled);
        getSupportActionBar().setDisplayHomeAsUpEnabled(enabled);
    }
    /**
     * @param toolbar
     * @param title      string id
     * @param enabled      toolbar返回键是否可用，true-可用，false-不可用
     * @param toolbarColor toolbar背景颜色，-1为默认色
     */
    public void initToolbar(Toolbar toolbar, String title, boolean enabled, int toolbarColor)
    {
        if (-1 == toolbarColor)
        {
            toolbarColor = this.toolbarColor;
        }
        //设置toolbat标题
        toolbar.setTitle(title);
        //设置toolbar背景色
        toolbar.setBackgroundColor(getResources().getColor(toolbarColor));
        setSupportActionBar(toolbar);
        //设置toolbar返回键是否可用
        getSupportActionBar().setHomeButtonEnabled(enabled);
        getSupportActionBar().setDisplayHomeAsUpEnabled(enabled);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if ((System.currentTimeMillis() - firstTime) > 2000)
            {
                // 如果两次按键时间间隔大于2000毫秒，则不退出
                CommonUtils.showToast(this,getResources().getString(R.string.exit_after_press_again));
                firstTime = System.currentTimeMillis();// 更新mExitTime
            } else
            {
                //要在退出前，停止上传位置
                PollingUtils.stopPollingService(this, PollingService.class,PollingService.ACTION);
                CommonUtils.setJpushAlias(this, "");
                ExitApplication.getInstanse().exit();
                android.os.Process.killProcess(android.os.Process.myPid());
            }

            return true;
        }
    return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        isForeground = true;
        Log.d(Constant.TAG,"onResume driver foreground-->"+isForeground);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        isForeground = false;
        Log.d(Constant.TAG,"onPause driver foreground-->"+isForeground);
        //停止下载线程
        updateManager.stopApkThread();
    }

}
