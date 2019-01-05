package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"NOT SET\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        String sqlCount = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL = \"NOT SET\"";
        ResultSet rs = statement.executeQuery(sqlCount);
        int counter = -1;
        if(rs.next()){
            counter = rs.getInt("HOW_MANY");
        }
        assertEquals(0, counter);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER= -1";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);

        String sqlCount = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = -1";
        ResultSet rs = statement.executeQuery(sqlCount);
        int counter = -1;
        if(rs.next()){
            counter = rs.getInt("HOW_MANY");
        }
        assertEquals(0, counter);
    }
}
