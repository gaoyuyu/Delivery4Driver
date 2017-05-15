package com.gaoyy.delivery4driver.api.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaoyy on 2017/5/15 0015.
 */

public class DriverInfo
{

    /**
     * success : true
     * errorCode : -1
     * msg : login Success
     * body : {"orderTime":30,"courier":{"id":"da1d8309704141ad8fe1b6ad17fe1e13","isNewRecord":false,"remarks":"test account","createDate":"2017-03-08 21:45:55","updateDate":"2017-05-15 08:00:06","name":"test","sex":"1","userName":"test","userPwd":"123456","age":111,"orderCount":0,"tel":"1111111","idCard":"1111","addr":"111","longitude":"116.941998","latitude":"38.938416","isOnline":"1","course":"348.750000","locationTime":1494767634000,"carNumber":"111","driverNumber":"111","driverDate":"2017-08-31","carInsurance":"2017-08-31","driverdatepush":"0","carinsurancepush":"0","minlat":0,"maxlat":0,"minlng":0,"maxlng":0},"dictStatus":[{"id":"6c2ee94ca3c94a1088bf1beec356905d","isNewRecord":false,"remarks":"等待","createDate":"2016-11-17 15:15:50","updateDate":"2016-11-17 15:15:50","value":"0","label":"Wait","type":"dict_status","description":"等待","sort":0,"parentId":"0"},{"id":"597d8cab1b8f4fc487cf8ab7f7df3997","isNewRecord":false,"remarks":"接受","createDate":"2016-11-17 15:16:28","updateDate":"2016-11-17 15:16:28","value":"1","label":"Accept","type":"dict_status","description":"接受","sort":1,"parentId":"0"},{"id":"ce76354e28e44a6093cab30fb625bd83","isNewRecord":false,"remarks":"派送","createDate":"2016-11-17 15:17:00","updateDate":"2016-11-17 15:17:00","value":"2","label":"Delivery","type":"dict_status","description":"派送","sort":2,"parentId":"0"},{"id":"cb5c6fd9486743348894bc42a3ceb81f","isNewRecord":false,"remarks":"完成","createDate":"2016-11-17 15:17:33","updateDate":"2016-11-17 15:17:33","value":"3","label":"Finish","type":"dict_status","description":"完成","sort":3,"parentId":"0"},{"id":"f75832e76185404d96b8cec0fe0541cb","isNewRecord":false,"remarks":"取消","createDate":"2016-11-17 15:17:55","updateDate":"2016-11-17 15:17:55","value":"4","label":"Cancel","type":"dict_status","description":"取消","sort":4,"parentId":"0"},{"id":"581ab0fe7b484180b970544beee1e154","isNewRecord":false,"remarks":"退单","createDate":"2016-11-25 09:43:30","updateDate":"2016-11-25 09:43:30","value":"5","label":"Back","type":"dict_status","description":"退单","sort":5,"parentId":"0"}],"user":{"id":"d83c9fe3b10346389a977252de41a89a","isNewRecord":false,"remarks":"","createDate":"2017-03-08 21:45:55","updateDate":"2017-05-13 01:51:39","loginName":"test","no":"test","name":"test","email":"","phone":"","mobile":"1111111","userType":"3","loginIp":"113.119.8.99","loginDate":"2017-05-15 13:00:06","loginFlag":"1","photo":"","qrCode":null,"oldLoginName":null,"newPassword":null,"sign":null,"randomCode":"kslcfr","oldLoginIp":"180.212.38.75","oldLoginDate":"2017-05-14 12:57:32","role":null,"roleIds":"e4484645fbbd4b90bedcce3659da7d6f","roleNames":"司机","admin":false}}
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
         * orderTime : 30
         * courier : {"id":"da1d8309704141ad8fe1b6ad17fe1e13","isNewRecord":false,"remarks":"test account","createDate":"2017-03-08 21:45:55","updateDate":"2017-05-15 08:00:06","name":"test","sex":"1","userName":"test","userPwd":"123456","age":111,"orderCount":0,"tel":"1111111","idCard":"1111","addr":"111","longitude":"116.941998","latitude":"38.938416","isOnline":"1","course":"348.750000","locationTime":1494767634000,"carNumber":"111","driverNumber":"111","driverDate":"2017-08-31","carInsurance":"2017-08-31","driverdatepush":"0","carinsurancepush":"0","minlat":0,"maxlat":0,"minlng":0,"maxlng":0}
         * dictStatus : [{"id":"6c2ee94ca3c94a1088bf1beec356905d","isNewRecord":false,"remarks":"等待","createDate":"2016-11-17 15:15:50","updateDate":"2016-11-17 15:15:50","value":"0","label":"Wait","type":"dict_status","description":"等待","sort":0,"parentId":"0"},{"id":"597d8cab1b8f4fc487cf8ab7f7df3997","isNewRecord":false,"remarks":"接受","createDate":"2016-11-17 15:16:28","updateDate":"2016-11-17 15:16:28","value":"1","label":"Accept","type":"dict_status","description":"接受","sort":1,"parentId":"0"},{"id":"ce76354e28e44a6093cab30fb625bd83","isNewRecord":false,"remarks":"派送","createDate":"2016-11-17 15:17:00","updateDate":"2016-11-17 15:17:00","value":"2","label":"Delivery","type":"dict_status","description":"派送","sort":2,"parentId":"0"},{"id":"cb5c6fd9486743348894bc42a3ceb81f","isNewRecord":false,"remarks":"完成","createDate":"2016-11-17 15:17:33","updateDate":"2016-11-17 15:17:33","value":"3","label":"Finish","type":"dict_status","description":"完成","sort":3,"parentId":"0"},{"id":"f75832e76185404d96b8cec0fe0541cb","isNewRecord":false,"remarks":"取消","createDate":"2016-11-17 15:17:55","updateDate":"2016-11-17 15:17:55","value":"4","label":"Cancel","type":"dict_status","description":"取消","sort":4,"parentId":"0"},{"id":"581ab0fe7b484180b970544beee1e154","isNewRecord":false,"remarks":"退单","createDate":"2016-11-25 09:43:30","updateDate":"2016-11-25 09:43:30","value":"5","label":"Back","type":"dict_status","description":"退单","sort":5,"parentId":"0"}]
         * user : {"id":"d83c9fe3b10346389a977252de41a89a","isNewRecord":false,"remarks":"","createDate":"2017-03-08 21:45:55","updateDate":"2017-05-13 01:51:39","loginName":"test","no":"test","name":"test","email":"","phone":"","mobile":"1111111","userType":"3","loginIp":"113.119.8.99","loginDate":"2017-05-15 13:00:06","loginFlag":"1","photo":"","qrCode":null,"oldLoginName":null,"newPassword":null,"sign":null,"randomCode":"kslcfr","oldLoginIp":"180.212.38.75","oldLoginDate":"2017-05-14 12:57:32","role":null,"roleIds":"e4484645fbbd4b90bedcce3659da7d6f","roleNames":"司机","admin":false}
         */

