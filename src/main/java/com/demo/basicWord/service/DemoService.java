package com.demo.basicWord.service;

import com.demo.basicWord.entity.Demo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public interface DemoService {
    void down(HttpServletResponse response, Demo demo) throws Exception;

    void downMap(HttpServletResponse response, HashMap<String,Object> param) throws Exception;
}
