package com.peramdy.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author peramdy
 * @date 2017/12/4.
 */
public class HelloWord {

    public void simpleOne() {
        Jedis jedis = new Jedis("192.168.136.130", 16379);
        jedis.set("1", "redis_1");
        System.out.println(jedis.get("1"));
    }

    public void simpleTwo() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMaxWaitMillis(2000);
        jedisPoolConfig.setTestOnBorrow(true);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "192.168.136.130", 16379, 1000);
        Jedis jedis = jedisPool.getResource();

        jedis.set("2", "redis_2");
        System.out.println(jedis.get("2"));
    }

}
