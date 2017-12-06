package com.peramdy.ehcache;

import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.ResourcePools;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.xml.XmlConfiguration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class EhcacheManager {

    /**
     * xmlPath 路径
     */
    private String xmlConfigUrl;

    /**
     * alias 别名
     */
    private String alias;

    /**
     * heap 堆
     */
    private Integer heap;

    /**
     * offHeap 外堆
     */
    private Integer offHeap;

    /**
     * disk 磁盘大小
     */
    private Integer disk;

    /**
     * persistencePath 持久化路径
     */
    private String persistencePath;

    /**
     * persistenceFileName 持久化文件名称
     */
    private String persistenceFileName;

    /**
     * persistent 是否持久化
     */
    private boolean persistent = false;


    /**
     * xml configuration  constructor
     *
     * @param xmlConfigUrl
     */
    protected EhcacheManager(String xmlConfigUrl) {
        this.xmlConfigUrl = xmlConfigUrl;
    }

    /**
     * alias and heap constructor
     *
     * @param alias
     * @param heap
     */
    protected EhcacheManager(String alias, Integer heap) {
        this.alias = alias;
        this.heap = heap;
    }


    /**
     * alias | heap | offHeap constructor
     *
     * @param alias
     * @param heap
     * @param offHeap
     */
    protected EhcacheManager(String alias, Integer heap, Integer offHeap) {
        this.alias = alias;
        this.heap = heap;
        this.offHeap = offHeap;
    }


    /**
     * handler constructor
     *
     * @param alias
     * @param heap
     * @param offHeap
     * @param disk
     * @param persistencePath
     * @param persistenceFileName
     * @param persistent
     */
    protected EhcacheManager(String alias, Integer heap, Integer offHeap,
                             Integer disk, String persistencePath,
                             String persistenceFileName, boolean persistent) {
        this.alias = alias;
        this.heap = heap;
        this.offHeap = offHeap;
        this.disk = disk;
        this.persistencePath = persistencePath;
        this.persistenceFileName = persistenceFileName;
        this.persistent = persistent;
    }

    public String getXmlConfigUrl() {
        return xmlConfigUrl;
    }

    public String getAlias() {
        return alias;
    }

    public Integer getHeap() {
        return heap;
    }

    public Integer getOffHeap() {
        return offHeap;
    }

    public Integer getDisk() {
        return disk;
    }

    public String getPersistencePath() {
        return persistencePath;
    }

    public String getPersistenceFileName() {
        return persistenceFileName;
    }

    public boolean isPersistent() {
        return persistent;
    }

    /**
     * create cacheManager by xml file
     *
     * @return
     */
    public CacheManager CreateCacheManagerXml() {

        if (xmlConfigUrl == null) {
            return null;
        }

        File file = new File(xmlConfigUrl);
        URI uri = file.toURI();
        URL url = null;
        try {
            url = uri.toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        XmlConfiguration xmlConfig = new XmlConfiguration(url);
        CacheManager cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        cacheManager.init();
        return cacheManager;
    }


    /**
     * create cacheManager
     *
     * @return
     */
    public CacheManager CreateCacheManager() {

        ResourcePoolsBuilder resourcePoolsBuilder = ResourcePoolsBuilder.newResourcePoolsBuilder();

        ResourcePools resourcePools = null;

        if (heap != null && offHeap == null && !persistent) {
            resourcePools = resourcePoolsBuilder
                    //堆
                    .heap(heap, EntryUnit.ENTRIES)
                    .build();
        }
        if (heap != null && offHeap != null && !persistent) {
            resourcePools = resourcePoolsBuilder
                    //堆
                    .heap(heap, EntryUnit.ENTRIES)
                    //外堆
                    .offheap(offHeap, MemoryUnit.MB)
                    .build();
        }

        if (persistent) {
            resourcePools = resourcePoolsBuilder
                    //堆
                    .heap(heap == null ? 10 : heap, EntryUnit.ENTRIES)
                    //外堆
                    .offheap(offHeap == null ? 16 : offHeap, MemoryUnit.MB)
                    //磁盘
                    .disk(disk == null ? 1 : disk, MemoryUnit.GB)
                    .build();
        }
        if (resourcePools == null) {
            return null;
        }


        CacheConfiguration<String, String> cacheConfiguration = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, String.class, resourcePools)
                //失效时间
                .withExpiry(Expirations.timeToIdleExpiration(Duration.of(1, TimeUnit.DAYS)))
                .build();


        CacheManager cacheManager = null;

        /**
         * persistent
         */
        if (persistent) {
            cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                    //持久化
                    .with(CacheManagerBuilder.persistence(persistencePath + File.separator + persistenceFileName))
                    .build();
        } else {
            cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        }
        cacheManager.init();

        if (alias == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String nowStr = sdf.format(new Date());
            alias = "default_" + nowStr;
        }
        cacheManager.createCache(alias, cacheConfiguration);
        return cacheManager;
    }


    /**
     * close cacheManager
     *
     * @param cacheManager
     */
    public void CloseCacheManager(CacheManager cacheManager) {
        if (cacheManager != null) {
            cacheManager.close();
        }
    }


    /**
     * inn class
     */
    public static class builder {

        private String xmlConfigPath;
        private String alias;
        private Integer heap;
        private Integer offHeap;
        private Integer disk;
        private String persistencePath;
        private Boolean persistent = false;
        private String persistenceFileName;

        /**
         * default constructor
         */
        public builder() {

        }

        /**
         * add xmlConfigPath
         *
         * @param xmlConfigPath
         * @return
         */
        public builder xmlConfigPath(String xmlConfigPath) {
            this.xmlConfigPath = xmlConfigPath;
            return this;
        }

        /**
         * add alias
         *
         * @param alias
         * @return
         */
        public builder alias(String alias) {
            this.alias = alias;
            return this;
        }

        /**
         * add heap
         *
         * @param heap
         * @return
         */
        public builder heap(Integer heap) {
            this.heap = heap;
            return this;
        }

        /**
         * add offHeap
         *
         * @param offHeap
         * @return
         */
        public builder offHeap(Integer offHeap) {
            this.offHeap = offHeap;
            return this;
        }

        /**
         * add disk
         *
         * @param disk
         * @return
         */
        public builder disk(Integer disk) {
            this.disk = disk;
            return this;
        }

        /**
         * add persistencePath
         *
         * @param persistencePath
         * @return
         */
        public builder persistencePath(String persistencePath) {
            this.persistencePath = persistencePath;
            return this;
        }

        /**
         * persistent or not
         *
         * @param persistent
         * @return
         */
        public builder persistent(Boolean persistent) {
            if (persistent == null) {
                this.persistent = false;
            } else {
                this.persistent = persistent;
            }
            return this;
        }

        /**
         * add persistent file
         *
         * @param fileName 文件名称
         * @return
         */
        public builder persistenceFileName(String fileName) {
            if (fileName == null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String nowStr = sdf.format(new Date());
                this.persistenceFileName = nowStr;
            } else {
                this.persistenceFileName = fileName;
            }
            return this;
        }


        /**
         * build EhcacheManager
         *
         * @return
         */
        public EhcacheManager build() {
            if (xmlConfigPath != null) {
                return new EhcacheManager(xmlConfigPath);
            } else if (persistent) {
                if (persistencePath == null) {
                    String osName = System.getProperty("os.name");
                    if (osName.contains("Windows")) {
                        persistencePath = "d:";
                    } else {
                        persistencePath = "/usr/local/";
                    }
                }
                if (persistenceFileName == null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String nowStr = sdf.format(new Date());
                    persistenceFileName = nowStr;
                }
                return new EhcacheManager(alias, heap, offHeap, disk, persistencePath, persistenceFileName, persistent);
            } else {
                return new EhcacheManager(alias, heap, offHeap);
            }
        }
    }


}
