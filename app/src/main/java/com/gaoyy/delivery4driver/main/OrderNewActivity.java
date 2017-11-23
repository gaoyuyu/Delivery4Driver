package com.gaoyy.delivery4driver.main;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.api.RetrofitService;
import com.gaoyy.delivery4driver.api.bean.CommonInfo;
import com.gaoyy.delivery4driver.api.bean.OrderListInfo;
import com.gaoyy.delivery4driver.api.bean.OrderNewInfo;
import com.gaoyy.delivery4driver.base.BaseActivity;
import com.gaoyy.delivery4driver.base.CustomDialogFragment;
import com.gaoyy.delivery4driver.util.CommonUtils;
import com.gaoyy.delivery4driver.util.DialogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.jpush.android.api.JPushInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderNewActivity extends BaseActivity implements View.OnClickListener
{

    private RelativeLayout activityOrderNew;
    private Toolbar orderNewToolbar;
    private ProgressBar orderNewProgressbar;
    private LinearLayout orderNewMainLayout;
    private TextView orderNewTip;
    private TextView orderNewShip;
    private TextView orderNewTax;
    private TextView orderNewTaxTvq;
    private TextView orderNewIncome;
    private TextView orderNewCoupon;
    private TextView orderNewAcivity;
    private TextView orderNewSum;
    private TextView orderNewRemark;
    private TextView orderNewEaTime;
    private Spinner orderNewSpinner;
    private TextView orderNewEsTime;
    private TextView orderNewSubtotal;
    private LinearLayout orderNewOperationLayout;
    private AppCompatButton orderNewRefuseBtn;
    private AppCompatButton orderNewAcceptBtn;


    private TextView itemCommonAddtime;
    private TextView itemCommonAddress;
    private TextView itemCommonCustomer;
    private TextView itemCommonPhone;
    private TextView itemCommonNo;
    private LinearLayout itemCommonGoodsLayout;

    private OrderListInfo.BodyBean.PageBean.ListBean order;

    private List<String> expectTimeList = new ArrayList<>();

    private OrderNewInfo orderNewInfo;

    private CustomDialogFragment loading;

    private Call<OrderNewInfo> newOrderDetailCall;
    private Call<CommonInfo> acceptCall, refuseCall;

    //是否从推送进入Ativity
    private boolean isFormNotice;

    private String id = "";
    private String orderId = "";

    @Override
    protected void initContentView()
    {
        setContentView(R.layout.activity_order_new);
    }

    @Override
    protected void assignViews()
    {
        super.assignViews();
        activityOrderNew = (RelativeLayout) findViewById(R.id.activity_order_new);
        orderNewToolbar = (Toolbar) findViewById(R.id.order_new_toolbar);
        orderNewProgressbar = (ProgressBar) findViewById(R.id.order_new_progressbar);
        orderNewMainLayout = (LinearLayout) findViewById(R.id.order_new_main_layout);
        orderNewTip = (TextView) findViewById(R.id.order_new_tip);
        orderNewShip = (TextView) findViewById(R.id.order_new_ship);
        orderNewTax = (TextView) findViewById(R.id.order_new_tax);
        orderNewTaxTvq = (TextView) findViewById(R.id.order_new_tax_tvq);
        orderNewIncome = (TextView) findViewById(R.id.order_new_income);
        orderNewCoupon = (TextView) findViewById(R.id.order_new_coupon);
        orderNewAcivity = (TextView) findViewById(R.id.order_new_acivity);
        orderNewSum = (TextView) findViewById(R.id.order_new_sum);
        orderNewRemark = (TextView) findViewById(R.id.order_new_remark);
        orderNewEaTime = (TextView) findViewById(R.id.order_new_ea_time);
        orderNewSpinner = (Spinner) findViewById(R.id.order_new_spinner);
        orderNewEsTime = (TextView) findViewById(R.id.order_new_estime);
        orderNewSubtotal = (TextView) findViewById(R.id.order_new_subtotal);
        orderNewOperationLayout = (LinearLayout) findViewById(R.id.order_new_operation_layout);
        orderNewRefuseBtn = (AppCompatButton) findViewById(R.id.order_new_refuse_btn);
        orderNewAcceptBtn = (AppCompatButton) findViewById(R.id.order_new_accept_btn);

        itemCommonAddtime = (TextView) findViewById(R.id.item_common_addtime);
        itemCommonAddress = (TextView) findViewById(R.id.item_common_address);
        itemCommonCustomer = (TextView) findViewById(R.id.item_common_customer);
        itemCommonPhone = (TextView) findViewById(R.id.item_common_phone);
        itemCommonNo = (TextView) findViewById(R.id.item_common_no);
        itemCommonGoodsLayout = (LinearLayout) findViewById(R.id.item_common_goods_layout);
    }

    @Override
    protected void initToolbar()
    {
        super.initToolbar(orderNewToolbar, R.string.toolbar_title_order_new, true, -1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.order_new_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void configViews()
    {
        super.configViews();
        isFormNotice = getIntent().getBundleExtra("notice") != null;
        if (!isFormNotice)
        {
            order = (OrderListInfo.BodyBean.PageBean.ListBean) getIntent().getSerializableExtra("order");
            id = order.getId();
            orderId = String.valueOf(order.getOrderId());
        }
        else
        {
            Bundle bundle = getIntent().getBundleExtra("notice");
            try
            {
                JSONObject json = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                Iterator<String> it = json.keys();

                while (it.hasNext())
                {
                    String key = it.next().toString();
                    String value = json.optString(key);
                    if (key.equals("order_id"))
                    {
                        orderId = value;
                    }
                    if (key.equals("id"))
                    {
                        id = value;
                    }

                }
            }
            catch (JSONException e)
            {
                Log.e(Constant.TAG, "Get message extra JSON error!");
            }
            //餐厅接口无orderTime字段，默认30秒
            ValueAnimator valueAnimator = ValueAnimator.ofInt(30, 0);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator)
                {
                    int currentOrderTime = (int) valueAnimator.getAnimatedValue();
                    orderNewRefuseBtn.setText(getResources().getString(R.string.refuse_order_btn_text) + "（" + currentOrderTime + "）");
                }
            });
            valueAnimator.addListener(new AnimatorListenerAdapter()
            {
                @Override
                public void onAnimationEnd(Animator animation)
                {
                    super.onAnimationEnd(animation);
                    finish();
                }
            });
            valueAnimator.setDuration(30000);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.start();
        }

        String loginName = CommonUtils.getLoginName(this);
        String randomCode = CommonUtils.getRandomCode(this);


        Map<String, String> params = new HashMap<>();
        params.put("loginName", loginName);
        params.put("randomCode", randomCode);
        params.put("id", id);
        params.put("order_id", orderId);
        params.put("language", CommonUtils.getSysLanguage());

        CommonUtils.httpDebugLogger("最新订单参数-->" + params.toString());
        newOrderDetailCall = RetrofitService.sApiService.newOrderDetail(params);

        setLoadingVisible();
        newOrderDetailCall.enqueue(new Callback<OrderNewInfo>()
        {
            @Override
            public void onResponse(Call<OrderNewInfo> call, Response<OrderNewInfo> response)
            {
                if (response.isSuccessful() && response.body() != null)
                {
                    orderNewInfo = response.body();

                    if (orderNewInfo.isSuccess())
                    {
                        OrderNewInfo.BodyBean.ObjBean data = orderNewInfo.getBody().getObj();
                        Log.d(Constant.TAG, "=order_id==>" + data.getOrder_id());
                        if ((data.getDistribution_type() != null) && (data.getDistribution_type().equals("Pick-Up")))
                        {
                            Log.d(Constant.TAG, "=Pick-Up==>" + data.getDistribution_type());
                            ((LinearLayout) (orderNewTip.getParent())).setVisibility(View.GONE);
                            itemCommonCustomer.setText("" + data.getBuyerName());
                            itemCommonPhone.setText("" + data.getBuyerMobile());
                        }
                        else if ((data.getDistribution_type() != null) && (data.getDistribution_type().equals("Delivery")))
                        {
                            Log.d(Constant.TAG, "=Delivery==>" + data.getDistribution_type());
                            ((LinearLayout) (orderNewTip.getParent())).setVisibility(View.VISIBLE);
                            itemCommonCustomer.setText("" + data.getAddr().getTrueName());
                            itemCommonPhone.setText("" + data.getAddr().getMobile());
                        }

                        Log.e(Constant.TAG, "bean->" + data.toString());

                        itemCommonAddtime.setText("" + data.getAddTime());
                        itemCommonNo.setText("" + data.getOrder_id());

                        List<OrderNewInfo.BodyBean.ObjBean.GcsBean> goods = data.getGcs();
                        itemCommonGoodsLayout.removeAllViews();

                        double sub = 0;

                        for (OrderNewInfo.BodyBean.ObjBean.GcsBean item : goods)
                        {
                            View root = LayoutInflater.from(OrderNewActivity.this).inflate(R.layout.item_food, itemCommonGoodsLayout, false);
                            TextView goodName = (TextView) root.findViewById(R.id.item_food_name);
                            TextView goodCount = (TextView) root.findViewById(R.id.item_food_count);
                            TextView goodPrice = (TextView) root.findViewById(R.id.item_food_price);
                            goodName.setText("" + item.getGoods_name());
                            goodCount.setText("x" + item.getCount());
                            double itemSub = (item.getCount()) * ((double) item.getPrice());
                            sub += itemSub;
                            //保留2位小数
                            goodPrice.setText("$" + CommonUtils.deci2(item.getPrice()));
                            itemCommonGoodsLayout.addView(root);
                        }
                        orderNewSubtotal.setText("$" + CommonUtils.deci2(sub));
                        //设置价格
                        setPrice(data);
                        //总计
                        orderNewSum.setText("$" + CommonUtils.deci2(data.getTotalPrice()));
                        //备注
                        orderNewRemark.setText(data.getMsg() + "");
                        //期望送达时间
                        orderNewEaTime.setText("" + data.getAppointment_time());

                        expectTimeList.add("");
                        expectTimeList.add("now");
                        expectTimeList.add("5min");
                        expectTimeList.add("10min");
                        expectTimeList.add("15min");
                        expectTimeList.add("20min");
                        //适配器
                        ArrayAdapter adapter = new ArrayAdapter<String>(OrderNewActivity.this, android.R.layout.simple_spinner_item, expectTimeList);
                        //设置样式
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        //加载适配器
                        orderNewSpinner.setAdapter(adapter);

                        setLoadingGone();

                        /**
                         * flage  0-没接单 1-已接单
                         * 已接单-不显示拒绝按钮，接单按钮，预计送达时间
                         */
                        if (1 == Integer.valueOf(orderNewInfo.getBody().getFlag()))
                        {
                            orderNewOperationLayout.setVisibility(View.GONE);
                            if (data.getEstimatedTime() == null)
                            {
                                ((LinearLayout) (orderNewSpinner.getParent())).setVisibility(View.GONE);
                            }
                            else
                            {
                                orderNewSpinner.setVisibility(View.GONE);
                                orderNewEsTime.setText(data.getEstimatedTime());
                            }
                        }
                        else
                        {
                            orderNewOperationLayout.setVisibility(View.VISIBLE);
                            ((LinearLayout) (orderNewSpinner.getParent())).setVisibility(View.VISIBLE);
                            orderNewEsTime.setVisibility(View.GONE);
                        }

                    }
                    else
                    {
                        CommonUtils.showToast(OrderNewActivity.this,orderNewInfo.getMsg());
                        orderNewProgressbar.setVisibility(View.GONE);
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<OrderNewInfo> call, Throwable t)
            {
                Log.e(Constant.TAG, "error->" + t.toString());
            }
        });

    }

    /**
     * 设置价格
     *
     * @param data
     */
    private void setPrice(OrderNewInfo.BodyBean.ObjBean data)
    {
        //小费
        if (data.getTipPrice() == null || (Double) (data.getTipPrice()) == 0.0)
        {
            ((LinearLayout) (orderNewTip.getParent())).setVisibility(View.GONE);
        }
        else
        {
            ((TextView) ((LinearLayout) (orderNewTip.getParent())).getChildAt(0)).setText(getResources().getString(R.string.tip_price) + "(" + data.getTipRate() + "%)");
            orderNewTip.setText("$" + CommonUtils.deci2(data.getTipPrice()));
        }

        //配送费
        if (data.getShip_price() == null || (Double) (data.getShip_price()) == 0.0)
        {
            ((LinearLayout) (orderNewShip.getParent())).setVisibility(View.GONE);
        }
        else
        {
            orderNewShip.setText("$" + CommonUtils.deci2(data.getShip_price()));
        }

        //税1
        if (data.getTaxation() == null || (Double) (data.getTaxation()) == 0.0)
        {
            ((LinearLayout) (orderNewTax.getParent())).setVisibility(View.GONE);
        }
        else
        {
            ((TextView) ((LinearLayout) (orderNewTax.getParent())).getChildAt(0)).setText(getResources().getString(R.string.taxation) + "(" + data.getTaxrate() + "%)");

            orderNewTax.setText("$" + CommonUtils.deci2(data.getTaxation()));
        }

        //税2
        if (data.getTaxation_tvq() == null || (Double) (data.getTaxation_tvq()) == 0.0)
        {
            ((LinearLayout) (orderNewTaxTvq.getParent())).setVisibility(View.GONE);
        }
        else
        {
            ((TextView) ((LinearLayout) (orderNewTaxTvq.getParent())).getChildAt(0)).setText(getResources().getString(R.string.taxation_tvq) + "(" + data.getTaxrate_tvq() + "%)");
            orderNewTaxTvq.setText("$" + CommonUtils.deci2(data.getTaxation_tvq()));
        }

        //收益
        if (data.getUseIncomePrice() == null || (Double) (data.getUseIncomePrice()) == 0.0)
        {
            ((LinearLayout) (orderNewIncome.getParent())).setVisibility(View.GONE);
        }
        else
        {
            orderNewIncome.setText("-$" + CommonUtils.deci2(data.getUseIncomePrice()));
        }

        //代金券
        if (data.getCouponPrice() == null || (Double) (data.getCouponPrice()) == 0.0)
        {
            ((LinearLayout) (orderNewCoupon.getParent())).setVisibility(View.GONE);
        }
        else
        {
            orderNewCoupon.setText("-$" + CommonUtils.deci2(data.getCouponPrice()));
        }

        //商家满减
        if (data.getActivityPrice() == null || (Double) (data.getActivityPrice()) == 0.0)
        {
            ((LinearLayout) (orderNewAcivity.getParent())).setVisibility(View.GONE);
        }
        else
        {
            orderNewAcivity.setText("-$" + CommonUtils.deci2(data.getActivityPrice()));
        }
    }

    private void setLoadingVisible()
    {
        orderNewProgressbar.setVisibility(View.VISIBLE);
        orderNewMainLayout.setVisibility(View.GONE);
        orderNewOperationLayout.setVisibility(View.GONE);
    }

    private void setLoadingGone()
    {
        orderNewProgressbar.setVisibility(View.GONE);
        orderNewMainLayout.setVisibility(View.VISIBLE);
        orderNewOperationLayout.setVisibility(View.VISIBLE);
    }


    @Override
    protected void setListener()
    {
        super.setListener();
        orderNewRefuseBtn.setOnClickListener(this);
        orderNewAcceptBtn.setOnClickListener(this);
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
            case R.id.action_print_order:
                Intent intent = new Intent(OrderNewActivity.this, PrintActivity.class);
                intent.putExtra("orderNewInfo", orderNewInfo);
                startActivityForResult(intent, Constant.REQUEST_PRINT);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.REQUEST_PRINT)
        {
            if (resultCode == RESULT_OK)
            {
                CommonUtils.showToast(this, R.string.print_complete);
                //打印完成后关闭页面，跳转到订单列表
                finishToOrderList();
            }
            else if (resultCode == RESULT_CANCELED)
            {
                CommonUtils.showToast(this, R.string.print_cancel);
                //打印完成后关闭页面，跳转到订单列表
                finishToOrderList();
            }
        }
    }

    @Override
    public void onClick(View view)
    {
        int id = view.getId();
        switch (id)
        {
            case R.id.order_new_refuse_btn:
                AlertDialog.Builder dialog = new AlertDialog.Builder(OrderNewActivity.this);
                dialog.setTitle(R.string.dialog_reminder).setMessage(R.string.alert_confirm_refuse);
                dialog.setPositiveButton(R.string.alert_confirm,
                        new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                orderRefuse();
                            }
                        })
                        .setNegativeButton(R.string.alert_cancel, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                dialog.dismiss();
                            }
                        }).show();
                break;
            case R.id.order_new_accept_btn:
                orderAccept();
                break;
        }
    }

    public void showLoading()
    {
        loading = DialogUtils.showLoadingDialog(this);
    }

    public void hideLoading()
    {
        if (loading != null)
        {
            loading.dismissAllowingStateLoss();
        }
    }

    /**
     * 接单
     */
    private void orderAccept()
    {
        if (String.valueOf(orderNewSpinner.getSelectedItem()).equals(""))
        {
            CommonUtils.showToast(this, R.string.es_arrival_time_check);
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("order_id", orderId);
        params.put("finishedTime", orderNewSpinner.getSelectedItem() + "");
        params.put("loginName", CommonUtils.getLoginName(this));
        params.put("randomCode", CommonUtils.getRandomCode(this));
        CommonUtils.httpDebugLogger("接受订单请求参数" + params.toString());
        acceptCall = RetrofitService.sApiService.orderAccept(params);
        showLoading();
        acceptCall.enqueue(new Callback<CommonInfo>()
        {
            @Override
            public void onResponse(Call<CommonInfo> call, Response<CommonInfo> response)
            {
                hideLoading();
                if (response.isSuccessful() && response.body() != null)
                {
                    CommonInfo commonInfo = response.body();
                    CommonUtils.showToast(OrderNewActivity.this, commonInfo.getMsg());
                    if (commonInfo.isSuccess())
                    {
                        if (!isFormNotice)
                        {
                            Intent intent = new Intent(OrderNewActivity.this, PrintActivity.class);
                            intent.putExtra("orderNewInfo", orderNewInfo);
                            startActivityForResult(intent, Constant.REQUEST_PRINT);
                        }
                        else
                        {
                            finish();
                        }

                    }

                }
                else
                {
                    CommonUtils.showToast(OrderNewActivity.this, "接受订单请求失败");
                }

            }

            @Override
            public void onFailure(Call<CommonInfo> call, Throwable t)
            {
                hideLoading();
                CommonUtils.httpErrorLogger(t.toString());
            }
        });
    }

    /**
     * 拒绝接单
     */
    private void orderRefuse()
    {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("order_id", orderId);
        params.put("loginName", CommonUtils.getLoginName(this));
        params.put("randomCode", CommonUtils.getRandomCode(this));
        CommonUtils.httpDebugLogger("拒绝接单请求参数" + params.toString());
        refuseCall = RetrofitService.sApiService.orderRefuse(params);

        showLoading();
        refuseCall.enqueue(new Callback<CommonInfo>()
        {
            @Override
            public void onResponse(Call<CommonInfo> call, Response<CommonInfo> response)
            {
                hideLoading();
                if (response.isSuccessful() && response.body() != null)
                {
                    CommonInfo commonInfo = response.body();
                    CommonUtils.showToast(OrderNewActivity.this, commonInfo.getMsg());
                    if (commonInfo.isSuccess())
                    {
                        orderNewOperationLayout.setVisibility(View.GONE);
                        ((LinearLayout) (orderNewSpinner.getParent())).setVisibility(View.GONE);
                        //拒绝接单后finish页面，跳转到订单列表
                        finishToOrderList();
                    }
                }
                else
                {
                    CommonUtils.showToast(OrderNewActivity.this, "拒绝接单请求失败");
                }
            }

            @Override
            public void onFailure(Call<CommonInfo> call, Throwable t)
            {
                hideLoading();
                CommonUtils.httpErrorLogger(t.toString());
            }
        });
    }

    /**
     * finish后，跳转到订单列表
     */
    private void finishToOrderList()
    {
        finish();
        Intent orderList = new Intent();
        orderList.setAction("android.intent.action.DetailToMainReceiver");
        orderList.putExtra("orderList", 1);
        sendBroadcast(orderList);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        //取消网络请求
        if (newOrderDetailCall != null) newOrderDetailCall.cancel();
        if (acceptCall != null) acceptCall.cancel();
        if (refuseCall != null) refuseCall.cancel();
    }
}
