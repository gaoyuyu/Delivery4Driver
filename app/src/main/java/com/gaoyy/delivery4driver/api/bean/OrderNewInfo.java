package com.gaoyy.delivery4driver.api.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaoyy on 2017/9/10 0010.
 */

public class OrderNewInfo implements Serializable
{

    /**
     * body : {"flag":"1","storeName":"小小的买手店","obj":{"activityPrice":0,"addTime":"2017-11-01 03:30:41","addr":{"addTime":"2017-09-21 23:35:20","area_info":"中国吉林省长春市双阳区北山路长春市双阳区客运东站","deleteStatus":false,"houseNumber":"101","id":32970,"latitude":"43.529906","longitude":"125.68565139999998","mobile":"1306904902","telephone":null,"trueName":"买家3","trueSex":1,"zip":null},"appointment_time":"尽快送达","buyerMobile":null,"buyerName":null,"cancel_time":null,"clientType":"ios","commissionPirce":15.11,"commissionRate":20,"couponPrice":null,"courier_id":1,"courier_statistics_id":null,"deleteStatus":false,"distance":47.07,"distribution_type":"Delivery","estimatedTime":"20min","finishTime":null,"gcs":[{"addTime":"2017-11-01 03:30:32","cart_type":null,"count":1,"deleteStatus":false,"goods_id":98621,"goods_name":"苜蓿柿子","goods_photo":null,"id":232200,"price":60,"spec_info":null}],"goodsCount":0,"goods_amount":60,"id":736,"is_courierstatistics":false,"is_platformstatistics":false,"makingTime":1509544221176,"msg":"    ","orderEva":null,"orderEvas":[],"orderReply":null,"order_id":"MA171101010001","order_status":3,"order_type":"app","payTime":null,"platform_id":null,"return_shipTime":null,"sendingTime":null,"shipTime":null,"ship_price":44,"takingTime":1509544221129,"taxation":5.2,"taxation_tvq":10.37,"taxrate":"5","taxrate_tvq":"9.975","tipPrice":17.94,"tipRate":15,"totalPrice":137.51,"useIncomePrice":0,"useIncomeRate":12},"language":"zh"}
     * errorCode : -1
     * msg : 操作成功
     * success : true
     */

    private BodyBean body;
    private String errorCode;
    private String msg;
    private boolean success;

    public BodyBean getBody()
    {
        return body;
    }

