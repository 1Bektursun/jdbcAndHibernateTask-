package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    Connection connection = Util.getConnection();

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users(id serial primary key ,first_name varchar,last_name varchar,age int)");
            System.out.println("Succesfully created table users ...");
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void dropUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE users");
            System.out.println("Succesfully Deleted table users ...");
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users(first_name,last_name,age) values (?,?,?);"
            );
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setInt(3,age);
            preparedStatement.executeUpdate();
            System.out.println(name + " successfully added ...");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void removeUserById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE id = ?"
            );
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            System.out.println(id + " Successfully deleted ...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> alluUserList = new ArrayList<>();
        String query = """
                select * from users;
                """;

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                alluUserList.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alluUserList;
    }

    public void cleanUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE users");
            System.out.println("Table successfully cleaned ...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}