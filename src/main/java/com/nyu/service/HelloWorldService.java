package com.nyu.service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

// <name>Archetype - nyu-software</name>
//  <url>http://maven.apache.org</url>

@RestController
@EnableAutoConfiguration
@ComponentScan("com.nyu.service")
//加注解 就表示所有都返回json格式的
//是springmvc提供的，而不是springboot提供的

public class HelloWorldService {


    @RequestMapping("/getUser")
    public String getUser(){
        return "nyuclasses";
    }
    //controller 控制层注解

    public static void main(String[] args){
        SpringApplication.run(HelloWorldService.class, args);


    }
}
