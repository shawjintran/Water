package com.t.water.entity.vo;

import lombok.Data;

@Data
public class ManagerShowVo {
    /**
     * 城管id
     */
    private String id;


    /**
     * 名字
     */

    private String name;


    /**
     * 上级河长id
     */
    private String superiorId;


    /**
     * 电话
     */
    private String phone;

    /**
     * 职位
     * 省级与县级
     */
    private String post;

    /**
     * 头像
     */
    private String profileUrl;


    /**
     * 地址
     */
    private String address;

}
