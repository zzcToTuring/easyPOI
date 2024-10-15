package com.demo.basicWord.service;


import com.demo.basicWord.entity.StudentInfo;
import org.apache.poi.ss.formula.functions.T;

import javax.servlet.http.HttpServletResponse;

/**
 * @author WJL
 * @version 1.0
 * @date 2023/02/06 13:56
 * @功能描述
 **/
public interface StudentInfoService {
    void down(HttpServletResponse response) throws Exception;

    StudentInfo getInfo() throws Exception;
}
