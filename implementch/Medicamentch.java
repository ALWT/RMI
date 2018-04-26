package implementch;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Medicament;
import interfacesch.Medicamentinterch;

public class Medicamentch implements Medicamentinterch {
	private String JDBC_DRIVER = "com.mysql.jdbc.Driver",host;  
	private String DB_URL,dbase;
	private String USER;
	private String PASS;
	private Connection conn = null;
	private Statement stmt = null;
    public Medicamentch(String host,String dbase,String USER,String PASS)
    {this.host=host;
     this.dbase=(dbase==null)?"Test":dbase;
     this.USER=(USER==null)?"root":USER;
     this.PASS=(PASS==null)?"":PASS;
     this.DB_URL= "jdbc:mysql://"+host+"/"+this.dbase;
    }
   
   public String getHost() throws RemoteException
   {return this.host;}
   
   public String getDBase() throws RemoteException
   {return this.dbase;}
   
	@Override
	public void changeNume(int pid, String nume) throws RemoteException {
		try{Class.forName(JDBC_DRIVER);
		  System.out.println("Connecting to database...");
		  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
	          stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "UPDATE medicament SET nume='"+nume+"' WHERE id_medicament="+pid;
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
	public void changeNume(Medicament p, String nume) throws RemoteException {
		if(!(this.host.equals(p.getHost())&&this.dbase.equals(p.getDBase())))
			return ;
		this.changeNume(p.getID(), nume);}

	@Override
	public void changeDescriere(int pid, String clasa) throws RemoteException {
		try{Class.forName(JDBC_DRIVER);
		  System.out.println("Connecting to database...");
		  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
	          stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "UPDATE medicament SET descriere='"+clasa+"' WHERE id_medicament="+pid;
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
	public void changeDescriere(Medicament p, String clasa) throws RemoteException {
		if(!(this.host.equals(p.getHost())&&this.dbase.equals(p.getDBase())))
			return ;
		this.changeDescriere(p.getID(), clasa);}

	@Override
	public void changePret(int pid, double pret) throws RemoteException {
		try{Class.forName(JDBC_DRIVER);
		  System.out.println("Connecting to database...");
		  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
	          stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "UPDATE medicament SET pret="+pret+" WHERE id_medicament="+pid;
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
	public void changePret(Medicament p,double pret) throws RemoteException {
		if(!(this.host.equals(p.getHost())&&this.dbase.equals(p.getDBase())))
			return ;
		this.changePret(p.getID(), pret);
		
	}

	@Override
	public void changePoza(int pid, String poza) throws RemoteException {
		try{Class.forName(JDBC_DRIVER);
		  System.out.println("Connecting to database...");
		  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
	          stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "UPDATE medicament SET poza='"+poza+"' WHERE id_medicament="+pid;
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
	public void changePoza(Medicament p, String poza) throws RemoteException {
		if(!(this.host.equals(p.getHost())&&this.dbase.equals(p.getDBase())))
			return ;
		this.changePoza(p.getID(), poza);
		
	}

}
