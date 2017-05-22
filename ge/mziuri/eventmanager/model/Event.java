package ge.mziuri.eventmanager.model;

import java.util.Date;

public class Event {
    
    private int id;
    private String eventName;
    private int user_id;
    private int rating;
    private int place_id;
    private Date date;

    public Event() {
    }

    public Event(int id, String eventName, int user_id, int rating, int place_id, Date date) {
        this.id = id;
        this.eventName = eventName;
        this.user_id = user_id;
        this.rating = rating;
        this.place_id = place_id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
