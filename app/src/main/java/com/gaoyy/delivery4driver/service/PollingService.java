package com.gaoyy.delivery4driver.service;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.api.RetrofitService;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.android.gms.internal.zzs.TAG;

public class PollingService extends Service
{

    public static final String ACTION = "com.gaoyy.delivery4driver.service.PollingService";
    private static final String LOG_TAG = PollingService.class.getSimpleName();

    private LocationManager locationManager;
    private String locationProvider;

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public void onCreate()
    {

    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId)
    {
        Log.e(LOG_TAG, LOG_TAG + "===onStartCommand() executed");


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //获取所有可用的位置提供器
        List<String> providers = locationManager.getProviders(true);
        if (providers.contains(LocationManager.GPS_PROVIDER))
        {
            //如果是GPS
            locationProvider = LocationManager.GPS_PROVIDER;
        }
        else if (providers.contains(LocationManager.NETWORK_PROVIDER))
        {
            //如果是Network
            locationProvider = LocationManager.NETWORK_PROVIDER;
        }
        else
        {
            Log.e(TAG, LOG_TAG + "===没有可用的位置提供器");
        }

        //获取Location
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            Log.e(Constant.TAG, LOG_TAG + "=======权限申请失败=========");
//            CommonUtils.showToast(this, R.string.dialog_reminder_message);
        }
        else
        {
            Log.e(Constant.TAG, LOG_TAG + "=======权限申请成功=========");
            final Location location = locationManager.getLastKnownLocation(locationProvider);

            if (location != null)
            {
                Log.e(LOG_TAG, LOG_TAG + "===Latitude-->" + location.getLatitude());
                Log.e(LOG_TAG, LOG_TAG + "===Longitude-->" + location.getLongitude());

                uploadLocation(intent, location);


            }
            else
            {
                Log.e(TAG, LOG_TAG + "===location为空");
            }
            //监视地理位置变化
            locationManager.requestLocationUpdates(locationProvider, 3000, 1, new LocationListener()
            {
                @Override
                public void onLocationChanged(Location location)
                {

                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle)
                {

                }

                @Override
                public void onProviderEnabled(String s)
                {

                }

                @Override
                public void onProviderDisabled(String s)
                {
                    //如果位置发生变化,重新显示
                    uploadLocation(intent, location);
                }
            });
        }

        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 上传位置信息
     *
     * @param intent
     * @param location
     */
    private void uploadLocation(Intent intent, Location location)
    {
        if(intent == null) return;
        String loginName = intent.getStringExtra("loginName");
        String randomCode = intent.getStringExtra("randomCode");
        if ((loginName != null) && (randomCode != null))
        {
            String lat = String.valueOf(location.getLatitude());
            String lng = String.valueOf(location.getLongitude());
            Log.e(LOG_TAG, LOG_TAG + "--loginName-->" + loginName);
            Log.e(LOG_TAG, LOG_TAG + "--randomCode-->" + randomCode);
            Log.e(LOG_TAG, LOG_TAG + "--lat-->" + lat);
            Log.e(LOG_TAG, LOG_TAG + "--lng-->" + lng);
            Call<ResponseBody> call = RetrofitService.sApiService.upLoadDriverLocation(loginName, randomCode, lat, lng, "36");
            Log.e(LOG_TAG, LOG_TAG + "========开始上传位置信息======");
            call.enqueue(new Callback<ResponseBody>()
            {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response)
                {
                    if (response.isSuccessful() && response.body() != null)
                    {
                        Log.e(LOG_TAG, LOG_TAG + "========上传结束======");
                        try
                        {
                            Log.e(LOG_TAG, LOG_TAG + "===Upload responese-->" + response.body().string());
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t)
                {
                    Log.e(LOG_TAG, LOG_TAG + "========上传失败======" + t.toString());
                }
            });
        }
    }


    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.e(LOG_TAG, LOG_TAG + "=onDestroy==");
    }
}
