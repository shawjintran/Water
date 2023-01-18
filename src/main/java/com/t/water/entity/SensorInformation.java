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
 * @TableName sensor_information
 */
@TableName(value ="sensor_information")
@Data
public class SensorInformation implements Serializable {
    /**
     * 
     */
    @TableId
    private Long sensorId;

    /**
     * 
     */
    private String sensorLastTurbidity;

    /**
     * 
     */
    private String sensorLastCod;

    /**
     * 
     */
    private String sensorLastTds;

    /**
     * 
     */
    private String sensorLastPh;

    /**
     * 
     */
    private Integer sensorLastTemperature;

    /**
     * 
     */
    private Integer sensorPumpStatus;

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