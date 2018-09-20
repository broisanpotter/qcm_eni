package Dal;

import entity.ConnectDB;
import entity.Epreuve;
import entity.Question;
import entity.Test;


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
            rqt = cnx.prepareStatement("select * from question");
            rs=rqt.executeQuery();

            while (rs.next()){
                Question quest = new Question();
                quest.setIdQuestion(rs.getInt(("idQuestion")));
                quest.setEnonce(rs.getString("enonce"));
                quest.setMedia(rs.getString("media"));
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

    public static ArrayList<Question> getQuestionByTheme(Test test) throws SQLException {

        ArrayList<Question> QuestionsListe = new ArrayList<Question>();
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;

        try{

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement("select * from question as q inner join section_test as s on q.idTheme = s.idTheme where idTest = ?");
            rqt.setInt(1, test.getIdTest());
            rs=rqt.executeQuery();

            while (rs.next()){

                Question quest = new Question();
                quest.setIdQuestion(rs.getInt(("idQuestion")));
                quest.setEnonce(rs.getString("enonce"));
                quest.setMedia(rs.getString("media"));
                quest.setPoints(rs.getInt("points"));
                quest.setIdTheme(rs.getInt("idTheme"));

                QuestionsListe.add(quest);
            }
        }finally{

            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return QuestionsListe;
    }

    public static ArrayList<Question> getQuestionByEpreuve(Epreuve epreuve) throws SQLException {

        ArrayList<Question> QuestionsListe = new ArrayList<Question>();
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;

        try{

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement("select q.*,  from question as q inner join question_tirage as qt on q.idQuestion = qt.idQuestion where idEpreuve = ?");
            rqt.setInt(1, epreuve.getIdEpreuve());
            rs=rqt.executeQuery();

            while (rs.next()){

                Question quest = new Question();
                quest.setIdQuestion(rs.getInt(("idQuestion")));
                quest.setEnonce(rs.getString("enonce"));
                quest.setMedia(rs.getString("media"));
                quest.setPoints(rs.getInt("points"));
                quest.setIdTheme(rs.getInt("idTheme"));

                QuestionsListe.add(quest);
            }
        }finally{

            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return QuestionsListe;
    }

    public static Question getQuestion(Integer idQuestion) throws SQLException {

        Question question = null;
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;

        try{

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement("select * from question where idQuestion = ?");
            rqt.setInt(1, idQuestion);
            rs=rqt.executeQuery();

            if (rs.next()){

                question = new Question();
                question.setIdQuestion(rs.getInt(("idQuestion")));
                question.setEnonce(rs.getString("enonce"));
                question.setMedia(rs.getString("media"));
                question.setPoints(rs.getInt("points"));
                question.setIdTheme(rs.getInt("idTheme"));
            }
        }finally{

            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return question;
    }
}
