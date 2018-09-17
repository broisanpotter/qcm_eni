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
                test.setIdTest(rs.getInt("idTest"));
                test.setLibelle(rs.getString("libelle"));
                test.setDescription(rs.getString("description"));
                test.setDuree(rs.getInt("duree"));
                test.setSeuilHaut(rs.getInt("seuil_haut"));
                test.setSeuilBas(rs.getInt("seuil_bas"));

                listeTest.add(test);
            }


        }finally{
            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return listeTest;

    }
    public static void ajouterTest(String libelle , String description, int duree, int seuilHaut, int seuilBas) throws SQLException
    {
        Connection cnx=null;
        PreparedStatement rqt=null;
        try
        {
            cnx=ConnectDB.connect();
            rqt=cnx.prepareStatement("insert into test(libelle,description,duree,seuil_haut,seuil_bas) values (?,?,?,?,?)");
            rqt.setString(1,libelle);
            rqt.setString(2,description);
            rqt.setInt(3,duree);
            rqt.setInt(4,seuilHaut);
            rqt.setInt(5,seuilBas);
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


    public static void supprimerTest(int idTest) throws SQLException
    {
        Connection cnx=null;
        PreparedStatement rqt=null;

        try
        {
            cnx=ConnectDB.connect();
            rqt=cnx.prepareStatement("delete from test where idTest=? ");
            rqt.setInt(1,idTest);
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


}
