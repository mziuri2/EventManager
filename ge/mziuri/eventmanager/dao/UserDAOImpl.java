package ge.mziuri.eventmanager.dao;

import ge.mziuri.EventManager.metainfo.DatabaseMetaInfo;
import ge.mziuri.eventmanager.model.Event;
import ge.mziuri.eventmanager.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public UserDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addUser(User user) {
        try {
            pstmt = con.prepareStatement("INSERT INTO users (id,username, password) VALUES (?,?,?,?);");
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Event> getMyGoingEvents(User user) {
        List<Event> goingEvents = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM events WHERE id=(SELECT event_id FROM gointevent WHERE user_id = ?)");
            ResultSet rs = pstmt.executeQuery();
            pstmt.setInt(1, user.getId());
            while (rs.next()) {
                int id = rs.getInt("id");
                String eventName = rs.getString("eventName");
                int user_id = rs.getInt("id");
                int rating = rs.getInt("rating");
                int place_id = rs.getInt("place_id");
                Date date = rs.getDate("date");
                Event event = new Event(id, eventName, user_id, rating, place_id, date);
                goingEvents.add(event);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return goingEvents;
    }

    @Override
    public List<Event> getMyCreatedEventsDESC() {
        List<Event> myEvents = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM events WHERE user_id = ?;");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String eventName = rs.getString("eventName");
                int user_id = rs.getInt("id");
                int rating = rs.getInt("rating");
                int place_id = rs.getInt("place_id");
                Date date = rs.getDate("date");
                Event event = new Event(id, eventName, user_id, rating, place_id, date);
                myEvents.add(event);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myEvents;
    }

    @Override
    public void goingOnEvent(Event event, User user) {
        try {
            pstmt = con.prepareStatement("INSERT INTO goingevents (event_id,user_id)values (?,?);");
            pstmt.setInt(1, event.getId());
            pstmt.setInt(2, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
