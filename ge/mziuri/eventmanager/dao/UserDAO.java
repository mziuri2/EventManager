package ge.mziuri.eventmanager.dao;

import ge.mziuri.eventmanager.model.Event;
import ge.mziuri.eventmanager.model.User;
import java.util.List;


public interface UserDAO {
    
    void addUser(User user);
    List<Event> getMyGoingEvents(User user); 
    List<Event> getMyCreatedEventsDESC(); //klebadobit
    void goingOnEvent(Event event);
}
