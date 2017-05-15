package com.gaoyy.delivery4driver.api;

import android.content.Context;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gaoyy on 2017/3/12 0012.
 * 整个网络通信服务的启动控制，必须先调用初始化函数才能正常使用网络通信接口
 */
public class RetrofitService
{
    public static Api sApiService;
    public static GoogleMapApi sGoogleMapApiService;
    private RetrofitService()
    {
        throw new AssertionError();
    }

    /**
     * 初始化网络通信服务
     */
    public static void init(Context context)
    {
        // 指定缓存路径,缓存大小100Mb
        Cache cache = new Cache(new File(context.getCacheDir(), "HttpCache"),
                1024 * 1024 * 100);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .retryOnConnectionFailure(true)
                .connectTimeout(1500000, TimeUnit.MILLISECONDS)
                .writeTimeout(2000000, TimeUnit.MILLISECONDS)
                .readTimeout(2000000, TimeUnit.MILLISECONDS)
                .build();

        Retrofit apiRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_BASE)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        sApiService = apiRetrofit.create(Api.class);



        Retrofit mapRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.GOOGLE_MAP_API_BASE)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        sGoogleMapApiService = mapRetrofit.create(GoogleMapApi.class);
    }
}
