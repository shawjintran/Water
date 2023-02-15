package com.t.water.entity.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RiverQuery {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "河长名字,模糊查询")
    private String managerName;

    @ApiModelProperty(value = "水域名字,模糊查询")
    private String riverName;
}
