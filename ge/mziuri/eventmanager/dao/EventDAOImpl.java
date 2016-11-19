package ge.mziuri.eventmanager.dao;

import ge.mziuri.eventmanager.model.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class EventDAOImpl implements EventDAO{
    
    private Connection con;
    
    private PreparedStatement pstmt;
    
    @Override
    public void addEvent(Event event) {
        try {
            pstmt = con.prepareStatement("INSERT INTO ");
            pstmt.setString(1, event.getEventName());
            pstmt.setDate(2, event.getDate());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String eventName = rs.getString("");
                int user_id = rs.getInt("");
                int rating = rs.getInt("");
                int place_id = rs.getInt("");
                Event event = new Event(id,eventName,user_id,rating,place_id);
                events.add(event);
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return events;
    }

    @Override
    public List<Event> getTodaysTop3Events() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
