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
    private void timeValidation(){

    }
    //fetch all id findById
    public Meeting(int id, String title, LocalDateTime startTime, LocalDateTime endTime, String description, MeetingCalendar calendar) {
        this(id, title, startTime, endTime, description);
        this.calendar = calendar;
    }
    //Constructor return only meeting without calendar
    public Meeting(int id, String title, LocalDateTime startTime, LocalDateTime endTime, String description) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }
    //contructor to create meeting to database
    public Meeting(String title, LocalDateTime startTime, LocalDateTime endTime, String description, MeetingCalendar calendar) {
        this(title,startTime,endTime,description);
        this.calendar = calendar;
    }
    //constructor to choose a calendar to fix meeting
    public Meeting(String title, LocalDateTime startTime, LocalDateTime endTime, String description) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public  String displayMeetingInfo()
    {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("info").append(displayMeetingInfo()).append("\n");
        stringBuilder.append("id").append(id).append("\n");
        stringBuilder.append("title").append(title).append("\n");
        stringBuilder.append(" Start time ").append(startTime).append("\n");
        stringBuilder.append("endTime").append(endTime).append("\n");
        stringBuilder.append(" Description ").append(description).append("\n");
        stringBuilder.append("Calendar ").append(calendar).append("\n");

        return stringBuilder.toString();
    }
}
