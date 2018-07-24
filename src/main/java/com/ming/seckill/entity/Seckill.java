package com.ming.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author chenmingcan
 */
@Data
public class Seckill {
    private long seckillId;
    private String name;
    private int number;
    private Date startTime;
    private Date endTime;
    private Date createTime;

}
