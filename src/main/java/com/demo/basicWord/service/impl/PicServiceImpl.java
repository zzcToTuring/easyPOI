package com.demo.basicWord.service.impl;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.word.WordExportUtil;
import com.demo.basicWord.service.PicService;
import com.demo.basicWord.util.ImageUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class PicServiceImpl implements PicService {

    @Autowired
    private ImageUtil imageUtil;

    @Override
    public void down(HttpServletResponse response) throws Exception {

        File rootPath = new File(ResourceUtils.getURL("classpath:").getPath()); //SpringBoot项目获取根目录的方式
        File templatePath = new File(rootPath.getAbsolutePath(),"/templates/pic.docx");

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("age","一级标题");
        params.put("name","二级标题");
        params.put("img",imageUtil.imgFormatting("templates/pic.png",100,100));

        XWPFDocument xwpfDocument = WordExportUtil.exportWord07(templatePath.getPath(), params);
        String filename="导出word.docx";
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader( "Content-Disposition", "attachment;filename="  + new String(filename.getBytes(),"ISO8859-1"));
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        xwpfDocument.write(outputStream);


    }



}
