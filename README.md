# auto-code-mongodb

#### 介绍
目前市面上的代码生成器都是关系型数据库的.没有mongodb非关系型数据库的代码生成工具.
这个项目提供了基于json的形式生成代码的增删改差,减少自己书写CURD的工作量.
开箱即用.无任何代码入侵

#### 软件架构
maven
spring boot
spring mongodb


#### 使用说明

1.  本项目已经上传中央仓库直接引入依赖即可
```
<dependency>
            <groupId>com.zengtengpeng</groupId>
            <artifactId>auto-code-mongodb</artifactId>
            <version>1.0.0</version>
        </dependency>
```
2.  写一个main 方法生成代码
```
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
        generate.setRemark("用户表");
        //作者
        generate.setAuthor("ztp");
        //父包
        generate.setParentPackage("com.maishi");
        //子包
        generate.setModulePackage("test");
        Generate.FilePath filePath = generate.getFilePath();
        // mongodb的子模块,如果没有可不填写
        //filePath.setMongodbModule("iot-socket-mongodb");
        // 公共模块,如果没有可不填写
        //filePath.setCommonModule("iot-common");
        // 业务模块,如果没有可不填写
//        filePath.setBusinessModule("iot-bg-api");
        //根路径
        filePath.setBasePath(System.getProperty("user.dir")+"/demo");

        autoCode.exec(generate);
    }
}

```


3. 生成完毕

```
bean地址: D:\resource\workspace\auto-code-mongodb/demo/src/main/java/com/maishi/test/bean/SysUser.java
Service地址: D:\resource\workspace\auto-code-mongodb/demo/src/main/java/com/maishi/test/service/SysUserService.java
ServiceImpl地址: D:\resource\workspace\auto-code-mongodb/demo/src/main/java/com/maishi/test/service/impl/SysUserServiceImpl.java
controller地址: D:\resource\workspace\auto-code-mongodb/demo/src/main/java/com/maishi/test/controller/SysUserController.java
```


4. 当然你也可以自定义模板,在 resources/mongodb 创建对应的模板. 具体模板参考代码中的模板. 使用的是 freemarker 引擎
