package com.demo.basicWord.util;

import cn.afterturn.easypoi.entity.ImageEntity;
import org.springframework.stereotype.Service;

@Service
public  class  ImageUtil {
     public ImageEntity imgFormatting(String imgPath, int width, int height) {
        //设置图片
        ImageEntity image = new ImageEntity(imgPath, width, height);
        //表格外添加简单图片
        image.setType(ImageEntity.URL);
        return image;
    }
}
