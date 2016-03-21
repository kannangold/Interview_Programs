package string.sample;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteExample {
public static final String driver = "org.sqlite.JDBC";
    
    public static void main(String[] args)
    {
        //STEP 1: Setup the Driver
        try
        {
            //Load the driver class dynamically.
            Driver d = (Driver)Class.forName(driver).newInstance();
            DriverManager.registerDriver(d);
        }
        catch(Exception e)
        {
            System.out.println("Error loading database driver: " + e.toString());
            return;
        }
        
        //STEP 2: Create connection to database using database URL
        Connection con;
        try
        {
		//Path of the db file.
            String url = "jdbc:sqlite:C:\\Users\\eimoppq\\Documents\\Workspace\\Assets\\SQLite\\s.db";
		con = DriverManager.getConnection(url);
        }
        catch(SQLException e)
        {
            System.out.println("Error creating connection: " + e.toString());
            return;
        }
        
        //STEP 3: Create a statement, and run query
        Statement stmt;
        ResultSet res;
        try
        {
        	String sql = "insert into emp values('Ericsson')";
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
		
            sql = "SELECT * FROM emp ORDER BY name";
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
        }
        catch(SQLException e)
        {
            System.out.println("Error creating or running statement: " + e.toString());
            try
            {
                con.close();
            }catch(Exception exc) {}
            return;
        }        
        //STEP 4: Read results
        try
        {
            String name;
            while(res.next())
            {
                name = res.getString("name");
          	    System.out.println("Name : " + name);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error processing results: " + e.toString());
            try
            {
                res.close();
                stmt.close();
                con.close();
            }
            catch(Exception ex)
            {
            }
            return;
        }        
        //STEP 5: Close stuff
        try
        {
            res.close();
            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error closing connections: " + e.toString());
            return;
        }
    }

}
