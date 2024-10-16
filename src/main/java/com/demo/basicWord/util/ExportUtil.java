package com.demo.basicWord.util;

import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Service
public class ExportUtil {
    public void exportWord(HttpServletResponse response,String path,Map<String, Object> params) throws Exception{
        //根据模板+数据 导出文档
        //tip:本地可以使用:te
        XWPFDocument xwpfDocument = WordExportUtil.exportWord07(path,params);
        String filename="导出word.docx";
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader( "Content-Disposition", "attachment;filename="  + new String(filename.getBytes(),"ISO8859-1"));
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        xwpfDocument.write(outputStream);
    }
}
