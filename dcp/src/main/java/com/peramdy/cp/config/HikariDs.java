package com.peramdy.cp.config;

import com.peramdy.cp.constant.HikariCpConstants;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class HikariDs {

    public static HikariDataSource CreateDateSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(HikariCpConstants.DRIVER);
        config.setJdbcUrl(HikariCpConstants.JDBC_URL);
        config.setUsername(HikariCpConstants.USER);
        config.setPassword(HikariCpConstants.PASSWORD);
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

}
