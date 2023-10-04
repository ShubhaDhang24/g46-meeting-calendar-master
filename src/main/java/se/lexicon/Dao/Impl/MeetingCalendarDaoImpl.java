package se.lexicon.Dao.Impl;

import se.lexicon.Dao.MeetingCalendarDao;
import se.lexicon.exception.MySqlException;
import se.lexicon.model.MeetingCalendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public class MeetingCalendarDaoImpl implements MeetingCalendarDao {
    Connection connection;

    public MeetingCalendarDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public MeetingCalendar createMeetingCalender(String userName, String title) {
        String query = "INSERT INTO Meeting_calender(userName,title)values(? ?)";
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
            return meetingCalendar;

        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
        return null;
    }

    @Override
    public Optional<MeetingCalendar> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<MeetingCalendar> findByUserName(String userName) {
        return null;
    }

    @Override
    public boolean deleteCalender(int id) {
        return false;
    }
}
