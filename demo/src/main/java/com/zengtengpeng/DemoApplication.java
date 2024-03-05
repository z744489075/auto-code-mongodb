package com.zengtengpeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);
        String property = System.getProperty("user.dir");
        Properties properties = System.getProperties();
        properties.forEach((k,v)->{

            System.out.println(k+"="+v);
        });
    }

}
