package se.lexicon.Dao;

import se.lexicon.model.Meeting;

import java.util.Collection;
import java.util.Optional;

public interface MeetingDao {
Meeting createMeeting(Meeting meeting);
Optional<Meeting>findById(int meeting_id);
Collection<Meeting> findAllMeetingByCalenderId(int calender_id);
boolean deleteMeeting(int meeting_id);

}