    public void setBody(BodyBean body)
    {
        this.body = body;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public static class BodyBean implements Serializable
    {
        /**
         * flag : 1
         * storeName : 小小的买手店
         * obj : {"activityPrice":0,"addTime":"2017-11-01 03:30:41","addr":{"addTime":"2017-09-21 23:35:20","area_info":"中国吉林省长春市双阳区北山路长春市双阳区客运东站","deleteStatus":false,"houseNumber":"101","id":32970,"latitude":"43.529906","longitude":"125.68565139999998","mobile":"1306904902","telephone":null,"trueName":"买家3","trueSex":1,"zip":null},"appointment_time":"尽快送达","buyerMobile":null,"buyerName":null,"cancel_time":null,"clientType":"ios","commissionPirce":15.11,"commissionRate":20,"couponPrice":null,"courier_id":1,"courier_statistics_id":null,"deleteStatus":false,"distance":47.07,"distribution_type":"Delivery","estimatedTime":"20min","finishTime":null,"gcs":[{"addTime":"2017-11-01 03:30:32","cart_type":null,"count":1,"deleteStatus":false,"goods_id":98621,"goods_name":"苜蓿柿子","goods_photo":null,"id":232200,"price":60,"spec_info":null}],"goodsCount":0,"goods_amount":60,"id":736,"is_courierstatistics":false,"is_platformstatistics":false,"makingTime":1509544221176,"msg":"    ","orderEva":null,"orderEvas":[],"orderReply":null,"order_id":"MA171101010001","order_status":3,"order_type":"app","payTime":null,"platform_id":null,"return_shipTime":null,"sendingTime":null,"shipTime":null,"ship_price":44,"takingTime":1509544221129,"taxation":5.2,"taxation_tvq":10.37,"taxrate":"5","taxrate_tvq":"9.975","tipPrice":17.94,"tipRate":15,"totalPrice":137.51,"useIncomePrice":0,"useIncomeRate":12}
         * language : zh
         */

        private String flag;

        public String getPaymentMethod()
        {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod)
        {
            this.paymentMethod = paymentMethod;
        }

        private String paymentMethod;
        private String storeName;
        private ObjBean obj;
        private String language;

        public String getFlag()
        {
            return flag;
        }

        public void setFlag(String flag)
        {
            this.flag = flag;
        }

        public String getStoreName()
        {
            return storeName;
        }

        public void setStoreName(String storeName)
        {
            this.storeName = storeName;
        }

        public ObjBean getObj()
        {
            return obj;
        }

        public void setObj(ObjBean obj)
        {
            this.obj = obj;
        }

        public String getLanguage()
        {
            return language;
        }

        public void setLanguage(String language)
        {
            this.language = language;
        }

        public static class ObjBean implements Serializable
        {
            @Override
            public String toString()
            {
                return "ObjBean{" +
                        "activityPrice=" + activityPrice +
                        ", addTime='" + addTime + '\'' +
                        ", addr=" + addr +
                        ", appointment_time='" + appointment_time + '\'' +
                        ", buyerMobile=" + buyerMobile +
                        ", buyerName=" + buyerName +
                        ", cancel_time=" + cancel_time +
                        ", clientType='" + clientType + '\'' +
                        ", commissionPirce=" + commissionPirce +
                        ", commissionRate=" + commissionRate +
                        ", couponPrice=" + couponPrice +
                        ", courier_id=" + courier_id +
                        ", courier_statistics_id=" + courier_statistics_id +
                        ", deleteStatus=" + deleteStatus +
                        ", distance=" + distance +
                        ", distribution_type='" + distribution_type + '\'' +
                        ", estimatedTime='" + estimatedTime + '\'' +
                        ", finishTime=" + finishTime +
                        ", goodsCount=" + goodsCount +
                        ", goods_amount=" + goods_amount +
                        ", id=" + id +
                        ", is_courierstatistics=" + is_courierstatistics +
                        ", is_platformstatistics=" + is_platformstatistics +
                        ", makingTime=" + makingTime +
                        ", msg='" + msg + '\'' +
                        ", orderEva=" + orderEva +
                        ", orderReply=" + orderReply +
                        ", order_id='" + order_id + '\'' +
                        ", order_status=" + order_status +
                        ", order_type='" + order_type + '\'' +
                        ", payTime=" + payTime +
                        ", platform_id=" + platform_id +
                        ", return_shipTime=" + return_shipTime +
                        ", sendingTime=" + sendingTime +
                        ", shipTime=" + shipTime +
                        ", ship_price=" + ship_price +
                        ", takingTime=" + takingTime +
                        ", taxation=" + taxation +
                        ", taxation_tvq=" + taxation_tvq +
                        ", taxrate='" + taxrate + '\'' +
                        ", taxrate_tvq='" + taxrate_tvq + '\'' +
                        ", tipPrice=" + tipPrice +
                        ", tipRate=" + tipRate +
                        ", totalPrice=" + totalPrice +
                        ", useIncomePrice=" + useIncomePrice +
                        ", useIncomeRate=" + useIncomeRate +
                        ", gcs=" + gcs +
                        ", orderEvas=" + orderEvas +
                        '}';
            }

            /**
             * activityPrice : 0
             * addTime : 2017-11-01 03:30:41
             * addr : {"addTime":"2017-09-21 23:35:20","area_info":"中国吉林省长春市双阳区北山路长春市双阳区客运东站","deleteStatus":false,"houseNumber":"101","id":32970,"latitude":"43.529906","longitude":"125.68565139999998","mobile":"1306904902","telephone":null,"trueName":"买家3","trueSex":1,"zip":null}
             * appointment_time : 尽快送达
             * buyerMobile : null
             * buyerName : null
             * cancel_time : null
             * clientType : ios
             * commissionPirce : 15.11
             * commissionRate : 20
             * couponPrice : null
             * courier_id : 1
             * courier_statistics_id : null
             * deleteStatus : false
             * distance : 47.07
             * distribution_type : Delivery
             * estimatedTime : 20min
             * finishTime : null
             * gcs : [{"addTime":"2017-11-01 03:30:32","cart_type":null,"count":1,"deleteStatus":false,"goods_id":98621,"goods_name":"苜蓿柿子","goods_photo":null,"id":232200,"price":60,"spec_info":null}]
             * goodsCount : 0
             * goods_amount : 60
             * id : 736
             * is_courierstatistics : false
             * is_platformstatistics : false
             * makingTime : 1509544221176
             * msg :
             * orderEva : null
             * orderEvas : []
             * orderReply : null
             * order_id : MA171101010001
             * order_status : 3
             * order_type : app
             * payTime : null
             * platform_id : null
             * return_shipTime : null
             * sendingTime : null
             * shipTime : null
             * ship_price : 44
             * takingTime : 1509544221129
             * taxation : 5.2
             * taxation_tvq : 10.37
             * taxrate : 5
             * taxrate_tvq : 9.975
             * tipPrice : 17.94
             * tipRate : 15
             * totalPrice : 137.51
             * useIncomePrice : 0
             * useIncomeRate : 12
             */

            private Object activityPrice;
            private Object addTime;
            private AddrBean addr;
            private Object appointment_time;
            private Object buyerMobile;
            private Object buyerName;
            private Object cancel_time;
            private Object clientType;
            private Object commissionPirce;
            private Object commissionRate;
            private Object couponPrice;
            private Object courier_id;
            private Object courier_statistics_id;
            private Object deleteStatus;
            private Object distance;
            private Object distribution_type;
            private String estimatedTime;
            private Object finishTime;
            private Object goodsCount;
            private Object goods_amount;
            private Object id;
            private Object is_courierstatistics;
            private Object is_platformstatistics;
            private Object makingTime;
            private Object msg;
            private Object orderEva;
            private Object orderReply;
            private Object order_id;
            private Object order_status;
            private Object order_type;
            private Object payTime;
            private Object platform_id;
            private Object return_shipTime;
            private Object sendingTime;
            private Object shipTime;
            private Object ship_price;
            private Object takingTime;
            private Object taxation;
            private Object taxation_tvq;
            private Object taxrate;
            private Object taxrate_tvq;
            private Object tipPrice;
            private Object tipRate;
            private Object totalPrice;
            private Object useIncomePrice;
            private Object useIncomeRate;
            private List<GcsBean> gcs;
            private List<?> orderEvas;


            public Object getActivityPrice()
            {
                return activityPrice;
            }

            public void setActivityPrice(Object activityPrice)
            {
                this.activityPrice = activityPrice;
            }

            public Object getAddTime()
            {
                return addTime;
            }

            public void setAddTime(Object addTime)
            {
                this.addTime = addTime;
            }

            public AddrBean getAddr()
            {
                return addr;
            }

            public void setAddr(AddrBean addr)
            {
                this.addr = addr;
            }

            public Object getAppointment_time()
            {
                return appointment_time;
            }

            public void setAppointment_time(Object appointment_time)
            {
                this.appointment_time = appointment_time;
            }

            public Object getBuyerMobile()
            {
                return buyerMobile;
            }

            public void setBuyerMobile(Object buyerMobile)
            {
                this.buyerMobile = buyerMobile;
            }

            public Object getBuyerName()
            {
                return buyerName;
            }

            public void setBuyerName(Object buyerName)
            {
                this.buyerName = buyerName;
            }

            public Object getCancel_time()
            {
                return cancel_time;
            }

            public void setCancel_time(Object cancel_time)
            {
                this.cancel_time = cancel_time;
            }

            public Object getClientType()
            {
                return clientType;
            }

            public void setClientType(Object clientType)
            {
                this.clientType = clientType;
            }

            public Object getCommissionPirce()
            {
                return commissionPirce;
            }

            public void setCommissionPirce(Object commissionPirce)
            {
                this.commissionPirce = commissionPirce;
            }

            public Object getCommissionRate()
            {
                return commissionRate;
            }

            public void setCommissionRate(Object commissionRate)
            {
                this.commissionRate = commissionRate;
            }

            public Object getCouponPrice()
            {
                return couponPrice;
            }

            public void setCouponPrice(Object couponPrice)
            {
                this.couponPrice = couponPrice;
            }

            public Object getCourier_id()
            {
                return courier_id;
            }

            public void setCourier_id(Object courier_id)
            {
                this.courier_id = courier_id;
            }

            public Object getCourier_statistics_id()
            {
                return courier_statistics_id;
            }

            public void setCourier_statistics_id(Object courier_statistics_id)
            {
                this.courier_statistics_id = courier_statistics_id;
            }

            public Object getDeleteStatus()
            {
                return deleteStatus;
            }

            public void setDeleteStatus(Object deleteStatus)
            {
                this.deleteStatus = deleteStatus;
            }

            public Object getDistance()
            {
                return distance;
            }

            public void setDistance(Object distance)
            {
                this.distance = distance;
            }

            public Object getDistribution_type()
            {
                return distribution_type;
            }

            public void setDistribution_type(Object distribution_type)
            {
                this.distribution_type = distribution_type;
            }

            public String getEstimatedTime()
            {
                return estimatedTime;
            }

            public void setEstimatedTime(String estimatedTime)
            {
                this.estimatedTime = estimatedTime;
            }

            public Object getFinishTime()
            {
                return finishTime;
            }

            public void setFinishTime(Object finishTime)
            {
                this.finishTime = finishTime;
            }

            public Object getGoodsCount()
            {
                return goodsCount;
            }

            public void setGoodsCount(Object goodsCount)
            {
                this.goodsCount = goodsCount;
            }

            public Object getGoods_amount()
            {
                return goods_amount;
            }

            public void setGoods_amount(Object goods_amount)
            {
                this.goods_amount = goods_amount;
            }

            public Object getId()
            {
                return id;
            }

            public void setId(Object id)
            {
                this.id = id;
            }

            public Object getIs_courierstatistics()
            {
                return is_courierstatistics;
            }

            public void setIs_courierstatistics(Object is_courierstatistics)
            {
                this.is_courierstatistics = is_courierstatistics;
            }

            public Object getIs_platformstatistics()
            {
                return is_platformstatistics;
            }

            public void setIs_platformstatistics(Object is_platformstatistics)
            {
                this.is_platformstatistics = is_platformstatistics;
            }

            public Object getMakingTime()
            {
                return makingTime;
            }

            public void setMakingTime(Object makingTime)
            {
                this.makingTime = makingTime;
            }

            public Object getMsg()
            {
                return msg;
            }

            public void setMsg(Object msg)
            {
                this.msg = msg;
            }

            public Object getOrderEva()
            {
                return orderEva;
            }

            public void setOrderEva(Object orderEva)
            {
                this.orderEva = orderEva;
            }

            public Object getOrderReply()
            {
                return orderReply;
            }

            public void setOrderReply(Object orderReply)
            {
                this.orderReply = orderReply;
            }

            public Object getOrder_id()
            {
                return order_id;
            }

            public void setOrder_id(Object order_id)
            {
                this.order_id = order_id;
            }

            public Object getOrder_status()
            {
                return order_status;
            }

            public void setOrder_status(Object order_status)
            {
                this.order_status = order_status;
            }

            public Object getOrder_type()
            {
                return order_type;
            }

            public void setOrder_type(Object order_type)
            {
                this.order_type = order_type;
            }

            public Object getPayTime()
            {
                return payTime;
            }

            public void setPayTime(Object payTime)
            {
                this.payTime = payTime;
            }

            public Object getPlatform_id()
            {
                return platform_id;
            }

            public void setPlatform_id(Object platform_id)
            {
                this.platform_id = platform_id;
            }

            public Object getReturn_shipTime()
            {
                return return_shipTime;
            }

            public void setReturn_shipTime(Object return_shipTime)
            {
                this.return_shipTime = return_shipTime;
            }

            public Object getSendingTime()
            {
                return sendingTime;
            }

            public void setSendingTime(Object sendingTime)
            {
                this.sendingTime = sendingTime;
            }

            public Object getShipTime()
            {
                return shipTime;
            }

            public void setShipTime(Object shipTime)
            {
                this.shipTime = shipTime;
            }

            public Object getShip_price()
            {
                return ship_price;
            }

            public void setShip_price(Object ship_price)
            {
                this.ship_price = ship_price;
            }

            public Object getTakingTime()
            {
                return takingTime;
            }

            public void setTakingTime(Object takingTime)
            {
                this.takingTime = takingTime;
            }

            public Object getTaxation()
            {
                return taxation;
            }

            public void setTaxation(Object taxation)
            {
                this.taxation = taxation;
            }

            public Object getTaxation_tvq()
            {
                return taxation_tvq;
            }

            public void setTaxation_tvq(Object taxation_tvq)
            {
                this.taxation_tvq = taxation_tvq;
            }

            public Object getTaxrate()
            {
                return taxrate;
            }

            public void setTaxrate(Object taxrate)
            {
                this.taxrate = taxrate;
            }

            public Object getTaxrate_tvq()
            {
                return taxrate_tvq;
            }

            public void setTaxrate_tvq(Object taxrate_tvq)
            {
                this.taxrate_tvq = taxrate_tvq;
            }

            public Object getTipPrice()
            {
                return tipPrice;
            }

            public void setTipPrice(Object tipPrice)
            {
                this.tipPrice = tipPrice;
            }

            public Object getTipRate()
            {
                return tipRate;
            }

            public void setTipRate(Object tipRate)
            {
                this.tipRate = tipRate;
            }

            public Object getTotalPrice()
            {
                return totalPrice;
            }

            public void setTotalPrice(Object totalPrice)
            {
                this.totalPrice = totalPrice;
            }

            public Object getUseIncomePrice()
            {
                return useIncomePrice;
            }

            public void setUseIncomePrice(Object useIncomePrice)
            {
                this.useIncomePrice = useIncomePrice;
            }

            public Object getUseIncomeRate()
            {
                return useIncomeRate;
            }

            public void setUseIncomeRate(Object useIncomeRate)
            {
                this.useIncomeRate = useIncomeRate;
            }

            public List<GcsBean> getGcs()
            {
                return gcs;
            }

            public void setGcs(List<GcsBean> gcs)
            {
                this.gcs = gcs;
            }

            public List<?> getOrderEvas()
            {
                return orderEvas;
            }

            public void setOrderEvas(List<?> orderEvas)
            {
                this.orderEvas = orderEvas;
            }

            public static class AddrBean implements  Serializable
            {
                /**
                 * addTime : 2017-09-21 23:35:20
                 * area_info : 中国吉林省长春市双阳区北山路长春市双阳区客运东站
                 * deleteStatus : false
                 * houseNumber : 101
                 * id : 32970
                 * latitude : 43.529906
                 * longitude : 125.68565139999998
                 * mobile : 1306904902
                 * telephone : null
                 * trueName : 买家3
                 * trueSex : 1
                 * zip : null
                 */

                private String addTime;
                private String area_info;
                private boolean deleteStatus;
                private String houseNumber;
                private int id;
                private String latitude;
                private String longitude;
                private String mobile;
                private Object telephone;
                private String trueName;
                private int trueSex;
                private Object zip;

                public String getAddTime()
                {
                    return addTime;
                }

                public void setAddTime(String addTime)
                {
                    this.addTime = addTime;
                }

                public String getArea_info()
                {
                    return area_info;
                }

                public void setArea_info(String area_info)
                {
                    this.area_info = area_info;
                }

                public boolean isDeleteStatus()
                {
                    return deleteStatus;
                }

                public void setDeleteStatus(boolean deleteStatus)
                {
                    this.deleteStatus = deleteStatus;
                }

                public String getHouseNumber()
                {
                    return houseNumber;
                }

                public void setHouseNumber(String houseNumber)
                {
                    this.houseNumber = houseNumber;
                }

                public int getId()
                {
                    return id;
                }

                public void setId(int id)
                {
                    this.id = id;
                }

                public String getLatitude()
                {
                    return latitude;
                }

                public void setLatitude(String latitude)
                {
                    this.latitude = latitude;
                }

                public String getLongitude()
                {
                    return longitude;
                }

                public void setLongitude(String longitude)
                {
                    this.longitude = longitude;
                }

                public String getMobile()
                {
                    return mobile;
                }

                public void setMobile(String mobile)
                {
                    this.mobile = mobile;
                }

                public Object getTelephone()
                {
                    return telephone;
                }

                public void setTelephone(Object telephone)
                {
                    this.telephone = telephone;
                }

                public String getTrueName()
                {
                    return trueName;
                }

                public void setTrueName(String trueName)
                {
                    this.trueName = trueName;
                }

                public int getTrueSex()
                {
                    return trueSex;
                }

                public void setTrueSex(int trueSex)
                {
                    this.trueSex = trueSex;
                }

                public Object getZip()
                {
                    return zip;
                }

                public void setZip(Object zip)
                {
                    this.zip = zip;
                }
            }

            public static class GcsBean implements  Serializable
            {
                /**
                 * addTime : 2017-11-01 03:30:32
                 * cart_type : null
                 * count : 1
                 * deleteStatus : false
                 * goods_id : 98621
                 * goods_name : 苜蓿柿子
                 * goods_photo : null
                 * id : 232200
                 * price : 60
                 * spec_info : null
                 */

                private String addTime;
                private Object cart_type;
                private int count;
                private boolean deleteStatus;
                private int goods_id;
                private String goods_name;
                private Object goods_photo;
                private int id;
                private Object price;
                private Object spec_info;

                public String getAddTime()
                {
                    return addTime;
                }

                public void setAddTime(String addTime)
                {
                    this.addTime = addTime;
                }

                public Object getCart_type()
                {
                    return cart_type;
                }

                public void setCart_type(Object cart_type)
                {
                    this.cart_type = cart_type;
                }

                public int getCount()
                {
                    return count;
                }

                public void setCount(int count)
                {
                    this.count = count;
                }

                public boolean isDeleteStatus()
                {
                    return deleteStatus;
                }

                public void setDeleteStatus(boolean deleteStatus)
                {
                    this.deleteStatus = deleteStatus;
                }

                public int getGoods_id()
                {
                    return goods_id;
                }

                public void setGoods_id(int goods_id)
                {
                    this.goods_id = goods_id;
                }

                public String getGoods_name()
                {
                    return goods_name;
                }

                public void setGoods_name(String goods_name)
                {
                    this.goods_name = goods_name;
                }

                public Object getGoods_photo()
                {
                    return goods_photo;
                }

                public void setGoods_photo(Object goods_photo)
                {
                    this.goods_photo = goods_photo;
                }

                public int getId()
                {
                    return id;
                }

                public void setId(int id)
                {
                    this.id = id;
                }

                public Object getPrice()
                {
                    return price;
                }

                public void setPrice(Object price)
                {
                    this.price = price;
                }

                public Object getSpec_info()
                {
                    return spec_info;
                }

                public void setSpec_info(Object spec_info)
                {
                    this.spec_info = spec_info;
                }
            }
        }
    }
}
