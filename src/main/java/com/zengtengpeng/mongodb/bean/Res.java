package com.zengtengpeng.mongodb.bean;

import com.zengtengpeng.mongodb.enums.RCode;
import lombok.Data;


/**
 *  公共接收参数头
 *
 * @author ztp
 * @return
 * @date 2020/10/28 18:20
 */
@Data
public class Res<T> {

    private String msg;

    // 0代表成功
    private Integer code=0;


    /**
     *  总页数
     * @author ztp
     * @return
     * @date 2020/10/30 9:59
     */
    private Integer total;

    private T data;


    public Res(Integer code, Throwable e) {
        this.code = code;
        this.msg = e.getMessage();
    }

    public Res() {

    }

    public static Res<String> error() {
        Res<String> platformRes=new Res<>();
        platformRes.setCode(RCode.FAIL.code());
        platformRes.setMsg(RCode.FAIL.desc());
        return platformRes;
    }

    public static Res<String> error(RCode codeMsgType) {
        Res<String> platformRes=new Res<>();
        platformRes.setCode(codeMsgType.code());
        platformRes.setMsg(codeMsgType.desc());
        return platformRes;
    }

    public static  <T> Res<T> error(Integer code, String desc) {
        Res<T> platformRes=new Res<>();
        platformRes.setCode(code);
        platformRes.setMsg(desc);
        return platformRes;
    }
    public static <T> Res<T> error(Integer code, String desc, T t) {
        Res<T> platformRes=new Res<>();
        platformRes.setCode(code);
        platformRes.setMsg(desc);
        platformRes.setData(t);
        return platformRes;
    }
    public static <T> Res<T> error(RCode codeMsgType, T t) {
        Res<T> platformRes=new Res<>();
        platformRes.setCode(codeMsgType.code());
        platformRes.setMsg(codeMsgType.desc());
        platformRes.setData(t);
        return platformRes;
    }

    public static <T> Res<T> success(T t) {
        Res<T> platformRes=new Res<>();
        platformRes.setCode(RCode.SUCCESS.code());
        platformRes.setMsg(RCode.SUCCESS.desc());
        platformRes.setData(t);
        return platformRes;
    }

    public static <T> Res<T> success() {
        return success(null);
    }

    public static <T> Res<T> success(String msg, T t) {
        Res<T> platformRes=new Res<>();
        platformRes.setCode(RCode.SUCCESS.code());
        platformRes.setMsg(msg);
        platformRes.setData(t);
        return platformRes;
    }
    public static <T> Res<T> asyn(String msg) {
        Res<T> platformRes=new Res<>();
        platformRes.setCode(-1);
        platformRes.setMsg(msg);
        platformRes.setData(null);
        return platformRes;
    }

    public static <T> Res<T> error(String msg) {
        Res<T> platformRes=new Res<>();
        platformRes.setCode(RCode.FAIL.code());
        platformRes.setMsg(msg);
        return platformRes;
    }




    public Boolean getSuccess() {
        return this.code==0;
    }


}
