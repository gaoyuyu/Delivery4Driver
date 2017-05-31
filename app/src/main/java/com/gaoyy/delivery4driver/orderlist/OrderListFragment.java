package com.gaoyy.delivery4driver.orderlist;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.adapter.OrderListAdapter;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.api.RetrofitService;
import com.gaoyy.delivery4driver.api.bean.OrderListInfo;
import com.gaoyy.delivery4driver.api.bean.OrderOperationStatusInfo;
import com.gaoyy.delivery4driver.base.BaseFragment;
import com.gaoyy.delivery4driver.base.CustomDialogFragment;
import com.gaoyy.delivery4driver.main.OrderDetailActivity;
import com.gaoyy.delivery4driver.util.CommonUtils;
import com.gaoyy.delivery4driver.util.DialogUtils;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OrderListFragment extends BaseFragment implements OrderListContract.View, SwipeRefreshLayout.OnRefreshListener, OrderListAdapter.OnItemClickListener
{
    //下拉刷新标识
    public static final int PULL_TO_REFRESH = 400;
    //上拉加载更多标识
    public static final int UP_TO_LOAD_MORE = 500;

    private OrderListContract.Presenter mOrderListPresenter;
    private static final String LOG_TAG = OrderListFragment.class.getSimpleName();


    private ProgressWheel commonProgresswheel;
    private SwipeRefreshLayout commonSwipeRefreshLayout;
    private RecyclerView commonRv;
    private int lastVisibleItem;


    private int pageNo = 1;
    private int pageSize = 3;
    private int pageCount;

    private LinearLayoutManager linearLayoutManager;
    private OrderListAdapter orderListAdapter;
    private LinkedList<OrderListInfo.BodyBean.PageBean.ListBean> orderList = new LinkedList<>();


    public OrderListFragment()
    {
        // Required empty public constructor
    }

    public static OrderListFragment newInstance()
    {
        OrderListFragment fragment = new OrderListFragment();
        return fragment;
    }


    @Override
    protected int getFragmentLayoutId()
    {
        return R.layout.fragment_order_list;
    }


    @Override
    protected void assignViews(View rootView)
    {
        super.assignViews(rootView);
        commonProgresswheel = (ProgressWheel) rootView.findViewById(R.id.common_progresswheel);
        commonSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.common_swipeRefreshLayout);
        commonRv = (RecyclerView) rootView.findViewById(R.id.common_rv);
    }


    @Override
    protected void configViews()
    {
        super.configViews();
        orderListAdapter = new OrderListAdapter(activity, orderList);
        commonRv.setAdapter(orderListAdapter);
        //设置布局
        linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        commonRv.setLayoutManager(linearLayoutManager);
        commonRv.setItemAnimator(new DefaultItemAnimator());

        CommonUtils.setSwipeLayoutProgressBackgroundColor(activity, commonSwipeRefreshLayout);


    }

    @Override
    protected void setListener()
    {
        super.setListener();

        commonSwipeRefreshLayout.setOnRefreshListener(this);
        commonRv.setOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState)
            {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == orderListAdapter.getItemCount())
                {
                    //总共有多少页
                    int pageSum = 0;
                    pageNo = pageNo + 1;

                    if (pageCount % pageSize == 0)
                    {
                        pageSum = pageCount / pageSize;
                    }
                    else
                    {
                        pageSum = pageCount / pageSize + 1;
                    }
                    Log.d(Constant.TAG, "page sum-->" + pageSum);
                    Log.d(Constant.TAG, "page No-->" + pageNo);
                    if (pageNo <= pageSum)
                    {
                        Map<String, String> params = getOrderListParams(pageNo, pageSize);
                        Log.d(Constant.TAG, "上拉加载更多，传递参数-->" + params.toString());
                        mOrderListPresenter.orderList(params, UP_TO_LOAD_MORE);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
        //设置item的点击事件
        orderListAdapter.setOnItemClickListener(this);
    }

    @NonNull
    private Map<String, String> getOrderListParams(int pageNo, int pageSize)
    {
        Map<String, String> params = new HashMap<>();
        params.put("loginName", CommonUtils.getLoginName(activity));
        params.put("randomCode", CommonUtils.getRandomCode(activity));
        params.put("pageNo", String.valueOf(pageNo));
        params.put("pageSize", String.valueOf(pageSize));
        return params;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        mOrderListPresenter.start();

        //在onResume中加载数据
        pageNo=1;
        Map<String, String> params = getOrderListParams(pageNo, pageSize);
        Log.d(Constant.TAG, params.toString());
        mOrderListPresenter.orderList(params, PULL_TO_REFRESH);
    }

    @Override
    public boolean isActive()
    {
        return isAdded();
    }


    @Override
    public void showOrderList(LinkedList<OrderListInfo.BodyBean.PageBean.ListBean> orderList, int count)
    {
        orderListAdapter.updateData(orderList);
        pageCount = count;
    }

    @Override
    public void loadMoreOrderList(LinkedList<OrderListInfo.BodyBean.PageBean.ListBean> orderList, int count)
    {
        orderListAdapter.addMoreItem(orderList);
        pageCount = count;
    }

    @Override
    public void refreshing()
    {
        commonSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void finishRefesh()
    {
        commonSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showToast(String msg)
    {
        CommonUtils.showToast(activity,msg);
    }

    @Override
    public void setPresenter(OrderListContract.Presenter presenter)
    {
        Log.i(Constant.TAG, LOG_TAG + "  setPresenter");
        if (presenter != null)
        {
            mOrderListPresenter = presenter;
        }
    }

    @Override
    public void onRefresh()
    {
        pageNo = 1;
        Map<String, String> params = getOrderListParams(pageNo, pageSize);
        Log.d(Constant.TAG, "下拉刷新，传递参数-->" + params.toString());
        mOrderListPresenter.orderList(params, PULL_TO_REFRESH);
    }

    @Override
    public void onItemClick(View view, int position, final OrderListInfo.BodyBean.PageBean.ListBean order)
    {
        int id = view.getId();
        switch (id)
        {
            case R.id.item_order_card_view:
                Intent intent = new Intent(activity, OrderDetailActivity.class);
                intent.putExtra("order", order);
                startActivity(intent);
                break;
            case R.id.item_order_pick_up_btn:
                orderSend(position,order);
                break;
            case R.id.item_order_finish_btn:
                orderFinish(position,order);
                break;
        }
    }

    /**
     * 饭店及司机订单派送，用于Delivery按钮
     * @param position
     * @param order
     */
    private void orderSend(final int position,final OrderListInfo.BodyBean.PageBean.ListBean order)
    {
        CommonUtils.httpDebugLogger("司机订单派送请求");
        final CustomDialogFragment deliveryLoading = DialogUtils.showLoadingDialog(activity);
        Call<OrderOperationStatusInfo> deliveryCall = RetrofitService.sApiService.orderSend(CommonUtils.getLoginName(activity), CommonUtils.getRandomCode(activity), order.getId());
        deliveryCall.enqueue(new Callback<OrderOperationStatusInfo>()
        {
            @Override
            public void onResponse(Call<OrderOperationStatusInfo> call, Response<OrderOperationStatusInfo> response)
            {
                deliveryLoading.dismiss();
                if (response.isSuccessful() && response.body() != null)
                {
                    OrderOperationStatusInfo oosi = response.body();
                    String errorCode = oosi.getErrorCode();
                    String msg = oosi.getMsg();
                    CommonUtils.httpDebugLogger("[isSuccess="+oosi.isSuccess()+"][errorCode=" + errorCode + "][msg=" + msg + "]");
                    CommonUtils.showSnackBar(commonRv, oosi.getMsg());
                    if (oosi.isSuccess() && oosi.getErrorCode().equals("-1"))
                    {
                        int status = oosi.getBody().getStatus();
                        //设置订单状态
                        order.setStatus(status);
                        //设置delivery时间
                        order.setDeliveryDate(CommonUtils.getCurrentTime());
                        //更新数据
                        orderListAdapter.singleItemUpdate(position,order);
                    }
                }
            }

            @Override
            public void onFailure(Call<OrderOperationStatusInfo> call, Throwable t)
            {
                deliveryLoading.dismiss();
                CommonUtils.httpErrorLogger(t.toString());
                CommonUtils.showToast(activity,getResources().getString(R.string.network_error));
            }
        });
    }

    /**
     * 完成订单
     * @param position
     * @param order
     */
    private void orderFinish(final int position,final OrderListInfo.BodyBean.PageBean.ListBean order)
    {
        CommonUtils.httpDebugLogger("司机完成订单请求");
        final CustomDialogFragment finishLoading = DialogUtils.showLoadingDialog(activity);
        Call<OrderOperationStatusInfo> finishCall = RetrofitService.sApiService.orderFinish(CommonUtils.getLoginName(activity), CommonUtils.getRandomCode(activity), order.getId());
        finishCall.enqueue(new Callback<OrderOperationStatusInfo>()
        {
            @Override
            public void onResponse(Call<OrderOperationStatusInfo> call, Response<OrderOperationStatusInfo> response)
            {
                finishLoading.dismiss();
                if (response.isSuccessful() && response.body() != null)
                {
                    OrderOperationStatusInfo oosi = response.body();
                    String errorCode = oosi.getErrorCode();
                    String msg = oosi.getMsg();
                    CommonUtils.httpDebugLogger("[isSuccess="+oosi.isSuccess()+"][errorCode=" + errorCode + "][msg=" + msg + "]");
                    CommonUtils.showSnackBar(commonRv, oosi.getMsg());
                    if (oosi.isSuccess() && oosi.getErrorCode().equals("-1"))
                    {
                        int status = oosi.getBody().getStatus();
                        //设置订单状态
                        order.setStatus(status);
                        //设置取消时间
                        order.setFinishDate(CommonUtils.getCurrentTime());
                        //更新数据
                        orderListAdapter.singleItemUpdate(position,order);
                    }
                }
            }

            @Override
            public void onFailure(Call<OrderOperationStatusInfo> call, Throwable t)
            {
                finishLoading.dismiss();
                CommonUtils.httpErrorLogger(t.toString());
                CommonUtils.showToast(activity,getResources().getString(R.string.network_error));
            }
        });
    }
}
