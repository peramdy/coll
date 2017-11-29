package com.peramdy.cp.config;

import com.peramdy.cp.constant.ProxoolConstants;
import org.logicalcobwebs.proxool.ProxoolDataSource;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class ProxoolDs {

    public static ProxoolDataSource CreateDateSource() {
        ProxoolDataSource dataSource = new ProxoolDataSource();
        dataSource.setDriver(ProxoolConstants.DRIVER);
        dataSource.setDriverUrl(ProxoolConstants.JDBC_URL);
        dataSource.setUser(ProxoolConstants.USER);
        dataSource.setPassword(ProxoolConstants.PASSWORD);
        return dataSource;
    }

}
