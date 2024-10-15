package com.demo.basicWord.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public interface DemoService {
    void down(HttpServletResponse response) throws Exception;

}
