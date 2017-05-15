package com.gaoyy.delivery4driver.changepwd;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.base.BaseActivity;
import com.gaoyy.delivery4driver.util.ActivityUtils;


public class ChangePwdActivity extends BaseActivity
{
    private Toolbar changePwdToolbar;


    @Override
    protected void initContentView()
    {
        setContentView(R.layout.activity_change_pwd);
    }

    @Override
    protected void assignViews()
    {
        super.assignViews();
        changePwdToolbar = (Toolbar) findViewById(R.id.change_pwd_toolbar);
    }

    @Override
    protected void initToolbar()
    {
        super.initToolbar(changePwdToolbar, "修改密码", true, -1);
    }

    @Override
    protected void configViews()
    {
        super.configViews();

        ChangePwdFragment changePwdFragment = (ChangePwdFragment) getSupportFragmentManager().findFragmentById(R.id.change_pwd_content);
        if (changePwdFragment == null)
        {
            changePwdFragment = ChangePwdFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),changePwdFragment, R.id.change_pwd_content);
        }
        new ChangePwdPresenter(changePwdFragment);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
