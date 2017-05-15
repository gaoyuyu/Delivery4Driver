package com.gaoyy.delivery4driver.api.bean;

/**
 * Created by gaoyy on 2017/5/12 0012.
 */

public class OrderSaveInfo
{

    /**
     * success : true
     * errorCode : -1
     * msg : Save
     * body : {"order":{"id":"b6bab4d1a5854813afc14ad3cb825530","isNewRecord":false,"remarks":"234994740  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 08:38:27","updateDate":"2017-05-12 08:38:27","orderNo":"201705122222","customerName":null,"customerTel":"2349947400","customerAddr":"APT48,1552a rue Baxter","apt":"48","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":1494596307058,"status":0,"isTimeout":0,"pushCount":1,"finishedTime":"other","remark":"door bell not working","dispatch":null,"customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":null,"hotelLatitude":null,"hotelAddr":null,"isHasCourierLogin":null,"validTime":null,"hotelTel":null,"date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"}}
     */

    private boolean success;
    private String errorCode;
    private String msg;
    private BodyBean body;

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
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

    public BodyBean getBody()
    {
        return body;
    }

    public void setBody(BodyBean body)
    {
        this.body = body;
    }

    public static class BodyBean
    {
        /**
         * order : {"id":"b6bab4d1a5854813afc14ad3cb825530","isNewRecord":false,"remarks":"234994740  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 08:38:27","updateDate":"2017-05-12 08:38:27","orderNo":"201705122222","customerName":null,"customerTel":"2349947400","customerAddr":"APT48,1552a rue Baxter","apt":"48","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":1494596307058,"status":0,"isTimeout":0,"pushCount":1,"finishedTime":"other","remark":"door bell not working","dispatch":null,"customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":null,"hotelLatitude":null,"hotelAddr":null,"isHasCourierLogin":null,"validTime":null,"hotelTel":null,"date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"}
         */

        private OrderBean order;

        public OrderBean getOrder()
        {
            return order;
        }

        public void setOrder(OrderBean order)
        {
            this.order = order;
        }

