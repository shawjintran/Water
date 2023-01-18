package com.t.water.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName river_manager
 */
@TableName(value ="river_manager")
@Data
public class RiverManager implements Serializable {
    /**
     * 
     */
    @TableId
    private Long managerId;

    /**
     * 
     */
    private Long superiorId;

    /**
     * 
     */
    private String managerPhone;

    /**
     * 
     */
    private String managerPwd;

    /**
     * 
     */
    private String managerPost;

    /**
     * 
     */
    private String managerProfileUrl;

    /**
     * 
     */
    private String managerAddress;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}