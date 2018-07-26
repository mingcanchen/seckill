package com.ming.seckill.dao.cache;


import com.ming.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;


/**
 * @author chenmingcan
 */
@Repository
public class RedisDao {

    private RedisTemplate redisTemplate;

    @Autowired
    public RedisDao(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 从redis获取信息
     *
     * @param seckillId id
     * @return 如果不存在，则返回null
     */
    private Seckill getSeckill(long seckillId) {

        String key = getSeckillRedisKey(seckillId);

        return (Seckill) redisTemplate.opsForValue().get(key);
    }

    /**
     * 从缓存获取，如果没有，则从数据库获取
     * 会用到分布式锁
     *
     * @param seckillId     id
     * @param getDataFromDb 从数据库获取的方法
     * @return 返回商品信息
     */
    public Seckill getOrPutSeckill(long seckillId, Function<Long, Seckill> getDataFromDb) {


        Seckill seckill = getSeckill(seckillId);
        if (seckill != null) {
            return seckill;
        }

        seckill = getDataFromDb.apply(seckillId);
        putSeckill(seckill);

        return seckill;
    }

    /**
     * 根据id获取redis的key
     *
     * @param seckillId 商品id
     * @return redis的key
     */
    private String getSeckillRedisKey(long seckillId) {
        return "seckill:" + seckillId;
    }


    private void putSeckill(Seckill seckill) {

        String key = getSeckillRedisKey(seckill.getSeckillId());

        //超时缓存，1小时
        int timeout = 60 * 60;

        redisTemplate.opsForValue().set(key, seckill, timeout, TimeUnit.SECONDS);

    }
}
