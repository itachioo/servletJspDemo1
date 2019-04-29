package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String driver = null;
    private static String username = null;
    private static String password = null;
    private static String url = null;

    static{
        try{
            InputStream in  = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties prop = new Properties();
            prop.load(in);

            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username, password );
    }

    public static void relsase(Connection conn, Statement st, ResultSet rs) {
        if(rs != null) {
            try{
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st != null) {
            try{
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            st = null;
        }
        if(conn != null) {
            try{
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
