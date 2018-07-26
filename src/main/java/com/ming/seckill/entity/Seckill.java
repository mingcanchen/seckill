package com.ming.seckill.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenmingcan
 */
@Data
public class Seckill implements Serializable {
    private long seckillId;
    private String name;
    private int number;
    private Date startTime;
    private Date endTime;
    private Date createTime;

}
