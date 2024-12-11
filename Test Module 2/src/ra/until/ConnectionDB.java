package ra.until;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/quanlynhansu";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public static Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public static void closConnection(Connection conn, CallableStatement callSt) {
        if (conn != null) {
            try{
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (callSt != null) {
            try{
                callSt.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection conn, CallableStatement callSt) {
    }
}