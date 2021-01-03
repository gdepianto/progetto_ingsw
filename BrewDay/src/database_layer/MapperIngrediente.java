package database_layer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Ingrediente;

public class MapperIngrediente {
	public void insert(Ingrediente ing) {
		  Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:brewday.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "INSERT INTO ingrediente (nome,disponibilita) " +
	                        "VALUES ('"+ing.getNome()+"',"+ing.getDisponibilita()+");"; 
	         stmt.executeUpdate(sql);

	         

	         stmt.close();
	         c.commit();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
	   
	}
	
	public ArrayList getIngredienti() {
		Connection c = null;
		Statement stmt = null;
		
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
		      
		      while ( rs.next() ) {
		         String nome = rs.getString("nome");
		         String unitaMisura = rs.getString("unitaMisura");
		         float quantita  = rs.getFloat("quantita");
		         
		         
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
		System.out.println("Operation done successfully");
		return null;
	}
		
	
}
