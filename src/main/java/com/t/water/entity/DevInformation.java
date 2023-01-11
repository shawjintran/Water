package com.t.water.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName dev_information
 */
@TableName(value ="dev_information")
public class DevInformation implements Serializable {
    /**
     * 
     */
    @TableId
    private Long devId;

    /**
     * 设备上一次发送位置的时间
     */
    private Date devLastTime;

    /**
     * 设备上一次的纬度
     */
    private Long devLastLat;

    /**
     * 设备上一次的经度
     */
    private Long devLastLon;

    /**
     * 
     */
    private Date devStartime;

    /**
     * 
     */
    private Integer devStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getDevId() {
        return devId;
    }

    /**
     * 
     */
    public void setDevId(Long devId) {
        this.devId = devId;
    }

    /**
     * 设备上一次发送位置的时间
     */
    public Date getDevLastTime() {
        return devLastTime;
    }

    /**
     * 设备上一次发送位置的时间
     */
    public void setDevLastTime(Date devLastTime) {
        this.devLastTime = devLastTime;
    }

    /**
     * 设备上一次的纬度
     */
    public Long getDevLastLat() {
        return devLastLat;
    }

    /**
     * 设备上一次的纬度
     */
    public void setDevLastLat(Long devLastLat) {
        this.devLastLat = devLastLat;
    }

    /**
     * 设备上一次的经度
     */
    public Long getDevLastLon() {
        return devLastLon;
    }

    /**
     * 设备上一次的经度
     */
    public void setDevLastLon(Long devLastLon) {
        this.devLastLon = devLastLon;
    }

    /**
     * 
     */
    public Date getDevStartime() {
        return devStartime;
    }

    /**
     * 
     */
    public void setDevStartime(Date devStartime) {
        this.devStartime = devStartime;
    }

    /**
     * 
     */
    public Integer getDevStatus() {
        return devStatus;
    }

    /**
     * 
     */
    public void setDevStatus(Integer devStatus) {
        this.devStatus = devStatus;
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
        DevInformation other = (DevInformation) that;
        return (this.getDevId() == null ? other.getDevId() == null : this.getDevId().equals(other.getDevId()))
            && (this.getDevLastTime() == null ? other.getDevLastTime() == null : this.getDevLastTime().equals(other.getDevLastTime()))
            && (this.getDevLastLat() == null ? other.getDevLastLat() == null : this.getDevLastLat().equals(other.getDevLastLat()))
            && (this.getDevLastLon() == null ? other.getDevLastLon() == null : this.getDevLastLon().equals(other.getDevLastLon()))
            && (this.getDevStartime() == null ? other.getDevStartime() == null : this.getDevStartime().equals(other.getDevStartime()))
            && (this.getDevStatus() == null ? other.getDevStatus() == null : this.getDevStatus().equals(other.getDevStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDevId() == null) ? 0 : getDevId().hashCode());
        result = prime * result + ((getDevLastTime() == null) ? 0 : getDevLastTime().hashCode());
        result = prime * result + ((getDevLastLat() == null) ? 0 : getDevLastLat().hashCode());
        result = prime * result + ((getDevLastLon() == null) ? 0 : getDevLastLon().hashCode());
        result = prime * result + ((getDevStartime() == null) ? 0 : getDevStartime().hashCode());
        result = prime * result + ((getDevStatus() == null) ? 0 : getDevStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", devId=").append(devId);
        sb.append(", devLastTime=").append(devLastTime);
        sb.append(", devLastLat=").append(devLastLat);
        sb.append(", devLastLon=").append(devLastLon);
        sb.append(", devStartime=").append(devStartime);
        sb.append(", devStatus=").append(devStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}