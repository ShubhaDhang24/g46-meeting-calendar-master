package se.lexicon.model;

import java.util.ArrayList;
import java.util.List;

public class MeetingCalendar {

    // todo:
    private int id;
    private String title;
    private List<Meeting> meetings;
    private String userName;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public String getUserName() {
        return userName;
    }
    public Meeting addMeeting(Meeting meeting)
    {
        List<Meeting> newMeeting=new ArrayList<>();
        newMeeting.add(meeting);
        return meeting;
    }
    public Meeting removeMeeting(Meeting meeting)
    {
        List<Meeting>meetings1=new ArrayList<>();
        for (Meeting m:meetings1) {
            if (meeting.getTitle().equals(title)) {
                meetings1.remove(m);
                System.out.println("Meeting '" + title + "' removed successfully.");

            }
        }
        System.out.println("Meeting '" + title + "' not found.");
        return meeting;
    }

    }
