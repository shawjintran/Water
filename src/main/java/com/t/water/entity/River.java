package com.t.water.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName river
 */
@TableName(value ="river")
@Data
public class River implements Serializable {
    /**
     * 水域id
     */
    @TableId
    private String id;

    /**
     * 水域纬度
     */
    private BigDecimal riverLat;

    /**
     * 水域经度
     */
    private BigDecimal riverLon;

    /**
     * 水域状态
     */
    private String riverStatus;

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
        River other = (River) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRiverLat() == null ? other.getRiverLat() == null : this.getRiverLat().equals(other.getRiverLat()))
            && (this.getRiverLon() == null ? other.getRiverLon() == null : this.getRiverLon().equals(other.getRiverLon()))
            && (this.getRiverStatus() == null ? other.getRiverStatus() == null : this.getRiverStatus().equals(other.getRiverStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRiverLat() == null) ? 0 : getRiverLat().hashCode());
        result = prime * result + ((getRiverLon() == null) ? 0 : getRiverLon().hashCode());
        result = prime * result + ((getRiverStatus() == null) ? 0 : getRiverStatus().hashCode());
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
        sb.append(", riverLat=").append(riverLat);
        sb.append(", riverLon=").append(riverLon);
        sb.append(", riverStatus=").append(riverStatus);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}