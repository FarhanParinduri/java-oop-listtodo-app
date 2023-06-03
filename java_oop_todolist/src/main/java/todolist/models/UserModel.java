package todolist.models;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import todolist.entities.UserEntity;

public class UserModel {
    
    private DataSource dataSource;

    public UserModel(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void CreateUser (UserEntity user) {
        String sql = "INSERT INTO user VALUES (?, ?, now())";

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
                 ) {
            stmt.setString(1, user.getUserid());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public UserEntity[] FindAllUser() {
        String sql = "SELECT * FROM USER";

        try(
                Connection connection = dataSource.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql)
        ) {
            List<UserEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                UserEntity user = new UserEntity();
                user.setUserid(resultSet.getString("userid"));
                list.add(user);
            }

            return list.toArray(new UserEntity[]{});
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
