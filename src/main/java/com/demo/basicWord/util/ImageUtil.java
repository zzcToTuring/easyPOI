package com.demo.basicWord.util;

import cn.afterturn.easypoi.entity.ImageEntity;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Paths;

@Service
public  class  ImageUtil {

    //easyPOI返回需要的类型
     public ImageEntity imgFormatting(String imgPath, int width, int height) {
        //设置图片
        ImageEntity image = new ImageEntity(imgPath, width, height);
        //表格外添加简单图片
        image.setType(ImageEntity.URL);
        return image;
    }

    @GetMapping(value = "view",name="预览")
    public ResponseEntity<FileSystemResource> getImage(String imagePath) throws Exception {
        FileSystemResource fileSystemResource = new FileSystemResource(Paths.get(imagePath));
        if (!fileSystemResource.exists()) {
            return ResponseEntity.notFound().build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // 设置图片类型
        return ResponseEntity.ok().headers(headers).body(fileSystemResource);
    }

}
