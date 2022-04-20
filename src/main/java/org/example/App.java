package org.example;

import org.example.util.Db;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
//        System.out.println(getUserCount());
//        addUser(3,"Ariet",23);
//        System.out.println(getUserCount());
        printUsers();

    }


    public static int getUserCount() {
        String sql = "select count(*) from users";
        int count = 0;
        try (Connection conn = Db.connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public static void addUser(int id, String name, int age) {
        String sql = "insert into users(id,name,age) values(?,?,?)";
        try (Connection conn = Db.connection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, age);
            statement.executeUpdate();
            System.out.println("Successfully added : " + name);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public static void printUsers(){
        String SQL = "SELECT * FROM users";
        try {Connection connection = Db.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
                while (resultSet.next()){
                    System.out.println(resultSet.getInt("Id") + ""+ resultSet.getString("name")+
                            resultSet.getInt("age"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}