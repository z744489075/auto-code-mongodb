package com.zengtengpeng;

import com.zengtengpeng.mongodb.bean.Generate;
import com.zengtengpeng.mongodb.core.AutoCode;

public class Test {

    public static void main(String[] args) {
        AutoCode autoCode=new AutoCode();
        Generate generate = new Generate();
        //需要生成代码的json
        generate.setJsonString("""
                {
                "money":56.1,
                "name":"张三",
                "date":"2024-01-01",
                "datetime":"2024-01-01 23:23:23",
                "age":5,
                "object":{
                    "ddd":123
                },
                "arrays":[
                    {
                    "names":"123"
                    }
                ]
                }
                """);
        //集合名称
        generate.setCollectionName("sys_user");
        //作者
        generate.setAuthor("ztp");
        //父包
        generate.setParentPackage("com.maishi");
        //子包
        generate.setModulePackage("test");
        Generate.FilePath filePath = generate.getFilePath();
        //mongodb的子模块,如果没有可不填写
        filePath.setMongodbModule("iot-socket-mongodb");
        //公共模块,如果没有可不填写
        filePath.setCommonModule("iot-common");
        //根路径
        filePath.setBasePath(System.getProperty("user.dir")+"/demo/src/main/java");

        autoCode.exec(generate);
    }
}
