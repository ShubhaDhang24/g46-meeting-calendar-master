package se.lexicon.Dao.Impl;

import se.lexicon.Dao.Impl.db.MyDbConnection;
import se.lexicon.Dao.UserDao;
import se.lexicon.exception.AuthenticateFailedException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    @Override
    public User createUser(String userName) {
        String query=" ";

            try (Connection connection = MyDbConnection.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
            }
            catch (SQLException e) {

        }

        return null;
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.empty();
    }

    @Override
    public boolean authenticate(User user) throws AuthenticateFailedException, UserExpiredException {
        return false;
    }
}
