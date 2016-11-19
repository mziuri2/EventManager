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
import java.util.Date;
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
            pstmt = con.prepareStatement("INSERT INTO country (id, name, address) VALUES (?,?,?,?,?)");
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
            pstmt = con.prepareStatement("SELECT * FROM place;");
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
    public Event getEventByDateAndPlace(Date date, Place place) {
        ArrayList<Place> places = null;
        int i=0;
        try {
            pstmt = con.prepareStatement("SELECT * FROM event WHERE date = ? and place_id = ?;");
            pstmt.setDate(1, date);
            pstmt.setInt(2, place.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                Long population = rs.getLong("population");
                boolean capital = rs.getBoolean("capital");
                int country_id = rs.getInt("country_city");
                City city = new City(id, cityName, population, capital, country_id);
                cities.add(city);
            }
               throw new DaoTestException(ProjectMetaInfo.cantFindCity);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return places;
    }  
}
