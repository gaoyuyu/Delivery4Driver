package com.gaoyy.delivery4driver.api.bean;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by gaoyy on 2017/5/13 0013.
 */

public class OrderListInfo
{

    /**
     * success : true
     * errorCode : -1
     * msg : Success
     * body : {"page":{"pageNo":1,"pageSize":5,"count":8,"list":[{"id":"904a826bf88141b9b7f2ca91ddc85a7f","isNewRecord":false,"remarks":"442613833  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 11:24:01","updateDate":"2017-05-12 15:58:40","orderNo":"2017051222220008","customerName":null,"customerTel":"4426138330","customerAddr":"APT20,1552a rue Baxter","apt":"20","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 11:29:00","deliveryDate":"2017-05-12 15:58:14","finishDate":"2017-05-12 15:58:40","cancelDate":null,"pushDate":1494606540000,"status":3,"isTimeout":0,"pushCount":3,"finishedTime":"other","remark":"door bell not working","dispatch":"1","customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"},{"id":"b6bab4d1a5854813afc14ad3cb825530","isNewRecord":false,"remarks":"234994740  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 08:38:27","updateDate":"2017-05-12 11:21:33","orderNo":"2017051222220002","customerName":null,"customerTel":"2349947400","customerAddr":"APT48,1552a rue Baxter","apt":"48","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 08:43:00","deliveryDate":"2017-05-12 11:20:28","finishDate":"2017-05-12 11:21:33","cancelDate":null,"pushDate":1494596580000,"status":3,"isTimeout":0,"pushCount":3,"finishedTime":"other","remark":"door bell not working","dispatch":"1","customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"},{"id":"adf268cb74b043ecbc66a67df72594f4","isNewRecord":false,"remarks":"985674094  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 08:35:14","updateDate":"2017-05-12 11:21:29","orderNo":"2017051222220001","customerName":null,"customerTel":"9856740940","customerAddr":"APT25,9856740940","apt":"25","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 08:40:00","deliveryDate":"2017-05-12 11:20:23","finishDate":"2017-05-12 11:21:29","cancelDate":null,"pushDate":1494596400000,"status":3,"isTimeout":0,"pushCount":3,"finishedTime":"other","remark":"door bell not working","dispatch":"1","customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"},{"id":"8e680200ad8b4cabb8690de7839274e3","isNewRecord":false,"remarks":"Test data ignore it","createDate":"2017-05-12 11:20:55","updateDate":"2017-05-12 11:21:21","orderNo":"2017051222220007","customerName":null,"customerTel":"4444444444","customerAddr":"APTrt23,1472 Rue Sherbrooke Ouest","apt":"rt23","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 11:20:59","deliveryDate":"2017-05-12 11:21:14","finishDate":"2017-05-12 11:21:21","cancelDate":null,"pushDate":1494606055000,"status":3,"isTimeout":0,"pushCount":1,"finishedTime":"20mins","remark":"door bell not working,","dispatch":null,"customerLongitude":"-73.580681","customerLatitude":"45.497427","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"},{"id":"179a8cefa3cd495084e3b0905979eac7","isNewRecord":false,"remarks":"729966339  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 11:11:19","updateDate":"2017-05-12 11:21:18","orderNo":"2017051222220004","customerName":null,"customerTel":"7299663390","customerAddr":"APT23,1552a rue Baxter","apt":"23","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 11:16:00","deliveryDate":"2017-05-12 11:20:42","finishDate":"2017-05-12 11:21:18","cancelDate":null,"pushDate":1494605760000,"status":3,"isTimeout":0,"pushCount":3,"finishedTime":"other","remark":"","dispatch":"1","customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"}],"html":"<div class=\"fixed-table-pagination\" style=\"display: block;\"><div class=\"pull-left pagination-detail\"><span class=\"pagination-info\">显示第 1 到第 5 条记录，总共 8 条记录<\/span><span class=\"page-list\">每页显示 <span class=\"btn-group dropup\"><button type=\"button\" class=\"btn btn-default  btn-outline dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\"><span class=\"page-size\">5<\/span> <span class=\"caret\"><\/span><\/button><ul class=\"dropdown-menu\" role=\"menu\"><li class=\"\"><a href=\"javascript:page(1,10,'');\">10<\/a><\/li><li class=\"\"><a href=\"javascript:page(1,25,'');\">25<\/a><\/li><li class=\"\"><a href=\"javascript:page(1,50,'');\">50<\/a><\/li><li class=\"\"><a href=\"javascript:page(1,100,'');\">100<\/a><\/li><\/ul><\/span> 条记录<\/span><\/div><div class=\"pull-right pagination-roll\"><ul class=\"pagination pagination-outline\"><li class=\"paginate_button previous disabled\"><a href=\"javascript:\"><i class=\"fa fa-angle-double-left\"><\/i><\/a><\/li>\n<li class=\"paginate_button previous disabled\"><a href=\"javascript:\"><i class=\"fa fa-angle-left\"><\/i><\/a><\/li>\n<li class=\"paginate_button active\"><a href=\"javascript:\">1<\/a><\/li>\n<li class=\"paginate_button \"><a href=\"javascript:\" onclick=\"page(2,5,'');\">2<\/a><\/li>\n<li class=\"paginate_button next\"><a href=\"javascript:\" onclick=\"page(2,5,'');\"><i class=\"fa fa-angle-right\"><\/i><\/a><\/li>\n<li class=\"paginate_button next\"><a href=\"javascript:\" onclick=\"page(2,5,'');\"><i class=\"fa fa-angle-double-right\"><\/i><\/a><\/li>\n<\/ul><\/div><\/div>","firstResult":0,"maxResults":5}}
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
         * page : {"pageNo":1,"pageSize":5,"count":8,"list":[{"id":"904a826bf88141b9b7f2ca91ddc85a7f","isNewRecord":false,"remarks":"442613833  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 11:24:01","updateDate":"2017-05-12 15:58:40","orderNo":"2017051222220008","customerName":null,"customerTel":"4426138330","customerAddr":"APT20,1552a rue Baxter","apt":"20","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 11:29:00","deliveryDate":"2017-05-12 15:58:14","finishDate":"2017-05-12 15:58:40","cancelDate":null,"pushDate":1494606540000,"status":3,"isTimeout":0,"pushCount":3,"finishedTime":"other","remark":"door bell not working","dispatch":"1","customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"},{"id":"b6bab4d1a5854813afc14ad3cb825530","isNewRecord":false,"remarks":"234994740  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 08:38:27","updateDate":"2017-05-12 11:21:33","orderNo":"2017051222220002","customerName":null,"customerTel":"2349947400","customerAddr":"APT48,1552a rue Baxter","apt":"48","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 08:43:00","deliveryDate":"2017-05-12 11:20:28","finishDate":"2017-05-12 11:21:33","cancelDate":null,"pushDate":1494596580000,"status":3,"isTimeout":0,"pushCount":3,"finishedTime":"other","remark":"door bell not working","dispatch":"1","customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"},{"id":"adf268cb74b043ecbc66a67df72594f4","isNewRecord":false,"remarks":"985674094  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 08:35:14","updateDate":"2017-05-12 11:21:29","orderNo":"2017051222220001","customerName":null,"customerTel":"9856740940","customerAddr":"APT25,9856740940","apt":"25","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 08:40:00","deliveryDate":"2017-05-12 11:20:23","finishDate":"2017-05-12 11:21:29","cancelDate":null,"pushDate":1494596400000,"status":3,"isTimeout":0,"pushCount":3,"finishedTime":"other","remark":"door bell not working","dispatch":"1","customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"},{"id":"8e680200ad8b4cabb8690de7839274e3","isNewRecord":false,"remarks":"Test data ignore it","createDate":"2017-05-12 11:20:55","updateDate":"2017-05-12 11:21:21","orderNo":"2017051222220007","customerName":null,"customerTel":"4444444444","customerAddr":"APTrt23,1472 Rue Sherbrooke Ouest","apt":"rt23","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 11:20:59","deliveryDate":"2017-05-12 11:21:14","finishDate":"2017-05-12 11:21:21","cancelDate":null,"pushDate":1494606055000,"status":3,"isTimeout":0,"pushCount":1,"finishedTime":"20mins","remark":"door bell not working,","dispatch":null,"customerLongitude":"-73.580681","customerLatitude":"45.497427","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"},{"id":"179a8cefa3cd495084e3b0905979eac7","isNewRecord":false,"remarks":"729966339  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 11:11:19","updateDate":"2017-05-12 11:21:18","orderNo":"2017051222220004","customerName":null,"customerTel":"7299663390","customerAddr":"APT23,1552a rue Baxter","apt":"23","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 11:16:00","deliveryDate":"2017-05-12 11:20:42","finishDate":"2017-05-12 11:21:18","cancelDate":null,"pushDate":1494605760000,"status":3,"isTimeout":0,"pushCount":3,"finishedTime":"other","remark":"","dispatch":"1","customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"}],"html":"<div class=\"fixed-table-pagination\" style=\"display: block;\"><div class=\"pull-left pagination-detail\"><span class=\"pagination-info\">显示第 1 到第 5 条记录，总共 8 条记录<\/span><span class=\"page-list\">每页显示 <span class=\"btn-group dropup\"><button type=\"button\" class=\"btn btn-default  btn-outline dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\"><span class=\"page-size\">5<\/span> <span class=\"caret\"><\/span><\/button><ul class=\"dropdown-menu\" role=\"menu\"><li class=\"\"><a href=\"javascript:page(1,10,'');\">10<\/a><\/li><li class=\"\"><a href=\"javascript:page(1,25,'');\">25<\/a><\/li><li class=\"\"><a href=\"javascript:page(1,50,'');\">50<\/a><\/li><li class=\"\"><a href=\"javascript:page(1,100,'');\">100<\/a><\/li><\/ul><\/span> 条记录<\/span><\/div><div class=\"pull-right pagination-roll\"><ul class=\"pagination pagination-outline\"><li class=\"paginate_button previous disabled\"><a href=\"javascript:\"><i class=\"fa fa-angle-double-left\"><\/i><\/a><\/li>\n<li class=\"paginate_button previous disabled\"><a href=\"javascript:\"><i class=\"fa fa-angle-left\"><\/i><\/a><\/li>\n<li class=\"paginate_button active\"><a href=\"javascript:\">1<\/a><\/li>\n<li class=\"paginate_button \"><a href=\"javascript:\" onclick=\"page(2,5,'');\">2<\/a><\/li>\n<li class=\"paginate_button next\"><a href=\"javascript:\" onclick=\"page(2,5,'');\"><i class=\"fa fa-angle-right\"><\/i><\/a><\/li>\n<li class=\"paginate_button next\"><a href=\"javascript:\" onclick=\"page(2,5,'');\"><i class=\"fa fa-angle-double-right\"><\/i><\/a><\/li>\n<\/ul><\/div><\/div>","firstResult":0,"maxResults":5}
         */

