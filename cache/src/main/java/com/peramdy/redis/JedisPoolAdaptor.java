package com.peramdy.redis;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import java.lang.reflect.Method;
import java.net.URI;

/**
 * Created by peramdy on 2017/12/6.
 */
public class JedisPoolAdaptor extends JedisPool implements MethodInterceptor {

    private static Logger logger = LoggerFactory.getLogger(JedisPoolAdaptor.class);

    private JedisPool jedisPool;


    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host) {
        super(poolConfig, host);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class}, new Object[]{poolConfig, host});
    }

    public JedisPoolAdaptor(String host, int port) {
        super(host, port);
        proxy(new Class[]{String.class, int.class}, new Object[]{host, port});
    }

    public JedisPoolAdaptor(String host) {
        super(host);
        proxy(new Class[]{String.class}, new Object[]{host});
    }

    public JedisPoolAdaptor(String host, SSLSocketFactory sslSocketFactory,
                            SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(host, sslSocketFactory, sslParameters, hostnameVerifier);
        proxy(new Class[]{String.class, SSLSocketFactory.class, SSLParameters.class, HostnameVerifier.class},
                new Object[]{host, sslSocketFactory, sslParameters, hostnameVerifier});
    }

    public JedisPoolAdaptor(URI uri) {
        super(uri);
        proxy(new Class[]{URI.class}, new Object[]{uri});
    }

    public JedisPoolAdaptor(URI uri, SSLSocketFactory sslSocketFactory,
                            SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(uri, sslSocketFactory, sslParameters, hostnameVerifier);
        proxy(new Class[]{URI.class, SSLSocketFactory.class, SSLParameters.class, HostnameVerifier.class},
                new Object[]{uri, sslSocketFactory, sslParameters, hostnameVerifier});
    }

    public JedisPoolAdaptor(URI uri, int timeout) {
        super(uri, timeout);
        proxy(new Class[]{URI.class, int.class}, new Object[]{uri, timeout});
    }

    public JedisPoolAdaptor(URI uri, int timeout, SSLSocketFactory sslSocketFactory,
                            SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(uri, timeout, sslSocketFactory, sslParameters, hostnameVerifier);
        proxy(new Class[]{URI.class, int.class, SSLSocketFactory.class,
                        SSLParameters.class, HostnameVerifier.class},
                new Object[]{uri, timeout, sslSocketFactory, sslParameters, hostnameVerifier});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password) {
        super(poolConfig, host, port, timeout, password);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class, int.class, int.class,
                        String.class},
                new Object[]{poolConfig, host, port, timeout, password});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig,
                            String host, int port, int timeout, String password, boolean ssl) {
        super(poolConfig, host, port, timeout, password, ssl);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class, int.class, int.class,
                        String.class, boolean.class},
                new Object[]{poolConfig, host, port, timeout, password, ssl});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host,
                            int port, int timeout, String password, boolean ssl,
                            SSLSocketFactory sslSocketFactory, SSLParameters sslParameters,
                            HostnameVerifier hostnameVerifier) {
        super(poolConfig, host, port, timeout, password, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class, int.class, int.class,
                        String.class, boolean.class, SSLSocketFactory.class, SSLParameters.class, HostnameVerifier.class},
                new Object[]{poolConfig, host, port, timeout, password, ssl, sslSocketFactory, sslParameters, hostnameVerifier});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host, int port) {
        super(poolConfig, host, port);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class, int.class},
                new Object[]{poolConfig, host, port});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host, int port, boolean ssl) {
        super(poolConfig, host, port, ssl);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class, int.class, boolean.class},
                new Object[]{poolConfig, host, port, ssl});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host,
                            int port, boolean ssl, SSLSocketFactory sslSocketFactory,
                            SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(poolConfig, host, port, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class,
                        int.class, boolean.class, SSLSocketFactory.class,
                        SSLParameters.class, HostnameVerifier.class},
                new Object[]{poolConfig, host, port, ssl, sslSocketFactory, sslParameters, hostnameVerifier});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host, int port, int timeout) {
        super(poolConfig, host, port, timeout);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class,
                        int.class, int.class},
                new Object[]{poolConfig, host, port, timeout});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, boolean ssl) {
        super(poolConfig, host, port, timeout, ssl);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class,
                        int.class, int.class, boolean.class},
                new Object[]{poolConfig, host, port, timeout, ssl});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host,
                            int port, int timeout, boolean ssl, SSLSocketFactory sslSocketFactory,
                            SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(poolConfig, host, port, timeout, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class,
                        int.class, int.class, boolean.class, SSLSocketFactory.class, SSLParameters.class, HostnameVerifier.class},
                new Object[]{poolConfig, host, port, timeout, ssl, sslSocketFactory, sslParameters, hostnameVerifier});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password, int database) {
        super(poolConfig, host, port, timeout, password, database);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class,
                        int.class, int.class, String.class, int.class},
                new Object[]{poolConfig, host, port, timeout, password, database});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host, int port, int timeout,
                            String password, int database, boolean ssl) {
        super(poolConfig, host, port, timeout, password, database, ssl);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class,
                        int.class, int.class, String.class, int.class, boolean.class},
                new Object[]{poolConfig, host, port, timeout, password, database, ssl});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host, int port,
                            int timeout, String password, int database, boolean ssl,
                            SSLSocketFactory sslSocketFactory, SSLParameters sslParameters,
                            HostnameVerifier hostnameVerifier) {
        super(poolConfig, host, port, timeout, password, database, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class,
                        int.class, int.class, String.class, int.class, boolean.class, SSLSocketFactory.class,
                        SSLParameters.class, HostnameVerifier.class},
                new Object[]{poolConfig, host, port, timeout, password, database, ssl, sslSocketFactory, sslParameters, hostnameVerifier});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host, int port, int timeout,
                            String password, int database, String clientName) {
        super(poolConfig, host, port, timeout, password, database, clientName);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class,
                        int.class, int.class, String.class, int.class, String.class},
                new Object[]{poolConfig, host, port, timeout, password, database, clientName});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host, int port, int timeout,
                            String password, int database, String clientName, boolean ssl) {
        super(poolConfig, host, port, timeout, password, database, clientName, ssl);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class,
                        int.class, int.class, String.class, int.class, String.class, boolean.class},
                new Object[]{poolConfig, host, port, timeout, password, database, clientName, ssl});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host, int port,
                            int timeout, String password, int database, String clientName,
                            boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters,
                            HostnameVerifier hostnameVerifier) {
        super(poolConfig, host, port, timeout, password, database, clientName, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class, int.class,
                        int.class, String.class, int.class, String.class,
                        boolean.class, SSLSocketFactory.class, SSLParameters.class,
                        HostnameVerifier.class},
                new Object[]{poolConfig, host, port, timeout, password, database, clientName, ssl, sslSocketFactory,
                        sslParameters, hostnameVerifier});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, String host, int port,
                            int connectionTimeout, int soTimeout, String password, int database,
                            String clientName, boolean ssl, SSLSocketFactory sslSocketFactory,
                            SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(poolConfig, host, port, connectionTimeout, soTimeout, password, database, clientName, ssl,
                sslSocketFactory, sslParameters, hostnameVerifier);
        proxy(new Class[]{GenericObjectPoolConfig.class, String.class, int.class,
                        int.class, int.class, String.class, int.class, String.class,
                        boolean.class, SSLSocketFactory.class, SSLParameters.class, HostnameVerifier.class},
                new Object[]{poolConfig, host, port, connectionTimeout, soTimeout, password, database, clientName, ssl,
                        sslSocketFactory, sslParameters, hostnameVerifier});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, URI uri) {
        super(poolConfig, uri);
        proxy(new Class[]{GenericObjectPoolConfig.class, URI.class}, new Object[]{poolConfig, uri});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, URI uri,
                            SSLSocketFactory sslSocketFactory, SSLParameters sslParameters,
                            HostnameVerifier hostnameVerifier) {
        super(poolConfig, uri, sslSocketFactory, sslParameters, hostnameVerifier);
        proxy(new Class[]{GenericObjectPoolConfig.class, URI.class, SSLSocketFactory.class,
                        SSLParameters.class, HostnameVerifier.class},
                new Object[]{poolConfig, uri, sslSocketFactory, sslParameters, hostnameVerifier});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, URI uri, int timeout) {
        super(poolConfig, uri, timeout);
        proxy(new Class[]{GenericObjectPoolConfig.class, URI.class, int.class},
                new Object[]{poolConfig, uri, timeout});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, URI uri, int timeout,
                            SSLSocketFactory sslSocketFactory, SSLParameters sslParameters,
                            HostnameVerifier hostnameVerifier) {
        super(poolConfig, uri, timeout, sslSocketFactory, sslParameters, hostnameVerifier);
        proxy(new Class[]{GenericObjectPoolConfig.class, URI.class, int.class,
                        SSLSocketFactory.class, SSLParameters.class, HostnameVerifier.class},
                new Object[]{poolConfig, uri, timeout, sslSocketFactory, sslParameters, hostnameVerifier});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, URI uri, int connectionTimeout, int soTimeout) {
        super(poolConfig, uri, connectionTimeout, soTimeout);
        proxy(new Class[]{GenericObjectPoolConfig.class, URI.class, int.class, int.class},
                new Object[]{poolConfig, uri, connectionTimeout, connectionTimeout, soTimeout});
    }

    public JedisPoolAdaptor(GenericObjectPoolConfig poolConfig, URI uri, int connectionTimeout, int soTimeout,
                            SSLSocketFactory sslSocketFactory, SSLParameters sslParameters,
                            HostnameVerifier hostnameVerifier) {
        super(poolConfig, uri, connectionTimeout, soTimeout, sslSocketFactory, sslParameters, hostnameVerifier);
        proxy(new Class[]{GenericObjectPoolConfig.class, URI.class, int.class, int.class,
                        SSLSocketFactory.class, SSLParameters.class, HostnameVerifier.class},
                new Object[]{poolConfig, uri, connectionTimeout, soTimeout, sslSocketFactory, sslParameters, hostnameVerifier});
    }

    private void proxy(Class[] classes, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(JedisPool.class);
        enhancer.setCallback(this);
        jedisPool = (JedisPool) enhancer.create(classes, args);
    }

    public Object intercept(Object enhancer, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        logger.info("jedis-pool monitor");
        System.out.println("jedis-pool monitor");
        String methodName = method.getName();
        logger.info("jedis-pool method name : " + methodName);
        System.out.println("jedis-pool method name : " + methodName);
        for (Object arg : args) {
            logger.info("jedis-pool arg = " + arg.getClass().toString() + " : " + arg);
            System.out.println("jedis-pool arg = " + arg.getClass().toString() + " : " + arg);
        }

        Object result = proxy.invokeSuper(enhancer, args);

        logger.info("jedis-pool result :" + result);
        System.out.println("jedis-pool result :" + result);

        return result;
    }

    @Override
    public Jedis getResource() {
        return jedisPool.getResource();
    }

    @Override
    public void returnBrokenResource(Jedis resource) {
        jedisPool.returnBrokenResource(resource);
    }

    @Override
    public void returnResource(Jedis resource) {
        jedisPool.returnResource(resource);
    }
}
