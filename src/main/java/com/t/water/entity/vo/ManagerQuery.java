package com.t.water.entity.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ManagerQuery {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名字,模糊查询")
    private String name;

    @ApiModelProperty(value = "职位")
    private String post;

}
