package com.gaoyy.delivery4driver.api.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaoyy on 2017/9/10 0010.
 */

public class OrderNewInfo implements Serializable
{

    /**
     * body : {"flag":"1","storeName":"商家7的店","obj":{"activityPrice":67.2,"addTime":"2017-09-04 22:08:33","addr":{"addTime":"2017-09-01 21:08:45","area_info":"拉丁区, 蒙特利尔, 魁北克省, 加拿大","deleteStatus":false,"houseNumber":"344","id":32925,"latitude":"45.51550779999999","longitude":"-73.56390599999997","mobile":"1380433405","telephone":null,"trueName":"买家","trueSex":1,"zip":null},"appointment_time":"now","buyerMobile":null,"buyerName":null,"cancel_time":null,"clientType":"ios","commissionPirce":0,"commissionRate":0,"couponPrice":null,"courier_id":null,"courier_statistics_id":null,"deleteStatus":false,"distance":1.56,"distribution_type":"Delivery","finishTime":null,"gcs":[{"addTime":"2017-09-04 22:08:18","cart_type":null,"count":3,"deleteStatus":false,"goods_id":98555,"goods_name":"锅包肉","goods_photo":null,"id":230125,"price":32,"spec_info":null}],"goodsCount":0,"goods_amount":96,"id":130,"is_courierstatistics":false,"is_platformstatistics":false,"makingTime":1504958958000,"msg":"    ","orderEva":null,"orderEvas":[],"orderReply":null,"order_id":"3280920170904220833","order_status":4,"order_type":"app","payTime":null,"platform_id":null,"return_shipTime":null,"sendingTime":1505016350000,"shipTime":null,"ship_price":0,"takingTime":1504958958000,"taxation":4.8,"taxation_tvq":9.58,"taxrate":"5","taxrate_tvq":"9.975","tipPrice":16.56,"tipRate":15,"totalPrice":59.74,"useIncomePrice":0,"useIncomeRate":12},"language":"zh"}
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

    public static class BodyBean  implements Serializable
    {
        /**
         * flag : 1
         * storeName : 商家7的店
         * obj : {"activityPrice":67.2,"addTime":"2017-09-04 22:08:33","addr":{"addTime":"2017-09-01 21:08:45","area_info":"拉丁区, 蒙特利尔, 魁北克省, 加拿大","deleteStatus":false,"houseNumber":"344","id":32925,"latitude":"45.51550779999999","longitude":"-73.56390599999997","mobile":"1380433405","telephone":null,"trueName":"买家","trueSex":1,"zip":null},"appointment_time":"now","buyerMobile":null,"buyerName":null,"cancel_time":null,"clientType":"ios","commissionPirce":0,"commissionRate":0,"couponPrice":null,"courier_id":null,"courier_statistics_id":null,"deleteStatus":false,"distance":1.56,"distribution_type":"Delivery","finishTime":null,"gcs":[{"addTime":"2017-09-04 22:08:18","cart_type":null,"count":3,"deleteStatus":false,"goods_id":98555,"goods_name":"锅包肉","goods_photo":null,"id":230125,"price":32,"spec_info":null}],"goodsCount":0,"goods_amount":96,"id":130,"is_courierstatistics":false,"is_platformstatistics":false,"makingTime":1504958958000,"msg":"    ","orderEva":null,"orderEvas":[],"orderReply":null,"order_id":"3280920170904220833","order_status":4,"order_type":"app","payTime":null,"platform_id":null,"return_shipTime":null,"sendingTime":1505016350000,"shipTime":null,"ship_price":0,"takingTime":1504958958000,"taxation":4.8,"taxation_tvq":9.58,"taxrate":"5","taxrate_tvq":"9.975","tipPrice":16.56,"tipRate":15,"totalPrice":59.74,"useIncomePrice":0,"useIncomeRate":12}
         * language : zh
         */

        private String flag;
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

