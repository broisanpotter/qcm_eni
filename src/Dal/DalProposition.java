package Dal;

import entity.ConnectDB;
import entity.Promotion;
import entity.Proposition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DalProposition {

    static String selectPromotionByQuestion = "select * from proposition where idQuestion = ?";

    public static ArrayList<Proposition> promotionsByQuestion(Integer idQuestion) throws SQLException {
        ArrayList<Proposition> propositionsListe = new ArrayList<>();

        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;

        try{

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(selectPromotionByQuestion);
            rqt.setInt(1, idQuestion);
            rs=rqt.executeQuery();

            while(rs.next()){
                Proposition proposition = new Proposition();
                proposition.setIdProposition(rs.getInt("idProposition"));
                proposition.setIdQuestion(rs.getInt("idQuestion"));
                proposition.setEstBonne(rs.getBoolean("estBonne"));
                proposition.setEnonce(rs.getString("enonce"));
                propositionsListe.add(proposition);
            }
        }finally{

            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return propositionsListe;
    }
}
