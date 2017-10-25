package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    Connection connection;
    Statement st;
    ResultSet rs;
    public List<User> userList;

    public List<User> getUserById(int id) {
        userList = new ArrayList();
        String sql = "SELECT * FROM users WHERE id = " + id;
        try {
            connection = getConn();
            st = connection.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setAge(rs.getInt("age"));
                userList.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return userList;

    }

    public Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
