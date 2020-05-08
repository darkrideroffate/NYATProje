package akillicihaz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Veritaban implements IVeritaban{
    private Connection baglan(){

        Connection conn=null;

        try {


            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkıllıCihaz", "postgres","postegres");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public boolean login(String user,String pass){

        String sql = "SELECT 1 FROM \"public\".\"user\" WHERE \"username\" = \'" + user +  "\' AND \"password\" = \'" + pass + "\'";
        Connection conn=this.baglan();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();



            if(rs.next())
            {

                rs.close();
                stmt.close();
                System.out.println("Giriliyor....");
                return true;
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

}
