package DB;

import java.sql.*;

/**
 * Created by Yulia.Tsyutsyura on 12.02.2018.
 */
public class ConnectToDB {
    // JDBC URL, username and password of MySQL server
    //private static final String url = "jdbc:mysql://localhost:3306/paysecur_essaycontrol";
    private static final String url = "jdbc:mysql://db.uncomp.com.test:3306/paysecur_essaycontrol";
    private static final String user = "tester";
    private static final String password = "Ux6ZmbF8fnv6sLxT";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String args[]) {
        String query = "SELECT state_id FROM es_states es";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of state in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }
}

