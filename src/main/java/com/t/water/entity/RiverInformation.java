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
 * @TableName river_information
 */
@TableName(value ="river_information")
@Data
public class RiverInformation implements Serializable {
    /**
     * 
     */
    @TableId
    private Long riverId;

    /**
     * 
     */
    private String riverLat;

    /**
     * 
     */
    private String riverLon;

    /**
     * 
     */
    private String riverStatus;

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