package se.lexicon.Dao.Impl;

import se.lexicon.Dao.MeetingCalendarDao;
import se.lexicon.exception.MySqlException;
import se.lexicon.model.MeetingCalendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class MeetingCalendarDaoImpl implements MeetingCalendarDao {
    Connection connection;

    public MeetingCalendarDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public MeetingCalendar createMeetingCalender(String userName, String title) {
        String query = "INSERT INTO Meeting_calender(userName,title)values(?,?)";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            MeetingCalendar meetingCalendar = new MeetingCalendar(userName, title);
            preparedStatement.setString(2, meetingCalendar.getUserName());
            preparedStatement.setString(3, meetingCalendar.getTitle());
            int updatedRow = preparedStatement.executeUpdate();
            if (updatedRow == 0) {
                throw new MySqlException("Creating meeting calender failed . rows not affected ");
            }
            try(
                ResultSet  generatedKeys=preparedStatement.getGeneratedKeys()){
                if(generatedKeys.next()){
                    int calender_id=generatedKeys.getInt(1);
                    return new MeetingCalendar(calender_id,title,userName);
                }
                else {
                    String errorMsg="Error in  creating meeting calender";
                    System.out.println(errorMsg);
                    throw  new MySqlException(errorMsg);

                }
            }

        } catch (SQLException s) {
            String errorMsg="Error occured while creating meeting calender";
            throw  new MySqlException(errorMsg);
        }
    }

    @Override
    public Optional<MeetingCalendar> findById(int id)  {
        String query="Select * from Meeting_calender where id=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                String name=resultSet.getString("USERNAME");
                String title=resultSet.getString("Title");
                return Optional.of(new MeetingCalendar(id, title, name));
            }
        } catch (SQLException e) {
            String errMsg="error occurred while finding by ID";
            throw new RuntimeException(errMsg,e);
        }

        return Optional.empty();
    }

    @Override
    public Collection<MeetingCalendar> findByUserName(String userName) {
        String query="Select * from meeting_calender where USERNAME=?";
        List<MeetingCalendar> newList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(query);

            preparedStatement.setString(2,"userName");
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int id= resultSet.getInt("id");
                String name=resultSet.getString("USERNAME");
                String title=resultSet.getString("Title");
                newList.add(new MeetingCalendar(id,title,userName));
            }
        } catch (SQLException e) {
            String msg="Error while find by username ";
            throw new RuntimeException(msg,e);
        }
        return newList;
    }

    @Override
    public boolean deleteCalender(int id) {

        return false;
    }
}
