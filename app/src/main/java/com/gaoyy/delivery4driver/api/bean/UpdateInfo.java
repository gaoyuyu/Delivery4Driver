package com.gaoyy.delivery4driver.api.bean;

/**
 * Created by gaoyy on 2017/5/27 0027.
 */

public class UpdateInfo
{

    /**
     * success : true
     * errorCode : -1
     * msg :
     * body : {"androidVersion":"1","androidIsUpdate":"1","iosVersion":"1","iosIsUpdate":"1"}
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
         * androidVersion : 1
         * androidIsUpdate : 1
         * iosVersion : 1
         * iosIsUpdate : 1
         */

        private String androidVersion;
        private String androidIsUpdate;
        private String iosVersion;
        private String iosIsUpdate;

        public String getAndroidVersion()
        {
            return androidVersion;
        }

        public void setAndroidVersion(String androidVersion)
        {
            this.androidVersion = androidVersion;
        }

        public String getAndroidIsUpdate()
        {
            return androidIsUpdate;
        }

        public void setAndroidIsUpdate(String androidIsUpdate)
        {
            this.androidIsUpdate = androidIsUpdate;
        }

        public String getIosVersion()
        {
            return iosVersion;
        }

        public void setIosVersion(String iosVersion)
        {
            this.iosVersion = iosVersion;
        }

        public String getIosIsUpdate()
        {
            return iosIsUpdate;
        }

        public void setIosIsUpdate(String iosIsUpdate)
        {
            this.iosIsUpdate = iosIsUpdate;
        }
    }
}
