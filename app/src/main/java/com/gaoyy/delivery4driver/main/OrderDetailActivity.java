package com.gaoyy.delivery4driver.main;


import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.bean.OrderListInfo;
import com.gaoyy.delivery4driver.base.BaseActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class OrderDetailActivity extends BaseActivity implements OnMapReadyCallback
{

    private Toolbar orderDetailToolbar;
    private TextView orderDetailDate;
    private TextView orderDetailOrderNo;
    private TextView orderDetailStartPoint;
    private TextView orderDetailDistination;
    private TextView orderDetailPhone;
    private TextView orderDetailNotes;
    private TextView orderDetailFinishTime;
    private TextView orderDetailOther;

    private GoogleMap mMap;
    private OrderListInfo.BodyBean.PageBean.ListBean order;

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
        orderDetailDate = (TextView) findViewById(R.id.order_detail_date);
        orderDetailOrderNo = (TextView) findViewById(R.id.order_detail_order_no);
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
        super.initToolbar(orderDetailToolbar, R.string.toolbar_title_order_detail, true, -1);
    }

    @Override
    protected void configViews()
    {
        super.configViews();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.order_detail_map);
        mapFragment.getMapAsync(this);

        order= (OrderListInfo.BodyBean.PageBean.ListBean) getIntent().getSerializableExtra("order");
        orderDetailDate.setText(order.getCreateDate());
        orderDetailOrderNo.setText(order.getOrderNo());
        orderDetailStartPoint.setText(order.getHotelAddr());
        orderDetailDistination.setText(order.getCustomerAddr());
        orderDetailPhone.setText(order.getCustomerTel());
        orderDetailNotes.setText(order.getRemark());
        orderDetailFinishTime.setText(order.getFinishedTime());
        orderDetailOther.setText(order.getRemarks().trim());

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

        double customerLatitude = Double.parseDouble(order.getCustomerLatitude());
        double customerLongitude = Double.parseDouble(order.getCustomerLongitude());
        double hotelLatitude = Double.parseDouble(order.getHotelLatitude());
        double hotelLongitude = Double.parseDouble(order.getHotelLongitude());

        LatLng hotel = new LatLng(hotelLatitude, hotelLongitude);
        LatLng customer = new LatLng(customerLatitude, customerLongitude);

        MarkerOptions resOptions = new MarkerOptions()
                .position(hotel)
                .title(order.getHotelAddr())
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_restaurant_location));
        MarkerOptions cusOptions = new MarkerOptions()
                .position(customer)
                .title(order.getCustomerAddr())
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_customer_location));

        mMap.addMarker(resOptions);
        mMap.addMarker(cusOptions);

        mMap.animateCamera(CameraUpdateFactory.newLatLng(hotel));
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
}
