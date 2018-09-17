package Dal;

import entity.ConnectDB;
import entity.Epreuve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DalEpreuve {

    static String selectEpreuve = "select * from epreuve where idEpreuve = ?";
    static String selectEpreuvesListe = "select * from epreuve where idUtilisateur = ?";

    static String insertEpreuve = "insert into epreuve (dateDedutValidite, dateFinValidite, etat, idTest, idUtilisateur) values (?, ?, ?, ?, ?)";

    public static Epreuve getEpreuve(Integer idEpreuve) throws SQLException{

        Epreuve epreuve = null;
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try{

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(selectEpreuve);
            rqt.setInt(1, idEpreuve);
            rs=rqt.executeQuery();
            if (rs.next()){


            }
        }finally{

            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return epreuve;
    }

    public static ArrayList<Epreuve> getEpreuves(Integer idUtilisateur) throws SQLException{

        ArrayList<Epreuve> epreuvesListe = null;
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try{

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(selectEpreuvesListe);
            rqt.setInt(1, idUtilisateur);
            rs=rqt.executeQuery();

            while (rs.next()){
                Epreuve epreuve = new Epreuve();
                epreuve.setIdEpreuve(rs.getInt("idEpreuve"));
                epreuve.setDateDebutValidite(rs.getDate("dateDedutValidite"));
                epreuve.setDateFinValidite(rs.getDate("dateFinValidite"));
                epreuve.setTempsEcoule(rs.getInt("tempsEcoule"));
                epreuve.setEtat(rs.getString("etat"));
                epreuve.setNote_obtenue(rs.getDouble("note_obtenue"));
                epreuve.setNiveau_obtenu(rs.getString("niveau_obtenu"));
                epreuvesListe.add(epreuve);
            }
        }finally{

            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return epreuvesListe;
    }

    public static Epreuve setEpreuve(Epreuve epreuve) throws SQLException{

        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try{

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(insertEpreuve);
            rqt.setDate(1, epreuve.getDateDebutValidite());
            rqt.setDate(2, epreuve.getDateFinValidite());
            rqt.setString(3, epreuve.getEtat());
            rqt.setInt(4, epreuve.getIdTest());
            rqt.setInt(5, epreuve.getIdUtilisateur());
            rs=rqt.executeQuery();
        }finally{

            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return epreuve;
    }
}
