package Backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class Myconnections {
    public Connection mysql(String url,String user,String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
     public Connection postgresql(String url,String user,String password){
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
