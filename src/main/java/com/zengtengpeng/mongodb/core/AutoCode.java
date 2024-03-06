package com.zengtengpeng.mongodb.core;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.zengtengpeng.mongodb.bean.Generate;
import com.zengtengpeng.mongodb.bean.Table;
import com.zengtengpeng.mongodb.enums.ColumnType;
import com.zengtengpeng.mongodb.utils.MyStringUtils;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.SneakyThrows;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AutoCode {

    //1.创建配置类
    static Configuration configuration=new Configuration(Configuration.getVersion());
    static {

        //2.设置模板所在的目录
        try {
            FileTemplateLoader templates = new FileTemplateLoader(new File(AutoCode.class.getClassLoader().getResource("mongodb").getPath()));
            configuration.setTemplateLoader(templates);
        } catch (Exception e) {
            System.out.println(e);
        }
        //3.设置字符集
        configuration.setDefaultEncoding("utf-8");
    }


    public static void exec(Generate generate){
        String jsonString = generate.getJsonString();
        generate.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        JSONObject jsonObject = JSON.parseObject(jsonString);
        Table table=new Table();
        table.setCollectionName(generate.getCollectionName());
        table.setBusinessName(MyStringUtils.upperCase(generate.getCollectionName(),false));
        List<Table.Column> columnList=new ArrayList<>();
        table.setColumnList(columnList);
        jsonObject.forEach((k,v)->{
            Table.Column column=new Table.Column();
            column.setName(MyStringUtils.firstLowerCase(k));

            if(v instanceof JSONObject){

                column.setType(ColumnType.object);
            } else if(v instanceof JSONArray){

                column.setType(ColumnType.array);
            }else if (v instanceof Double || v instanceof Float|| v instanceof BigDecimal){
                column.setType(ColumnType.bigDecimal);
            }else if (v instanceof Integer || v instanceof Long){
                column.setType(ColumnType.number);
            }else {
                column.setType(ColumnType.text);
                try {
                    LocalDate.parse(v.toString());
                    column.setType(ColumnType.date);
                } catch (Exception e) {
                    //格式化异常不处理,证明他不是date
                }

                try {
                    LocalDateTime.parse(v.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    column.setType(ColumnType.datetime);
                } catch (Exception e) {
                    //格式化异常不处理,证明他不是datetime
                }

            }
            column.setRemark(v.toString());
            columnList.add(column);
        });
        generate.setTable(table);
        Generate.FilePath filePath = generate.getFilePath();

        //bean
        bean(generate);

        //feign
        String mongodbModule = filePath.getMongodbModule();
        if(mongodbModule!=null && !mongodbModule.isEmpty()){
            //如果mongodb的模块名都没有则意味着这个不是一个模块化的工程
            feign(generate);
        }

        //service
        service(generate);

        //serviceImpl
        serviceImpl(generate);

        //controller
        controller(generate);
    }

    /**
     * 生成 controller
     */
    @SneakyThrows
    public static void controller(Generate generate){
        Template template = configuration.getTemplate("controller.ftl");
        //6.创建Writer对象                   生成的静态资源的地址
        Generate.FilePath filePath = generate.getFilePath();
        Table table = generate.getTable();
        String upperName = MyStringUtils.firstUpperCase(table.getBusinessName());
        String path = filePath.getBasePath();


        path+="/"+(generate.getParentPackage()+"."+generate.getModulePackage()+".controller").replace(".","/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        path+="/"+upperName+"Controller.java";
        if(!generate.getCover()){
            file=new File(path);
            if(file.exists()){
                System.out.println("文件已经存在,不允许覆盖 path= "+path);
                return;
            }
        }
        Writer out =new FileWriter(path);
        template.process(generate,out);
        System.out.println("controller地址: "+path);
        out.close();

    }


    /**
     * 生成serviceImpl
     */
    @SneakyThrows
    public static void serviceImpl(Generate generate){
        Template template = configuration.getTemplate("serviceImpl.ftl");
        //6.创建Writer对象                   生成的静态资源的地址
        Generate.FilePath filePath = generate.getFilePath();
        Table table = generate.getTable();
        String upperName = MyStringUtils.firstUpperCase(table.getBusinessName());
        String path = filePath.getBasePath();


        path+="/"+(generate.getParentPackage()+"."+generate.getModulePackage()+".service.impl").replace(".","/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        path+="/"+upperName+"ServiceImpl.java";
        if(!generate.getCover()){
            file=new File(path);
            if(file.exists()){
                System.out.println("文件已经存在,不允许覆盖 path= "+path);
                return;
            }
        }
        Writer out =new FileWriter(path);
        template.process(generate,out);
        System.out.println("ServiceImpl地址: "+path);
        out.close();

    }

    /**
     * 生成service
     */
    @SneakyThrows
    public static void service(Generate generate){
        Template template = configuration.getTemplate("service.ftl");
        //6.创建Writer对象                   生成的静态资源的地址
        Generate.FilePath filePath = generate.getFilePath();
        Table table = generate.getTable();
        String upperName = MyStringUtils.firstUpperCase(table.getBusinessName());
        String path = filePath.getBasePath();


        path+="/"+(generate.getParentPackage()+"."+generate.getModulePackage()+".service").replace(".","/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        path+="/"+upperName+"Service.java";
        if(!generate.getCover()){
            file=new File(path);
            if(file.exists()){
                System.out.println("文件已经存在,不允许覆盖 path= "+path);
                return;
            }
        }
        Writer out =new FileWriter(path);
        template.process(generate,out);
        System.out.println("Service地址: "+path);
        out.close();

    }


    /**
     * 生成bean
     */
    @SneakyThrows
    public static void feign(Generate generate){
        Template template = configuration.getTemplate("feign.ftl");
        //6.创建Writer对象                   生成的静态资源的地址
        Generate.FilePath filePath = generate.getFilePath();
        Table table = generate.getTable();
        String upperName = MyStringUtils.firstUpperCase(table.getBusinessName());
        String path = filePath.getBasePath();
        if(filePath.getCommonModule()!=null){
            path+="/"+filePath.getCommonModule();
        }
        if(filePath.getFeignPackage()==null){
            filePath.setFeignPackage(generate.getParentPackage()+"."+generate.getModulePackage()+".feign");
        }

        path+="/"+filePath.getFeignPackage().replace(".","/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        path+="/"+upperName+"Feign.java";
        if(!generate.getCover()){
            file=new File(path);
            if(file.exists()){
                System.out.println("文件已经存在,不允许覆盖 path= "+path);
                return;
            }
        }
        Writer out =new FileWriter(path);
        template.process(generate,out);
        System.out.println("Feign地址: "+path);
        out.close();

    }

    /**
     * 生成bean
    */
    @SneakyThrows
    public static void bean(Generate generate){
        Template template = configuration.getTemplate("bean.ftl");
        //6.创建Writer对象                   生成的静态资源的地址
        Generate.FilePath filePath = generate.getFilePath();
        Table table = generate.getTable();
        String upperName = MyStringUtils.firstUpperCase(table.getBusinessName());
        String path = filePath.getBasePath();
        if(filePath.getCommonModule()!=null){
            path+="/"+filePath.getCommonModule();
        }
        if(filePath.getBeanPackage()==null){
            filePath.setBeanPackage(generate.getParentPackage()+"."+generate.getModulePackage()+".bean");
        }

        path+="/"+filePath.getBeanPackage().replace(".","/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        path+="/"+upperName+".java";
        if(!generate.getCover()){
            file=new File(path);
            if(file.exists()){
                System.out.println("文件已经存在,不允许覆盖 path= "+path);
                return;
            }
        }
        Writer out =new FileWriter(path);
        template.process(generate,out);
        System.out.println("bean地址: "+path);
        out.close();

    }
}
