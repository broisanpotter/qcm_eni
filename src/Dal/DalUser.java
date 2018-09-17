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
        System.out.println("inside list user");
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try{
            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement("select * from Utilisateur where codeProfil=" + codeProfil);
            rs=rqt.executeQuery();
            System.out.println("exec query");

            while (rs.next()){
                Utilisateur user = new Utilisateur();
                user.setIdUtilisateur(rs.getInt("idUtilisateur"));
                user.setNom(rs.getString("nom"));
                user.setEmail(rs.getString("email"));
                user.setPrenom(rs.getString("prenom"));
                listeUser.add(user);
                System.out.println(user.getPrenom());
            }


        }finally{
            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        System.out.println("out query");
        return listeUser;

    }

    public static void ajouterUser(String nom , String prenom,String email, String password, int promo, int profil) throws SQLException
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
            rqt.setInt(5,promo);
            rqt.setInt(6,profil);
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
