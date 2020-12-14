package com.git.zxxxd.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "演示类", description = "请求参数类")
public class Demo implements Serializable {
    @ApiModelProperty(value = "defaultStr", example = "mockStrValue")
    private String name;
    @ApiModelProperty(value = "defaultStr", example = "19",required = true)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
