package auth.entities;

import java.io.Serializable;

/**
 * Created by Adnan on 9.5.2015..
 */
public class AuthResponseObject implements Serializable {
    String jwt;
    String message;
    Boolean isAutorized = false;
    String name;
    String id;

    public AuthResponseObject() {

    }

    public AuthResponseObject(String jwt, String message, Boolean isAutorized, String name) {
        this.jwt = jwt;
        this.message = message;
        this.isAutorized = isAutorized;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getIsAutorized() {
        return isAutorized;
    }

    public void setIsAutorized(Boolean isAutorized) {
        this.isAutorized = isAutorized;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