        public static class OrderBean
        {
            /**
             * id : b6bab4d1a5854813afc14ad3cb825530
             * isNewRecord : false
             * remarks : 234994740  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER
             * createDate : 2017-05-12 08:38:27
             * updateDate : 2017-05-12 08:38:27
             * orderNo : 201705122222
             * customerName : null
             * customerTel : 2349947400
             * customerAddr : APT48,1552a rue Baxter
             * apt : 48
             * orderPrice : 0
             * createName : hotel
             * hotelUser : hotel
             * courierName : null
             * actionName : null
             * courierLogin : null
             * courierTel : null
             * acceptDate : null
             * deliveryDate : null
             * finishDate : null
             * cancelDate : null
             * pushDate : 1494596307058
             * status : 0
             * isTimeout : 0
             * pushCount : 1
             * finishedTime : other
             * remark : door bell not working
             * dispatch : null
             * customerLongitude : -73.6101765
             * customerLatitude : 45.438691
             * hotelLongitude : null
             * hotelLatitude : null
             * hotelAddr : null
             * isHasCourierLogin : null
             * validTime : null
             * hotelTel : null
             * date : null
             * count : null
             * remarkList : null
             * pushFrequency : null
             * price : 0.0
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String orderNo;
            private Object customerName;
            private String customerTel;
            private String customerAddr;
            private String apt;
            private int orderPrice;
            private String createName;
            private String hotelUser;
            private Object courierName;
            private Object actionName;
            private Object courierLogin;
            private Object courierTel;
            private Object acceptDate;
            private Object deliveryDate;
            private Object finishDate;
            private Object cancelDate;
            private long pushDate;
            private int status;
            private int isTimeout;
            private int pushCount;
            private String finishedTime;
            private String remark;
            private Object dispatch;
            private String customerLongitude;
            private String customerLatitude;
            private Object hotelLongitude;
            private Object hotelLatitude;
            private Object hotelAddr;
            private Object isHasCourierLogin;
            private Object validTime;
            private Object hotelTel;
            private Object date;
            private Object count;
            private Object remarkList;
            private Object pushFrequency;
            private String price;

            public String getId()
            {
                return id;
            }

            public void setId(String id)
            {
                this.id = id;
            }

            public boolean isIsNewRecord()
            {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord)
            {
                this.isNewRecord = isNewRecord;
            }

            public String getRemarks()
            {
                return remarks;
            }

            public void setRemarks(String remarks)
            {
                this.remarks = remarks;
            }

            public String getCreateDate()
            {
                return createDate;
            }

            public void setCreateDate(String createDate)
            {
                this.createDate = createDate;
            }

            public String getUpdateDate()
            {
                return updateDate;
            }

            public void setUpdateDate(String updateDate)
            {
                this.updateDate = updateDate;
            }

            public String getOrderNo()
            {
                return orderNo;
            }

            public void setOrderNo(String orderNo)
            {
                this.orderNo = orderNo;
            }

            public Object getCustomerName()
            {
                return customerName;
            }

            public void setCustomerName(Object customerName)
            {
                this.customerName = customerName;
            }

            public String getCustomerTel()
            {
                return customerTel;
            }

            public void setCustomerTel(String customerTel)
            {
                this.customerTel = customerTel;
            }

            public String getCustomerAddr()
            {
                return customerAddr;
            }

            public void setCustomerAddr(String customerAddr)
            {
                this.customerAddr = customerAddr;
            }

            public String getApt()
            {
                return apt;
            }

            public void setApt(String apt)
            {
                this.apt = apt;
            }

            public int getOrderPrice()
            {
                return orderPrice;
            }

            public void setOrderPrice(int orderPrice)
            {
                this.orderPrice = orderPrice;
            }

            public String getCreateName()
            {
                return createName;
            }

            public void setCreateName(String createName)
            {
                this.createName = createName;
            }

            public String getHotelUser()
            {
                return hotelUser;
            }

            public void setHotelUser(String hotelUser)
            {
                this.hotelUser = hotelUser;
            }

            public Object getCourierName()
            {
                return courierName;
            }

            public void setCourierName(Object courierName)
            {
                this.courierName = courierName;
            }

            public Object getActionName()
            {
                return actionName;
            }

            public void setActionName(Object actionName)
            {
                this.actionName = actionName;
            }

            public Object getCourierLogin()
            {
                return courierLogin;
            }

            public void setCourierLogin(Object courierLogin)
            {
                this.courierLogin = courierLogin;
            }

            public Object getCourierTel()
            {
                return courierTel;
            }

            public void setCourierTel(Object courierTel)
            {
                this.courierTel = courierTel;
            }

            public Object getAcceptDate()
            {
                return acceptDate;
            }

            public void setAcceptDate(Object acceptDate)
            {
                this.acceptDate = acceptDate;
            }

            public Object getDeliveryDate()
            {
                return deliveryDate;
            }

            public void setDeliveryDate(Object deliveryDate)
            {
                this.deliveryDate = deliveryDate;
            }

            public Object getFinishDate()
            {
                return finishDate;
            }

            public void setFinishDate(Object finishDate)
            {
                this.finishDate = finishDate;
            }

            public Object getCancelDate()
            {
                return cancelDate;
            }

            public void setCancelDate(Object cancelDate)
            {
                this.cancelDate = cancelDate;
            }

            public long getPushDate()
            {
                return pushDate;
            }

            public void setPushDate(long pushDate)
            {
                this.pushDate = pushDate;
            }

            public int getStatus()
            {
                return status;
            }

            public void setStatus(int status)
            {
                this.status = status;
            }

            public int getIsTimeout()
            {
                return isTimeout;
            }

            public void setIsTimeout(int isTimeout)
            {
                this.isTimeout = isTimeout;
            }

            public int getPushCount()
            {
                return pushCount;
            }

            public void setPushCount(int pushCount)
            {
                this.pushCount = pushCount;
            }

            public String getFinishedTime()
            {
                return finishedTime;
            }

            public void setFinishedTime(String finishedTime)
            {
                this.finishedTime = finishedTime;
            }

            public String getRemark()
            {
                return remark;
            }

            public void setRemark(String remark)
            {
                this.remark = remark;
            }

            public Object getDispatch()
            {
                return dispatch;
            }

            public void setDispatch(Object dispatch)
            {
                this.dispatch = dispatch;
            }

            public String getCustomerLongitude()
            {
                return customerLongitude;
            }

            public void setCustomerLongitude(String customerLongitude)
            {
                this.customerLongitude = customerLongitude;
            }

            public String getCustomerLatitude()
            {
                return customerLatitude;
            }

            public void setCustomerLatitude(String customerLatitude)
            {
                this.customerLatitude = customerLatitude;
            }

            public Object getHotelLongitude()
            {
                return hotelLongitude;
            }

            public void setHotelLongitude(Object hotelLongitude)
            {
                this.hotelLongitude = hotelLongitude;
            }

            public Object getHotelLatitude()
            {
                return hotelLatitude;
            }

            public void setHotelLatitude(Object hotelLatitude)
            {
                this.hotelLatitude = hotelLatitude;
            }

            public Object getHotelAddr()
            {
                return hotelAddr;
            }

            public void setHotelAddr(Object hotelAddr)
            {
                this.hotelAddr = hotelAddr;
            }

            public Object getIsHasCourierLogin()
            {
                return isHasCourierLogin;
            }

            public void setIsHasCourierLogin(Object isHasCourierLogin)
            {
                this.isHasCourierLogin = isHasCourierLogin;
            }

            public Object getValidTime()
            {
                return validTime;
            }

            public void setValidTime(Object validTime)
            {
                this.validTime = validTime;
            }

            public Object getHotelTel()
            {
                return hotelTel;
            }

            public void setHotelTel(Object hotelTel)
            {
                this.hotelTel = hotelTel;
            }

            public Object getDate()
            {
                return date;
            }

            public void setDate(Object date)
            {
                this.date = date;
            }

            public Object getCount()
            {
                return count;
            }

            public void setCount(Object count)
            {
                this.count = count;
            }

            public Object getRemarkList()
            {
                return remarkList;
            }

            public void setRemarkList(Object remarkList)
            {
                this.remarkList = remarkList;
            }

            public Object getPushFrequency()
            {
                return pushFrequency;
            }

            public void setPushFrequency(Object pushFrequency)
            {
                this.pushFrequency = pushFrequency;
            }

            public String getPrice()
            {
                return price;
            }

            public void setPrice(String price)
            {
                this.price = price;
            }
        }
    }
}
