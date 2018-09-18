package Dal;

import entity.ConnectDB;
import entity.Profil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DalProfil {

    static String selectProfil = "select * from profil";

    public static ArrayList<Profil> getAllProfil() throws SQLException {

        ArrayList<Profil> listProfil = new ArrayList<>();

        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;

        try{

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(selectProfil);
            rs=rqt.executeQuery();

            while(rs.next()){
                Profil profil = new Profil();
                profil.setCodeProfil(rs.getInt("codeProfil"));
                profil.setLibelle(rs.getString("libelle"));
                listProfil.add(profil);
            }
        }finally{

            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return listProfil;
    }
}
