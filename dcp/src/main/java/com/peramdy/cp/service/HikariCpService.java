package com.peramdy.cp.service;

import com.peramdy.cp.constant.BasicConstants;
import com.peramdy.cp.dao.QueryDao;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class HikariCpService {

    public static void queryHikariCp(HikariDataSource ds, Integer executeCount) {

        QueryDao dao = new QueryDao();

        /**
         * initial execute
         */
        for (int i = 0; i < BasicConstants.INITIAL_COUNT; i++) {
            try {
                dao.query(ds.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * execute sql
         */
        long startTime = System.currentTimeMillis();
        for (int n = 0; n < executeCount; n++) {
            try {
                dao.query(ds.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.println("HikariCp spent " + (endTime - startTime) + " millis executing sql!");

    }

}
