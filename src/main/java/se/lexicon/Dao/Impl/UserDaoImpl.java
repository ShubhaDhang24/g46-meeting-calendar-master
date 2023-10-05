package se.lexicon.Dao.Impl;

import se.lexicon.Dao.Impl.db.MyDbConnection;
import se.lexicon.Dao.UserDao;
import se.lexicon.exception.AuthenticateFailedException;
import se.lexicon.exception.MySqlException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User createUser(String userName) {
        String query = "Insert into USER(USERNAME,_PASSWORD) values(?, ?)";
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            User user = new User(userName);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            int updatedRow = preparedStatement.executeUpdate();
            if (updatedRow == 0) {
                throw new MySqlException("Creating rows failed . rows not affected ");
            }
            return user;
        } catch (SQLException e) {
            throw new MySqlException("Error in sql query :" + userName, e);
        }
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        String query = " select * from User where userName=?";
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String foundUserName = resultSet.getString("userName");
                String foundPassword = resultSet.getString("password");
                boolean isExpired = resultSet.getBoolean("expired");
                User user = new User(foundUserName, foundPassword, isExpired);
                return Optional.of(user);
            } else
                return Optional.empty();
        } catch (SQLException s) {
            throw new MySqlException("Error occurred could not find userName " + userName, s);
        }
    }
    @Override
    public boolean authenticate(User user) throws AuthenticateFailedException, UserExpiredException {
        //STEP1: DEFINE A QUERY
        //STEP2: CREATE PREPARED STATEMENT
        //STEP3: SET PARAMETER TO PREPARED STMT
        //STEP4: EXECUTE QUERY
        //STEP5: RESULT SET
        //STEP6: IF RESULT SET EXISTS THEN GO TO 7
        //STEP7:IF USER EXPIRED THROW EXCEPTION
        //STEP8:ELSE IF RESULTSET WAS NULL THROW EXCEPTION
        //STEP9: RETURN TRUE
        String query="select * from User where userName=?,password=?";
        try(
                PreparedStatement preparedStatement= connection.prepareStatement(query);
        ){
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                boolean isExp= resultSet.getBoolean("Expired");
                if(isExp){
                    throw  new UserExpiredException("User is no longer registered ");
                }

            }
            else throw new AuthenticateFailedException("Authentication failed ");
            return true;

        } catch (SQLException e) {
            throw new MySqlException("Error occured while authenticating user ");
        }
    }
}
