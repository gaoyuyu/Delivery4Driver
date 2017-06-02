package com.gaoyy.delivery4driver.orderlist;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.base.BaseActivity;
import com.gaoyy.delivery4driver.util.ActivityUtils;

public class OrderListActivity extends BaseActivity
{

    private LinearLayout activityOrderList;
    private Toolbar orderListToolbar;
    private FrameLayout orderListContent;


    @Override
    protected void initContentView()
    {
        setContentView(R.layout.activity_order_list);
    }

    @Override
    protected void assignViews()
    {
        super.assignViews();
        activityOrderList = (LinearLayout) findViewById(R.id.activity_order_list);
        orderListToolbar = (Toolbar) findViewById(R.id.order_list_toolbar);
        orderListContent = (FrameLayout) findViewById(R.id.order_list_content);
    }

    @Override
    protected void initToolbar()
    {
        super.initToolbar(orderListToolbar,R.string.toolbar_title_order_list,true,-1);
    }


    @Override
    protected void configViews()
    {
        super.configViews();

        OrderListFragment orderListFragment = (OrderListFragment) getSupportFragmentManager().findFragmentById(R.id.order_list_content);
        if (orderListFragment == null)
        {
            orderListFragment = OrderListFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),orderListFragment, R.id.order_list_content);
        }
        new OrderListPresenter(orderListFragment);
    }


    @Override
    protected void resumePresenter()
    {
//        OrderListFragment orderListFragment = (OrderListFragment) getSupportFragmentManager().findFragmentById(R.id.order_list_content);
//        new OrderListPresenter(orderListFragment);
        super.resumePresenter();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
//        getMenuInflater().inflate(R.menu.order_detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
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
