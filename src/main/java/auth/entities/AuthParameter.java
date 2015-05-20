package auth.entities;

import java.io.Serializable;

/**
 * Created by Adnan on 9.5.2015..
 */
public class AuthParameter implements Serializable {
    String username;
    String password;

    public AuthParameter() {
    }

    public AuthParameter(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}