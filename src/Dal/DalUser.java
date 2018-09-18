package Dal;

import entity.ConnectDB;
import entity.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DalUser {

    public static List<Utilisateur> listerUser( int codeProfil) throws SQLException {

        List<Utilisateur> listeUser = new ArrayList<Utilisateur>();
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try{
            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement("select * from Utilisateur where codeProfil=" + codeProfil);
            rs=rqt.executeQuery();

            while (rs.next()){
                Utilisateur user = new Utilisateur();
                user.setIdUtilisateur(rs.getInt("idUtilisateur"));
                user.setNom(rs.getString("nom"));
                user.setEmail(rs.getString("email"));
                user.setPrenom(rs.getString("prenom"));
                listeUser.add(user);
            }


        }finally{
            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return listeUser;

    }

    public static Utilisateur selectSingleUser(int id) throws SQLException {

        String selectSingleUser = "select idUtilisateur, nom, prenom, email, codeProfil, codePromo from utilisateur where idUtilisateur = ?";

        Utilisateur user = null;
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;

        try{
            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(selectSingleUser);
            rqt.setInt(1, id);
            rs=rqt.executeQuery();

            if (rs.next()){
                user = new Utilisateur();
                user.setIdUtilisateur(id);
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setProfil(rs.getInt("codeProfil"));
                user.setPromotion(rs.getString("codePromo"));
            }
        }finally{
            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return user;

    }

    public static void ajouterUser(String nom , String prenom,String email, String password, int profil, String promo) throws SQLException
    {
        Connection cnx=null;
        PreparedStatement rqt=null;
        try
        {
            cnx=ConnectDB.connect();
            rqt=cnx.prepareStatement("insert into utilisateur(nom,prenom,email,password,codeprofil,codePromo) values (?,?,?,?,?,?)");
            rqt.setString(1,nom);
            rqt.setString(2,prenom);
            rqt.setString(3,email);
            rqt.setString(4,password);
            rqt.setInt(5,profil);
            rqt.setString(6,promo);
            rqt.executeUpdate();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }

    }

    public static void updateUser(int id,String nom , String prenom, String email, int profil, String promo) throws SQLException
    {
        Connection cnx=null;
        PreparedStatement rqt=null;
        try
        {
            cnx=ConnectDB.connect();
            rqt=cnx.prepareStatement("update utilisateur set nom = ?,prenom = ?,email = ?,codeprofil = ?,codePromo = ?  where idUtilisateur = ?");
            rqt.setString(1,nom);
            rqt.setString(2,prenom);
            rqt.setString(3,email);
            rqt.setInt(4,profil);
            rqt.setString(5,promo);
            rqt.setInt(6,id);
            rqt.executeUpdate();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
    }


    public static void supprimerUser(String email) throws SQLException
    {
        Connection cnx=null;
        PreparedStatement rqt=null;

        try
        {
            cnx=ConnectDB.connect();
            rqt=cnx.prepareStatement("delete from  utilisateur where email=? ");
            rqt.setString(1,email);
            rqt.executeUpdate();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }

    }
}
