package com.demo.basicWord.controller;

import com.demo.basicWord.entity.Demo;
import com.demo.basicWord.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/demo")
public class demoController {
    @Autowired
    private DemoService demoservice;

    @PostMapping (value = "down",name = "下载1")
    public void down(HttpServletResponse response, @RequestBody Demo demo) throws Exception {
        demoservice.down(response,demo);
    }

    @PostMapping(value = "downMap",name = "下载")
    public void downMap(HttpServletResponse response, @RequestBody HashMap<String,Object> params) throws Exception {
        demoservice.downMap(response,params);
    }



}
