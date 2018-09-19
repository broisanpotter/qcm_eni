package Dal;

import entity.ConnectDB;
import entity.Question;
import entity.SectionTest;
import entity.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DalSectionTest {

    static String selectSectionTest = "select * from section_test where idTest = ?";

    public static SectionTest getSectionTest(Test test) throws SQLException {

        SectionTest sectionTest = null;
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;

        try{

            cnx = ConnectDB.connect();
            rqt = cnx.prepareStatement(selectSectionTest);
            rqt.setInt(1, test.getIdTest());
            rs=rqt.executeQuery();

            while (rs.next()){

                sectionTest = new SectionTest();
                sectionTest.setNbQuestionsATirer(rs.getInt(("nbQuestionsATirer")));
                sectionTest.setIdTest(rs.getInt("idTest"));
                sectionTest.setIdTheme(rs.getInt("idTheme"));
            }
        }finally{

            if (rs!=null) rs.close();
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return sectionTest;
    }

}
