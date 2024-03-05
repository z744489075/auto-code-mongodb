package com.zengtengpeng.mongodb.bean;

import lombok.Data;

import java.util.List;

/**
 *
 *
 * @author ztp
 * @return
 * @date 2022/3/7 18:50
 */
@Data
public class MongoPage<T> {

    /**
     * 查询数据列表
     */
    private List<T> records;

    /**
     * 总数
     */
    private long total;


    public static Integer getSkip(Integer page,Integer pageSize) {
        return Math.max((page - 1) * pageSize, 0);
    }
}
