package com.t.water.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName sensor
 */
@TableName(value ="sensor")
@Data
public class Sensor implements Serializable {
    /**
     * 传感器数据id
     */
    @TableId
    private String id;

    /**
     * 设备id
     */
    private String devId;

    /**
     * 浑浊度
     */
    private String turbidity;

    /**
     * 化学需氧量
     */
    private String cod;

    /**
     * tds溶解性总固体
     */
    private String tds;

    /**
     * ph酸碱度
     */
    private String ph;

    /**
     * 温度
     */
    private Integer temperature;

    /**
     * 水泵开关
     */
    private Integer pumpStatus;

    /**
     * 创建时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill= FieldFill.INSERT)
    private Date createdTime;

    /**
     * 更新时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic(value = "0",delval = "1")
    @TableField(fill = FieldFill.INSERT)//不用查该字段
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


    public Sensor initdemo(String id, String devId, Date time){
        this.setId(id);
        this.setDevId(devId);
        this.setTurbidity("0");
        this.setCod("0");
        this.setTds("0");
        this.setPh("0");
        this.setTemperature(0);
        this.setCreatedTime(time);
        this.setUpdateTime(time);
        this.setPumpStatus(1);
        return this;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Sensor other = (Sensor) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDevId() == null ? other.getDevId() == null : this.getDevId().equals(other.getDevId()))
            && (this.getTurbidity() == null ? other.getTurbidity() == null : this.getTurbidity().equals(other.getTurbidity()))
            && (this.getCod() == null ? other.getCod() == null : this.getCod().equals(other.getCod()))
            && (this.getTds() == null ? other.getTds() == null : this.getTds().equals(other.getTds()))
            && (this.getPh() == null ? other.getPh() == null : this.getPh().equals(other.getPh()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()))
            && (this.getPumpStatus() == null ? other.getPumpStatus() == null : this.getPumpStatus().equals(other.getPumpStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDevId() == null) ? 0 : getDevId().hashCode());
        result = prime * result + ((getTurbidity() == null) ? 0 : getTurbidity().hashCode());
        result = prime * result + ((getCod() == null) ? 0 : getCod().hashCode());
        result = prime * result + ((getTds() == null) ? 0 : getTds().hashCode());
        result = prime * result + ((getPh() == null) ? 0 : getPh().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        result = prime * result + ((getPumpStatus() == null) ? 0 : getPumpStatus().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", devId=").append(devId);
        sb.append(", turbidity=").append(turbidity);
        sb.append(", cod=").append(cod);
        sb.append(", tds=").append(tds);
        sb.append(", ph=").append(ph);
        sb.append(", temperature=").append(temperature);
        sb.append(", pumpStatus=").append(pumpStatus);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}