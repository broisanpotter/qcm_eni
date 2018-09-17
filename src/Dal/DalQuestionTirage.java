package Dal;

import entity.ConnectDB;
import entity.Epreuve;
import entity.QuestionTirage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DalQuestionTirage {

    static String selectQuestionsTirageListe = "select * from questiontirage where idEpreuve = ?";
    static String selectQuestionTirage = "select * from questiontirage where idEpreuve = ? and idQuestion = ?";

    public static ArrayList<QuestionTirage> getQuestionsTirageListe(Integer idEpreuve) throws SQLException {

        ArrayList<QuestionTirage> questionsTirageListe = null;
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
                question.setEstMarquee(rs.getString("estMarquee"));
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
                question.setEstMarquee(rs.getString("estMarquee"));
                question.setNumOrdre(rs.getInt("numOrdre"));

            }
        } finally {

            if (rs != null) rs.close();
            if (rqt != null) rqt.close();
            if (cnx != null) cnx.close();
        }
        return questionTirage;
    }
}
