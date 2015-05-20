package auth.entities;

import auth.entities.ResponseMessage;

import javax.ws.rs.core.Response;

/**
 * Created by Adnan on 10.5.2015..
 */
public class ResponseMessages {
    public static final ResponseMessage
            INVALID_LOGIN=new ResponseMessage(Response.Status.UNAUTHORIZED,"1", "Invalid username or password");

    public static final ResponseMessage
            INVALID_USERNAME=new ResponseMessage(Response.Status.BAD_REQUEST,"2", "Invalid username");
}