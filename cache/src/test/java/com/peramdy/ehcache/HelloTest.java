package com.peramdy.ehcache;

import junit.framework.TestCase;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.io.IOException;

/**
 * @author peramdy
 * @date 2017/11/30.
 */
public class HelloTest extends TestCase {

    /**
     * basic
     */
    public void testOne() {

        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();

        CacheConfigurationBuilder cacheConfigurationBuilder = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, String.class, ResourcePoolsBuilder.heap(5));
        Cache cache = cacheManager.createCache("one", cacheConfigurationBuilder);
        cache.put("1", "hello1!");
        cache.put("2", "hello2!");
        cache.put("3", "hello3!");
        cache.put("4", "hello4!");
        cache.put("5", "hello5!");
        cache.put("6", "hello6!");

        String value1 = (String) cache.get("1");
        System.out.println("value1: " + value1);

        String value2 = (String) cache.get("2");
        System.out.println("value2: " + value2);

        String value3 = (String) cache.get("3");
        System.out.println("value3: " + value3);

        String value4 = (String) cache.get("4");
        System.out.println("value4: " + value4);

        String value5 = (String) cache.get("5");
        System.out.println("value5: " + value5);

        String value6 = (String) cache.get("6");
        System.out.println("value6: " + value6);

        cacheManager.close();
    }


    public void testTwo() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://www.baidu.com");
        try {
            httpClient.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * cacheManger
     */
    public void testThree() {
        HelloWord.simpleOne();
    }

    /**
     * userManagerCache
     */
    public void testFour() {
        HelloWord.simpleTwo();
    }

    /**
     * persistenceCache
     */
    public void testFive() {
        HelloWord.simpleThree("d:");
    }

    public void testSix() {
        EhcacheManager ehcacheManager = new EhcacheManager.builder()
                .alias("cry")
//                .persistent(true)
                .build();
        CacheManager cacheManager = ehcacheManager.CreateCacheManager();
        Cache cache = cacheManager.getCache("cry", String.class, String.class);
        cache.put("1", "testSix");

        System.out.println(cache.get("1"));

    }


    public void testSeven() {

        System.out.println(System.getProperty("os.name"));

        System.out.println(System.getProperty("os.arch"));

        System.out.println(System.getProperty("os.version"));

    }


    public void testEight() {
        EhcacheManager ehcacheManager = new EhcacheManager.builder()
                .xmlConfigPath("D:/program/github/cache/src/main/resource/ehcacheConfig.xml")
                .build();
        CacheManager cacheManager = ehcacheManager.CreateCacheManagerXml();

        Cache cache = cacheManager.getCache("one", String.class, String.class);
        cache.put("1", "test");

        System.out.println(cache.get("1"));

    }

    public void testNine() {
        EhcacheManager ehcacheManager = new EhcacheManager.builder()
                .xmlConfigPath("D:/program/github/cache/src/main/resource/ehcacheConfig.xml")
                .build();
        CacheManager cacheManager = ehcacheManager.CreateCacheManagerXml();

        EhCacheClientAdapter clientAdapter = new EhCacheClientAdapter
                .builder()
                .cacheManager(cacheManager)
                .build();

        clientAdapter.put("one", "12-3", "十二月三号");

        System.out.println(clientAdapter.get("one", "12-3"));

    }


    public void testTen() {
        EhcacheManager ehcacheManager = new EhcacheManager.builder()
                .xmlConfigPath("D:/program/github/cache/src/main/resource/ehcacheConfig.xml")
                .build();
        CacheManager cacheManager = ehcacheManager.CreateCacheManagerXml();

        EhCacheClientAdapter clientAdapter = EhCacheClientAdapter.newEhCacheClientAdapter(cacheManager);

        clientAdapter.put("one", "12-3", "十二月三号");

        System.out.println(clientAdapter.get("one", "12-3"));

    }

}
