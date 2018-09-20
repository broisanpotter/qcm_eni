package Dal;

import entity.ConnectDB;
import entity.Epreuve;
import entity.Question;
import entity.QuestionTirage;

import java.sql.*;
import java.util.ArrayList;

public class DalQuestionTirage {

    static String selectQuestionsTirageListe = "select * from question_tirage where idEpreuve = ?";
    static String selectQuestionTirage = "select * from question_tirage where idEpreuve = ? and idQuestion = ?";

    static String insertQuestionTirage = "insert into question_tirage (estMarquee, idQuestion, numordre, idEpreuve) values (?, ?, ?, ?)";

    public static ArrayList<QuestionTirage> getQuestionsTirageListe(Integer idEpreuve) throws SQLException {

        ArrayList<QuestionTirage> questionsTirageListe = new ArrayList<>();
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try {

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(selectQuestionsTirageListe);
            rqt.setInt(1, idEpreuve);
            rs = rqt.executeQuery();
            while (rs.next()) {

                QuestionTirage question = new QuestionTirage();
                question.setIdEpreuve(rs.getInt("idEpreuve"));
                question.setIdQuestion(rs.getInt("idQuestion"));
                question.setEstMarquee(rs.getBoolean("estMarquee"));
                question.setNumOrdre(rs.getInt("numOrdre"));
                questionsTirageListe.add(question);

            }
        } finally {

            if (rs != null) rs.close();
            if (rqt != null) rqt.close();
            if (cnx != null) cnx.close();
        }
        return questionsTirageListe;
    }

    public static QuestionTirage getQuestionTirage(Integer idEpreuve, Integer idQuestion) throws SQLException {

        QuestionTirage questionTirage = null;
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try {

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(selectQuestionTirage);
            rqt.setInt(1, idEpreuve);
            rqt.setInt(2, idQuestion);
            rs = rqt.executeQuery();
            if (rs.next()) {

                QuestionTirage question = new QuestionTirage();
                question.setIdEpreuve(rs.getInt("idEpreuve"));
                question.setIdQuestion(rs.getInt("idQuestion"));
                question.setEstMarquee(rs.getBoolean("estMarquee"));
                question.setNumOrdre(rs.getInt("numOrdre"));

            }
        } finally {

            if (rs != null) rs.close();
            if (rqt != null) rqt.close();
            if (cnx != null) cnx.close();
        }
        return questionTirage;
    }

    public static void setQuestionTirage(QuestionTirage questionTirage) throws SQLException {

        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try {

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(insertQuestionTirage);
            rqt.setBoolean(1, questionTirage.getEstMarquee());
            rqt.setInt(2, questionTirage.getIdQuestion());
            rqt.setInt(3, questionTirage.getNumOrdre());
            rqt.setInt(4, questionTirage.getIdEpreuve());
            rqt.execute();
        } finally {

            if (rs != null) rs.close();
            if (rqt != null) rqt.close();
            if (cnx != null) cnx.close();
        }
    }

}
