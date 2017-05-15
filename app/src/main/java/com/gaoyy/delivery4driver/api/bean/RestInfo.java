package com.gaoyy.delivery4driver.api.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaoyy on 2017/5/6 0006.
 */

public class RestInfo
{

    /**
     * success : true
     * errorCode : -1
     * msg : login Success
     * body : {"remarkDict":[{"id":"2fec1ee8b9734d91b1da1f7d1a7ec712","isNewRecord":false,"remarks":"","createDate":"2016-11-22 16:12:51","updateDate":"2017-02-23 08:55:05","value":"2","label":"door bell not working","type":"dict_remark","description":"备注项","sort":10,"parentId":"0"}],"finishedTime":[{"id":"6fa6b9a850de491a833a9c2af5489a69","isNewRecord":false,"remarks":"other","createDate":"2017-02-23 10:44:38","updateDate":"2017-03-15 00:31:58","value":"other","label":"other","type":"finished_time","description":"other","sort":0,"parentId":"0"},{"id":"599b4cff207b486a95b4c29bc0721477","isNewRecord":false,"remarks":"","createDate":"2017-02-23 10:42:35","updateDate":"2017-03-15 00:27:04","value":"5mins","label":"5mins","type":"finished_time","description":"预计5分钟之内完成","sort":1,"parentId":"0"},{"id":"6b45ed166d584863b47b61a0ecf361f0","isNewRecord":false,"remarks":"","createDate":"2017-02-23 10:43:28","updateDate":"2017-03-01 19:41:59","value":"10mins","label":"10mins","type":"finished_time","description":"预计10分钟之内完成","sort":2,"parentId":"0"},{"id":"6fa6b9a850de491a833a9c2af5489a68","isNewRecord":false,"remarks":"","createDate":"2017-02-23 10:44:38","updateDate":"2017-03-01 19:41:49","value":"15mins","label":"15mins","type":"finished_time","description":"预计15分钟之内完成","sort":3,"parentId":"0"},{"id":"64897b7359a041e88f8a2c62366b72f0","isNewRecord":false,"remarks":"","createDate":"2017-02-23 10:45:15","updateDate":"2017-03-01 19:41:43","value":"20mins","label":"20mins","type":"finished_time","description":"预计20分钟之内完成","sort":4,"parentId":"0"}],"hotel":{"id":"ac6addc923ca457f91f576bab91adef4","isNewRecord":false,"remarks":"","createDate":"2017-03-14 09:30:42","updateDate":"2017-03-14 09:30:42","name":"SanHeSheng","addr":"4424 Wellingtong","userName":"sanhe4424","userPwd":"sanhe951","contacts":"sanhe4424","tel":"5146412761","startDeliveryTime":"11:00","endDeliveryTime":"21:40","longitude":"-73.56724262237549","latitude":"45.4597844747297","no":"0203"},"dictStatus":[{"id":"6c2ee94ca3c94a1088bf1beec356905d","isNewRecord":false,"remarks":"等待","createDate":"2016-11-17 15:15:50","updateDate":"2016-11-17 15:15:50","value":"0","label":"Wait","type":"dict_status","description":"等待","sort":0,"parentId":"0"},{"id":"597d8cab1b8f4fc487cf8ab7f7df3997","isNewRecord":false,"remarks":"接受","createDate":"2016-11-17 15:16:28","updateDate":"2016-11-17 15:16:28","value":"1","label":"Accept","type":"dict_status","description":"接受","sort":1,"parentId":"0"},{"id":"ce76354e28e44a6093cab30fb625bd83","isNewRecord":false,"remarks":"派送","createDate":"2016-11-17 15:17:00","updateDate":"2016-11-17 15:17:00","value":"2","label":"Delivery","type":"dict_status","description":"派送","sort":2,"parentId":"0"},{"id":"cb5c6fd9486743348894bc42a3ceb81f","isNewRecord":false,"remarks":"完成","createDate":"2016-11-17 15:17:33","updateDate":"2016-11-17 15:17:33","value":"3","label":"Finish","type":"dict_status","description":"完成","sort":3,"parentId":"0"},{"id":"f75832e76185404d96b8cec0fe0541cb","isNewRecord":false,"remarks":"取消","createDate":"2016-11-17 15:17:55","updateDate":"2016-11-17 15:17:55","value":"4","label":"Cancel","type":"dict_status","description":"取消","sort":4,"parentId":"0"},{"id":"581ab0fe7b484180b970544beee1e154","isNewRecord":false,"remarks":"退单","createDate":"2016-11-25 09:43:30","updateDate":"2016-11-25 09:43:30","value":"5","label":"Back","type":"dict_status","description":"退单","sort":5,"parentId":"0"}],"user":{"id":"795169542a874c02b66442b587114946","isNewRecord":false,"remarks":"","createDate":"2017-03-14 09:30:42","updateDate":"2017-05-07 02:13:27","loginName":"sanhe4424","no":"sanhe4424","name":"SanHeSheng","email":"","phone":"","mobile":"5146412761","userType":"3","loginIp":"47.89.184.140","loginDate":"2017-05-10 14:42:13","loginFlag":"1","photo":"","qrCode":null,"oldLoginName":null,"newPassword":null,"sign":null,"randomCode":"6arwxm","oldLoginIp":"47.91.150.190","oldLoginDate":"2017-05-10 14:22:23","role":null,"roleIds":"304630d8cad64ed3a4f0731f0c29b27f","roleNames":"饭店","admin":false}}
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
         * remarkDict : [{"id":"2fec1ee8b9734d91b1da1f7d1a7ec712","isNewRecord":false,"remarks":"","createDate":"2016-11-22 16:12:51","updateDate":"2017-02-23 08:55:05","value":"2","label":"door bell not working","type":"dict_remark","description":"备注项","sort":10,"parentId":"0"}]
         * finishedTime : [{"id":"6fa6b9a850de491a833a9c2af5489a69","isNewRecord":false,"remarks":"other","createDate":"2017-02-23 10:44:38","updateDate":"2017-03-15 00:31:58","value":"other","label":"other","type":"finished_time","description":"other","sort":0,"parentId":"0"},{"id":"599b4cff207b486a95b4c29bc0721477","isNewRecord":false,"remarks":"","createDate":"2017-02-23 10:42:35","updateDate":"2017-03-15 00:27:04","value":"5mins","label":"5mins","type":"finished_time","description":"预计5分钟之内完成","sort":1,"parentId":"0"},{"id":"6b45ed166d584863b47b61a0ecf361f0","isNewRecord":false,"remarks":"","createDate":"2017-02-23 10:43:28","updateDate":"2017-03-01 19:41:59","value":"10mins","label":"10mins","type":"finished_time","description":"预计10分钟之内完成","sort":2,"parentId":"0"},{"id":"6fa6b9a850de491a833a9c2af5489a68","isNewRecord":false,"remarks":"","createDate":"2017-02-23 10:44:38","updateDate":"2017-03-01 19:41:49","value":"15mins","label":"15mins","type":"finished_time","description":"预计15分钟之内完成","sort":3,"parentId":"0"},{"id":"64897b7359a041e88f8a2c62366b72f0","isNewRecord":false,"remarks":"","createDate":"2017-02-23 10:45:15","updateDate":"2017-03-01 19:41:43","value":"20mins","label":"20mins","type":"finished_time","description":"预计20分钟之内完成","sort":4,"parentId":"0"}]
         * hotel : {"id":"ac6addc923ca457f91f576bab91adef4","isNewRecord":false,"remarks":"","createDate":"2017-03-14 09:30:42","updateDate":"2017-03-14 09:30:42","name":"SanHeSheng","addr":"4424 Wellingtong","userName":"sanhe4424","userPwd":"sanhe951","contacts":"sanhe4424","tel":"5146412761","startDeliveryTime":"11:00","endDeliveryTime":"21:40","longitude":"-73.56724262237549","latitude":"45.4597844747297","no":"0203"}
         * dictStatus : [{"id":"6c2ee94ca3c94a1088bf1beec356905d","isNewRecord":false,"remarks":"等待","createDate":"2016-11-17 15:15:50","updateDate":"2016-11-17 15:15:50","value":"0","label":"Wait","type":"dict_status","description":"等待","sort":0,"parentId":"0"},{"id":"597d8cab1b8f4fc487cf8ab7f7df3997","isNewRecord":false,"remarks":"接受","createDate":"2016-11-17 15:16:28","updateDate":"2016-11-17 15:16:28","value":"1","label":"Accept","type":"dict_status","description":"接受","sort":1,"parentId":"0"},{"id":"ce76354e28e44a6093cab30fb625bd83","isNewRecord":false,"remarks":"派送","createDate":"2016-11-17 15:17:00","updateDate":"2016-11-17 15:17:00","value":"2","label":"Delivery","type":"dict_status","description":"派送","sort":2,"parentId":"0"},{"id":"cb5c6fd9486743348894bc42a3ceb81f","isNewRecord":false,"remarks":"完成","createDate":"2016-11-17 15:17:33","updateDate":"2016-11-17 15:17:33","value":"3","label":"Finish","type":"dict_status","description":"完成","sort":3,"parentId":"0"},{"id":"f75832e76185404d96b8cec0fe0541cb","isNewRecord":false,"remarks":"取消","createDate":"2016-11-17 15:17:55","updateDate":"2016-11-17 15:17:55","value":"4","label":"Cancel","type":"dict_status","description":"取消","sort":4,"parentId":"0"},{"id":"581ab0fe7b484180b970544beee1e154","isNewRecord":false,"remarks":"退单","createDate":"2016-11-25 09:43:30","updateDate":"2016-11-25 09:43:30","value":"5","label":"Back","type":"dict_status","description":"退单","sort":5,"parentId":"0"}]
         * user : {"id":"795169542a874c02b66442b587114946","isNewRecord":false,"remarks":"","createDate":"2017-03-14 09:30:42","updateDate":"2017-05-07 02:13:27","loginName":"sanhe4424","no":"sanhe4424","name":"SanHeSheng","email":"","phone":"","mobile":"5146412761","userType":"3","loginIp":"47.89.184.140","loginDate":"2017-05-10 14:42:13","loginFlag":"1","photo":"","qrCode":null,"oldLoginName":null,"newPassword":null,"sign":null,"randomCode":"6arwxm","oldLoginIp":"47.91.150.190","oldLoginDate":"2017-05-10 14:22:23","role":null,"roleIds":"304630d8cad64ed3a4f0731f0c29b27f","roleNames":"饭店","admin":false}
         */

