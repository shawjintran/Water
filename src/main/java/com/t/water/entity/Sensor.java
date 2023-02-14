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
    private String devid;

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
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
            && (this.getDevid() == null ? other.getDevid() == null : this.getDevid().equals(other.getDevid()))
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
        result = prime * result + ((getDevid() == null) ? 0 : getDevid().hashCode());
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
        sb.append(", devid=").append(devid);
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