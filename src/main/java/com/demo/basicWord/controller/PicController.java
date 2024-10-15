package com.demo.basicWord.controller;

import com.demo.basicWord.service.PicService;
import com.demo.basicWord.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/pic")
public class PicController {
    @Autowired
    private PicService picService;

    @Autowired
    private ImageUtil imageUtil;

    @GetMapping(value = "down",name = "下载")
    public void down(HttpServletResponse response) throws Exception {
        picService.down(response);
    }

    @GetMapping(value = "viewPic",name="预览")
    @ResponseBody
    @CrossOrigin()
    public ResponseEntity<FileSystemResource> getImage(HttpServletResponse response) throws Exception {
        return imageUtil.getImage("src/main/resources/templates/pic.png");
    }

    @GetMapping(value = "view",name="预览")
    public String getH()  {
        return "../pic/pic.html";
    }

}
