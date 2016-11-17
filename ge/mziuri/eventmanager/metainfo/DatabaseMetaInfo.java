package ge.mziuri.EventManager.metainfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseMetaInfo {
    
    public static final String databaseURL = "jdbc:postgresql://localhost:5432/em";
    
    public static final String username = "postgres";
    
    public static final String passsword = "rame";
    
    public static void closeConnection(Connection con, PreparedStatement pstmt) {
        try {
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
