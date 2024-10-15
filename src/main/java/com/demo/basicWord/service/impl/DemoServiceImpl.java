package com.demo.basicWord.service.impl;

import cn.afterturn.easypoi.word.WordExportUtil;
import com.demo.basicWord.service.DemoService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public void down(HttpServletResponse response) throws Exception {

        File rootPath = new File(ResourceUtils.getURL("classpath:").getPath()); //SpringBoot项目获取根目录的方式
        File templatePath = new File(rootPath.getAbsolutePath(),"/templates/规格书/规格书.docx");



        /*List<Map<String,Object>> resourceList=new ArrayList();
        Map<String,Object> userLine1 =new HashMap<>();
        Map<String,Object> userLine2 =new HashMap<>();
        resourceList.add(userLine1);
        resourceList.add(userLine2);

        userLine1.put("id","1");
        userLine1.put("content","11111111");
        userLine1.put("date","2099-99-99");
        userLine1.put("name","???");

        userLine2.put("id","2");
        userLine2.put("content","22222");
        userLine2.put("date","2000-99-99");
        userLine2.put("name","!!!!!!");


        params.put("ml",resourceList);*/

        List<Map<String,Object>> resourceList=new ArrayList();

        Map<String,Object> userLine1 =new HashMap<>();
        Map<String,Object> userLine2 =new HashMap<>();
        resourceList.add(userLine1);
        resourceList.add(userLine2);

        //编辑数据
        userLine1.put("name","zs");
        userLine2.put("name","ls");
        userLine1.put("remark","**********");
        userLine2.put("remark","******");
        userLine1.put("isTrue",false);
        userLine2.put("isTrue",true);

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("update_date","2099-99-99");
        params.put("button","●");
        params.put("resourceList",resourceList);


        XWPFDocument xwpfDocument = WordExportUtil.exportWord07(templatePath.getPath(), params);
        String filename="导出word.docx";
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader( "Content-Disposition", "attachment;filename="  + new String(filename.getBytes(),"ISO8859-1"));
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        xwpfDocument.write(outputStream);

    }
}
