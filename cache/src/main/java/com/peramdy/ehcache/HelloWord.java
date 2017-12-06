package com.peramdy.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.UserManagedCache;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.ResourcePools;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.builders.UserManagedCacheBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;

import java.io.File;

/**
 * @author peramdy
 * @date 2017/12/1.
 */
public class HelloWord {


    /**
     * cacheManager
     */
    public static void simpleOne() {
        CacheManagerBuilder cacheManagerBuilder = CacheManagerBuilder.newCacheManagerBuilder();
        CacheManager cacheManager = cacheManagerBuilder.build();
        cacheManager.init();
        ResourcePools resourcePools = ResourcePoolsBuilder.heap(10).build();
        CacheConfiguration cacheConfiguration = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, String.class, resourcePools).build();
        Cache cache = cacheManager.createCache("hello", cacheConfiguration);
        cache.put("1", "test_1");
        cache.put("2", "test_2");
        cache.put("3", "test_3");
        cache.put("4", "test_4");
        cache.put("5", "test_5");
        cache.put("6", "test_6");

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

    /**
     * userManagerCache
     */
    public static void simpleTwo() {
        UserManagedCacheBuilder userManagedCacheBuilder = UserManagedCacheBuilder.newUserManagedCacheBuilder(Integer.class, String.class);
        UserManagedCache<Integer, String> userManagedCache = userManagedCacheBuilder.build();
        userManagedCache.init();
        userManagedCache.put(1, "test_1");
        userManagedCache.put(2, "test_2");
        userManagedCache.put(3, "test_3");
        userManagedCache.put(4, "test_4");
        userManagedCache.put(5, "test_5");
        userManagedCache.put(6, "test_6");

        String value1 = userManagedCache.get(1);
        System.out.println("value1: " + value1);

        String value2 = userManagedCache.get(2);
        System.out.println("value2: " + value2);

        String value3 = userManagedCache.get(3);
        System.out.println("value3: " + value3);

        String value4 = userManagedCache.get(4);
        System.out.println("value4: " + value4);

        String value5 = userManagedCache.get(5);
        System.out.println("value5: " + value5);

        String value6 = userManagedCache.get(6);
        System.out.println("value6: " + value6);

        userManagedCache.close();

    }


    /**
     * persistenceCache
     *
     * @param path
     */
    public static void simpleThree(String path) {

        ResourcePools resourcePools = ResourcePoolsBuilder.newResourcePoolsBuilder()
                //堆
                .heap(5, EntryUnit.ENTRIES)
                //堆外
                .offheap(1, MemoryUnit.MB)
                //磁盘
                .disk(1, MemoryUnit.GB)
                .build();

        CacheConfiguration cacheConfiguration = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Integer.class, String.class, resourcePools).build();

        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence(path + File.separator + "myEhCache"))
                .withCache("persistence_ehcache", cacheConfiguration)
                .build();

        cacheManager.init();

        Cache cache = cacheManager.getCache("persistence_ehcache", Integer.class, String.class);

        cache.put(1, "smile");
        cache.put(2, "laugh");
        cache.put(3, "horselaugh");
        cache.put(4, "giggle");
        cache.put(5, "grin");
        cache.put(6, "chuckle");
        cache.put(7, "snicker");
        cache.put(8, "roar");
        cache.put(9, "simper");
        cache.put(10, "cachinnate");
        cache.put(11, "chortle");
        cache.put(12, "deride");
        cache.put(13, "taunt");
        cache.put(14, "guffaw");


        String expression_1 = (String) cache.get(1);
        System.out.println(expression_1);

        String expression_2 = (String) cache.get(2);
        System.out.println(expression_2);

        String expression_3 = (String) cache.get(3);
        System.out.println(expression_3);

        String expression_4 = (String) cache.get(4);
        System.out.println(expression_4);

        String expression_5 = (String) cache.get(5);
        System.out.println(expression_5);

        String expression_6 = (String) cache.get(6);
        System.out.println(expression_6);

        String expression_7 = (String) cache.get(7);
        System.out.println(expression_7);

        String expression_8 = (String) cache.get(8);
        System.out.println(expression_8);

        String expression_9 = (String) cache.get(9);
        System.out.println(expression_9);

        String expression_10 = (String) cache.get(10);
        System.out.println(expression_10);

        String expression_11 = (String) cache.get(11);
        System.out.println(expression_11);

        String expression_12 = (String) cache.get(12);
        System.out.println(expression_12);

        String expression_13 = (String) cache.get(13);
        System.out.println(expression_13);

        String expression_14 = (String) cache.get(14);
        System.out.println(expression_14);

        cacheManager.close();

    }


}
