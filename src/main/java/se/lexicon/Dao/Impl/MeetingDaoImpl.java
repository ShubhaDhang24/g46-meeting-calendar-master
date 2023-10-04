package se.lexicon.Dao.Impl;

import se.lexicon.Dao.MeetingDao;
import se.lexicon.model.Meeting;

import java.util.Collection;
import java.util.Optional;

public class MeetingDaoImpl implements MeetingDao {
    @Override
    public Meeting createMeeting(Meeting meeting) {

        return null;
    }

    @Override
    public Optional<Meeting> findById(int meeting_id) {
        return Optional.empty();
    }

    @Override
    public Collection<Meeting> findAllMeetingByCalenderId(int calender_id) {
        return null;
    }

    @Override
    public boolean deleteMeeting(int meeting_id) {
        return false;
    }
}
