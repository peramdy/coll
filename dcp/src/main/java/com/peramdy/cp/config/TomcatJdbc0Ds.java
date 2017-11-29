package com.peramdy.cp.config;

import com.peramdy.cp.constant.TomcatJdbcConstants;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class TomcatJdbc0Ds {

    public static DataSource CreateDataSource() {

        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(TomcatJdbcConstants.DRIVER);
        dataSource.setUrl(TomcatJdbcConstants.JDBC_URL);
        dataSource.setUsername(TomcatJdbcConstants.USER);
        dataSource.setPassword(TomcatJdbcConstants.PASSWORD);
        return dataSource;
    }

}
