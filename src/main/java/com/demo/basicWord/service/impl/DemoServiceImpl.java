package com.demo.basicWord.service.impl;

import java.lang.reflect.Field;
import com.demo.basicWord.entity.Demo;
import com.demo.basicWord.service.DemoService;
import com.demo.basicWord.util.ExportUtil;
import com.demo.basicWord.util.ImageUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private  ImageUtil imageUtil;

    @Autowired
    private ExportUtil exportUtil;

    @Override
    public void down(HttpServletResponse response, Demo demo) throws Exception {

        File rootPath = new File(ResourceUtils.getURL("classpath:").getPath()); //SpringBoot项目获取根目录的方式
        File templatePath = new File(rootPath.getAbsolutePath(),"/templates/规格书/规格书.docx");
        Map<String,Object> params = new HashMap<String,Object>();

        //反射bean中所有的类
        Field[] fields = Demo.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(demo);
            params.put(fieldName, value);
        }
        exportUtil.exportWord(response,templatePath.getPath(),params);

    }

    @Override
    public void downMap(HttpServletResponse response, HashMap<String, Object> param) throws Exception {
        File rootPath = new File(ResourceUtils.getURL("classpath:").getPath()); //SpringBoot项目获取根目录的方式
        File templatePath = new File(rootPath.getAbsolutePath(),"/templates/规格书/规格书.docx");
        Map<String,Object> params = new HashMap<String,Object>();
        exportUtil.exportWord(response,templatePath.getPath(),params);
    }


}
