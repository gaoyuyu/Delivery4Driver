package com.gaoyy.delivery4driver.orderlist;

import android.util.Log;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.api.bean.OrderListInfo;
import com.gaoyy.delivery4driver.util.CommonUtils;

import java.util.LinkedList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gaoyy on 2017/5/6 0006.
 */

public class OrderListPresenter implements OrderListContract.Presenter
{
    private OrderListContract.View mOrderListView;

    public OrderListPresenter(OrderListContract.View mOrderListView)
    {
        this.mOrderListView = mOrderListView;
        mOrderListView.setPresenter(this);
    }

    @Override
    public void start()
    {
        Log.i(Constant.TAG, "OrderList start");
    }

    @Override
    public void orderList(Call<OrderListInfo> call, Map<String, String> params, final int refreshTag)
    {
        CommonUtils.httpDebugLogger("获取订单列表");

        mOrderListView.refreshing();

        call.enqueue(new Callback<OrderListInfo>()
        {
            @Override
            public void onResponse(Call<OrderListInfo> call, Response<OrderListInfo> response)
            {
                if (!mOrderListView.isActive())
                {
                    return;
                }

                //停止刷新
                mOrderListView.finishRefesh();

                if (response.isSuccessful() && response.body() != null)
                {
                    OrderListInfo orderListInfo = response.body();
                    String msg = orderListInfo.getMsg();
                    String errorCode = orderListInfo.getErrorCode();
                    CommonUtils.httpDebugLogger("[isSuccess=" + orderListInfo.isSuccess() + "][errorCode=" + errorCode + "][msg=" + msg + "]");
                    if (orderListInfo.isSuccess())
                    {
                        LinkedList<OrderListInfo.BodyBean.PageBean.ListBean> orderList = orderListInfo.getBody().getPage().getList();
                        if (refreshTag == OrderListFragment.PULL_TO_REFRESH)
                        {
                            mOrderListView.showOrderList(orderList, orderListInfo.getBody().getPage().getCount());
                        }
                        else
                        {
                            mOrderListView.loadMoreOrderList(orderList, orderListInfo.getBody().getPage().getCount());
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<OrderListInfo> call, Throwable t)
            {
                if (!mOrderListView.isActive())
                {
                    return;
                }
                //停止刷新
                mOrderListView.finishRefesh();
                CommonUtils.httpErrorLogger(t.toString());
                mOrderListView.showToast(R.string.network_error);
            }
        });
    }
}
