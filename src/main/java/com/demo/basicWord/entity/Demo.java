package com.demo.basicWord.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Demo {
    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String str5;
    private String str6;
    private String str7;
    private String str8;
    private String str9;
    private String str10;
    private List<TableList> tableList1;
    private List<TableList> tableList2;
    private image image;


    @Data
    public static class TableList{
        private String cell1;
        private String cell2;
        private String cell3;
        private String cell4;
    }


    @Data
    public static class image {
        private String pathUrl;
        private int width;
        private int height;
    }
}


