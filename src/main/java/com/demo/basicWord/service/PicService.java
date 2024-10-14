package com.demo.basicWord.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface PicService {
    void down(HttpServletResponse response) throws Exception;
}
