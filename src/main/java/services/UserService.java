package services;

import com.sun.jersey.spi.resource.Singleton;
import dbclasses.User;

/**
 * Created by XenoGearX on 23.3.2015.
 */

@Singleton
public class UserService {

    public User updateUser(int userId) {
        User user = new User();
        user.setIduser(userId);
        return user;
    }

    public User createUser(User user) {

        return user;
    }




}
