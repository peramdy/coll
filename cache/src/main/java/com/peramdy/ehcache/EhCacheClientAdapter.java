package com.peramdy.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author peramdy
 * @date 2017/12/2.
 */
public class EhCacheClientAdapter implements EhCacheAdapter {

    private static Logger logger = LoggerFactory.getLogger(EhCacheClientAdapter.class);


    private CacheManager cacheManager;

    /**
     * new instance
     *
     * @param cacheManager
     * @return
     */
    public static EhCacheClientAdapter newEhCacheClientAdapter(CacheManager cacheManager) {
        if (cacheManager == null) {
            logger.error("CacheManager is null !");
            return null;
        }
        return new EhCacheClientAdapter(cacheManager);
    }

    /**
     * constructor
     *
     * @param cacheManager
     */
    private EhCacheClientAdapter(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    /**
     * put key-value
     *
     * @param alias
     * @param key
     * @param value
     */
    public void put(String alias, String key, String value) {
        logger.info("put key {}, value {} to cache {}", key, value, alias);
        Cache cache = cacheManager.getCache(alias, String.class, String.class);
        cache.put(key, value);
    }

    /**
     * get value
     *
     * @param alias
     * @param key
     * @return
     */
    public Object get(String alias, String key) {
        logger.info("get value from cache {} by key {} ", alias, key);
        Cache cache = cacheManager.getCache(alias, String.class, String.class);
        return cache.get(key);
    }

    /**
     * remove value
     *
     * @param alias
     * @param key
     */
    public void remove(String alias, String key) {
        logger.info("remove value from cache {} by key {} ", alias, key);
        Cache cache = cacheManager.getCache(alias, String.class, String.class);
        cache.remove(alias, key);
    }

    /**
     * remove cache
     *
     * @param alias
     */
    public void remvoeCache(String alias) {
        logger.info("remove cache {} ", alias);
        cacheManager.removeCache(alias);
    }

    /**
     * inn class
     */
    public static class builder {

        private CacheManager cacheManager;

        public builder cacheManager(CacheManager cacheManager) {
            this.cacheManager = cacheManager;
            return this;
        }

        public EhCacheClientAdapter build() {
            return new EhCacheClientAdapter(cacheManager);
        }

    }

}
