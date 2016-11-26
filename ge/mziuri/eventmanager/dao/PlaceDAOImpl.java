package ge.mziuri.eventmanager.dao;



import ge.mziuri.EventManager.metainfo.DatabaseMetaInfo;
import ge.mziuri.eventmanager.model.Event;
import ge.mziuri.eventmanager.model.Place;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class PlaceDAOImpl implements PlaceDAO {
    
    private Connection con;
    
    private PreparedStatement pstmt;
    
    public PlaceDAOImpl() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void addPlace(Place place) {
        try {
            pstmt = con.prepareStatement("INSERT INTO places (id, name, address) VALUES (?,?,?)");
            pstmt.setInt(1, place.getId());
            pstmt.setString(2, place.getName());
            pstmt.setString(3, place.getAddress());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   
    @Override
    public List<Place> getAllPlaces() {
        List<Place> places = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM places;");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                Place place = new Place(id, name, address);
                places.add(place);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return places;
    }

    @Override
    public List<Event>  getEventByDateAndPlace(Date date, Place place) {
        List<Event> events = new ArrayList<>();
        int i=0;
        try {
            pstmt = con.prepareStatement("SELECT * FROM event WHERE date = ? and place_id = ?;");
            pstmt.setDate(1, date);
            pstmt.setInt(2, place.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String eventName = rs.getString("eventName");
                int user_id = rs.getInt("user_id");
                int rating = rs.getInt("rating");
                Event event = new Event(id, eventName, user_id, rating,place.getId(),date);
                events.add(event);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return events;
    }  
}

