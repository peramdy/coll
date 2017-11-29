package com.peramdy.cp.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.peramdy.cp.constant.DruidConstants;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class DruidDs {

    public static DruidDataSource CreateDateSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(DruidConstants.DRIVER);
        druidDataSource.setUrl(DruidConstants.JDBC_URL);
        druidDataSource.setUsername(DruidConstants.USER);
        druidDataSource.setPassword(DruidConstants.PASSWORD);
        return druidDataSource;
    }

}
