package com.peramdy.redis;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by peramdy on 2017/12/6.
 */
public class Proxy implements MethodInterceptor {


    public Object getProxy(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("before");
        Object object = proxy.invokeSuper(obj, args);
        System.out.println("after");

        return object;
    }
}
