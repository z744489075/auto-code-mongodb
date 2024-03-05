package com.zengtengpeng;

import com.zengtengpeng.mongodb.bean.Generate;
import com.zengtengpeng.mongodb.core.AutoCode;

public class Test {

    public static void main(String[] args) {
        AutoCode autoCode=new AutoCode();
        Generate generate = new Generate();
        generate.setJsonString("""
                {
                "id":1,
                "name":"张三",
                "date":"2024-01-01",
                "datetime":"2024-01-01 23:23:23",
                "age":5,
                "money":56.1
                }
                """);
        generate.setCollectionName("sys_user");
        generate.setAuthor("ztp");
        generate.setParentPackage("com.maishi");
        generate.setModulePackage("test");

        autoCode.exec(generate);
    }
}
