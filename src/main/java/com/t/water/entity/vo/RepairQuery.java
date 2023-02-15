package com.t.water.entity.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RepairQuery {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名字,模糊查询")//管理者名字
    private String managerName;

    @ApiModelProperty(value = "维修原因关键词")
    private String progressWords;

}
