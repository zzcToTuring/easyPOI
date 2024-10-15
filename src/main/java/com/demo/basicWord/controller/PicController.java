package com.demo.basicWord.controller;

import cn.afterturn.easypoi.entity.ImageEntity;
import com.demo.basicWord.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Paths;
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
    public ResponseEntity<FileSystemResource> getImage(HttpServletResponse response) throws Exception {
        String imagePath = "src/main/resources/templates/pic.png"; // 图片的相对路径
        FileSystemResource fileSystemResource = new FileSystemResource(Paths.get(imagePath));

        if (!fileSystemResource.exists()) {
            return ResponseEntity.notFound().build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // 设置图片类型
        return ResponseEntity.ok().headers(headers).body(fileSystemResource);
    }


}
