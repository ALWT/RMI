package implementch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import classes.Farmacie;
import interfacesch.Farmacieinterch;

public class Farmaciech implements Farmacieinterch {
	private String JDBC_DRIVER = "com.mysql.jdbc.Driver",host;  
	private String DB_URL,dbase;
	private String USER;
	private String PASS;
	private Connection conn = null;
	private Statement stmt = null;
    public Farmaciech(String host,String dbase,String USER,String PASS)
    {this.host=host;
     this.dbase=(dbase==null)?"Test":dbase;
     this.USER=(USER==null)?"root":USER;
     this.PASS=(PASS==null)?"":PASS;
     this.DB_URL= "jdbc:mysql://"+host+"/"+this.dbase;
    }
   
   public String getHost() 
   {return this.host;}
   
   public String getDBase() 
   {return this.dbase;}
   
	@Override
	public void changeNume(int fid, String nume)  {
		try{Class.forName(JDBC_DRIVER);
		  System.out.println("Connecting to database...");
		  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
	          stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "UPDATE farmacie SET nume='"+nume+"' WHERE id_farmacie="+fid;
			      stmt.executeUpdate(sql);
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }finally{
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){}
			      try{  if(conn!=null)
			            conn.close();
			      }catch(SQLException se){se.printStackTrace();}
			   }}

	@Override
	public void changeNume(Farmacie f, String nume)  {
		if(f==null)
			return ;
		if(!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
			return ;
		this.changeNume(f.getID(), nume);
		
	}

	@Override
	public void changeAdresa(int fid, String adresa)  {
		try{Class.forName(JDBC_DRIVER);
		  System.out.println("Connecting to database...");
		  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
	          stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "UPDATE farmacie SET adresa='"+adresa+"' WHERE id_farmacie="+fid;
			      stmt.executeUpdate(sql);
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }finally{
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){}
			      try{  if(conn!=null)
			            conn.close();
			      }catch(SQLException se){se.printStackTrace();}
			   }
		
	}

	@Override
	public void changeAdresa(Farmacie f, String adresa)  {
		if(f==null)
			return ;
		if(!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
			return ;
		this.changeAdresa(f.getID(), adresa);
		
	}

	@Override
	public void changeNrtel(int fid, String nrtel)  {
		try{Class.forName(JDBC_DRIVER);
		  System.out.println("Connecting to database...");
		  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
	          stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "UPDATE farmacie SET telefon='"+nrtel+"' WHERE id_farmacie="+fid;
			      stmt.executeUpdate(sql);
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }finally{
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){}
			      try{  if(conn!=null)
			            conn.close();
			      }catch(SQLException se){se.printStackTrace();}
			   }
		
	}

	@Override
	public void changeNrtel(Farmacie f, String nrtel)  {
		if(f==null)
			return ;
		if(!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
			return ;
		this.changeNrtel(f.getID(), nrtel);
		
	}
}