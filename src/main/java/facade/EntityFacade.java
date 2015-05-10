package facade;
import dbclasses.User;

/**
 * Created by Adnan on 9.5.2015..
 */
public interface EntityFacade
{


    User getUserById(Integer id);

    User getUserByUsername(String username);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(User user);


   /*TOKEN

    VerificationTokens getAllTokens();

    VerificationToken getToken(String id);

    VerificationToken updateToken(VerificationToken token);

    VerificationToken createToken(VerificationToken token);

    void deleteToken(VerificationToken token);*/
}