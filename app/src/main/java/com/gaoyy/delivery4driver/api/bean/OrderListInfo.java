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
     * body : {"page":{"pageNo":1,"pageSize":10,"count":12,"list":[{"id":"34fc42e64df8449fb47cd109fd43b9e3","isNewRecord":false,"remarks":"","createDate":"2017-09-05 21:21:12","updateDate":"2017-09-05 21:25:00","orderNo":"2017090513240001","customerName":null,"customerTel":"1234567890","customerAddr":"APT4楼405,金海湾人民大街店","apt":"4楼405","orderPrice":0,"createName":"商家7的店","hotelUser":"sj7","courierName":"Sam","actionName":null,"courierLogin":"Sam","courierTel":"34","acceptDate":"2017-09-05 21:25:00","deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":"2017-09-05 21:25:00","status":1,"isTimeout":0,"pushCount":3,"finishedTime":"0","remark":"","dispatch":"1","customerLongitude":"0.000000","customerLatitude":"0.000000","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":null,"goodsInfo":null,"orderGoods":null,"orderType":0,"distributionType":"Delivery","price":"0.0"},{"id":"3c88a888b71a49d3969ec791cc669baf","isNewRecord":false,"remarks":"","createDate":"2017-09-04 22:25:14","updateDate":"2017-09-04 22:29:00","orderNo":"2017090413240001","customerName":null,"customerTel":"1234567890","customerAddr":"APT4楼405,金海湾人民大街店","apt":"4楼405","orderPrice":0,"createName":"商家7的店","hotelUser":"sj7","courierName":"Sam","actionName":null,"courierLogin":"Sam","courierTel":"34","acceptDate":"2017-09-04 22:29:00","deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":"2017-09-04 22:29:00","status":1,"isTimeout":0,"pushCount":3,"finishedTime":"0","remark":"","dispatch":"1","customerLongitude":"0.000000","customerLatitude":"0.000000","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":null,"goodsInfo":null,"orderGoods":null,"orderType":0,"distributionType":"Delivery","price":"0.0"},{"id":"f1ca376c359748d78297a59ec64ba604","isNewRecord":false,"remarks":"","createDate":"2017-09-04 22:11:51","updateDate":"2017-09-04 22:21:48","orderNo":"2017090413240001","customerName":null,"customerTel":"1234567890","customerAddr":"APT4楼405,金海湾人民大街店","apt":"4楼405","orderPrice":0,"createName":"商家7的店","hotelUser":"sj7","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-09-04 22:15:00","deliveryDate":"2017-09-04 22:21:35","finishDate":"2017-09-04 22:21:48","cancelDate":null,"pushDate":"2017-09-04 22:15:00","status":3,"isTimeout":0,"pushCount":3,"finishedTime":"20mins","remark":"","dispatch":"1","customerLongitude":"0.000000","customerLatitude":"0.000000","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":null,"goodsInfo":null,"orderGoods":null,"orderType":0,"distributionType":"Delivery","price":"0.0"},{"id":"055c327f84b0496785f4e4012d00d071","isNewRecord":false,"remarks":"","createDate":"2017-09-04 22:16:51","updateDate":"2017-09-04 22:21:41","orderNo":"2017090413240001","customerName":null,"customerTel":"1234567890","customerAddr":"APT4楼405,金海湾人民大街店","apt":"4楼405","orderPrice":0,"createName":"商家7的店","hotelUser":"sj7","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-09-04 22:21:00","deliveryDate":"2017-09-04 22:21:38","finishDate":"2017-09-04 22:21:41","cancelDate":null,"pushDate":"2017-09-04 22:21:00","status":3,"isTimeout":0,"pushCount":3,"finishedTime":"20mins","remark":"","dispatch":"1","customerLongitude":"0.000000","customerLatitude":"0.000000","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":null,"goodsInfo":null,"orderGoods":null,"orderType":0,"distributionType":"Delivery","price":"0.0"},{"id":"8bbabc2056ed428f817e46aca18ac715","isNewRecord":false,"remarks":"","createDate":"2017-09-03 22:50:14","updateDate":"2017-09-04 02:29:42","orderNo":"2017090313240001","customerName":"官健","customerTel":"5149843566","customerAddr":"5902 Rue Hamilton, Montreal, QC, Canada","apt":null,"orderPrice":53.51,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":"2017-09-04 02:29:42","pushDate":"2017-09-04 02:28:08","status":4,"isTimeout":0,"pushCount":1,"finishedTime":"20min","remark":null,"dispatch":"0","customerLongitude":"-73.598366","customerLatitude":"45.45933220000001","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"123","goodsInfo":"锅包肉,1,32.00;麦当劳,1,54.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"53.51"},{"id":"4df52043b829400dbf9055237fbdbf71","isNewRecord":false,"remarks":"","createDate":"2017-09-03 22:56:57","updateDate":"2017-09-04 02:27:27","orderNo":"2017090313240001","customerName":"官健","customerTel":"5149843566","customerAddr":"5902 Rue Hamilton, Montreal, QC, Canada","apt":null,"orderPrice":53.51,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":4,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"-73.598366","customerLatitude":"45.45933220000001","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"124","goodsInfo":"锅包肉,1,32.00;麦当劳,1,54.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"53.51"},{"id":"4f82f3cd6fa44e28beb2daccb75c5b51","isNewRecord":false,"remarks":"","createDate":"2017-09-04 22:08:33","updateDate":"2017-09-04 22:08:33","orderNo":"2017090413240001","customerName":"买家","customerTel":"13241234","customerAddr":"拉丁区, 蒙特利尔, 魁北克省, 加拿大","apt":null,"orderPrice":59.74,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":6,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"-73.56390599999997","customerLatitude":"45.51550779999999","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"130","goodsInfo":"锅包肉,3,32.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"59.74"},{"id":"1f94e84d70fe49878ce7dd6785460c6b","isNewRecord":false,"remarks":"","createDate":"2017-09-03 22:32:38","updateDate":"2017-09-03 22:32:38","orderNo":"2017090313240001","customerName":"刘楠","customerTel":"13069049021","customerAddr":"中国吉林省长春市二道区","apt":null,"orderPrice":65522.4,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":6,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"125.37421700000004","customerLatitude":"43.865595","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"122","goodsInfo":"锅包肉,2,32.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"65522.4"},{"id":"9eb4288759974f2abb3f2d8441ebb20a","isNewRecord":false,"remarks":"","createDate":"2017-09-03 22:31:54","updateDate":"2017-09-03 22:31:54","orderNo":"2017090313240001","customerName":"刘楠","customerTel":"13069049021","customerAddr":"中国吉林省长春市二道区","apt":null,"orderPrice":65522.4,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":6,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"125.37421700000004","customerLatitude":"43.865595","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"121","goodsInfo":"锅包肉,2,32.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"65522.4"},{"id":"7dfce6dd62a84042b187a39998f46e6d","isNewRecord":false,"remarks":"两瓶水，请准时送达","createDate":"2017-09-03 22:22:31","updateDate":"2017-09-03 22:22:31","orderNo":"2017090313240001","customerName":"刘楠","customerTel":"13069049021","customerAddr":"中国吉林省长春市二道区","apt":null,"orderPrice":65516.17,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":6,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"125.37421700000004","customerLatitude":"43.865595","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"120","goodsInfo":"麦当劳,1,54.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"65516.17"}],"html":"<div class=\"fixed-table-pagination\" style=\"display: block;\"><div class=\"pull-left pagination-detail\"><span class=\"pagination-info\">显示第 1 到第 10 条记录，总共 12 条记录<\/span><span class=\"page-list\">每页显示 <span class=\"btn-group dropup\"><button type=\"button\" class=\"btn btn-default  btn-outline dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\"><span class=\"page-size\">10<\/span> <span class=\"caret\"><\/span><\/button><ul class=\"dropdown-menu\" role=\"menu\"><li class=\"active\"><a href=\"javascript:page(1,10,'');\">10<\/a><\/li><li class=\"\"><a href=\"javascript:page(1,25,'');\">25<\/a><\/li><li class=\"\"><a href=\"javascript:page(1,50,'');\">50<\/a><\/li><li class=\"\"><a href=\"javascript:page(1,100,'');\">100<\/a><\/li><\/ul><\/span> 条记录<\/span><\/div><div class=\"pull-right pagination-roll\"><ul class=\"pagination pagination-outline\"><li class=\"paginate_button previous disabled\"><a href=\"javascript:\"><i class=\"fa fa-angle-double-left\"><\/i><\/a><\/li>\n<li class=\"paginate_button previous disabled\"><a href=\"javascript:\"><i class=\"fa fa-angle-left\"><\/i><\/a><\/li>\n<li class=\"paginate_button active\"><a href=\"javascript:\">1<\/a><\/li>\n<li class=\"paginate_button \"><a href=\"javascript:\" onclick=\"page(2,10,'');\">2<\/a><\/li>\n<li class=\"paginate_button next\"><a href=\"javascript:\" onclick=\"page(2,10,'');\"><i class=\"fa fa-angle-right\"><\/i><\/a><\/li>\n<li class=\"paginate_button next\"><a href=\"javascript:\" onclick=\"page(2,10,'');\"><i class=\"fa fa-angle-double-right\"><\/i><\/a><\/li>\n<\/ul><\/div><\/div>","maxResults":10,"firstResult":0}}
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
         * page : {"pageNo":1,"pageSize":10,"count":12,"list":[{"id":"34fc42e64df8449fb47cd109fd43b9e3","isNewRecord":false,"remarks":"","createDate":"2017-09-05 21:21:12","updateDate":"2017-09-05 21:25:00","orderNo":"2017090513240001","customerName":null,"customerTel":"1234567890","customerAddr":"APT4楼405,金海湾人民大街店","apt":"4楼405","orderPrice":0,"createName":"商家7的店","hotelUser":"sj7","courierName":"Sam","actionName":null,"courierLogin":"Sam","courierTel":"34","acceptDate":"2017-09-05 21:25:00","deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":"2017-09-05 21:25:00","status":1,"isTimeout":0,"pushCount":3,"finishedTime":"0","remark":"","dispatch":"1","customerLongitude":"0.000000","customerLatitude":"0.000000","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":null,"goodsInfo":null,"orderGoods":null,"orderType":0,"distributionType":"Delivery","price":"0.0"},{"id":"3c88a888b71a49d3969ec791cc669baf","isNewRecord":false,"remarks":"","createDate":"2017-09-04 22:25:14","updateDate":"2017-09-04 22:29:00","orderNo":"2017090413240001","customerName":null,"customerTel":"1234567890","customerAddr":"APT4楼405,金海湾人民大街店","apt":"4楼405","orderPrice":0,"createName":"商家7的店","hotelUser":"sj7","courierName":"Sam","actionName":null,"courierLogin":"Sam","courierTel":"34","acceptDate":"2017-09-04 22:29:00","deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":"2017-09-04 22:29:00","status":1,"isTimeout":0,"pushCount":3,"finishedTime":"0","remark":"","dispatch":"1","customerLongitude":"0.000000","customerLatitude":"0.000000","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":null,"goodsInfo":null,"orderGoods":null,"orderType":0,"distributionType":"Delivery","price":"0.0"},{"id":"f1ca376c359748d78297a59ec64ba604","isNewRecord":false,"remarks":"","createDate":"2017-09-04 22:11:51","updateDate":"2017-09-04 22:21:48","orderNo":"2017090413240001","customerName":null,"customerTel":"1234567890","customerAddr":"APT4楼405,金海湾人民大街店","apt":"4楼405","orderPrice":0,"createName":"商家7的店","hotelUser":"sj7","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-09-04 22:15:00","deliveryDate":"2017-09-04 22:21:35","finishDate":"2017-09-04 22:21:48","cancelDate":null,"pushDate":"2017-09-04 22:15:00","status":3,"isTimeout":0,"pushCount":3,"finishedTime":"20mins","remark":"","dispatch":"1","customerLongitude":"0.000000","customerLatitude":"0.000000","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":null,"goodsInfo":null,"orderGoods":null,"orderType":0,"distributionType":"Delivery","price":"0.0"},{"id":"055c327f84b0496785f4e4012d00d071","isNewRecord":false,"remarks":"","createDate":"2017-09-04 22:16:51","updateDate":"2017-09-04 22:21:41","orderNo":"2017090413240001","customerName":null,"customerTel":"1234567890","customerAddr":"APT4楼405,金海湾人民大街店","apt":"4楼405","orderPrice":0,"createName":"商家7的店","hotelUser":"sj7","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-09-04 22:21:00","deliveryDate":"2017-09-04 22:21:38","finishDate":"2017-09-04 22:21:41","cancelDate":null,"pushDate":"2017-09-04 22:21:00","status":3,"isTimeout":0,"pushCount":3,"finishedTime":"20mins","remark":"","dispatch":"1","customerLongitude":"0.000000","customerLatitude":"0.000000","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":null,"goodsInfo":null,"orderGoods":null,"orderType":0,"distributionType":"Delivery","price":"0.0"},{"id":"8bbabc2056ed428f817e46aca18ac715","isNewRecord":false,"remarks":"","createDate":"2017-09-03 22:50:14","updateDate":"2017-09-04 02:29:42","orderNo":"2017090313240001","customerName":"官健","customerTel":"5149843566","customerAddr":"5902 Rue Hamilton, Montreal, QC, Canada","apt":null,"orderPrice":53.51,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":"2017-09-04 02:29:42","pushDate":"2017-09-04 02:28:08","status":4,"isTimeout":0,"pushCount":1,"finishedTime":"20min","remark":null,"dispatch":"0","customerLongitude":"-73.598366","customerLatitude":"45.45933220000001","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"123","goodsInfo":"锅包肉,1,32.00;麦当劳,1,54.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"53.51"},{"id":"4df52043b829400dbf9055237fbdbf71","isNewRecord":false,"remarks":"","createDate":"2017-09-03 22:56:57","updateDate":"2017-09-04 02:27:27","orderNo":"2017090313240001","customerName":"官健","customerTel":"5149843566","customerAddr":"5902 Rue Hamilton, Montreal, QC, Canada","apt":null,"orderPrice":53.51,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":4,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"-73.598366","customerLatitude":"45.45933220000001","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"124","goodsInfo":"锅包肉,1,32.00;麦当劳,1,54.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"53.51"},{"id":"4f82f3cd6fa44e28beb2daccb75c5b51","isNewRecord":false,"remarks":"","createDate":"2017-09-04 22:08:33","updateDate":"2017-09-04 22:08:33","orderNo":"2017090413240001","customerName":"买家","customerTel":"13241234","customerAddr":"拉丁区, 蒙特利尔, 魁北克省, 加拿大","apt":null,"orderPrice":59.74,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":6,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"-73.56390599999997","customerLatitude":"45.51550779999999","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"130","goodsInfo":"锅包肉,3,32.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"59.74"},{"id":"1f94e84d70fe49878ce7dd6785460c6b","isNewRecord":false,"remarks":"","createDate":"2017-09-03 22:32:38","updateDate":"2017-09-03 22:32:38","orderNo":"2017090313240001","customerName":"刘楠","customerTel":"13069049021","customerAddr":"中国吉林省长春市二道区","apt":null,"orderPrice":65522.4,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":6,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"125.37421700000004","customerLatitude":"43.865595","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"122","goodsInfo":"锅包肉,2,32.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"65522.4"},{"id":"9eb4288759974f2abb3f2d8441ebb20a","isNewRecord":false,"remarks":"","createDate":"2017-09-03 22:31:54","updateDate":"2017-09-03 22:31:54","orderNo":"2017090313240001","customerName":"刘楠","customerTel":"13069049021","customerAddr":"中国吉林省长春市二道区","apt":null,"orderPrice":65522.4,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":6,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"125.37421700000004","customerLatitude":"43.865595","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"121","goodsInfo":"锅包肉,2,32.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"65522.4"},{"id":"7dfce6dd62a84042b187a39998f46e6d","isNewRecord":false,"remarks":"两瓶水，请准时送达","createDate":"2017-09-03 22:22:31","updateDate":"2017-09-03 22:22:31","orderNo":"2017090313240001","customerName":"刘楠","customerTel":"13069049021","customerAddr":"中国吉林省长春市二道区","apt":null,"orderPrice":65516.17,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":6,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"125.37421700000004","customerLatitude":"43.865595","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"120","goodsInfo":"麦当劳,1,54.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"65516.17"}],"html":"<div class=\"fixed-table-pagination\" style=\"display: block;\"><div class=\"pull-left pagination-detail\"><span class=\"pagination-info\">显示第 1 到第 10 条记录，总共 12 条记录<\/span><span class=\"page-list\">每页显示 <span class=\"btn-group dropup\"><button type=\"button\" class=\"btn btn-default  btn-outline dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\"><span class=\"page-size\">10<\/span> <span class=\"caret\"><\/span><\/button><ul class=\"dropdown-menu\" role=\"menu\"><li class=\"active\"><a href=\"javascript:page(1,10,'');\">10<\/a><\/li><li class=\"\"><a href=\"javascript:page(1,25,'');\">25<\/a><\/li><li class=\"\"><a href=\"javascript:page(1,50,'');\">50<\/a><\/li><li class=\"\"><a href=\"javascript:page(1,100,'');\">100<\/a><\/li><\/ul><\/span> 条记录<\/span><\/div><div class=\"pull-right pagination-roll\"><ul class=\"pagination pagination-outline\"><li class=\"paginate_button previous disabled\"><a href=\"javascript:\"><i class=\"fa fa-angle-double-left\"><\/i><\/a><\/li>\n<li class=\"paginate_button previous disabled\"><a href=\"javascript:\"><i class=\"fa fa-angle-left\"><\/i><\/a><\/li>\n<li class=\"paginate_button active\"><a href=\"javascript:\">1<\/a><\/li>\n<li class=\"paginate_button \"><a href=\"javascript:\" onclick=\"page(2,10,'');\">2<\/a><\/li>\n<li class=\"paginate_button next\"><a href=\"javascript:\" onclick=\"page(2,10,'');\"><i class=\"fa fa-angle-right\"><\/i><\/a><\/li>\n<li class=\"paginate_button next\"><a href=\"javascript:\" onclick=\"page(2,10,'');\"><i class=\"fa fa-angle-double-right\"><\/i><\/a><\/li>\n<\/ul><\/div><\/div>","maxResults":10,"firstResult":0}
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
             * pageSize : 10
             * count : 12
             * list : [{"id":"34fc42e64df8449fb47cd109fd43b9e3","isNewRecord":false,"remarks":"","createDate":"2017-09-05 21:21:12","updateDate":"2017-09-05 21:25:00","orderNo":"2017090513240001","customerName":null,"customerTel":"1234567890","customerAddr":"APT4楼405,金海湾人民大街店","apt":"4楼405","orderPrice":0,"createName":"商家7的店","hotelUser":"sj7","courierName":"Sam","actionName":null,"courierLogin":"Sam","courierTel":"34","acceptDate":"2017-09-05 21:25:00","deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":"2017-09-05 21:25:00","status":1,"isTimeout":0,"pushCount":3,"finishedTime":"0","remark":"","dispatch":"1","customerLongitude":"0.000000","customerLatitude":"0.000000","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":null,"goodsInfo":null,"orderGoods":null,"orderType":0,"distributionType":"Delivery","price":"0.0"},{"id":"3c88a888b71a49d3969ec791cc669baf","isNewRecord":false,"remarks":"","createDate":"2017-09-04 22:25:14","updateDate":"2017-09-04 22:29:00","orderNo":"2017090413240001","customerName":null,"customerTel":"1234567890","customerAddr":"APT4楼405,金海湾人民大街店","apt":"4楼405","orderPrice":0,"createName":"商家7的店","hotelUser":"sj7","courierName":"Sam","actionName":null,"courierLogin":"Sam","courierTel":"34","acceptDate":"2017-09-04 22:29:00","deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":"2017-09-04 22:29:00","status":1,"isTimeout":0,"pushCount":3,"finishedTime":"0","remark":"","dispatch":"1","customerLongitude":"0.000000","customerLatitude":"0.000000","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":null,"goodsInfo":null,"orderGoods":null,"orderType":0,"distributionType":"Delivery","price":"0.0"},{"id":"f1ca376c359748d78297a59ec64ba604","isNewRecord":false,"remarks":"","createDate":"2017-09-04 22:11:51","updateDate":"2017-09-04 22:21:48","orderNo":"2017090413240001","customerName":null,"customerTel":"1234567890","customerAddr":"APT4楼405,金海湾人民大街店","apt":"4楼405","orderPrice":0,"createName":"商家7的店","hotelUser":"sj7","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-09-04 22:15:00","deliveryDate":"2017-09-04 22:21:35","finishDate":"2017-09-04 22:21:48","cancelDate":null,"pushDate":"2017-09-04 22:15:00","status":3,"isTimeout":0,"pushCount":3,"finishedTime":"20mins","remark":"","dispatch":"1","customerLongitude":"0.000000","customerLatitude":"0.000000","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":null,"goodsInfo":null,"orderGoods":null,"orderType":0,"distributionType":"Delivery","price":"0.0"},{"id":"055c327f84b0496785f4e4012d00d071","isNewRecord":false,"remarks":"","createDate":"2017-09-04 22:16:51","updateDate":"2017-09-04 22:21:41","orderNo":"2017090413240001","customerName":null,"customerTel":"1234567890","customerAddr":"APT4楼405,金海湾人民大街店","apt":"4楼405","orderPrice":0,"createName":"商家7的店","hotelUser":"sj7","courierName":"Sam","actionName":"Sam","courierLogin":"Sam","courierTel":"34","acceptDate":"2017-09-04 22:21:00","deliveryDate":"2017-09-04 22:21:38","finishDate":"2017-09-04 22:21:41","cancelDate":null,"pushDate":"2017-09-04 22:21:00","status":3,"isTimeout":0,"pushCount":3,"finishedTime":"20mins","remark":"","dispatch":"1","customerLongitude":"0.000000","customerLatitude":"0.000000","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":null,"goodsInfo":null,"orderGoods":null,"orderType":0,"distributionType":"Delivery","price":"0.0"},{"id":"8bbabc2056ed428f817e46aca18ac715","isNewRecord":false,"remarks":"","createDate":"2017-09-03 22:50:14","updateDate":"2017-09-04 02:29:42","orderNo":"2017090313240001","customerName":"官健","customerTel":"5149843566","customerAddr":"5902 Rue Hamilton, Montreal, QC, Canada","apt":null,"orderPrice":53.51,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":"2017-09-04 02:29:42","pushDate":"2017-09-04 02:28:08","status":4,"isTimeout":0,"pushCount":1,"finishedTime":"20min","remark":null,"dispatch":"0","customerLongitude":"-73.598366","customerLatitude":"45.45933220000001","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"123","goodsInfo":"锅包肉,1,32.00;麦当劳,1,54.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"53.51"},{"id":"4df52043b829400dbf9055237fbdbf71","isNewRecord":false,"remarks":"","createDate":"2017-09-03 22:56:57","updateDate":"2017-09-04 02:27:27","orderNo":"2017090313240001","customerName":"官健","customerTel":"5149843566","customerAddr":"5902 Rue Hamilton, Montreal, QC, Canada","apt":null,"orderPrice":53.51,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":4,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"-73.598366","customerLatitude":"45.45933220000001","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"124","goodsInfo":"锅包肉,1,32.00;麦当劳,1,54.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"53.51"},{"id":"4f82f3cd6fa44e28beb2daccb75c5b51","isNewRecord":false,"remarks":"","createDate":"2017-09-04 22:08:33","updateDate":"2017-09-04 22:08:33","orderNo":"2017090413240001","customerName":"买家","customerTel":"13241234","customerAddr":"拉丁区, 蒙特利尔, 魁北克省, 加拿大","apt":null,"orderPrice":59.74,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":6,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"-73.56390599999997","customerLatitude":"45.51550779999999","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"130","goodsInfo":"锅包肉,3,32.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"59.74"},{"id":"1f94e84d70fe49878ce7dd6785460c6b","isNewRecord":false,"remarks":"","createDate":"2017-09-03 22:32:38","updateDate":"2017-09-03 22:32:38","orderNo":"2017090313240001","customerName":"刘楠","customerTel":"13069049021","customerAddr":"中国吉林省长春市二道区","apt":null,"orderPrice":65522.4,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":6,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"125.37421700000004","customerLatitude":"43.865595","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"122","goodsInfo":"锅包肉,2,32.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"65522.4"},{"id":"9eb4288759974f2abb3f2d8441ebb20a","isNewRecord":false,"remarks":"","createDate":"2017-09-03 22:31:54","updateDate":"2017-09-03 22:31:54","orderNo":"2017090313240001","customerName":"刘楠","customerTel":"13069049021","customerAddr":"中国吉林省长春市二道区","apt":null,"orderPrice":65522.4,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":6,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"125.37421700000004","customerLatitude":"43.865595","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"121","goodsInfo":"锅包肉,2,32.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"65522.4"},{"id":"7dfce6dd62a84042b187a39998f46e6d","isNewRecord":false,"remarks":"两瓶水，请准时送达","createDate":"2017-09-03 22:22:31","updateDate":"2017-09-03 22:22:31","orderNo":"2017090313240001","customerName":"刘楠","customerTel":"13069049021","customerAddr":"中国吉林省长春市二道区","apt":null,"orderPrice":65516.17,"createName":"商家7的店","hotelUser":"sj7","courierName":null,"actionName":null,"courierLogin":null,"courierTel":null,"acceptDate":null,"deliveryDate":null,"finishDate":null,"cancelDate":null,"pushDate":null,"status":6,"isTimeout":0,"pushCount":0,"finishedTime":null,"remark":null,"dispatch":null,"customerLongitude":"125.37421700000004","customerLatitude":"43.865595","hotelLongitude":"-73.56725599999999","hotelLatitude":"45.5016889","hotelAddr":"蒙特利尔, 魁北克省, 加拿大","isHasCourierLogin":null,"validTime":null,"hotelTel":"1441231234","date":null,"count":null,"remarkList":null,"pushFrequency":null,"orderId":"120","goodsInfo":"麦当劳,1,54.00;","orderGoods":null,"orderType":1,"distributionType":"Delivery","price":"65516.17"}]
             * html : <div class="fixed-table-pagination" style="display: block;"><div class="pull-left pagination-detail"><span class="pagination-info">显示第 1 到第 10 条记录，总共 12 条记录</span><span class="page-list">每页显示 <span class="btn-group dropup"><button type="button" class="btn btn-default  btn-outline dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="page-size">10</span> <span class="caret"></span></button><ul class="dropdown-menu" role="menu"><li class="active"><a href="javascript:page(1,10,'');">10</a></li><li class=""><a href="javascript:page(1,25,'');">25</a></li><li class=""><a href="javascript:page(1,50,'');">50</a></li><li class=""><a href="javascript:page(1,100,'');">100</a></li></ul></span> 条记录</span></div><div class="pull-right pagination-roll"><ul class="pagination pagination-outline"><li class="paginate_button previous disabled"><a href="javascript:"><i class="fa fa-angle-double-left"></i></a></li>
             <li class="paginate_button previous disabled"><a href="javascript:"><i class="fa fa-angle-left"></i></a></li>
             <li class="paginate_button active"><a href="javascript:">1</a></li>
             <li class="paginate_button "><a href="javascript:" onclick="page(2,10,'');">2</a></li>
             <li class="paginate_button next"><a href="javascript:" onclick="page(2,10,'');"><i class="fa fa-angle-right"></i></a></li>
             <li class="paginate_button next"><a href="javascript:" onclick="page(2,10,'');"><i class="fa fa-angle-double-right"></i></a></li>
             </ul></div></div>
             * maxResults : 10
             * firstResult : 0
             */

            private int pageNo;
            private int pageSize;
            private int count;
            private String html;
            private int maxResults;
            private int firstResult;
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

            public int getMaxResults()
            {
                return maxResults;
            }

            public void setMaxResults(int maxResults)
            {
                this.maxResults = maxResults;
            }

            public int getFirstResult()
            {
                return firstResult;
            }

            public void setFirstResult(int firstResult)
            {
                this.firstResult = firstResult;
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
                 * id : 34fc42e64df8449fb47cd109fd43b9e3
                 * isNewRecord : false
                 * remarks :
                 * createDate : 2017-09-05 21:21:12
                 * updateDate : 2017-09-05 21:25:00
                 * orderNo : 2017090513240001
                 * customerName : null
                 * customerTel : 1234567890
                 * customerAddr : APT4楼405,金海湾人民大街店
                 * apt : 4楼405
                 * orderPrice : 0
                 * createName : 商家7的店
                 * hotelUser : sj7
                 * courierName : Sam
                 * actionName : null
                 * courierLogin : Sam
                 * courierTel : 34
                 * acceptDate : 2017-09-05 21:25:00
                 * deliveryDate : null
                 * finishDate : null
                 * cancelDate : null
                 * pushDate : 2017-09-05 21:25:00
                 * status : 1
                 * isTimeout : 0
                 * pushCount : 3
                 * finishedTime : 0
                 * remark :
                 * dispatch : 1
                 * customerLongitude : 0.000000
                 * customerLatitude : 0.000000
                 * hotelLongitude : -73.56725599999999
                 * hotelLatitude : 45.5016889
                 * hotelAddr : 蒙特利尔, 魁北克省, 加拿大
                 * isHasCourierLogin : null
                 * validTime : null
                 * hotelTel : 1441231234
                 * date : null
                 * count : null
                 * remarkList : null
                 * pushFrequency : null
                 * orderId : null
                 * goodsInfo : null
                 * orderGoods : null
                 * orderType : 0
                 * distributionType : Delivery
                 * price : 0.0
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private String createDate;
                private String updateDate;
                private String orderNo;
                private String customerName;
                private String customerTel;
                private String customerAddr;
                private String apt;
                private Object orderPrice;
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
                private Object orderId;
                private Object goodsInfo;
                private Object orderGoods;
                private int orderType;
                private String distributionType;
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

                public String getCustomerName()
                {
                    return customerName;
                }

                public void setCustomerName(String customerName)
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

                public Object getOrderPrice()
                {
                    return orderPrice;
                }

                public void setOrderPrice(Object orderPrice)
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

                public Object getOrderId()
                {
                    return orderId;
                }

                public void setOrderId(Object orderId)
                {
                    this.orderId = orderId;
                }

                public Object getGoodsInfo()
                {
                    return goodsInfo;
                }

                public void setGoodsInfo(Object goodsInfo)
                {
                    this.goodsInfo = goodsInfo;
                }

                public Object getOrderGoods()
                {
                    return orderGoods;
                }

                public void setOrderGoods(Object orderGoods)
                {
                    this.orderGoods = orderGoods;
                }

                public int getOrderType()
                {
                    return orderType;
                }

                public void setOrderType(int orderType)
                {
                    this.orderType = orderType;
                }

                public String getDistributionType()
                {
                    return distributionType;
                }

                public void setDistributionType(String distributionType)
                {
                    this.distributionType = distributionType;
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
