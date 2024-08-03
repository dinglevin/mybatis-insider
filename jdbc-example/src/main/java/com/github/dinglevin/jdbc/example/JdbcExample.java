package com.github.dinglevin.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.github.dinglevin.jdbc.example.model.User;

public class JdbcExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";
        String username = "admin";
        String password = "admin123";

        try {
            // 1. 加载数据库驱动程序（可选，现代JDBC不需要手动加载驱动）
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 建立数据库连接
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. 创建 SQL 查询语句
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 1);

            // 4. 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery();

            // 5. 处理结果集
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));

                System.out.println("ID: " + user.getId());
                System.out.println("Name: " + user.getName());
                System.out.println("Email: " + user.getEmail());
            }

            // 6. 关闭资源
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Exit");
            System.exit(0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}