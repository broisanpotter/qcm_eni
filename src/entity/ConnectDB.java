package entity;


import java.sql.*;

public class ConnectDB {

    public Connection connect() {

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

    public boolean checkUser(String email, String password, Connection connection) {

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT idUtilisateur, email, password FROM utilisateur WHERE email = ? and password= ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            String mailBdd = null;
            String passwordBdd = null;

            while(resultSet.next()){
                mailBdd = resultSet.getString("email");
                passwordBdd = resultSet.getString("password");
            }

            if (email.equals(mailBdd) && password.equals(passwordBdd)){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

}
