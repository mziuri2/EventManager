package ge.mziuri.eventmanager.dao;

import ge.mziuri.eventmanager.model.Event;
import java.util.List;

public interface EventDAO {
    
    void addEvent(Event event);
    List<Event> getAllEvents();
    List<Event> getTodaysTop3Events();
}
