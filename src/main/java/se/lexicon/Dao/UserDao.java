package se.lexicon.Dao;

import se.lexicon.exception.AuthenticateFailedException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import java.util.Optional;

public interface UserDao {
    User createUser(String userName);

    Optional<User> findByUserName(String userName);

    boolean authenticate(User user) throws AuthenticateFailedException, UserExpiredException;//check if user exists or no

}
