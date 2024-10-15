package com.demo.basicWord.controller;

import cn.afterturn.easypoi.entity.ImageEntity;
import com.demo.basicWord.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Handler;

@RestController
@RequestMapping("/pic")
public class PicController {
    @Autowired
    private PicService picService;

    @GetMapping(value = "down",name = "下载")
    public void down(HttpServletResponse response) throws Exception {
        picService.down(response);
    }

    @GetMapping(value = "view",name="预览")
    public ImageEntity view(HttpServletResponse response) throws Exception {


        return null;
    }


}
