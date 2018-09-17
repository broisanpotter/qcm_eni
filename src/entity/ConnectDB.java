package entity;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class ConnectDB {

    public static Connection connect() {

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

    public static boolean checkSession(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        if(session.getAttribute("user") != null) {
            return true;
        }
        else {
            return false;
        }

    }

    public Utilisateur checkUser(String email, String password, Connection connection) {

        PreparedStatement preparedStatement = null;
        Utilisateur user = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT idUtilisateur, nom, prenom, email, password, codeProfil FROM utilisateur WHERE email = ? and password= ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            Integer idUser = null;
            String nom = null;
            String prenom = null;
            String mailBdd = null;
            String passwordBdd = null;
            Integer codeProfilBdd = null;

            while(resultSet.next()){
                idUser = resultSet.getInt("idUtilisateur");
                nom = resultSet.getString("nom");
                prenom = resultSet.getString("prenom");
                mailBdd = resultSet.getString("email");
                passwordBdd = resultSet.getString("password");
                codeProfilBdd = resultSet.getInt("codeProfil");
            }

            if (email.equals(mailBdd) && password.equals(passwordBdd)){
                user = new Utilisateur(idUser, nom, prenom,mailBdd,passwordBdd, codeProfilBdd);
                return user;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

}
