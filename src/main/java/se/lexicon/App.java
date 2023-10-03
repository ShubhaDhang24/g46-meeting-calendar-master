package se.lexicon;

import se.lexicon.Dao.Impl.UserDaoImpl;
import se.lexicon.Dao.Impl.db.MyDbConnection;
import se.lexicon.Dao.UserDao;
import se.lexicon.exception.AuthenticateFailedException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserDao userDao=new UserDaoImpl(MyDbConnection.getConnection());
      User createdUser= userDao.
              createUser("ADMIN");
        System.out.println(createdUser.userInfo());
        try {
           boolean isAuthenticated= userDao.authenticate(new User("admin","123456"));
        } catch (AuthenticateFailedException e) {
            throw new RuntimeException(e);
        } catch (UserExpiredException e) {
            throw new RuntimeException(e);
        }

    }
}
