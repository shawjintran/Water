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
 * @TableName repair_information
 */
@TableName(value ="repair_information")
@Data
public class RepairInformation implements Serializable {
    /**
     * 
     */
    @TableId
    private Long repairId;

    /**
     * 
     */
    private Long managerId;

    /**
     * 
     */
    private Long devId;

    /**
     * 
     */
    private String repairDescription;

    /**
     * 
     */
    private String repairProgress;

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