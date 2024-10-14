package com.demo.basicWord.service.impl;

import cn.afterturn.easypoi.word.WordExportUtil;
import com.demo.basicWord.entity.StudentInfo;
import com.demo.basicWord.service.StudentInfoService;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;


/**
 * @author WJL
 * @version 1.0
 * @date 2023/02/06 13:56
 * @功能描述
 **/
@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Override
    public void down(HttpServletResponse response) throws Exception {
        File rootPath = new File(ResourceUtils.getURL("classpath:").getPath()); //SpringBoot项目获取根目录的方式
        File templatePath = new File(rootPath.getAbsolutePath(),"/templates/studentInfo.docx");
        //准备导出数据
        //查询所有用户数
        // 生成 Random 对象

        //给对象进行赋值
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setYx("信息工程");
        studentInfo.setZy("计科");
        studentInfo.setNj("2020");
        studentInfo.setBj("1");
        studentInfo.setXh("123");
        studentInfo.setName("肖");
        studentInfo.setSex("男");
        studentInfo.setBirthday("2000");
        studentInfo.setJg("四川");
        studentInfo.setSfzhm("2512312");
        studentInfo.setJtrk("4");
        studentInfo.setPhone("191");
        studentInfo.setXxdz("四川省");
        studentInfo.setYzbm("641300");
        studentInfo.setJzsjh("13555");
        studentInfo.setXf("1400");
        studentInfo.setZsf("800");
        studentInfo.setJzxm("xy");
        studentInfo.setJznj("55");
        studentInfo.setYxsgx("父子");
        studentInfo.setGzdw("无");
        studentInfo.setJob("无");
        studentInfo.setJznsr("20");
        studentInfo.setJkzt("健康");
        studentInfo.setJtnsr("30000");
        studentInfo.setQm("肖");
        studentInfo.setN("2020");
        studentInfo.setY("2");
        studentInfo.setR("10");
        
       // studentInfo studentInfo= this.list().get(number);
        Map<String,Object> params = new HashMap<String,Object>();
        String yx = studentInfo.getYx();
        String zy = studentInfo.getZy();
        String nj = studentInfo.getNj();
        String bj = studentInfo.getBj();
        String xh = studentInfo.getXh();
        String name = studentInfo.getName();
        String sex = studentInfo.getSex();
        String birthday = studentInfo.getBirthday();
        String jg = studentInfo.getJg();
        String sfzhm = studentInfo.getSfzhm();
        String jtrk = studentInfo.getJtrk();
        String phone = studentInfo.getPhone();
        String xxdz = studentInfo.getXxdz();
        String yzbm = studentInfo.getYzbm();
        String jzsjh = studentInfo.getJzsjh();
        String xf = studentInfo.getXf();
        String zsf = studentInfo.getZsf();
        String jzxm = studentInfo.getJzxm();
        String jznj = studentInfo.getJznj();
        String yxsgx = studentInfo.getYxsgx();
        String gzdw = studentInfo.getGzdw();
        String job = studentInfo.getJob();
        String jznsr = studentInfo.getJznsr();
        String jkzt = studentInfo.getJkzt();
        String jtnsr = studentInfo.getJtnsr();
        String qm = studentInfo.getQm();
        String n = studentInfo.getN();
        String y = studentInfo.getY();
        String r = studentInfo.getR();

        params.put("yx",yx);
        params.put("zy",zy);
        params.put("nj",nj);
        params.put("bj",bj);
        params.put("xh",xh);
        params.put("name",name);
        params.put("sex",sex);
        params.put("birthday",birthday);
        params.put("jg",jg);
        params.put("sfzhm",sfzhm);
        params.put("jtrk",jtrk);
        params.put("phone",phone);

        params.put("xxdz",xxdz);
        params.put("yzbm",yzbm);
        params.put("jzsjh",jzsjh);
        params.put("xf",xf);
        params.put("zsf",zsf);
        params.put("jzxm",jzxm);
        params.put("jznj",jznj);
        params.put("yxsgx",yxsgx);
        params.put("gzdw",gzdw);
        params.put("job",job);
        params.put("jznsr",jznsr);
        params.put("jkzt",jkzt);
        params.put("jtnsr",jtnsr);
        params.put("qm",qm);
        params.put("n",n);
        params.put("y",y);
        params.put("r",r);

        params.put("1","☑");
        params.put("2","☑");
        //根据模板+数据 导出文档
        XWPFDocument xwpfDocument = WordExportUtil.exportWord07(templatePath.getPath(), params);
        String filename="导出word.docx";
        //设置文件的打开方式和mime类型
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader( "Content-Disposition", "attachment;filename="  + new String(filename.getBytes(),"ISO8859-1"));
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        xwpfDocument.write(outputStream);
    }
}
