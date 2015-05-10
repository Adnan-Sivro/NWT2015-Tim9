package facade;

import dbclasses.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 * Created by Adnan on 9.5.2015..
 */
@Stateless
public class EntityFacadeImpl implements EntityFacade
{
    @PersistenceContext(unitName = "NWTPersistenceUnit")
    private EntityManager em;

    /**
     * USERS
     */

    @Override
    public User getUserById(Integer id)
    {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public User getUserByUsername(String username)
    {

        TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_USERNAME, User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public User createUser(User user)
    {
        em.persist(user);

        return user;
    }

    @Override
    public User updateUser(User user)
    {
        em.merge(user);

        return user;
    }

    @Override
    public void deleteUser(User user)
    {
        em.remove(user);
    }
/*

    @Override
    public VerificationTokens getAllTokens() {
        TypedQuery<VerificationToken> query = em.createNamedQuery(VerificationToken.FIND_ALL, VerificationToken.class);
        return new VerificationTokens(query.getResultList());
    }

    @Override
    public VerificationToken getToken(String id) {
        VerificationToken token = em.find(VerificationToken.class, id);
        return token;
    }

    @Override
    public VerificationToken updateToken(VerificationToken token) {
        em.merge(token);
        assertNotNull(token.getId());
        return token;
    }

    @Override
    public VerificationToken createToken(VerificationToken token) {
        em.persist(token);
        assertNotNull(token.getId());
        return token;
    }

    @Override
    public void deleteToken(VerificationToken token) {
        em.remove(token);
    }
    */
}