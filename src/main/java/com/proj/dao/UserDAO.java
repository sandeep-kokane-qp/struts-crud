package com.proj.dao;

import com.proj.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDAO {

    private static final String SELECT_FROM_USER = "SELECT * from User";
    private static final String INSERT_INTO_USER = "INSERT INTO User values (?,?,?,?,?)";
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DELETE_USER_BY_ID = "DELETE FROM User WHERE id=?";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM User WHERE id=?";
    private static final String UPDATE_USER_BY_ID = "UPDATE User SET firstName=?, lastName=?,email=?,city=? WHERE id=?";

    private static Connection getConnection() {
        try {
            Class.forName(MYSQL_DRIVER);
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "Sandy@1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int insert(User user) {
        System.out.println("UserDAO.insert");
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT_INTO_USER);
            preparedStatement.setString(1, String.valueOf(UUID.randomUUID()));
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getCity());

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static List<User> readAllUsers() {
        System.out.println("UserDAO.readAllUsers");

        List<User> userList = new ArrayList<>();

        try {
            Statement statement =
                    getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_USER);


            while (resultSet.next()) {
                userList.add(getUser(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

    public static User getUserById(String id) {
        System.out.println("UserDAO.getUserById");
        try {

            PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return getUser(resultSet);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static User getUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getString(1));
        user.setFirstName(resultSet.getString(2));
        user.setLastName(resultSet.getString(3));
        user.setEmail(resultSet.getString(4));
        user.setCity(resultSet.getString(5));

        return user;
    }

    public static int update(User user) {
        System.out.println("UserDAO.update");

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(UPDATE_USER_BY_ID);
            preparedStatement.setString(5, user.getId());
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCity());

            int update = preparedStatement.executeUpdate();
            System.out.println(update);
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static void delete(String id) {
        System.out.println("UserDAO.delete");
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setString(1, id);
            boolean execute = preparedStatement.execute();
            System.out.println("Deleted :: " + execute);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