        private int orderTime;
        private CourierBean courier;
        private UserBean user;
        private List<DictStatusBean> dictStatus;

        public int getOrderTime()
        {
            return orderTime;
        }

        public void setOrderTime(int orderTime)
        {
            this.orderTime = orderTime;
        }

        public CourierBean getCourier()
        {
            return courier;
        }

        public void setCourier(CourierBean courier)
        {
            this.courier = courier;
        }

        public UserBean getUser()
        {
            return user;
        }

        public void setUser(UserBean user)
        {
            this.user = user;
        }

        public List<DictStatusBean> getDictStatus()
        {
            return dictStatus;
        }

        public void setDictStatus(List<DictStatusBean> dictStatus)
        {
            this.dictStatus = dictStatus;
        }

        public static class CourierBean
        {
            /**
             * id : da1d8309704141ad8fe1b6ad17fe1e13
             * isNewRecord : false
             * remarks : test account
             * createDate : 2017-03-08 21:45:55
             * updateDate : 2017-05-15 08:00:06
             * name : test
             * sex : 1
             * userName : test
             * userPwd : 123456
             * age : 111
             * orderCount : 0
             * tel : 1111111
             * idCard : 1111
             * addr : 111
             * longitude : 116.941998
             * latitude : 38.938416
             * isOnline : 1
             * course : 348.750000
             * locationTime : 1494767634000
             * carNumber : 111
             * driverNumber : 111
             * driverDate : 2017-08-31
             * carInsurance : 2017-08-31
             * driverdatepush : 0
             * carinsurancepush : 0
             * minlat : 0
             * maxlat : 0
             * minlng : 0
             * maxlng : 0
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String name;
            private String sex;
            private String userName;
            private String userPwd;
            private int age;
            private int orderCount;
            private String tel;
            private String idCard;
            private String addr;
            private String longitude;
            private String latitude;
            private String isOnline;
            private String course;
            private long locationTime;
            private String carNumber;
            private String driverNumber;
            private String driverDate;
            private String carInsurance;
            private String driverdatepush;
            private String carinsurancepush;
            private int minlat;
            private int maxlat;
            private int minlng;
            private int maxlng;

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

            public String getName()
            {
                return name;
            }

            public void setName(String name)
            {
                this.name = name;
            }

            public String getSex()
            {
                return sex;
            }

            public void setSex(String sex)
            {
                this.sex = sex;
            }

            public String getUserName()
            {
                return userName;
            }

            public void setUserName(String userName)
            {
                this.userName = userName;
            }

            public String getUserPwd()
            {
                return userPwd;
            }

            public void setUserPwd(String userPwd)
            {
                this.userPwd = userPwd;
            }

            public int getAge()
            {
                return age;
            }

            public void setAge(int age)
            {
                this.age = age;
            }

            public int getOrderCount()
            {
                return orderCount;
            }

            public void setOrderCount(int orderCount)
            {
                this.orderCount = orderCount;
            }

            public String getTel()
            {
                return tel;
            }

            public void setTel(String tel)
            {
                this.tel = tel;
            }

            public String getIdCard()
            {
                return idCard;
            }

            public void setIdCard(String idCard)
            {
                this.idCard = idCard;
            }

            public String getAddr()
            {
                return addr;
            }

            public void setAddr(String addr)
            {
                this.addr = addr;
            }

            public String getLongitude()
            {
                return longitude;
            }

            public void setLongitude(String longitude)
            {
                this.longitude = longitude;
            }

            public String getLatitude()
            {
                return latitude;
            }

            public void setLatitude(String latitude)
            {
                this.latitude = latitude;
            }

            public String getIsOnline()
            {
                return isOnline;
            }

            public void setIsOnline(String isOnline)
            {
                this.isOnline = isOnline;
            }

            public String getCourse()
            {
                return course;
            }

            public void setCourse(String course)
            {
                this.course = course;
            }

            public long getLocationTime()
            {
                return locationTime;
            }

            public void setLocationTime(long locationTime)
            {
                this.locationTime = locationTime;
            }

            public String getCarNumber()
            {
                return carNumber;
            }

            public void setCarNumber(String carNumber)
            {
                this.carNumber = carNumber;
            }

            public String getDriverNumber()
            {
                return driverNumber;
            }

            public void setDriverNumber(String driverNumber)
            {
                this.driverNumber = driverNumber;
            }

            public String getDriverDate()
            {
                return driverDate;
            }

            public void setDriverDate(String driverDate)
            {
                this.driverDate = driverDate;
            }

            public String getCarInsurance()
            {
                return carInsurance;
            }

            public void setCarInsurance(String carInsurance)
            {
                this.carInsurance = carInsurance;
            }

            public String getDriverdatepush()
            {
                return driverdatepush;
            }

            public void setDriverdatepush(String driverdatepush)
            {
                this.driverdatepush = driverdatepush;
            }

            public String getCarinsurancepush()
            {
                return carinsurancepush;
            }

            public void setCarinsurancepush(String carinsurancepush)
            {
                this.carinsurancepush = carinsurancepush;
            }

            public int getMinlat()
            {
                return minlat;
            }

            public void setMinlat(int minlat)
            {
                this.minlat = minlat;
            }

            public int getMaxlat()
            {
                return maxlat;
            }

            public void setMaxlat(int maxlat)
            {
                this.maxlat = maxlat;
            }

            public int getMinlng()
            {
                return minlng;
            }

            public void setMinlng(int minlng)
            {
                this.minlng = minlng;
            }

            public int getMaxlng()
            {
                return maxlng;
            }

            public void setMaxlng(int maxlng)
            {
                this.maxlng = maxlng;
            }
        }

        public static class UserBean
        {
            /**
             * id : d83c9fe3b10346389a977252de41a89a
             * isNewRecord : false
             * remarks :
             * createDate : 2017-03-08 21:45:55
             * updateDate : 2017-05-13 01:51:39
             * loginName : test
             * no : test
             * name : test
             * email :
             * phone :
             * mobile : 1111111
             * userType : 3
             * loginIp : 113.119.8.99
             * loginDate : 2017-05-15 13:00:06
             * loginFlag : 1
             * photo :
             * qrCode : null
             * oldLoginName : null
             * newPassword : null
             * sign : null
             * randomCode : kslcfr
             * oldLoginIp : 180.212.38.75
             * oldLoginDate : 2017-05-14 12:57:32
             * role : null
             * roleIds : e4484645fbbd4b90bedcce3659da7d6f
             * roleNames : 司机
             * admin : false
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String loginName;
            private String no;
            private String name;
            private String email;
            private String phone;
            private String mobile;
            private String userType;
            private String loginIp;
            private String loginDate;
            private String loginFlag;
            private String photo;
            private Object qrCode;
            private Object oldLoginName;
            private Object newPassword;
            private Object sign;
            private String randomCode;
            private String oldLoginIp;
            private String oldLoginDate;
            private Object role;
            private String roleIds;
            private String roleNames;
            private boolean admin;

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

            public String getLoginName()
            {
                return loginName;
            }

            public void setLoginName(String loginName)
            {
                this.loginName = loginName;
            }

            public String getNo()
            {
                return no;
            }

            public void setNo(String no)
            {
                this.no = no;
            }

            public String getName()
            {
                return name;
            }

            public void setName(String name)
            {
                this.name = name;
            }

            public String getEmail()
            {
                return email;
            }

            public void setEmail(String email)
            {
                this.email = email;
            }

            public String getPhone()
            {
                return phone;
            }

            public void setPhone(String phone)
            {
                this.phone = phone;
            }

            public String getMobile()
            {
                return mobile;
            }

            public void setMobile(String mobile)
            {
                this.mobile = mobile;
            }

            public String getUserType()
            {
                return userType;
            }

            public void setUserType(String userType)
            {
                this.userType = userType;
            }

            public String getLoginIp()
            {
                return loginIp;
            }

            public void setLoginIp(String loginIp)
            {
                this.loginIp = loginIp;
            }

            public String getLoginDate()
            {
                return loginDate;
            }

            public void setLoginDate(String loginDate)
            {
                this.loginDate = loginDate;
            }

            public String getLoginFlag()
            {
                return loginFlag;
            }

            public void setLoginFlag(String loginFlag)
            {
                this.loginFlag = loginFlag;
            }

            public String getPhoto()
            {
                return photo;
            }

            public void setPhoto(String photo)
            {
                this.photo = photo;
            }

            public Object getQrCode()
            {
                return qrCode;
            }

            public void setQrCode(Object qrCode)
            {
                this.qrCode = qrCode;
            }

            public Object getOldLoginName()
            {
                return oldLoginName;
            }

            public void setOldLoginName(Object oldLoginName)
            {
                this.oldLoginName = oldLoginName;
            }

            public Object getNewPassword()
            {
                return newPassword;
            }

            public void setNewPassword(Object newPassword)
            {
                this.newPassword = newPassword;
            }

            public Object getSign()
            {
                return sign;
            }

            public void setSign(Object sign)
            {
                this.sign = sign;
            }

            public String getRandomCode()
            {
                return randomCode;
            }

            public void setRandomCode(String randomCode)
            {
                this.randomCode = randomCode;
            }

            public String getOldLoginIp()
            {
                return oldLoginIp;
            }

            public void setOldLoginIp(String oldLoginIp)
            {
                this.oldLoginIp = oldLoginIp;
            }

            public String getOldLoginDate()
            {
                return oldLoginDate;
            }

            public void setOldLoginDate(String oldLoginDate)
            {
                this.oldLoginDate = oldLoginDate;
            }

            public Object getRole()
            {
                return role;
            }

            public void setRole(Object role)
            {
                this.role = role;
            }

            public String getRoleIds()
            {
                return roleIds;
            }

            public void setRoleIds(String roleIds)
            {
                this.roleIds = roleIds;
            }

            public String getRoleNames()
            {
                return roleNames;
            }

            public void setRoleNames(String roleNames)
            {
                this.roleNames = roleNames;
            }

            public boolean isAdmin()
            {
                return admin;
            }

            public void setAdmin(boolean admin)
            {
                this.admin = admin;
            }
        }

        public static class DictStatusBean implements Serializable
        {
            /**
             * id : 6c2ee94ca3c94a1088bf1beec356905d
             * isNewRecord : false
             * remarks : 等待
             * createDate : 2016-11-17 15:15:50
             * updateDate : 2016-11-17 15:15:50
             * value : 0
             * label : Wait
             * type : dict_status
             * description : 等待
             * sort : 0
             * parentId : 0
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String value;
            private String label;
            private String type;
            private String description;
            private int sort;
            private String parentId;

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

            public String getValue()
            {
                return value;
            }

            public void setValue(String value)
            {
                this.value = value;
            }

            public String getLabel()
            {
                return label;
            }

            public void setLabel(String label)
            {
                this.label = label;
            }

            public String getType()
            {
                return type;
            }

            public void setType(String type)
            {
                this.type = type;
            }

            public String getDescription()
            {
                return description;
            }

            public void setDescription(String description)
            {
                this.description = description;
            }

            public int getSort()
            {
                return sort;
            }

            public void setSort(int sort)
            {
                this.sort = sort;
            }

            public String getParentId()
            {
                return parentId;
            }

            public void setParentId(String parentId)
            {
                this.parentId = parentId;
            }
        }
    }
}
