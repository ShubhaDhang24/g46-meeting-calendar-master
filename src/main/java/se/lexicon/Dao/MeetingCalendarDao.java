package se.lexicon.Dao;

import se.lexicon.model.MeetingCalendar;

import java.util.Collection;
import java.util.Optional;

public interface MeetingCalendarDao {

    MeetingCalendar createMeetingCalender(String userName, String title);

    Optional<MeetingCalendar>findById(int id);
    //display meeting to user
    Collection<MeetingCalendar> findByUserName(String userName);
    boolean deleteCalender(int id);


}
