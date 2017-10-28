package com.gaoyy.delivery4driver.api.bean;

/**
 * Created by gaoyy on 2017/10/27 0027.
 */

public class ScoreInfo
{

    /**
     * body : {"oneStar":0,"twoStar":0,"threeStar":5,"fourStar":2,"fiveStar":4,"language":"zh"}
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

    public static class BodyBean
    {
        /**
         * oneStar : 0
         * twoStar : 0
         * threeStar : 5
         * fourStar : 2
         * fiveStar : 4
         * language : zh
         */

        private int oneStar;
        private int twoStar;
        private int threeStar;
        private int fourStar;
        private int fiveStar;
        private String language;

        public int getOneStar()
        {
            return oneStar;
        }

        public void setOneStar(int oneStar)
        {
            this.oneStar = oneStar;
        }

        public int getTwoStar()
        {
            return twoStar;
        }

        public void setTwoStar(int twoStar)
        {
            this.twoStar = twoStar;
        }

        public int getThreeStar()
        {
            return threeStar;
        }

        public void setThreeStar(int threeStar)
        {
            this.threeStar = threeStar;
        }

        public int getFourStar()
        {
            return fourStar;
        }

        public void setFourStar(int fourStar)
        {
            this.fourStar = fourStar;
        }

        public int getFiveStar()
        {
            return fiveStar;
        }

        public void setFiveStar(int fiveStar)
        {
            this.fiveStar = fiveStar;
        }

        public String getLanguage()
        {
            return language;
        }

        public void setLanguage(String language)
        {
            this.language = language;
        }
    }
}
