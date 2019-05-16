package com.amis.entity;

import lombok.Data;

/**
 * @ClassName Echars
 * @Description
 * @Author chenzexin
 * @Date 2019/5/15 16:45
 **/
@Data
public class Echars {
    private String name;
    private Integer num;

    public Echars(String name, Integer num) {
        super();
        this.name = name;
        this.num = num;
    }
}
