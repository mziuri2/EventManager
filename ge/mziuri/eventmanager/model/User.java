package ge.mziuri.eventmanager.model;

import java.util.List;

public class User {
    
    private int id;
    private String username;
    private String password;
    private List<Event> goingEvents;

    public User() {
    }

    public User(int id, String username, String password, List<Event> goingEvents) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.goingEvents = goingEvents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Event> getGoingEvents() {
        return goingEvents;
    }

    public void setGoingEvents(List<Event> goingEvents) {
        this.goingEvents = goingEvents;
    }
}
