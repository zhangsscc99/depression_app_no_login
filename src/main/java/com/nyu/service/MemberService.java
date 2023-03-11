package com.nyu.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberService {

    @Value("${nyu.name}")
    private String name;

    @Value("${nyu.age}")
    private String age;

    @RequestMapping("/getMember")
    public String getMember(){
        return "nyu_eduation";
    }


    @RequestMapping("/getProperties")
    public String getProperties(){
        return name + "--" + age;
    }
}
