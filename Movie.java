package Movie;

import java.sql.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Movie {
	
	   public static void main(String[] args) {
	      try {
	    	  
	         Class.forName("com.mysql.jdbc.Driver");
	      } catch(ClassNotFoundException e) {
	         System.out.println("Class not found "+ e);
	      }
	      try {
	         Connection con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/movie","root", "root");
	         
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery("SELECT * FROM movie");
	         System.out.println("MovieName Actor Actress Director YearofRelease");
	         
	         while (rs.next()) {
	           
	            String MovieName = rs.getString("MovieName");
	            String Actor = rs.getString("Actor");
	            String Actress = rs.getString("Actress");
	            String Director = rs.getString("Director");
	            int YearofRelease = rs.getInt("YearofRelease");
	            System.out.println(MovieName+"   "+Actor+"  "+Actress+"  "+Director+"  "+YearofRelease);
	         }
	      } catch(SQLException e) {
	         System.out.println("SQL exception occured" + e);
	      }
	   }
	}

