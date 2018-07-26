package com.ming.seckill.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenmingcan
 */
@Data
public class SuccessKilled implements Serializable {
    private long seckillId;
    private long userPhone;
    private short state;
    private Date createTime;

    /**
     * 多对一,因为一件商品在库存中有很多数量，对应的购买明细也有很多。
     */
    private Seckill seckill;

}
