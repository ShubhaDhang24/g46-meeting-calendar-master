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
        if(meetings==null) meetings=new ArrayList<>();
        return meetings;
    }

    public String getUserName() {
        return userName;
    }

    public MeetingCalendar(int id,String title){
        this(title);
        this.id = id;

    }
    public MeetingCalendar(String title) {
        this.title = title;
    }

    public MeetingCalendar(int id, String title, String userName) {
        this(id,title);
        this.userName = userName;
    }

    public void addMeeting(Meeting meeting)
    {   if(meetings==null) meetings= new ArrayList<>();
        meetings.add(meeting);
    }
    public void removeMeeting(Meeting meeting)
    {   if(meetings==null) throw new RuntimeException("Meeting is null");
        {
                        meetings.remove(meeting);
                        System.out.println("Meeting '" + title + "' removed successfully.");

            }
        }
        public void displayInfo()
        {
            System.out.println("id "+id+" title"+title);
        }
    }


