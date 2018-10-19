package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException{
        DbManager dbManager = DbManager.getInstance();
        String sqlGetActiveUsers = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_COUNT" +
                " FROM USERS U, POSTS P" +
                " WHERE P.USER_ID = U.ID" +
                " GROUP BY U.ID HAVING COUNT(*) > 1" +
                " ORDER BY U.ID";

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlGetActiveUsers);

        String record1 = "John Smith, 2 posts total.";
        String record2 = "Zachary Lee, 2 posts total.";

        int postsCounter = 0;
        while(rs.next()){
            int postsNumber = rs.getInt("POSTS_COUNT");

            String singleRecord = rs.getString("FIRSTNAME") + " " +
                    rs.getString("LASTNAME") + ", " +
                    postsNumber + " posts total.";

            System.out.println(singleRecord);
            postsCounter += postsNumber;
            Assert.assertTrue(singleRecord.equals(record1) || singleRecord.equals(record2));
        }
        rs.close();
        statement.close();
        Assert.assertEquals(postsCounter, 4);
    }
}

