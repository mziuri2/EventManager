package ge.mziuri.eventmanager.runner;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year;
import ge.mziuri.eventmanager.dao.EventDAO;
import ge.mziuri.eventmanager.dao.EventDAOImpl;
import ge.mziuri.eventmanager.dao.PlaceDAO;
import ge.mziuri.eventmanager.dao.PlaceDAOImpl;
import ge.mziuri.eventmanager.dao.UserDAO;
import ge.mziuri.eventmanager.dao.UserDAOImpl;
import ge.mziuri.eventmanager.model.Event;
import ge.mziuri.eventmanager.model.Place;
import ge.mziuri.eventmanager.model.User;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Runner {

    public static void main(String[] args) throws IOException, SQLException {
        EventDAO eventDAO = new EventDAOImpl();
        PlaceDAO placeDAO = new PlaceDAOImpl();
        UserDAO userDAO = new UserDAOImpl();
        
        /*Place class test
        Place place1 = new Place(1, "gldani", "dzaan shors");
        placeDAO.addPlace(place1);
        Place place2 = new Place(2, "MySweetHome", "panaskerteli str.");     musha
        placeDAO.addPlace(place2);
        */
        //System.out.println(placeDAO.getAllPlaces());                       musha
        
        //placeDAO.getEventByDateAndPlace(date, place1);          
        
        
        /*User class test
        User user1 = new User(3, "tato", "tato123");
        userDAO.addUser(user1);
        User user2 = new User(77, "giorgi leqvinadze", "pass123321");       musha
        userDAO.addUser(user2);
        */
        //userDAO.getMyCreatedEventsDESC();
        //userDAO.getMyGoingEvents(user2);
        //userDAO.goingOnEvent(event, user2);
        
        
        //Event class unfinished test
        Event event1 = new Event(1, "Devfest", 1, 0, 1, new Date(1, 1, 1));
        eventDAO.addEvent(event1);
        eventDAO.addEvent(event1);
        
    }
}
