package Dal;

import entity.ConnectDB;
import entity.Question;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DalQuestion {

    public static List<Question> lister() throws SQLException {

        List<Question> listeQuest = new ArrayList<Question>();

        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try{
            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement("select * from test");
            rs=rqt.executeQuery();

            while (rs.next()){
                Question quest = new Question();
                quest.setEnonce(rs.getString("enonce"));
                quest.setMedia(rs.getBlob("media"));
                quest.setPoints(rs.getInt("points"));
                quest.setIdTheme(rs.getInt("idTheme"));

                listeQuest.add(quest);
            }


        }finally{
            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return listeQuest;

    }

    public static void ajouterQuest(String enonce, Blob media, int points, int id_theme ) throws SQLException
    {
        Connection cnx=null;
        PreparedStatement rqt=null;
        try
        {
            cnx=ConnectDB.connect();
            rqt=cnx.prepareStatement("insert into question(enonce,media,points,id_theme) values (?,?,?,?)");
            rqt.setString(1,enonce);
            rqt.setBlob(2,media);
            rqt.setInt(3,points);
            rqt.setInt(4,id_theme);
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


    public static void supprimerQuest(int idQuest) throws SQLException
    {
        Connection cnx=null;
        PreparedStatement rqt=null;

        try
        {
            cnx=ConnectDB.connect();
            rqt=cnx.prepareStatement("delete from question where idQuestion=? ");
            rqt.setInt(1,idQuest);
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
