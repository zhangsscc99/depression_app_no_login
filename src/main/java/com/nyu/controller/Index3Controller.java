package com.nyu.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Index3Controller {



    @GetMapping("/index3")
    public String index3(HttpServletRequest request){

        return "index3";
    }
}
