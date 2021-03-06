package com.gaoyy.delivery4driver.main;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.RetrofitService;
import com.gaoyy.delivery4driver.api.bean.CommonInfo;
import com.gaoyy.delivery4driver.api.bean.DriverInfo;
import com.gaoyy.delivery4driver.base.BaseActivity;
import com.gaoyy.delivery4driver.base.CustomDialogFragment;
import com.gaoyy.delivery4driver.changepwd.ChangePwdActivity;
import com.gaoyy.delivery4driver.login.LoginActivity;
import com.gaoyy.delivery4driver.orderlist.OrderListFragment;
import com.gaoyy.delivery4driver.orderlist.OrderListPresenter;
import com.gaoyy.delivery4driver.service.PollingService;
import com.gaoyy.delivery4driver.util.ActivityUtils;
import com.gaoyy.delivery4driver.util.CommonUtils;
import com.gaoyy.delivery4driver.util.DialogUtils;
import com.gaoyy.delivery4driver.util.PollingUtils;
import com.jaeger.library.StatusBarUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private Toolbar mainToolbar;

    private DrawerLayout mainDrawerLayout;
    private NavigationView mainNavView;


    public static List<DriverInfo.BodyBean.DictStatusBean> dictStatus;

    @Override
    protected void initContentView()
    {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void assignViews()
    {
        super.assignViews();
        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mainDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mainNavView = (NavigationView) findViewById(R.id.main_nav_view);
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(this,mainDrawerLayout,getResources().getColor(R.color.colorPrimary));
    }

    @Override
    protected void initToolbar()
    {
        String name = CommonUtils.getName(this);
        super.initToolbar(mainToolbar, name, false, -1);
    }

    @Override
    protected void configViews()
    {
        super.configViews();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mainDrawerLayout, mainToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mainDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        configHeader();


        mainNavView.setNavigationItemSelectedListener(this);

        dictStatus = (List<DriverInfo.BodyBean.DictStatusBean>) getIntent().getSerializableExtra("dictStatus");

        OrderListFragment orderListFragment = OrderListFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), orderListFragment, R.id.main_content);
        new OrderListPresenter(orderListFragment);

    }

    /**
     * 设置header数据
     */
    private void configHeader()
    {
        View header = mainNavView.getHeaderView(0);
        TextView tv = (TextView) header.findViewById(R.id.header_username);
        tv.setText("Welcome," + CommonUtils.getName(this));
        //设置在线离线按钮
        SwitchCompat switchCompat = (SwitchCompat) header.findViewById(R.id.header_switch);
        SharedPreferences courierInfo = getSharedPreferences("courier", Activity.MODE_PRIVATE);
        String isOnline = courierInfo.getString("isOnline", "");
        if (isOnline.equals("1"))
        {
            switchCompat.setChecked(true);
        }
        else
        {
            switchCompat.setChecked(false);
        }
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
            {
                if (isChecked)
                {
                    //司机上线
                    driverOnline(compoundButton);
                }
                else
                {
                    //司机离线
                    driverOffline(compoundButton);
                }

            }
        });
    }

    /**
     * 司机离线
     */
    private void driverOffline(final CompoundButton compoundButton)
    {
        CommonUtils.httpDebugLogger("司机离线请求");
        final CustomDialogFragment offlineLoading = DialogUtils.showLoadingDialog(MainActivity.this);
        Call<CommonInfo> offlineCall = RetrofitService.sApiService.driverOffline(CommonUtils.getLoginName(MainActivity.this), CommonUtils.getRandomCode(MainActivity.this));
        offlineCall.enqueue(new Callback<CommonInfo>()
        {
            @Override
            public void onResponse(Call<CommonInfo> call, Response<CommonInfo> response)
            {
                offlineLoading.dismissAllowingStateLoss();
                if (response.isSuccessful() && response.body() != null)
                {
                    CommonInfo commonInfo = response.body();
                    String errorCode = commonInfo.getErrorCode();
                    String msg = commonInfo.getMsg();
                    CommonUtils.httpDebugLogger("[isSuccess="+commonInfo.isSuccess()+"][errorCode=" + errorCode + "][msg=" + msg + "]");
                    if (commonInfo.isSuccess())
                    {
                        CommonUtils.showToast(MainActivity.this, "Offline " + commonInfo.getMsg());
                    }
                    else
                    {
                        //离线失败，设置回true
                        CommonUtils.showToast(MainActivity.this, "Offline " + commonInfo.getMsg());
                        compoundButton.setChecked(true);

                    }
                }
            }

            @Override
            public void onFailure(Call<CommonInfo> call, Throwable t)
            {
                offlineLoading.dismissAllowingStateLoss();
                CommonUtils.httpErrorLogger(t.toString());
                if (!call.isCanceled())
                {
                    CommonUtils.showToast(MainActivity.this, getResources().getString(R.string.network_error));
                }
            }
        });
    }

    /**
     * 司机上线
     */
    private void driverOnline(final CompoundButton compoundButton)
    {
        CommonUtils.httpDebugLogger("司机上线请求");
        final CustomDialogFragment onlineLoading = DialogUtils.showLoadingDialog(MainActivity.this);
        Call<CommonInfo> onlineCall = RetrofitService.sApiService.driverOnline(CommonUtils.getLoginName(MainActivity.this), CommonUtils.getRandomCode(MainActivity.this));
        onlineCall.enqueue(new Callback<CommonInfo>()
        {
            @Override
            public void onResponse(Call<CommonInfo> call, Response<CommonInfo> response)
            {
                onlineLoading.dismissAllowingStateLoss();
                if (response.isSuccessful() && response.body() != null)
                {
                    CommonInfo commonInfo = response.body();
                    String errorCode = commonInfo.getErrorCode();
                    String msg = commonInfo.getMsg();
                    CommonUtils.httpDebugLogger("[isSuccess="+commonInfo.isSuccess()+"][errorCode=" + errorCode + "][msg=" + msg + "]");
                    if (commonInfo.isSuccess())
                    {
                        CommonUtils.showToast(MainActivity.this, "Online " + commonInfo.getMsg());
                    }
                    else
                    {
                        //上线失败，设置回true
                        CommonUtils.showToast(MainActivity.this, "Online " + commonInfo.getMsg());
                        compoundButton.setChecked(false);

                    }
                }
            }

            @Override
            public void onFailure(Call<CommonInfo> call, Throwable t)
            {
                onlineLoading.dismissAllowingStateLoss();
                CommonUtils.httpErrorLogger(t.toString());
                if (!call.isCanceled())
                {
                    CommonUtils.showToast(MainActivity.this, getResources().getString(R.string.network_error));
                }
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        if (mainDrawerLayout.isDrawerOpen(GravityCompat.START))
        {
            mainDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id)
        {
            case R.id.nav_change_pwd:
                Intent changePwd = new Intent();
                changePwd.setClass(MainActivity.this, ChangePwdActivity.class);
                startActivity(changePwd);
                break;
            case R.id.nav_person_detail:
                Intent personDetail = new Intent();
                personDetail.setClass(MainActivity.this,PersonalDetailActivity.class);
                startActivity(personDetail);
                break;
            case R.id.nav_score:
                Intent score = new Intent();
                score.setClass(MainActivity.this,ScoreActivity.class);
                startActivity(score);
                break;
            case R.id.nav_exit:
                String loginName = CommonUtils.getLoginName(this);
                String randomCode = CommonUtils.getRandomCode(this);
                logout(loginName, randomCode);
                break;
        }

        mainDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * 用户退出
     *
     * @param loginName
     * @param randomCode
     */
    private void logout(String loginName, String randomCode)
    {
        CommonUtils.httpDebugLogger("退出请求");
        Call<CommonInfo> call = RetrofitService.sApiService.logout(loginName, randomCode);
        final CustomDialogFragment loading = DialogUtils.showLoadingDialog(this);
        call.enqueue(new Callback<CommonInfo>()
        {
            @Override
            public void onResponse(Call<CommonInfo> call, Response<CommonInfo> response)
            {
                loading.dismissAllowingStateLoss();
                if (response.isSuccessful() && response.body() != null)
                {
                    CommonInfo logoutInfo = response.body();
                    String msg = logoutInfo.getMsg();
                    String errorCode = logoutInfo.getErrorCode();
                    CommonUtils.httpDebugLogger("[isSuccess="+logoutInfo.isSuccess()+"][errorCode=" + errorCode + "][msg=" + msg + "]");
                    if (errorCode.equals("-1"))
                    {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        CommonUtils.showToast(MainActivity.this, msg);
                       //停止上传位置
                        PollingUtils.stopPollingService(MainActivity.this, PollingService.class,PollingService.ACTION);

                        CommonUtils.setUpAutoLogin(MainActivity.this,false);
                    }
                    else if (errorCode.equals("-2"))
                    {
                        CommonUtils.showToast(MainActivity.this, msg);
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonInfo> call, Throwable t)
            {
                loading.dismissAllowingStateLoss();
                CommonUtils.httpErrorLogger(t.toString());
                if (!call.isCanceled())
                {
                    CommonUtils.showToast(MainActivity.this, getResources().getString(R.string.network_error));
                }
            }
        });
    }
}
