package todolist.usecases;

import com.zaxxer.hikari.HikariDataSource;

import todolist.entities.UserEntity;
import todolist.models.UserModel;
import todolist.utils.DBConnectionUtil;

public class Userusecase {

    private HikariDataSource dataSource;
    
    private UserModel userModel;

    public UserUsecase () {
        dataSource = DBConnectionUtil.getDataSource();
        userModel = new UserModel(dataSource);
    }

    public void GetUserList() {
        UserEntity[] userList = userModel.FindAllUser();
        for (UserEntity user : userlist) {
            System.out.println("- " + user.getUserid());
        }
    }

    public void AddUser(String userid, Srtring pass) {
        UserEntity userData = new UserEntity();
        userData.setUserid(userid);
        userData.setPassword(pass);
        userModel.CreateUser(userData);
        System.out.println("Create User Succeed!");
    }

    public void ChangePasswordUser(String newuserid, String newpass) {
        UserEntity userData = new UserEntity();
        userData.setUserid(newuserid);
        userData.setPassword(newpass);
        usermodel.ChangePasswordUser(userData);
        System.out.println("Change Password Succeed!");
    }
    
}
