package com.peramdy.ehcache;

/**
 * @author peramdy
 * @date 2017/12/2.
 */
public interface EhCacheAdapter {

    /**
     * put key-value
     *
     * @param alias
     * @param key
     * @param value
     */
    void put(String alias, String key, String value);

    /**
     * get value
     *
     * @param alias
     * @param key
     * @return
     */
    Object get(String alias, String key);

    /**
     * remove key
     *
     * @param alias
     * @param key
     */
    void remove(String alias, String key);

    /**
     * remove cache
     *
     * @param alias
     */
    void remvoeCache(String alias);

}
