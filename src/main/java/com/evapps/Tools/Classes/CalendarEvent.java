/**
 * Created by Djidjelly Siclait on 11/5/2016.
 */
package com.evapps.Tools.Classes;

import com.evapps.Tools.Enums.EventStatus;

import java.sql.Timestamp;

public class CalendarEvent {
    // Attributes
    private String title;
    private Timestamp dateAndTime;
    private String description;
    private EventStatus status;

    // Constructors
    public CalendarEvent(){

    }

    public CalendarEvent(String title, Timestamp dateAndTime, String description, EventStatus status){
        this.setTitle(title);
        this.setDateAndTime(dateAndTime);
        this.setDescription(description);
        this.setStatus(status);
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Timestamp dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }


}
