package com.zengtengpeng.mongodb.bean;

import lombok.Data;


/**
 * 公共接收参数头
 *
 * @author ztp
 * @return
 * @date 2020/10/28 18:20
 */
@Data
public class Req<T> {
    /**
     * iOS 1, Android 2, Windows 3, OSX 4, WEB 5, 小程序 6，linux 7
     *
     * @author ztp
     * @return
     * @date 2020/10/28 19:01
     */
    private String platform;

    /**
     * 版本号
     *
     * @author ztp
     * @return
     * @date 2020/10/28 19:01
     */
    private String version;

    /**
     * 页码
     *
     * @author ztp
     * @return
     * @date 2020/10/28 19:01
     */
    private Integer page = 1;

    /**
     * 页大小
     *
     * @author ztp
     * @return
     * @date 2020/10/28 19:01
     */
    private Integer pageSize = 20;


    private T data;

    public static <T> Req<T> getReq(T data) {
        Req<T> reqDO = new Req<>();
        reqDO.setPlatform("service");
        reqDO.setVersion("1.0");
        reqDO.setData(data);
        return reqDO;
    }

    public static <T> Req<T> setAll(Req<?> oldReq, T data) {
        Req<T> reqDO = new Req<>();
        reqDO.setPlatform(oldReq.getPlatform());
        reqDO.setVersion(oldReq.getVersion());
        reqDO.setData(data);
        return reqDO;
    }

    public static <T> Req<T> setAll(String service, String version, T data) {
        Req<T> reqDO = new Req<>();
        reqDO.setPlatform(service);
        reqDO.setVersion(version);
        reqDO.setData(data);
        return reqDO;
    }


    public Req<T> initPage(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;

        return this;
    }
}
