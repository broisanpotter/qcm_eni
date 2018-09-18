package Dal;

import entity.ConnectDB;
import entity.Promotion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DalPromotion {

    static String selectPromotion = "select * from promotion";

    public static ArrayList<Promotion> getAllPromotion() throws SQLException {
        ArrayList<Promotion> listPromotion = new ArrayList<>();

        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;

        try{

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(selectPromotion);
            rs=rqt.executeQuery();

            while(rs.next()){
                Promotion promotion = new Promotion();
                promotion.setCodePromo(rs.getString("codePromo"));
                promotion.setLibelle(rs.getString("Libelle"));
                listPromotion.add(promotion);
            }
        }finally{

            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return listPromotion;
    }

}
