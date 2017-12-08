package com.peramdy.redis;

import junit.framework.TestCase;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Before;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * @author peramdy
 * @date 2017/12/4.
 */
public class HelloTest extends TestCase {

    private HelloWord helloWord;

    @Before
    public void crateHelloWord() {
        helloWord = new HelloWord();
    }

    public void testOne() {
        helloWord.simpleOne();
    }

    public void testTwo() {
        helloWord.simpleTwo();
    }

    public void testThree() {
        JedisPool jedisPool = new JedisPoolsBuilder
                .builder()
                .host("192.168.136.130")
                .port(16379)
                .build();

        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.get("1"));
    }

    public void testFour() {
        JedisPool jedisPool = new JedisPoolsBuilder
                .builder()
                .host("192.168.136.130")
                .port(16379)
                .isMonitor(true)
                .build();

        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.get("1"));
    }

    public void testFive() {

        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(100);
        poolConfig.setMaxIdle(10);
        poolConfig.setMinIdle(5);

        JedisCluster jedisCluster = new JedisClusterBuilder
                .builder()
                .timeOut(2)
                .maxTotal(10)
                .addressConfigs("192.168.136.130:17001,192.168.136.130:17002," +
                        "192.168.136.130:17003,192.168.136.130:17004," +
                        "192.168.136.130:17005,192.168.136.130:17006")
                .poolConfig(poolConfig)
                .build();

        jedisCluster.set("cluster", "6666");
        System.out.println(jedisCluster.get("cluster"));

    }

    public void testSix() {
        Proxy proxy = new Proxy();
        SayHello sayHello = (SayHello) proxy.getProxy(SayHello.class);
        sayHello.say("hahaha");

    }


}
