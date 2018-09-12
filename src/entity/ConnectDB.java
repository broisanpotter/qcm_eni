package entity;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public Connection connectToDb() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch ( ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlserver://localhost;databasename=qcm";
        String utilisateur = "sa";
        String motDePasse = "Pa$$w0rd";
        Connection connexion = null;

        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connexion;
    }

}
