package ge.mziuri.eventmanager.dao;

import ge.mziuri.EventManager.metainfo.DatabaseMetaInfo;
import ge.mziuri.eventmanager.model.Event;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class EventDAOImpl implements EventDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public EventDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addEvent(Event event) {
        try {
            pstmt = con.prepareStatement("INSERT INTO EVENTS (name, date, place_id) VALUES (?,?,?);");
            pstmt.setString(1, event.getEventName());
            pstmt.setDate(2, event.getDate());
            pstmt.setInt(3, event.getPlace_id());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM EVENTS");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String eventName = rs.getString("eventName");
                int user_id = rs.getInt("user_id");
                int rating = rs.getInt("rating");
                int place_id = rs.getInt("place_id");
                Date date = rs.getDate("date");
                Event event = new Event(id, eventName, user_id, rating, place_id, date);
                events.add(event);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return events;
    }

    @Override
    public List<Event> getTodaysTop3Events() {
        List<Event> events = new ArrayList<>();
        int i = 0;
        try {
            pstmt = con.prepareStatement("SELECT * FROM event ORDER BY rating ASC;");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next() && i != 3) {
                int id = rs.getInt("id");
                String eventName = rs.getString("eventName");
                int user_id = rs.getInt("user_id");
                int rating = rs.getInt("rating");
                int place_id = rs.getInt("place_id");
                Date date = rs.getDate("date");
                Event event = new Event(id, eventName, user_id, rating, place_id, date);
                events.add(event);
                i++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return events;
    }
}
