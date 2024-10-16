package com.demo.basicWord.service.impl;

import cn.afterturn.easypoi.word.WordExportUtil;
import com.demo.basicWord.service.TepService;
import com.demo.basicWord.util.ExportUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TepServiceImpl implements TepService {

    @Autowired
    private ExportUtil exportUtil;

    @Override
    public void down(HttpServletResponse response) throws Exception {
        File rootPath = new File(ResourceUtils.getURL("classpath:").getPath()); //SpringBoot项目获取根目录的方式
        File templatePath = new File(rootPath.getAbsolutePath(),"/templates/tep.docx");

        /**
         * 通过实体类DTO方式导入
         * List<tep> resourceList =new ArrayList<>();
         * tep userLine1=new tep();
         * tep userLine2=new tep();
         * userLine1.setName("zs");
         * userLine2.setName("ls");
         * resourceList.add(userLine1);
         * resourceList.add(userLine2);
         * params.put("resourceList",resourceList);
         */


        List<Map<String,Object>> resourceList=new ArrayList();


        Map<String,Object> userLine1 =new HashMap<>();
        Map<String,Object> userLine2 =new HashMap<>();
        resourceList.add(userLine1);
        resourceList.add(userLine2);

        //编辑数据
        userLine1.put("name","zs");
        userLine1.put("isTrue",false);
        userLine1.put("remark","123");
        userLine2.put("name","ls");
        userLine2.put("remark","******");
        userLine2.put("isTrue",true);


        List<Map<String,Object>> resourceLists=new ArrayList();
        Map<String,Object> userLine3 =new HashMap<>();
        resourceLists.add(userLine3);
        userLine3.put("name","ls");
        userLine3.put("remark","******");
        userLine3.put("isTrue",true);

        //构建基本数据
        Map<String,Object> params = new HashMap<String,Object>();

        params.put("name","一级标题");
        params.put("update_date","二级标题");
        params.put("resourceList",resourceList);
        params.put("resourceLists",resourceLists);

        exportUtil.exportWord(response,templatePath.getPath(),params);
    }
}