        private PageBean page;

        public PageBean getPage()
        {
            return page;
        }

        public void setPage(PageBean page)
        {
            this.page = page;
        }

        public static class PageBean
        {
            /**
             * pageNo : 1
             * pageSize : 5
             * count : 8
             * list : [{"id":"904a826bf88141b9b7f2ca91ddc85a7f","isNewRecord":false,"remarks":"442613833  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 11:24:01","updateDate":"2017-05-12 15:58:40","orderNo":"2017051222220008","customerName":null,"customerTel":"4426138330","customerAddr":"APT20,1552a rue Baxter","apt":"20","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 11:29:00","deliveryDate":"2017-05-12 15:58:14","finishDate":"2017-05-12 15:58:40","cancelDate":null,"pushDate":1494606540000,"status":3,"isTimeout":0,"pushCount":3,"finishedTime":"other","remark":"door bell not working","dispatch":"1","customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"},{"id":"b6bab4d1a5854813afc14ad3cb825530","isNewRecord":false,"remarks":"234994740  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 08:38:27","updateDate":"2017-05-12 11:21:33","orderNo":"2017051222220002","customerName":null,"customerTel":"2349947400","customerAddr":"APT48,1552a rue Baxter","apt":"48","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 08:43:00","deliveryDate":"2017-05-12 11:20:28","finishDate":"2017-05-12 11:21:33","cancelDate":null,"pushDate":1494596580000,"status":3,"isTimeout":0,"pushCount":3,"finishedTime":"other","remark":"door bell not working","dispatch":"1","customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"},{"id":"adf268cb74b043ecbc66a67df72594f4","isNewRecord":false,"remarks":"985674094  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 08:35:14","updateDate":"2017-05-12 11:21:29","orderNo":"2017051222220001","customerName":null,"customerTel":"9856740940","customerAddr":"APT25,9856740940","apt":"25","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 08:40:00","deliveryDate":"2017-05-12 11:20:23","finishDate":"2017-05-12 11:21:29","cancelDate":null,"pushDate":1494596400000,"status":3,"isTimeout":0,"pushCount":3,"finishedTime":"other","remark":"door bell not working","dispatch":"1","customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"},{"id":"8e680200ad8b4cabb8690de7839274e3","isNewRecord":false,"remarks":"Test data ignore it","createDate":"2017-05-12 11:20:55","updateDate":"2017-05-12 11:21:21","orderNo":"2017051222220007","customerName":null,"customerTel":"4444444444","customerAddr":"APTrt23,1472 Rue Sherbrooke Ouest","apt":"rt23","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 11:20:59","deliveryDate":"2017-05-12 11:21:14","finishDate":"2017-05-12 11:21:21","cancelDate":null,"pushDate":1494606055000,"status":3,"isTimeout":0,"pushCount":1,"finishedTime":"20mins","remark":"door bell not working,","dispatch":null,"customerLongitude":"-73.580681","customerLatitude":"45.497427","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"},{"id":"179a8cefa3cd495084e3b0905979eac7","isNewRecord":false,"remarks":"729966339  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER","createDate":"2017-05-12 11:11:19","updateDate":"2017-05-12 11:21:18","orderNo":"2017051222220004","customerName":null,"customerTel":"7299663390","customerAddr":"APT23,1552a rue Baxter","apt":"23","orderPrice":0,"createName":"hotel","hotelUser":"hotel","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-05-12 11:16:00","deliveryDate":"2017-05-12 11:20:42","finishDate":"2017-05-12 11:21:18","cancelDate":null,"pushDate":1494605760000,"status":3,"isTimeout":0,"pushCount":3,"finishedTime":"other","remark":"","dispatch":"1","customerLongitude":"-73.6101765","customerLatitude":"45.438691","hotelLongitude":"-73.65730047225952","hotelLatitude":"45.500722338655436","hotelAddr":"hotel","isHasCourierLogin":null,"validTime":null,"hotelTel":"4444444444","date":null,"count":null,"remarkList":null,"pushFrequency":null,"price":"0.0"}]
             * html : <div class="fixed-table-pagination" style="display: block;"><div class="pull-left pagination-detail"><span class="pagination-info">显示第 1 到第 5 条记录，总共 8 条记录</span><span class="page-list">每页显示 <span class="btn-group dropup"><button type="button" class="btn btn-default  btn-outline dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="page-size">5</span> <span class="caret"></span></button><ul class="dropdown-menu" role="menu"><li class=""><a href="javascript:page(1,10,'');">10</a></li><li class=""><a href="javascript:page(1,25,'');">25</a></li><li class=""><a href="javascript:page(1,50,'');">50</a></li><li class=""><a href="javascript:page(1,100,'');">100</a></li></ul></span> 条记录</span></div><div class="pull-right pagination-roll"><ul class="pagination pagination-outline"><li class="paginate_button previous disabled"><a href="javascript:"><i class="fa fa-angle-double-left"></i></a></li>
             <li class="paginate_button previous disabled"><a href="javascript:"><i class="fa fa-angle-left"></i></a></li>
             <li class="paginate_button active"><a href="javascript:">1</a></li>
             <li class="paginate_button "><a href="javascript:" onclick="page(2,5,'');">2</a></li>
             <li class="paginate_button next"><a href="javascript:" onclick="page(2,5,'');"><i class="fa fa-angle-right"></i></a></li>
             <li class="paginate_button next"><a href="javascript:" onclick="page(2,5,'');"><i class="fa fa-angle-double-right"></i></a></li>
             </ul></div></div>
             * firstResult : 0
             * maxResults : 5
             */

