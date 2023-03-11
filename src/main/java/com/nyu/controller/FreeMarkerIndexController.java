package com.nyu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class FreeMarkerIndexController {
    @RequestMapping("/freemarkerIndex")
    public String freemarkerIndex(Map <String, Object> result){
        result.put("name", "张三");
        result.put("sex", "0");
        result.put("age", 22);
        ArrayList<String> userlist = new ArrayList<>();
        userlist.add("大学生");
        userlist.add("计算机");
        result.put("userlist", userlist);
        return "freemarkerIndex";
    }
}
