package ge.mziuri.eventmanager.dao;

import ge.mziuri.eventmanager.model.Event;
import ge.mziuri.eventmanager.model.Place;
import java.util.Date;
import java.util.List;

public interface PlaceDAO {
    
    void addPlace(Place place);
    List<Place> getAllPlaces();
    Event getEventByDateAndPlace(Date date,Place place);
}
