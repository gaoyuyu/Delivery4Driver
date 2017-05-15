package com.gaoyy.delivery4driver.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gaoyy.delivery4driver.R;


public abstract class BaseActivity extends AppCompatActivity
{
    private int toolbarColor = R.color.colorPrimary;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //加载布局
        initContentView();
        //初始化view
        assignViews();
        //初始化toolbar
        initToolbar();
        //配置views
        configViews();
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

}
