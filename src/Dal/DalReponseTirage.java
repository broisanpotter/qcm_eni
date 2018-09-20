package Dal;

import entity.ConnectDB;
import entity.ReponseTirage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DalReponseTirage {

    static String selectReponseTirageListe = "select * from Reponse_Tirage where idEpreuve = ?";
    static String selectReponseTirage = "select * from Reponse_Tirage where idEpreuve = ? and idQuestion = ? and idProposition = ?";

    static String insertReponseTirage = "insert into Reponse_Tirage (idEpreuve, idProposition, idQuestion) values (?, ?, ?)";

    static String deleteReponseTirage = "delete Reponse_Tirage where idEpreuve = ? and idQuestion = ? and idProposition = ?";

    public static ArrayList<ReponseTirage> getReponseTirageListe(Integer idEpreuve) throws SQLException {

        ArrayList<ReponseTirage> ReponseTirageListe = null;
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try {

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(selectReponseTirageListe);
            rqt.setInt(1, idEpreuve);
            rs = rqt.executeQuery();
            while (rs.next()) {

                ReponseTirage reponse = new ReponseTirage();
                reponse.setIdQuestion(rs.getInt("idQuestion"));
                reponse.setIdEpreuve(rs.getInt("idEpreuve"));
                reponse.setIdProposition(rs.getInt("idProposition"));
                ReponseTirageListe.add(reponse);

            }
        } finally {

            if (rs != null) rs.close();
            if (rqt != null) rqt.close();
            if (cnx != null) cnx.close();
        }
        return ReponseTirageListe;
    }

    public static ReponseTirage getReponseTirage(Integer idEpreuve, Integer idQuestion, Integer idReponse) throws SQLException {

        ReponseTirage reponseTirage = null;
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try {

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(selectReponseTirage);
            rqt.setInt(1, idEpreuve);
            rqt.setInt(2, idQuestion);
            rqt.setInt(3, idReponse);
            rs = rqt.executeQuery();
            while (rs.next()) {

                reponseTirage = new ReponseTirage();
                reponseTirage.setIdQuestion(rs.getInt("idQuestion"));
                reponseTirage.setIdEpreuve(rs.getInt("idEpreuve"));
                reponseTirage.setIdProposition(rs.getInt("idProposition"));

            }
        } finally {

            if (rs != null) rs.close();
            if (rqt != null) rqt.close();
            if (cnx != null) cnx.close();
        }
        return reponseTirage;
    }

    public static void setReponseTirage(Integer idEpreuve, Integer idReponse, Integer idQuestion) throws SQLException {

        ReponseTirage reponseTirage = null;
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try {
            reponseTirage = DalReponseTirage.getReponseTirage(idEpreuve, idQuestion, idReponse);
            System.out.println(reponseTirage);
            cnx = ConnectDB.connect();
            if(reponseTirage == null){
                rqt = cnx.prepareStatement(insertReponseTirage);
                rqt.setInt(1, idEpreuve);
                rqt.setInt(2, idReponse);
                rqt.setInt(3, idQuestion);
            }
            else {
                rqt = cnx.prepareStatement(deleteReponseTirage);
                rqt.setInt(1, idEpreuve);
                rqt.setInt(2, idQuestion);
                rqt.setInt(3, idReponse);
            }
            rqt.executeUpdate();
        } finally {

            if (rs != null) rs.close();
            if (rqt != null) rqt.close();
            if (cnx != null) cnx.close();
        }
    }
}
