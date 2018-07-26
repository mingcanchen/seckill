package com.ming.seckill.service.impl;

import com.ming.seckill.entity.Seckill;
import com.ming.seckill.service.SeckillService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillServiceImplTest {

    @Autowired
    private SeckillService seckillServiceImpl;
    @Test
    public void getSeckillList() {
        List<Seckill> seckillList = seckillServiceImpl.getSeckillList();
        Assert.assertNotNull(seckillList);
    }
}