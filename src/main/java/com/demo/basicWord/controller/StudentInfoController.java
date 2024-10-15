package com.demo.basicWord.controller;

import com.demo.basicWord.entity.StudentInfo;
import com.demo.basicWord.service.impl.StudentInfoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;


@Controller
//@RequestMapping("/student")
public class StudentInfoController {

    @Autowired
    private StudentInfoServiceImpl studentInfoService;


    @GetMapping("/view")
    public String testView(){
        return "student.html";
    }

    @GetMapping(value = "/down",name="下载订单文档")
    public void test( HttpServletResponse response) throws Exception{
        studentInfoService.down(response);
    }

    @GetMapping(value = "getData")
    @ResponseBody
    public StudentInfo getData() throws Exception{
        return studentInfoService.getInfo();
    }

}
