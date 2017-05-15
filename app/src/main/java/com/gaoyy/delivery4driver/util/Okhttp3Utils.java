package com.gaoyy.delivery4driver.util;

import okhttp3.OkHttpClient;

/**
 * Created by gaoyy on 2016/12/28.
 */

public class Okhttp3Utils
{
    private static OkHttpClient okHttpClient = null;

    private Okhttp3Utils()
    {

    }

    public static OkHttpClient getOKhttpClientSingletonInstance()
    {
        if (okHttpClient == null)
        {
            synchronized (Okhttp3Utils.class)
            {
                okHttpClient = new OkHttpClient();
            }
        }
        return okHttpClient;
    }
}
