package com.peramdy.cp.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.peramdy.cp.constant.C3p0Constants;

import java.beans.PropertyVetoException;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class C3p0Ds {

    public static ComboPooledDataSource CreateDataSource() {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(C3p0Constants.DRIVER);
            dataSource.setJdbcUrl(C3p0Constants.JDBC_URL);
            dataSource.setUser(C3p0Constants.USER);
            dataSource.setPassword(C3p0Constants.PASSWORD);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}