        public static class ObjBean  implements Serializable
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
             * activityPrice : 67.2
             * addTime : 2017-09-04 22:08:33
             * addr : {"addTime":"2017-09-01 21:08:45","area_info":"拉丁区, 蒙特利尔, 魁北克省, 加拿大","deleteStatus":false,"houseNumber":"344","id":32925,"latitude":"45.51550779999999","longitude":"-73.56390599999997","mobile":"1380433405","telephone":null,"trueName":"买家","trueSex":1,"zip":null}
             * appointment_time : now
             * buyerMobile : null
             * buyerName : null
             * cancel_time : null
             * clientType : ios
             * commissionPirce : 0
             * commissionRate : 0
             * couponPrice : null
             * courier_id : null
             * courier_statistics_id : null
             * deleteStatus : false
             * distance : 1.56
             * distribution_type : Delivery
             * finishTime : null
             * gcs : [{"addTime":"2017-09-04 22:08:18","cart_type":null,"count":3,"deleteStatus":false,"goods_id":98555,"goods_name":"锅包肉","goods_photo":null,"id":230125,"price":32,"spec_info":null}]
             * goodsCount : 0
             * goods_amount : 96
             * id : 130
             * is_courierstatistics : false
             * is_platformstatistics : false
             * makingTime : 1504958958000
             * msg :
             * orderEva : null
             * orderEvas : []
             * orderReply : null
             * order_id : 3280920170904220833
             * order_status : 4
             * order_type : app
             * payTime : null
             * platform_id : null
             * return_shipTime : null
             * sendingTime : 1505016350000
             * shipTime : null
             * ship_price : 0
             * takingTime : 1504958958000
             * taxation : 4.8
             * taxation_tvq : 9.58
             * taxrate : 5
             * taxrate_tvq : 9.975
             * tipPrice : 16.56
             * tipRate : 15
             * totalPrice : 59.74
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

            public Object getAddTime()
            {
                return addTime;
            }

            public AddrBean getAddr()
            {
                return addr;
            }

            public Object getAppointment_time()
            {
                return appointment_time;
            }

            public Object getBuyerMobile()
            {
                return buyerMobile;
            }

            public Object getBuyerName()
            {
                return buyerName;
            }

            public Object getCancel_time()
            {
                return cancel_time;
            }

            public Object getClientType()
            {
                return clientType;
            }

            public Object getCommissionPirce()
            {
                return commissionPirce;
            }

            public Object getCommissionRate()
            {
                return commissionRate;
            }

            public Object getCouponPrice()
            {
                return couponPrice;
            }

            public Object getCourier_id()
            {
                return courier_id;
            }

            public Object getCourier_statistics_id()
            {
                return courier_statistics_id;
            }

            public Object getDeleteStatus()
            {
                return deleteStatus;
            }

            public Object getDistance()
            {
                return distance;
            }

            public Object getDistribution_type()
            {
                return distribution_type;
            }

            public Object getFinishTime()
            {
                return finishTime;
            }

            public Object getGoodsCount()
            {
                return goodsCount;
            }

            public Object getGoods_amount()
            {
                return goods_amount;
            }

            public Object getId()
            {
                return id;
            }

            public Object getIs_courierstatistics()
            {
                return is_courierstatistics;
            }

            public Object getIs_platformstatistics()
            {
                return is_platformstatistics;
            }

            public Object getMakingTime()
            {
                return makingTime;
            }

            public Object getMsg()
            {
                return msg;
            }

            public Object getOrderEva()
            {
                return orderEva;
            }

            public Object getOrderReply()
            {
                return orderReply;
            }

            public Object getOrder_id()
            {
                return order_id;
            }

            public Object getOrder_status()
            {
                return order_status;
            }

            public Object getOrder_type()
            {
                return order_type;
            }

            public Object getPayTime()
            {
                return payTime;
            }

            public Object getPlatform_id()
            {
                return platform_id;
            }

            public Object getReturn_shipTime()
            {
                return return_shipTime;
            }