        private HotelBean hotel;
        private UserBean user;
        private List<RemarkDictBean> remarkDict;
        private List<FinishedTimeBean> finishedTime;
        private List<DictStatusBean> dictStatus;

        public HotelBean getHotel()
        {
            return hotel;
        }

        public void setHotel(HotelBean hotel)
        {
            this.hotel = hotel;
        }

        public UserBean getUser()
        {
            return user;
        }

        public void setUser(UserBean user)
        {
            this.user = user;
        }

        public List<RemarkDictBean> getRemarkDict()
        {
            return remarkDict;
        }

        public void setRemarkDict(List<RemarkDictBean> remarkDict)
        {
            this.remarkDict = remarkDict;
        }

        public List<FinishedTimeBean> getFinishedTime()
        {
            return finishedTime;
        }

        public void setFinishedTime(List<FinishedTimeBean> finishedTime)
        {
            this.finishedTime = finishedTime;
        }

        public List<DictStatusBean> getDictStatus()
        {
            return dictStatus;
        }

        public void setDictStatus(List<DictStatusBean> dictStatus)
        {
            this.dictStatus = dictStatus;
        }

        public static class HotelBean implements Serializable
        {
            /**
             * id : ac6addc923ca457f91f576bab91adef4
             * isNewRecord : false
             * remarks :
             * createDate : 2017-03-14 09:30:42
             * updateDate : 2017-03-14 09:30:42
             * name : SanHeSheng
             * addr : 4424 Wellingtong
             * userName : sanhe4424
             * userPwd : sanhe951
             * contacts : sanhe4424
             * tel : 5146412761
             * startDeliveryTime : 11:00
             * endDeliveryTime : 21:40
             * longitude : -73.56724262237549
             * latitude : 45.4597844747297
             * no : 0203
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private String updateDate;
            private String name;
            private String addr;
            private String userName;
            private String userPwd;
            private String contacts;
            private String tel;
            private String startDeliveryTime;
            private String endDeliveryTime;
            private String longitude;
            private String latitude;
            private String no;

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

            public String getAddr()
            {
                return addr;
            }

            public void setAddr(String addr)
            {
                this.addr = addr;
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

            public String getContacts()
            {
                return contacts;
            }

            public void setContacts(String contacts)
            {
                this.contacts = contacts;
            }

            public String getTel()
            {
                return tel;
            }

            public void setTel(String tel)
            {
                this.tel = tel;
            }

            public String getStartDeliveryTime()
            {
                return startDeliveryTime;
            }

            public void setStartDeliveryTime(String startDeliveryTime)
            {
                this.startDeliveryTime = startDeliveryTime;
            }

            public String getEndDeliveryTime()
            {
                return endDeliveryTime;
            }

            public void setEndDeliveryTime(String endDeliveryTime)
            {
                this.endDeliveryTime = endDeliveryTime;
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

            public String getNo()
            {
                return no;
            }

            public void setNo(String no)
            {
                this.no = no;
            }
        }

        public static class UserBean implements Serializable
        {
            /**
             * id : 795169542a874c02b66442b587114946
             * isNewRecord : false
             * remarks :
             * createDate : 2017-03-14 09:30:42
             * updateDate : 2017-05-07 02:13:27
             * loginName : sanhe4424
             * no : sanhe4424
             * name : SanHeSheng
             * email :
             * phone :
             * mobile : 5146412761
             * userType : 3
             * loginIp : 47.89.184.140
             * loginDate : 2017-05-10 14:42:13
             * loginFlag : 1
             * photo :
             * qrCode : null
             * oldLoginName : null
             * newPassword : null
             * sign : null
             * randomCode : 6arwxm
             * oldLoginIp : 47.91.150.190
             * oldLoginDate : 2017-05-10 14:22:23
             * role : null
             * roleIds : 304630d8cad64ed3a4f0731f0c29b27f
             * roleNames : 饭店
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

        public static class RemarkDictBean implements Serializable
        {
            /**
             * id : 2fec1ee8b9734d91b1da1f7d1a7ec712
             * isNewRecord : false
             * remarks :
             * createDate : 2016-11-22 16:12:51
             * updateDate : 2017-02-23 08:55:05
             * value : 2
             * label : door bell not working
             * type : dict_remark
             * description : 备注项
             * sort : 10
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

        public static class FinishedTimeBean implements Serializable
        {
            /**
             * id : 6fa6b9a850de491a833a9c2af5489a69
             * isNewRecord : false
             * remarks : other
             * createDate : 2017-02-23 10:44:38
             * updateDate : 2017-03-15 00:31:58
             * value : other
             * label : other
             * type : finished_time
             * description : other
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
