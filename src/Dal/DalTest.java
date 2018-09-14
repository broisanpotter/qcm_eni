package Dal;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.ConnectDB;
import entity.Test;
public class DalTest {

    /**
     *
     * @return La liste peut être vide mais jamais <code>null</code>
     * @throws SQLException
     */
    public static List<Test> lister() throws SQLException {

        List<Test> listeTest = new ArrayList<Test>();

        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        try{
            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement("select * from test");
            rs=rqt.executeQuery();

            while (rs.next()){
                Test test = new Test();
                test.setLibelle(rs.getString("libelle"));
                test.setDescription(rs.getString("description"));
                test.setDuree(rs.getDouble("duree"));
                test.setSeuilHaut(rs.getDouble("seuil_haut"));
                test.setSeuilBas(rs.getDouble("seuil_bas"));

                listeTest.add(test);
            }


        }finally{
            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return listeTest;

    }


}
