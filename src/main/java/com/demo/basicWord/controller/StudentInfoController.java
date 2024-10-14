package com.demo.basicWord.controller;

import com.demo.basicWord.service.impl.StudentInfoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;


@Controller
//@RequestMapping("/student")
public class StudentInfoController {

    @Autowired
    private StudentInfoServiceImpl DifficultyTableServiceImpl;


    @GetMapping("/view")
    public String testView(){
        return "student.html";
    }

    @GetMapping(value = "/down",name="下载订单文档")
    public void test( HttpServletResponse response) throws Exception{
        DifficultyTableServiceImpl.down(response);
    }

}
