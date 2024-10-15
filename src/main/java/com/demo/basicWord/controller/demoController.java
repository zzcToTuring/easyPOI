package com.demo.basicWord.controller;

import com.demo.basicWord.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/demo")
public class demoController {
    @Autowired
    private DemoService demoservice;

    @GetMapping(value = "down",name = "下载")
    public void down(HttpServletResponse response) throws Exception {
        demoservice.down(response);
    }
}
