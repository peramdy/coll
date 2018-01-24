package com.peramdy.serialization;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author peramdy on 2018/1/24.
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

    @Override
    public Collection<Class> getSerializableClasses() {

        List<Class> classes = new LinkedList<Class>();
        classes.add(Date.class);
        return classes;
    }
}