            public Object getSendingTime()
            {
                return sendingTime;
            }

            public Object getShipTime()
            {
                return shipTime;
            }

            public Object getShip_price()
            {
                return ship_price;
            }

            public Object getTakingTime()
            {
                return takingTime;
            }

            public Object getTaxation()
            {
                return taxation;
            }

            public Object getTaxation_tvq()
            {
                return taxation_tvq;
            }

            public Object getTaxrate()
            {
                return taxrate;
            }

            public Object getTaxrate_tvq()
            {
                return taxrate_tvq;
            }

            public Object getTipPrice()
            {
                return tipPrice;
            }

            public Object getTipRate()
            {
                return tipRate;
            }

            public Object getTotalPrice()
            {
                return totalPrice;
            }

            public Object getUseIncomePrice()
            {
                return useIncomePrice;
            }

            public Object getUseIncomeRate()
            {
                return useIncomeRate;
            }

            public List<GcsBean> getGcs()
            {
                return gcs;
            }

            public List<?> getOrderEvas()
            {
                return orderEvas;
            }

            public static class AddrBean implements  Serializable
            {
                /**
                 * addTime : 2017-09-01 21:08:45
                 * area_info : 拉丁区, 蒙特利尔, 魁北克省, 加拿大
                 * deleteStatus : false
                 * houseNumber : 344
                 * id : 32925
                 * latitude : 45.51550779999999
                 * longitude : -73.56390599999997
                 * mobile : 1380433405
                 * telephone : null
                 * trueName : 买家
                 * trueSex : 1
                 * zip : null
                 */

                private Object addTime;
                private Object area_info;
                private Object deleteStatus;
                private Object houseNumber;
                private Object id;
                private Object latitude;
                private Object longitude;
                private Object mobile;
                private Object telephone;
                private Object trueName;
                private Object trueSex;
                private Object zip;

                public Object getAddTime()
                {
                    return addTime;
                }

                public Object getArea_info()
                {
                    return area_info;
                }

                public Object getDeleteStatus()
                {
                    return deleteStatus;
                }

                public Object getHouseNumber()
                {
                    return houseNumber;
                }

                public Object getId()
                {
                    return id;
                }

                public Object getLatitude()
                {
                    return latitude;
                }

                public Object getLongitude()
                {
                    return longitude;
                }

                public Object getMobile()
                {
                    return mobile;
                }

                public Object getTelephone()
                {
                    return telephone;
                }

                public Object getTrueName()
                {
                    return trueName;
                }

                public Object getTrueSex()
                {
                    return trueSex;
                }

                public Object getZip()
                {
                    return zip;
                }
            }

            public static class GcsBean  implements  Serializable
            {
                /**
                 * addTime : 2017-09-04 22:08:18
                 * cart_type : null
                 * count : 3
                 * deleteStatus : false
                 * goods_id : 98555
                 * goods_name : 锅包肉
                 * goods_photo : null
                 * id : 230125
                 * price : 32
                 * spec_info : null
                 */

                private Object addTime;
                private Object cart_type;
                private Object count;
                private Object deleteStatus;
                private Object goods_id;
                private Object goods_name;
                private Object goods_photo;
                private Object id;
                private Object price;
                private Object spec_info;

                public Object getAddTime()
                {
                    return addTime;
                }

                public Object getCart_type()
                {
                    return cart_type;
                }

                public Object getCount()
                {
                    return count;
                }

                public Object getDeleteStatus()
                {
                    return deleteStatus;
                }

                public Object getGoods_id()
                {
                    return goods_id;
                }

                public Object getGoods_name()
                {
                    return goods_name;
                }

                public Object getGoods_photo()
                {
                    return goods_photo;
                }

                public Object getId()
                {
                    return id;
                }

                public Object getPrice()
                {
                    return price;
                }

                public Object getSpec_info()
                {
                    return spec_info;
                }
            }
        }
    }
}
