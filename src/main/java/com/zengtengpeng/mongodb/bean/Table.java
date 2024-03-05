package com.zengtengpeng.mongodb.bean;

import com.zengtengpeng.mongodb.enums.ColumnType;
import lombok.Data;

import java.util.List;

@Data
public class Table {

    /**
     * 集合名称 分隔用的是_
    */
    private String collectionName;

    /**
     * 业务的名称(集合名称转成驼峰),首字母是小写的
    */
    private String businessName;

    private List<Column> columnList;
    @Data
    public static class Column{

        /**
         * 列名称
        */
        private String name;

        /**
         * 类型
        */
        private ColumnType type;

        /**
         * 注释
        */
        private String remark;
    }
}
