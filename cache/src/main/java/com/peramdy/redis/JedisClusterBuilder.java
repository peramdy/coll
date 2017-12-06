package com.peramdy.redis;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author peramdy
 * @date 2017/12/5.
 */
public class JedisClusterBuilder {

    public static class builder {

        private String addressConfigs;

        private Integer timeOut;

        private Integer maxTotal;

        private boolean isMonitor = false;

        private GenericObjectPoolConfig genericObjectPoolConfig;

        private Pattern p = Pattern.compile("^.+[:]\\d{1,5}\\s*$");


        public builder addressConfigs(String addressConfigs) {
            this.addressConfigs = addressConfigs;
            return this;
        }

        public builder timeOut(Integer timeOut) {
            this.timeOut = timeOut;
            return this;
        }

        public builder maxTotal(Integer maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public builder isMonitor(boolean isMonitor) {
            this.isMonitor = isMonitor;
            return this;
        }

        public builder poolConfig(GenericObjectPoolConfig poolConfig) {
            this.genericObjectPoolConfig = poolConfig;
            return this;
        }


        public JedisCluster build() {
            if (isMonitor) {
                return new JedisClusterAdaptor(parseHostAndPort(), timeOut, maxTotal, genericObjectPoolConfig);
            } else {
                return new JedisCluster(parseHostAndPort(), timeOut, maxTotal, genericObjectPoolConfig);
            }

        }


        private Set<HostAndPort> parseHostAndPort() {
            try {
                if (StringUtils.isBlank(addressConfigs)) {
                    throw new IllegalArgumentException("未配置redis集群ip地址！");
                }
                String[] address = addressConfigs.split(",");
                Set<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();
                for (String ipPort : address) {
                    boolean isIpPort = p.matcher(ipPort).matches();
                    if (!isIpPort) {
                        throw new IllegalArgumentException("ip 或 port 不合法:" + ipPort);
                    }
                    String[] ipAndPort = ipPort.split(":");
                    HostAndPort hap = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
                    hostAndPorts.add(hap);
                }
                return hostAndPorts;
            } catch (IllegalArgumentException ex) {
                throw ex;
            } catch (Exception ex) {
                throw new IllegalArgumentException("解析 jedis 配置文件失败", ex);
            }
        }
    }

}
