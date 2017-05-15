package com.gaoyy.delivery4driver.main;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.api.RetrofitService;
import com.gaoyy.delivery4driver.api.bean.GeocodeInfo;
import com.gaoyy.delivery4driver.api.bean.OrderSaveInfo;
import com.gaoyy.delivery4driver.base.BaseActivity;
import com.gaoyy.delivery4driver.base.CustomDialogFragment;
import com.gaoyy.delivery4driver.orderlist.OrderListActivity;
import com.gaoyy.delivery4driver.util.CommonUtils;
import com.gaoyy.delivery4driver.util.DialogUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetailActivity extends BaseActivity implements OnMapReadyCallback
{

    private Toolbar orderDetailToolbar;
    private TextView orderDetailStartPoint;
    private TextView orderDetailDistination;
    private TextView orderDetailPhone;
    private TextView orderDetailNotes;
    private TextView orderDetailFinishTime;
    private TextView orderDetailOther;

    private GoogleMap mMap;


    //数据
    private String startDeliveryTime;
    private String endDeliveryTime;
    private String hotelAddr;
    private String hotelLng;
    private String hotelLat;

    private String customerTel;
    private String customerAddr;
    private String apt;
    private String finishedTime;
    private String remark;
    private String remarks;

    //客人经纬度
    private double customerAddrLat;
    private double customerAddrLng;

    @Override
    protected void initContentView()
    {
        setContentView(R.layout.activity_order_detail);
    }

    @Override
    protected void assignViews()
    {
        super.assignViews();
        orderDetailToolbar = (Toolbar) findViewById(R.id.order_detail_toolbar);
        orderDetailStartPoint = (TextView) findViewById(R.id.order_detail_start_point);
        orderDetailDistination = (TextView) findViewById(R.id.order_detail_distination);
        orderDetailPhone = (TextView) findViewById(R.id.order_detail_phone);
        orderDetailNotes = (TextView) findViewById(R.id.order_detail_notes);
        orderDetailFinishTime = (TextView) findViewById(R.id.order_detail_finish_time);
        orderDetailOther = (TextView) findViewById(R.id.order_detail_other);
    }

    @Override
    protected void initToolbar()
    {
        super.initToolbar(orderDetailToolbar, "订单详情", true, -1);
    }


    @Override
    protected void configViews()
    {
        super.configViews();


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.order_detail_map);
        mapFragment.getMapAsync(this);

        SharedPreferences hotelInfo = getSharedPreferences("hotel", Activity.MODE_PRIVATE);
        startDeliveryTime = hotelInfo.getString("startDeliveryTime", "");
        endDeliveryTime = hotelInfo.getString("endDeliveryTime", "");
        hotelAddr = hotelInfo.getString("addr", "");
        hotelLng = hotelInfo.getString("longitude", "");
        hotelLat = hotelInfo.getString("latitude", "");

        customerTel = getIntent().getStringExtra("customerTel");
        customerAddr = getIntent().getStringExtra("customerAddr");
        apt = getIntent().getStringExtra("apt");
        finishedTime = getIntent().getStringExtra("finishedTime");
        remark = getIntent().getStringExtra("remark");
        remarks = getIntent().getStringExtra("remarks").trim();

        orderDetailStartPoint.setText(hotelAddr);
        orderDetailDistination.setText("APT:" + apt + " " + customerAddr);
        orderDetailPhone.setText(customerTel);
        orderDetailNotes.setText(remark);
        orderDetailFinishTime.setText(finishedTime);
        orderDetailOther.setText(remarks);

        Call<GeocodeInfo> call = RetrofitService.sGoogleMapApiService.getLatLng(customerAddr, Constant.GOOGLE_MAP_KEY);
        final CustomDialogFragment loading = DialogUtils.showLoadingDialog(this);
        call.enqueue(new Callback<GeocodeInfo>()
        {
            @Override
            public void onResponse(Call<GeocodeInfo> call, Response<GeocodeInfo> response)
            {
                loading.dismiss();
                if (response.isSuccessful() && response.body() != null)
                {
                    GeocodeInfo geocodeInfo = response.body();

                    customerAddrLat = geocodeInfo.getResults().get(0).getGeometry().getLocation().getLat();
                    customerAddrLng = geocodeInfo.getResults().get(0).getGeometry().getLocation().getLng();

                    Log.d(Constant.TAG,"customerAddrLat--->"+customerAddrLat);
                    Log.d(Constant.TAG,"customerAddrLng--->"+customerAddrLng);

                    LatLng res = new LatLng(Double.parseDouble(hotelLat), Double.parseDouble(hotelLng));
                    LatLng cus = new LatLng(customerAddrLat, customerAddrLng);

                    MarkerOptions resOptions = new MarkerOptions()
                            .position(res)
                            .title(hotelAddr)
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_restaurant_location));
                    MarkerOptions cusOptions = new MarkerOptions()
                            .position(cus)
                            .title(customerAddr)
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_customer_location));

                    mMap.addMarker(resOptions);
                    mMap.addMarker(cusOptions);

                    mMap.animateCamera(CameraUpdateFactory.newLatLng(res));

                }
            }

            @Override
            public void onFailure(Call<GeocodeInfo> call, Throwable t)
            {
                loading.dismiss();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.order_detail_menu, menu);
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
            case R.id.action_submit:
                orderSave();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 保存订单数据到服务器
     */
    private void orderSave()
    {
        Map<String,String> params = new HashMap<>();
        params.put("loginName", CommonUtils.getLoginName(this));
        params.put("randomCode",CommonUtils.getRandomCode(this));
        params.put("customerTel",customerTel);
        params.put("customerAddr",customerAddr);
        params.put("apt",apt);
        params.put("orderPrice","0");
        params.put("remark",remark);
        params.put("remarks",remarks);
        params.put("customerLongitude",String.valueOf(customerAddrLng));
        params.put("customerLatitude",String.valueOf(customerAddrLat));
        params.put("finishedTime",finishedTime);
        Call<OrderSaveInfo> call = RetrofitService.sApiService.orderSave(params);
        final CustomDialogFragment loading = DialogUtils.showLoadingDialog(this);
        call.enqueue(new Callback<OrderSaveInfo>()
        {
            @Override
            public void onResponse(Call<OrderSaveInfo> call, Response<OrderSaveInfo> response)
            {
                loading.dismiss();
                if (response.isSuccessful() && response.body() != null)
                {
                    OrderSaveInfo orderSaveInfo = response.body();
                    CommonUtils.showSnackBar(orderDetailToolbar,orderSaveInfo.getMsg());
                    if(orderSaveInfo.getBody()!= null)
                    {
                        CustomDialogFragment dialog = DialogUtils.showAlertDialog(OrderDetailActivity.this,"Operation Successfully Competed","Order has been sent,wait for being accepted",
                                "continue to send orders","Order Lists");
                        dialog.setOnAlertDialogClickListener(new CustomDialogFragment.OnAlertDialogClickListener()
                        {
                            @Override
                            public void onButtonClick(DialogInterface dialog, int which)
                            {
                                switch (which)
                                {
                                    case AlertDialog.BUTTON_NEGATIVE:
                                        dialog.dismiss();
                                        finish();
                                        break;
                                    case AlertDialog.BUTTON_POSITIVE:
                                        // TODO: 2017/5/13 0013  跳转到OrderList
                                        Intent orderList = new Intent();
                                        orderList.setClass(OrderDetailActivity.this, OrderListActivity.class);
                                        startActivity(orderList);
                                        finish();
                                        break;
                                    default:
                                        break;
                                }

                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<OrderSaveInfo> call, Throwable t)
            {
                loading.dismiss();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        configMapUiSettings();
    }

    /**
     * 配置地图
     */
    private void configMapUiSettings()
    {
        UiSettings mUiSettings = mMap.getUiSettings();
        mUiSettings.setZoomControlsEnabled(true);
        mUiSettings.setCompassEnabled(true);
        mUiSettings.setMyLocationButtonEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        mMap.setMyLocationEnabled(true);
        mUiSettings.setScrollGesturesEnabled(true);
        mUiSettings.setZoomGesturesEnabled(true);
        mUiSettings.setTiltGesturesEnabled(true);
        mUiSettings.setRotateGesturesEnabled(true);
        mUiSettings.setMapToolbarEnabled(true);
    }
}
