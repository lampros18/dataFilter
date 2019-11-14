package gr.hua.dit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseManager {

    private String myDriver;
    private String myUrl;
    private Connection conn;
    private PreparedStatement preparedStmt;
    private String query;

    public void connect() {
        try {
            // create a mysql database connection
            myDriver = "com.mysql.cj.jdbc.Driver";
            myUrl = "jdbc:mysql://0.0.0.0:3306/db?rewriteBatchedStatements=true";
            Class.forName(myDriver);
            conn = DriverManager.getConnection(myUrl, "", "");

            // the mysql insert statement
            query = " insert into data_2015_2018_commercial (YEAR, MONTHS, COUNTRY, REGION, CITY, POSTAL_CODE, REGISTRATION_COUNT)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";
            preparedStmt = conn.prepareStatement(query);

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public void insertData(ArrayList<Record> records) {
        try{
            int i = 0;
            for (Record record : records) {
                preparedStmt.setInt(1, record.getYear());
                preparedStmt.setString(2, record.getMonths());
                preparedStmt.setString(3, record.getCountry());
                preparedStmt.setString(4, record.getRegion());
                preparedStmt.setString(5, record.getCity());
                preparedStmt.setString(6, record.getPostalCode());
                preparedStmt.setInt(7, record.getRegistrationCount());
                preparedStmt.addBatch();
                i++;

                if (i % 50000 == 0 || i == records.size()) {
                    preparedStmt.executeBatch();
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            preparedStmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}