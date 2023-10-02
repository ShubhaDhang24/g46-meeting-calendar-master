package se.lexicon.model;

import java.time.LocalDateTime;

public class Meeting {
    // todo:
    private int id;
    private  String title;
    private LocalDateTime startTime;
    private  LocalDateTime endTime;
    private String description;
    private MeetingCalendar calendar;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    public MeetingCalendar getCalendar() {
        return calendar;
    }
    public  void displayMeetingInfo()
    {
        System.out.println("Meeting details ");
        System.out.println("_______________________");
        System.out.println("Meeting id :"+id+" ,title"+title+
                "Date and time :"+startTime+","+endTime+" description "+description);
    }
}
