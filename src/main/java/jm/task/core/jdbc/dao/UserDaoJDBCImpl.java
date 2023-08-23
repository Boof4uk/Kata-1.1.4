package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, " +
                "lastName VARCHAR(50) NOT NULL, " +
                "age TINYINT NOT NULL)";

        try (Connection connection = JDBCConnection.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            System.out.println("Не удалось создать таблицу :(");
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE users";
        try(Connection connection = JDBCConnection.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            System.out.println("Не удалось удалить таблицу :(");
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO users (name, lastname, age) VALUES(?, ?, ?)";
        try (Connection connection = JDBCConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            System.out.println("Не удалось сохранить пользователя :(");

        }

    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try(Connection connection = JDBCConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Пользователь удален");
        } catch (SQLException e) {
            System.out.println("Не удалось удалить пользователя :(");

        }

    }

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection connection = JDBCConnection.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                user.setId(resultSet.getLong("id"));
                usersList.add(user);

            }
        } catch (SQLException e) {
            System.out.println("Не удалось получить список пользователей :(");
        }
        System.out.println(usersList);
        return usersList;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM users";
        try(Connection connection = JDBCConnection.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Таблица очищена");
        } catch (SQLException e) {
            System.out.println("Не удалось очистить таблицу :(");
        }
    }
}
