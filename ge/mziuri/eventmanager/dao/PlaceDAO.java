package ge.mziuri.eventmanager.dao;

import ge.mziuri.eventmanager.model.Event;
import ge.mziuri.eventmanager.model.Place;
import java.sql.Date;
import java.util.List;

public interface PlaceDAO {
    
    void addPlace(Place place);
    List<Place> getAllPlaces();
    List<Event> getEventByDateAndPlace(Date date,int place_id);
}