            private int pageNo;
            private int pageSize;
            private int count;
            private String html;
            private int firstResult;
            private int maxResults;
            private LinkedList<ListBean> list;

            public int getPageNo()
            {
                return pageNo;
            }

            public void setPageNo(int pageNo)
            {
                this.pageNo = pageNo;
            }

            public int getPageSize()
            {
                return pageSize;
            }

            public void setPageSize(int pageSize)
            {
                this.pageSize = pageSize;
            }

            public int getCount()
            {
                return count;
            }

            public void setCount(int count)
            {
                this.count = count;
            }

            public String getHtml()
            {
                return html;
            }

            public void setHtml(String html)
            {
                this.html = html;
            }

            public int getFirstResult()
            {
                return firstResult;
            }

            public void setFirstResult(int firstResult)
            {
                this.firstResult = firstResult;
            }

            public int getMaxResults()
            {
                return maxResults;
            }

            public void setMaxResults(int maxResults)
            {
                this.maxResults = maxResults;
            }

            public LinkedList<ListBean> getList()
            {
                return list;
            }

            public void setList(LinkedList<ListBean> list)
            {
                this.list = list;
            }

            public static class ListBean implements Serializable
            {
                /**
                 * id : 904a826bf88141b9b7f2ca91ddc85a7f
                 * isNewRecord : false
                 * remarks : 442613833  This is Test Data,PLEASE DO NOT ACCEPT THIS ORDER
                 * createDate : 2017-05-12 11:24:01
                 * updateDate : 2017-05-12 15:58:40
                 * orderNo : 2017051222220008
                 * customerName : null
                 * customerTel : 4426138330
                 * customerAddr : APT20,1552a rue Baxter
                 * apt : 20
                 * orderPrice : 0
                 * createName : hotel
                 * hotelUser : hotel
                 * courierName : Sam
                 * actionName : Sam
                 * courierLogin : Sam
                 * courierTel : 34
                 * acceptDate : 2017-05-12 11:29:00
                 * deliveryDate : 2017-05-12 15:58:14
                 * finishDate : 2017-05-12 15:58:40
                 * cancelDate : null
                 * pushDate : 1494606540000
                 * status : 3
                 * isTimeout : 0
                 * pushCount : 3
                 * finishedTime : other
                 * remark : door bell not working
                 * dispatch : 1
                 * customerLongitude : -73.6101765
                 * customerLatitude : 45.438691
                 * hotelLongitude : -73.65730047225952
                 * hotelLatitude : 45.500722338655436
                 * hotelAddr : hotel
                 * isHasCourierLogin : null
                 * validTime : null
                 * hotelTel : 4444444444
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
                private String courierName;
                private String actionName;
                private String courierLogin;
                private String courierTel;
                private String acceptDate;
                private String deliveryDate;
                private String finishDate;
                private String cancelDate;
                private String pushDate;
                private int status;
                private int isTimeout;
                private int pushCount;
                private String finishedTime;
                private String remark;
                private String dispatch;
                private String customerLongitude;
                private String customerLatitude;
                private String hotelLongitude;
                private String hotelLatitude;
                private String hotelAddr;
                private Object isHasCourierLogin;
                private Object validTime;
                private String hotelTel;
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

                public String getCourierName()
                {
                    return courierName;
                }

                public void setCourierName(String courierName)
                {
                    this.courierName = courierName;
                }

                public String getActionName()
                {
                    return actionName;
                }

                public void setActionName(String actionName)
                {
                    this.actionName = actionName;
                }

                public String getCourierLogin()
                {
                    return courierLogin;
                }

                public void setCourierLogin(String courierLogin)
                {
                    this.courierLogin = courierLogin;
                }

                public String getCourierTel()
                {
                    return courierTel;
                }

                public void setCourierTel(String courierTel)
                {
                    this.courierTel = courierTel;
                }

                public String getAcceptDate()
                {
                    return acceptDate;
                }

                public void setAcceptDate(String acceptDate)
                {
                    this.acceptDate = acceptDate;
                }

                public String getDeliveryDate()
                {
                    return deliveryDate;
                }

                public void setDeliveryDate(String deliveryDate)
                {
                    this.deliveryDate = deliveryDate;
                }

                public String getFinishDate()
                {
                    return finishDate;
                }

                public void setFinishDate(String finishDate)
                {
                    this.finishDate = finishDate;
                }

                public String getCancelDate()
                {
                    return cancelDate;
                }

                public void setCancelDate(String cancelDate)
                {
                    this.cancelDate = cancelDate;
                }

                public String getPushDate()
                {
                    return pushDate;
                }

                public void setPushDate(String pushDate)
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

                public String getDispatch()
                {
                    return dispatch;
                }

                public void setDispatch(String dispatch)
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

                public String getHotelLongitude()
                {
                    return hotelLongitude;
                }

                public void setHotelLongitude(String hotelLongitude)
                {
                    this.hotelLongitude = hotelLongitude;
                }

                public String getHotelLatitude()
                {
                    return hotelLatitude;
                }

                public void setHotelLatitude(String hotelLatitude)
                {
                    this.hotelLatitude = hotelLatitude;
                }

                public String getHotelAddr()
                {
                    return hotelAddr;
                }

                public void setHotelAddr(String hotelAddr)
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

                public String getHotelTel()
                {
                    return hotelTel;
                }

                public void setHotelTel(String hotelTel)
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
}
