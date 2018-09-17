package Dal;

import entity.ConnectDB;
import entity.ReponseTirage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DalReponseTirage {

    static String selectReponseTirageListe = "select * from ReponseTirage where idEpreuve = ?";
    static String selectReponseTirage = "select * from ReponseTirage where idEpreuve = ? and idreponse = ?";

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

    public static ReponseTirage getReponseTirage(Integer idEpreuve, Integer idreponse) throws SQLException {

        ReponseTirage ReponseTirage = null;
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try {

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(selectReponseTirage);
            rqt.setInt(1, idEpreuve);
            rqt.setInt(2, idreponse);
            rs = rqt.executeQuery();
            if (rs.next()) {

                ReponseTirage reponse = new ReponseTirage();
                reponse.setIdQuestion(rs.getInt("idQuestion"));
                reponse.setIdEpreuve(rs.getInt("idEpreuve"));
                reponse.setIdProposition(rs.getInt("idProposition"));

            }
        } finally {

            if (rs != null) rs.close();
            if (rqt != null) rqt.close();
            if (cnx != null) cnx.close();
        }
        return ReponseTirage;
    }
}
