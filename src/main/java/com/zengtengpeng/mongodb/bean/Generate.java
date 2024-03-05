package com.zengtengpeng.mongodb.bean;

import lombok.Data;

import java.util.List;

/**
 *  自动生成的bean
*/
@Data
public class Generate {

    /**
     * 需要生成代码的json
    */
    private String jsonString;

    /**
     * 集合的名称.多个单词请用_分隔
    */
    private String collectionName;
    /**
     *  作者
     *
     */
    private String author;


    /**
     *  需要生成的父包
     *
     * @author ztp
     * @param null
     * @return
     * @date 2022/1/4 8:36
     */
    private String parentPackage;

    /**
     *  需要生成的子包
     *
     * @author ztp
     * @param null
     * @return
     * @date 2022/1/4 8:36
     */
    private String modulePackage;



    /**
     * 文件输出路径
    */
    private FilePath filePath;
    /**
     * 路径
     */
    @Data
    public static class FilePath{

        /**
         *  根路径
         */
        private String basePath=System.getProperty("user.dir");

        /**
         * mongodb 对应的子model,没有不用填写
         */
        private String mongodbModule;


        /**
         *  设置公共模块的包名,没有不用填写
         *
         * @author ztp
         * @param null
         * @return
         * @date 2022/1/4 8:41
         */
        private String commonModule;
        /**
         *  业务层模型,没有不用填写
         *
         * @author ztp
         * @param null
         * @return
         * @date 2022/1/4 10:57
         */
        private String businessModule;


        /**
         *  bean的包,(如果不填写则在对应的子目录下)
         *
         * @author ztp
         * @param null
         * @return
         * @date 2022/1/4 8:50
         */
        private String beanPackage;
        /**
         *  feign的包(如果不填写则在对应的子目录下)
         *
         * @author ztp
         * @param null
         * @return
         * @date 2022/1/4 8:50
         */
        private String feignPackage;
    }


    /**
     * 内部使用,勿定义
    */
    private Table table;

}
