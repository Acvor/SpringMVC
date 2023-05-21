package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.UserDao;
import cn.edu.guet.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public int saveUser(User user){
        int nowId=1;
        Connection conn = DBConnection.getConn();
        PreparedStatement pstmt;//Statement：语句，PreparedStatement：预编译语句对象
        String sql = "SELECT * FROM \"users\"";
        ResultSet rs = null;
        try {
            System.out.println("Connection State:"+conn);
            pstmt = conn.prepareStatement(sql);
            //先找当前id的值
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if(rs.getInt("id")>=nowId) {
                    nowId = rs.getInt("id");
                    nowId++;
                }
            }

            conn.setAutoCommit(false);
            if (user.getUsername()==null || user.getAddress() == null) return 0;
            String Insql = "INSERT INTO \"users\"(\"id\",\"username\",\"address\") VALUES(?,?,?)";
            pstmt = conn.prepareStatement(Insql);
            pstmt.setInt(1, nowId);
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getAddress());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            DBConnection.closeConn(conn);
        }
        return 0;
    }

    @Override
    public List<User> viewUser() {
        Connection conn = DBConnection.getConn();
        PreparedStatement pstmt;//Statement：语句，PreparedStatement：预编译语句对象
        String sql = "SELECT * FROM \"users\"";
        ResultSet rs = null;//结果集
        List<User> userList = new ArrayList<>();
        try {
            System.out.println("Connection State:"+conn);
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id");
                String username = rs.getString("username");
                String address = rs.getString("address");
                User user = new User(id,username,address);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeConn(conn);
        }
        return userList;
    }

    @Override
    public void deleteUser(String id) {
        Connection conn = DBConnection.getConn();
        PreparedStatement pstmt;//Statement：语句，PreparedStatement：预编译语句对象
        String sql = "DELETE  FROM \"users\" WHERE \"id\"=?";
        try {
            System.out.println("Connection State:"+conn);
            conn.setAutoCommit(false);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //有异常就回滚
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            DBConnection.closeConn(conn);
        }
    }

    @Override
    public void updateUser(String id, String username, String address) {
        Connection conn = null;
        PreparedStatement pstmt;//Statement：语句，PreparedStatement：预编译语句对象
        String url="jdbc:oracle:thin:@106.52.247.48:1521:orcl";
        String sql = "UPDATE  \"users\" SET \"username\"=?,\"address\"=? WHERE \"id\"=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//1.
            conn= DriverManager.getConnection(url,"hgs","Grcl1234U");//2.
            System.out.println("Connection State:"+conn);
            conn.setAutoCommit(false);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, address);
            pstmt.setString(3, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            //有异常就回滚
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
