package com.peramdy.memcache;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeoutException;

/**
 * @author peramdy
 * @date 2017/12/8.
 */
public class HelloWord {

    private MemCachedClient memCachedClient = new MemCachedClient();


    /**
     * spyMemcached
     */
    public void simpleOne() {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("192.168.136.130", 11211);
        try {
            MemcachedClient memcachedClient = new MemcachedClient(inetSocketAddress);
            memcachedClient.add("memcached-sp", 1, "hello world <sp>!");
            System.out.println(memcachedClient.get("memcached-sp"));
            memcachedClient.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * XMemcached
     * <p>
     * xmemcached简介
     * xmemcached是一个新java memcached client。简单来说，Memcached 是一个高性能的分布式内存对象的key-value缓存系统，用于动态Web应用以减轻数据库负载，现在也有很多人将它作为内存式数据库在使用，memcached通过它的自定义协议与客户端交互，而XMemcached就是它的一个java客户端实现。
     * Memcached的java客户端已经存在两个了：官方提供的基于传统阻塞io的客户端 、Dustin Sallings实现的基于java nio的spymemcached 。另外还有一些在此基础上的改进版本。
     * <p>
     * XMemcached的主要特性
     * <p>
     * 高性能
     * XMemcached同样是基于java nio的客户端，java nio相比于传统阻塞io模型来说，有效率高（特别在高并发下）和资源耗费相对较少的优点。传统阻塞IO为了提高效率，需要创建一定数量的连接形成连接池，而nio仅需要一个连接即可（当然,nio也是可以做池化处理），相对来说减少了线程创建和切换的开销，这一点在高并发下特别明显。因此XMemcached与Spymemcached在性能都非常优秀，在某些方面（存储的数据比较小的情况下）Xmemcached比Spymemcached的表现更为优秀，具体可以看这个 Java Memcached Clients Benchmark 。
     * <p>
     * 支持完整的协议
     * Xmemcached支持所有的memcached协议，包括1.4.0正式开始使用的 二进制协议 。
     * <p>
     * 支持客户端分布
     * Memcached的分布只能通过客户端来实现，XMemcached实现了此功能，并且提供了一致性哈希(consistent hash)算法的实现。
     * <p>
     * 允许设置节点权重
     * XMemcached允许通过设置节点的权重来调节memcached的负载，设置的权重越高，该memcached节点存储的数据将越多，所承受的负载越大。
     * <p>
     * 动态增删节点
     * XMemcached允许通过JMX或者代码编程实现节点的动态添加或者移除，方便用户扩展和替换节点等。
     * <p>
     * 支持JMX
     * XMemcached通过JMX暴露的一些接口，支持client本身的监控和调整，允许动态设置调优参数、查看统计数据、动态增删节点等。
     * <p>
     * xmemcached的分布式
     * 由于memcached不支持服务器端分布式，所以memcached的分布只能通过客户端来实现，xmemcached实现了此功能，并且提供了一致性哈希(consistent hash)算法的实现，关于一致性hashing见http://kb.cnblogs.com/page/42734/
     * 需要说明的是这还只是客户端分布式，不支持主从，各个节点其实还是单独存储，并且未实现存储冗余，节点挂了数据就会相应得丢失
     * 具有如下优势：
     * <p>
     * xmemcached支持的存储对象
     * xmemcached支持的存储比较简单，只要实现了java序列化接口（Serializable接口）的对象就可以存储，当然可以包含Map、Set、List这些复杂对象
     * xmemcached的容错性
     * <p>
     * 如果当前连接了3个服务器端，其中有一个突然挂掉，那么执行client操作时会抛出异常，但是如果memcached.failureMode=true设置成false那么就不抛出异常，只不过你查询的那个数据显示为null
     * 由于是客户端分布式，所以并未实现存储冗余，如果要冗余需要自己实现代码
     */
    public void simpleTwo() {
        MemcachedClientBuilder memcachedClientBuilder = new XMemcachedClientBuilder("192.168.136.130:11211");
        try {
            net.rubyeye.xmemcached.MemcachedClient memcachedClient = memcachedClientBuilder.build();
            memcachedClient.add("memcached-x", 1, "hello world <x>!");
            System.out.println(memcachedClient.get("memcached-x"));
            memcachedClient.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    static {

        SockIOPool pool = SockIOPool.getInstance();
        String[] server = {"192.168.136.130:11211"};
        pool.setServers(server);
        pool.setInitConn(10);
        pool.setInitConn(10); // 设置初始连接
        pool.setMinConn(5);// 设置最小连接
        pool.setMaxConn(250); // 设置最大连接
        pool.setMaxIdle(1000 * 60 * 60 * 3); // 设置每个连接最大空闲时间3个小时
        pool.setMaintSleep(30);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setAliveCheck(true);
        pool.initialize();

    }

    /**
     * Memcached-Java-Client
     */
    public void simpleThree() {
        memCachedClient.add("memcached-java", "hello world <java>!");
        System.out.println(memCachedClient.get("memcached-java"));
    }


}
