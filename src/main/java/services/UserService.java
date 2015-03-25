package services;

import dbclasses.User;

import javax.ws.rs.QueryParam;
import java.sql.Timestamp;

/**
 * Created by XenoGearX on 23.3.2015.
 */
public class UserService {

    public User updateUser(int userId) {
        User user = new User();
        user.setIduser(userId);
        return user;
    }




}
