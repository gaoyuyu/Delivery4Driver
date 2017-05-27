package com.gaoyy.delivery4driver.api;


import com.gaoyy.delivery4driver.api.bean.CommonInfo;
import com.gaoyy.delivery4driver.api.bean.DriverInfo;
import com.gaoyy.delivery4driver.api.bean.OrderListInfo;
import com.gaoyy.delivery4driver.api.bean.OrderOperationStatusInfo;
import com.gaoyy.delivery4driver.api.bean.OrderSaveInfo;
import com.gaoyy.delivery4driver.api.bean.UpdateInfo;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by gaoyy on 2017/5/6 0006.
 */

public interface Api
{
    @GET("a/sys/user/mobile/version")
    Call<UpdateInfo> getAppCurrentVersion();

    /**
     * 登录
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("a/sys/user/mobile/login")
    Call<DriverInfo> login(@FieldMap Map<String, String> params);


    /**
     * 退出
     *
     * @param loginName
     * @param randomCode
     * @return
     */
    @FormUrlEncoded
    @POST("a/sys/user/mobile/loginout")
    Call<CommonInfo> logout(@Field("loginName") String loginName, @Field("randomCode") String randomCode);


    /**
     * 修改密码
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("a/sys/user/mobile/resetPwd")
    Call<CommonInfo> changePwd(@FieldMap Map<String, String> params);


    /**
     * 保存（提交）订单
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("a/order/order/mobile/ordersave")
    Call<OrderSaveInfo> orderSave(@FieldMap Map<String, String> params);

    /**
     * 订单列表
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("a/order/order/mobile/orderlist")
    Call<OrderListInfo> orderList(@FieldMap Map<String, String> params);


    /**
     * 饭店订单取消，用于cancle按钮
     *
     * @param loginName
     * @param randomCode
     * @return
     */
    @FormUrlEncoded
    @POST("a/order/order/mobile/ordercancel")
    Call<OrderOperationStatusInfo> orderCancle(@Field("loginName") String loginName, @Field("randomCode") String randomCode, @Field("id") String id);

    /**
     * 餐厅resubmit，用于resubmit按钮
     *
     * @param loginName
     * @param randomCode
     * @return
     */
    @FormUrlEncoded
    @POST("a/order/order/mobile/resubmit")
    Call<OrderOperationStatusInfo> orderResubmit(@Field("loginName") String loginName, @Field("randomCode") String randomCode, @Field("id") String id);

    /**
     * 饭店及司机订单派送，用于Delivery按钮
     *
     * @param loginName
     * @param randomCode
     * @return
     */
    @FormUrlEncoded
    @POST("a/order/order/mobile/ordersend")
    Call<OrderOperationStatusInfo> orderSend(@Field("loginName") String loginName, @Field("randomCode") String randomCode, @Field("id") String id);

    /**
     * 饭店订单退单，用于cancle after deliver按钮
     *
     * @param loginName
     * @param randomCode
     * @return
     */
    @FormUrlEncoded
    @POST("a/order/order/mobile/orderback")
    Call<OrderOperationStatusInfo> orderBack(@Field("loginName") String loginName, @Field("randomCode") String randomCode, @Field("id") String id);

    /**
     * 司机完成订单
     *
     * @param loginName
     * @param randomCode
     * @return
     */
    @FormUrlEncoded
    @POST("a/order/order/mobile/orderfinish")
    Call<OrderOperationStatusInfo> orderFinish(@Field("loginName") String loginName, @Field("randomCode") String randomCode, @Field("id") String id);


    /**
     * 司机上线
     *
     * @param loginName
     * @param randomCode
     * @return
     */
    @FormUrlEncoded
    @POST("a/sys/user/mobile/online")
    Call<CommonInfo> driverOnline(@Field("loginName") String loginName, @Field("randomCode") String randomCode);

    /**
     * 司机离线
     *
     * @param loginName
     * @param randomCode
     * @return
     */
    @FormUrlEncoded
    @POST("a/sys/user/mobile/offline")
    Call<CommonInfo> driverOffline(@Field("loginName") String loginName, @Field("randomCode") String randomCode);

    /**
     * 司机上传位置
     *
     * @param loginName
     * @param randomCode
     * @return
     */
    @FormUrlEncoded
    @POST("a/courier/courier/mobile/location")
    Call<ResponseBody> upLoadDriverLocation(@Field("loginName") String loginName, @Field("randomCode") String randomCode,
                                            @Field("latitude") String latitude, @Field("longitude") String longitude,@Field("course") String course);

    /**
     * 司机接受订单
     * @param logName
     * @param randomCode
     * @param id
     * @return
     */
    @FormUrlEncoded
    @POST("a/order/order/mobile/orderaccept")
    Call<OrderOperationStatusInfo> driverOrderAccept(@Field("loginName") String logName, @Field("randomCode") String randomCode, @Field("id") String id);


}
