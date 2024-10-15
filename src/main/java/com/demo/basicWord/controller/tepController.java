package com.demo.basicWord.controller;




import com.demo.basicWord.service.TepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/tep")
public class tepController {

    @Autowired
    private TepService tepService;

    @GetMapping(value = "down", name = "下载订单文档")
    public void test(HttpServletResponse response) throws Exception {
        tepService.down(response);
    }

    @GetMapping(value = "view", name = "在线预览")
    public void view(HttpServletResponse response) throws Exception {

    }
}

