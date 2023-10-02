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
        if(this.meetings==null) meetings=new ArrayList<>();
        return meetings;
    }

    public String getUserName() {
        return userName;
    }

    //constructor1 to fetch data from database
    public MeetingCalendar(int id,String title, String userName){
        this(title,userName);
        this.id = id;

    }
    //constructor 2 to search for specific
    public MeetingCalendar(String title) {
        this.title = title;
    }


    //constructor3 create a meeting calendar chaining constructor
    public MeetingCalendar( String title, String userName) {
        this(title);
        this.userName = userName;
    }

    public void addMeeting(Meeting meeting)
    {   if(meetings==null) meetings= new ArrayList<>();
        meetings.add(meeting);
    }
    public void removeMeeting(Meeting meeting)
    {   if(meetings==null) throw new RuntimeException("Meeting is null");
        {
            if(meeting==null) throw new RuntimeException("Meeting data is null");
                        meetings.remove(meeting);
                        System.out.println("Meeting '" + title + "' removed successfully.");

            }
        }
        public String displayCalendarInfo()
        {
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append("info").append(displayCalendarInfo()).append("\n");
            stringBuilder.append("id").append(id).append("\n");
            stringBuilder.append("title").append(title).append("\n");
            stringBuilder.append("User ").append(userName).append("\n");

            return stringBuilder.toString();
        }
    }


