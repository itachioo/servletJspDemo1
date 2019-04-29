package dao.impl;

import dao.IUserDao;
import entity.User;
import util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public int insertUser(User user) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String name = user.getName();
        String password = user.getPassword();
        try{
           conn = JdbcUtils.getConnection();
           st = conn.createStatement();
           String sql = "insert into user(name, password) values ('"+name+"','"+password+"')";
           int num = st.executeUpdate(sql);
           if(num>0) {
               return num;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(User user) {

        return 0;
    }

    @Override
    public int updateUserPwd(String name, String pwd) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "update user SET password=? where name = ?";
            st = conn.prepareStatement(sql);
            st.setString(1,pwd);
            st.setString(2,name);
            int num = st.executeUpdate();
            if(num>0) {
                return num;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> findUser(String name) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select * from user where name=?";
            st = conn.prepareStatement(sql);
            st.setString(1,name);
            rs = st.executeQuery();
            if(rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
