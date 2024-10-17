package com.demo.basicWord.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Demo {
    private String createName;
    private String update_date;
    private String sitIn;
    private String sitOut;
    private String str5;
    private String str6;
    private String str7;
    private String str8;
    private String str9;
    private String str10;
    private List<TableList> catalog;
    private Image dqzc;


    @Data
    public static class TableList{
        private String id;
        private String content;
        private String date;
        private String name;
    }


    @Data
    public static class Image {
        private String pathUrl;
        private int width;
        private int height;
    }
}


