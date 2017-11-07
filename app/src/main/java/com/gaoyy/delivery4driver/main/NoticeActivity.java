package com.gaoyy.delivery4driver.main;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.api.RetrofitService;
import com.gaoyy.delivery4driver.api.bean.OrderOperationStatusInfo;
import com.gaoyy.delivery4driver.base.BaseActivity;
import com.gaoyy.delivery4driver.base.CustomDialogFragment;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import cn.jpush.android.api.JPushInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticeActivity extends BaseActivity implements OnMapReadyCallback, View.OnClickListener
{
    private Toolbar noticeToolbar;
    private LinearLayout noticeLayout;
    private TextView noticeDate;
    private TextView noticeStartPoint;
    private TextView noticeDistination;
    private TextView noticePhone;
    private TextView noticeNotes;
    private TextView noticeOther;
    private TextView noticeFinishTime;
    private LinearLayout noticeBtnLayout;

    private AppCompatButton noticeCancleBtn;
    private AppCompatButton noticeAcceptBtn;


    private GoogleMap mMap;
    private double customerLatitude;
    private double customerLongitude;
    private double hotelLatitude;
    private double hotelLongitude;
    private String hotelName = "";
    private String customerAddr = "";
    private String orderId;

    private Call<OrderOperationStatusInfo> deliveryCall;


    @Override
    protected void initContentView()
    {
        setContentView(R.layout.activity_notice);
    }

    @Override
    protected void assignViews()
    {
        super.assignViews();
        noticeToolbar = (Toolbar) findViewById(R.id.notice_toolbar);
        noticeLayout = (LinearLayout) findViewById(R.id.notice_layout);
        noticeDate = (TextView) findViewById(R.id.notice_date);
        noticeStartPoint = (TextView) findViewById(R.id.notice_start_point);
        noticeDistination = (TextView) findViewById(R.id.notice_distination);
        noticePhone = (TextView) findViewById(R.id.notice_phone);
        noticeNotes = (TextView) findViewById(R.id.notice_notes);
        noticeOther = (TextView) findViewById(R.id.notice_other);
        noticeFinishTime = (TextView) findViewById(R.id.notice_finish_time);
        noticeBtnLayout = (LinearLayout) findViewById(R.id.notice_btn_layout);
        noticeCancleBtn = (AppCompatButton) findViewById(R.id.notice_cancle_btn);
        noticeAcceptBtn = (AppCompatButton) findViewById(R.id.notice_accept_btn);
    }


    @Override
    protected void initToolbar()
    {
        super.initToolbar(noticeToolbar, R.string.toolbar_title_new_order, true, -1);
    }

    @Override
    protected void configViews()
    {
        super.configViews();
        Bundle bundle = getIntent().getBundleExtra("notice");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.notice_map);
        mapFragment.getMapAsync(this);

        Log.d(Constant.TAG, "orderTine-->" + CommonUtils.getOrderTime(this));

        int orderTime = CommonUtils.getOrderTime(this);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(orderTime, 0);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator)
            {
                int currentOrderTime = (int) valueAnimator.getAnimatedValue();
                noticeCancleBtn.setText(getResources().getString(R.string.status_cancle) + "（" + currentOrderTime + "）");
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

        try
        {
            JSONObject json = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
            Iterator<String> it = json.keys();

            while (it.hasNext())
            {
                String key = it.next().toString();
                String value = json.optString(key);

                Log.d(Constant.TAG, "Notice---key-->" + key);
                Log.d(Constant.TAG, "Notice---value-->" + json.optString(key));

                setTextData(key, value, "hotelAddr", noticeStartPoint);
                setTextData(key, value, "customerAddr", noticeDistination);
                setTextData(key, value, "customerTel", noticePhone);
                setTextData(key, value, "remark", noticeNotes);
                setTextData(key, value, "remarks", noticeOther);
                setTextData(key, value, "createDate", noticeDate);
                if (key.equals("id"))
                {
                    orderId = value;
                }
            }
        }
        catch (JSONException e)
        {
            Log.e(Constant.TAG, "Get message extra JSON error!");
        }

        noticeCancleBtn.setOnClickListener(this);
        noticeAcceptBtn.setOnClickListener(this);

    }


    private void setTextData(String key, String value, String keyName, TextView tv)
    {
        if (key.equals(keyName))
        {
            tv.setText(value);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
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

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        configMapUiSettings();

        Bundle bundle = getIntent().getBundleExtra("notice");

        try
        {
            JSONObject json = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
            Iterator<String> it = json.keys();

            while (it.hasNext())
            {
                String key = it.next().toString();
                String value = json.optString(key);


                if (key.equals("name"))
                {
                    hotelName = value;
                }
                if (key.equals("customerAddr"))
                {
                    customerAddr = value;
                }


                if (key.equals("customerLatitude"))
                {
                    customerLatitude = Double.parseDouble(value);
                }
                if (key.equals("customerLongitude"))
                {
                    customerLongitude = Double.parseDouble(value);
                }
                if (key.equals("latitude"))
                {
                    hotelLatitude = Double.parseDouble(value);
                }
                if (key.equals("longitude"))
                {
                    hotelLongitude = Double.parseDouble(value);
                }

                Log.d(Constant.TAG, "customerLatitude--->" + customerLatitude);
                Log.d(Constant.TAG, "customerLongitude--->" + customerLongitude);
                Log.d(Constant.TAG, "hotelLatitude--->" + hotelLatitude);
                Log.d(Constant.TAG, "hotelLongitude--->" + hotelLongitude);
            }
            LatLng hotel = new LatLng(hotelLatitude, hotelLongitude);
            LatLng customer = new LatLng(customerLatitude, customerLongitude);

            MarkerOptions resOptions = new MarkerOptions()
                    .position(hotel)
                    .title(hotelName)
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_restaurant_location));
            MarkerOptions cusOptions = new MarkerOptions()
                    .position(customer)
                    .title(customerAddr)
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_customer_location));

            mMap.addMarker(resOptions);
            mMap.addMarker(cusOptions);

            mMap.animateCamera(CameraUpdateFactory.newLatLng(hotel));
        }
        catch (JSONException e)
        {
            Log.e(Constant.TAG, "Get message extra JSON error!");
        }
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
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mUiSettings.setScrollGesturesEnabled(true);
        mUiSettings.setZoomGesturesEnabled(true);
        mUiSettings.setTiltGesturesEnabled(true);
        mUiSettings.setRotateGesturesEnabled(true);
        mUiSettings.setMapToolbarEnabled(true);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.notice_cancle_btn:
                finish();
                break;
            case R.id.notice_accept_btn:
                orderAccept(orderId);
                break;
        }
    }

    private void orderAccept(String orderId)
    {
        CommonUtils.httpDebugLogger("司机接受订单");
        final CustomDialogFragment deliveryLoading = DialogUtils.showLoadingDialog(this);
        deliveryCall = RetrofitService.sApiService.driverOrderAccept(CommonUtils.getLoginName(this), CommonUtils.getRandomCode(this), orderId);
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
                    CommonUtils.httpDebugLogger("[isSuccess=" + oosi.isSuccess() + "][errorCode=" + errorCode + "][msg=" + msg + "]");

                    CommonUtils.showToast(NoticeActivity.this, oosi.getMsg());
                    if (oosi.isSuccess() && oosi.getErrorCode().equals("-1"))
                    {
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<OrderOperationStatusInfo> call, Throwable t)
            {
                deliveryLoading.dismiss();
                CommonUtils.httpErrorLogger(t.toString());
                if (!call.isCanceled())
                {
                    CommonUtils.showToast(NoticeActivity.this, getResources().getString(R.string.network_error));
                }

            }
        });
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        if (deliveryCall != null) deliveryCall.cancel();
    }
}
