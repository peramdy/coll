package com.peramdy.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author peramdy
 * @date 2017/12/4.
 */
public class JedisPoolsBuilder {


    public static class builder {

        private String host;
        private int port;
        private String auth;
        private int timeOut;
        private boolean isMonitor = false;


        private JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

//        private int maxTotal;
//        private boolean blockWhenExhausted;
//        private long maxWaitMillis;
//        private int minIdle;
//        private int maxIdle;
//        private boolean fairness;
//        private boolean lifo;
//        private boolean testOnBorrow;
//        private boolean testWhileIdle;
//        private boolean testOnReturn;
//        private boolean testOnCreate;
//        private long minEvictableIdleTimeMillis;
//        private String evictionPolicyClassName;
//        private long timeBetweenEvictionRunsMillis;
//        private long softMinEvictableIdleTimeMillis;
//        private int numTestsPerEvictionRun;
//        private String jmxNamePrefix;
//        private boolean jmxEnabled;
//        private String jmxNameBase;


        /**
         * 设定ip地址
         *
         * @param host
         * @return
         */
        public builder host(String host) {
            this.host = host;
            return this;
        }

        /**
         * 设定端口号
         *
         * @param port
         * @return
         */
        public builder port(int port) {
            this.port = port;
            return this;
        }


        /**
         * 设定登陆密码（没设定不关注）
         *
         * @param auth
         * @return
         */
        public builder auth(String auth) {
            this.auth = auth;
            return this;
        }

        /**
         * 连接超时时间
         *
         * @param timeOut
         * @return
         */
        public builder timeOut(int timeOut) {
            this.timeOut = timeOut;
            return this;
        }

        /**
         * @param maxTotal
         * @return
         */
        public builder maxTotal(int maxTotal) {
            this.jedisPoolConfig.setMaxTotal(maxTotal);
            return this;
        }

        /**
         * @param blockWhenExhausted
         * @return
         */
        public builder blockWhenExhausted(boolean blockWhenExhausted) {
            this.jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
            return this;
        }

        /**
         * @param maxWaitMillis
         * @return
         */
        public builder maxWaitMillis(long maxWaitMillis) {
            this.jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
            return this;
        }

        /**
         * @param minIdle
         * @return
         */
        public builder minIdle(int minIdle) {
            this.jedisPoolConfig.setMinIdle(minIdle);
            return this;
        }

        /**
         * @param maxIdle
         * @return
         */
        public builder maxIdle(int maxIdle) {
            this.jedisPoolConfig.setMaxIdle(maxIdle);
            return this;
        }


        /**
         * @param fairness
         * @return
         */
        public builder fairness(boolean fairness) {
            this.jedisPoolConfig.setFairness(fairness);
            return this;
        }

        /**
         * @param lifo
         * @return
         */
        public builder lifo(boolean lifo) {
            this.jedisPoolConfig.setLifo(lifo);
            return this;
        }

        /**
         * @param testOnBorrow
         * @return
         */
        public builder testOnBorrow(boolean testOnBorrow) {
            this.jedisPoolConfig.setTestOnBorrow(testOnBorrow);
            return this;
        }

        /**
         * @param testWhileIdle
         * @return
         */
        public builder testWhileIdle(boolean testWhileIdle) {
            this.jedisPoolConfig.setTestWhileIdle(testWhileIdle);
            return this;
        }


        /**
         * @param testOnReturn
         * @return
         */
        public builder testOnReturn(boolean testOnReturn) {
            this.jedisPoolConfig.setTestOnReturn(testOnReturn);
            return this;
        }


        /**
         * @param testOnCreate
         * @return
         */
        public builder testOnCreate(boolean testOnCreate) {
            this.jedisPoolConfig.setTestOnCreate(testOnCreate);
            return this;
        }


        /**
         * @param minEvictableIdleTimeMillis
         * @return
         */
        public builder minEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
            this.jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
            return this;
        }


        /**
         * @param evictionPolicyClassName
         * @return
         */
        public builder evictionPolicyClassName(String evictionPolicyClassName) {
            this.jedisPoolConfig.setEvictionPolicyClassName(evictionPolicyClassName);
            return this;
        }


        /**
         * @param timeBetweenEvictionRunsMillis
         * @return
         */
        public builder timeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
            this.jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
            return this;
        }


        /**
         * @param softMinEvictableIdleTimeMillis
         * @return
         */
        public builder softMinEvictableIdleTimeMillis(long softMinEvictableIdleTimeMillis) {
            this.jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(softMinEvictableIdleTimeMillis);
            return this;
        }


        /**
         * @param numTestsPerEvictionRun
         * @return
         */
        public builder numTestsPerEvictionRun(int numTestsPerEvictionRun) {
            this.jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
            return this;
        }


        /**
         * @param jmxNamePrefix
         * @return
         */
        public builder jmxNamePrefix(String jmxNamePrefix) {
            this.jedisPoolConfig.setJmxNamePrefix(jmxNamePrefix);
            return this;
        }

        /**
         * @param jmxEnabled
         * @return
         */
        public builder jmxEnabled(boolean jmxEnabled) {
            this.jedisPoolConfig.setJmxEnabled(jmxEnabled);
            return this;
        }


        /**
         * @param jmxNameBase
         * @return
         */
        public builder jmxNameBase(String jmxNameBase) {
            this.jedisPoolConfig.setJmxNameBase(jmxNameBase);
            return this;
        }

        public builder isMonitor(boolean isMonitor) {
            this.isMonitor = isMonitor;
            return this;
        }


        /**
         * @return
         */
        public JedisPool build() {
            if (isMonitor) {
                return new JedisPoolAdaptor(jedisPoolConfig, host, port, timeOut, auth);
            } else {
                return new JedisPool(jedisPoolConfig, host, port, timeOut, auth);
            }

        }

    }

}
