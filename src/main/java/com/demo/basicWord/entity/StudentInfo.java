package com.demo.basicWord.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentInfo implements Serializable {
    private static final long serialVersionUID = -3612266238012961332L;

    /**
     * 院系
     */
    private  String yx;

    /**
     * 专业
     */
    private  String zy;

    /**
     * 年级
     */
    private  String nj;

    /**
     * 班级
     */
    private  String bj;

    /**
     * 学号
     */
    private  String xh;

    /**
     * 姓名
     */
    private  String name;
    /**
     * 性别
     */
    private  String sex;

    /**
     * 年级
     */
    private String birthday;

    /**
     * 籍贯
     */
    private  String jg;

    /**
     * 身份证号码
     */
    private  String sfzhm;

    /**
     * 家庭人口
     */
    private  String jtrk;

    /**
     * 手机号码
     */
    private  String phone;

    /**
     * 详细地址
     */
    private  String xxdz;

    /**
     * 邮政编码
     */
    private  String yzbm;

    /**
     *家长手机号
     */
    private  String jzsjh;

    /**
     * 学费
     */
    private  String xf;

    /**
     * 住宿费
     */
    private  String zsf;

    /**
     * 家长姓名
     */
    private  String jzxm;

    /**
     * 家长年纪
     */
    private  String jznj;

    /**
     * 与学生关系
     */
    private  String yxsgx;

    /**
     * 工作单位
     */
    private  String gzdw;

    /**
     * 职业
     */
    private  String job;

    /**
     * 家长年收入
     */
    private  String jznsr;

    /**
     * 健康状态
     */
    private  String jkzt;

    /**
     * 家庭年收入
     */
    private  String jtnsr;

    /**
     * 签名
     */
    private  String qm;

    /**
     * 年
     */
    private  String n;

    /**
     * 月
     */
    private  String y;

    /**
     * 日
     */
    private  String r;
}
