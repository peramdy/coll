package com.peramdy.cp.dao;

import com.peramdy.cp.constant.BasicConstants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author peramdy
 * @date 2017/11/29.
 */
public class QueryDao {

    /**
     * query sql
     *
     * @param connection
     */
    public void query(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(BasicConstants.SQL);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
