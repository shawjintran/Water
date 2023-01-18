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
 * @TableName dev_information
 */
@TableName(value ="dev_information")
@Data
public class DevInformation implements Serializable {
    /**
     * 
     */
    private Long devId;

    /**
     * 
     */
    private Integer devLastLat;

    /**
     * 
     */
    private Integer devLastLon;

    /**
     * 
     */
    private Integer devStatus;

    /**
     * 
     */
    private Integer devLastPower;

    /**
     * 
     */
    private Date createdTime;

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