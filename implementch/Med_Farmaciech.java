package implementch;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Med_Farmacie;
import interfacesch.Med_Farmacieinterch;

public class Med_Farmaciech implements Med_Farmacieinterch {
	private String JDBC_DRIVER = "com.mysql.jdbc.Driver",host;  
	private String DB_URL,dbase;
	private String USER;
	private String PASS;
	private Connection conn = null;
	private Statement stmt = null;
    public Med_Farmaciech(String host,String dbase,String USER,String PASS)
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
	public void changeQuantity(int id_med_farmacie, int quantity) throws RemoteException {
    	try{Class.forName(JDBC_DRIVER);
		  System.out.println("Connecting to database...");
		  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
	          stmt = (Statement) conn.createStatement();
			      String sql;
			      sql = "UPDATE med_farmacie SET cantitate="+quantity+" WHERE ID="+id_med_farmacie;
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
	public void changeQuantity(Med_Farmacie mf, int quantity) throws RemoteException {
		if(!(this.host.equals(mf.getHost())&&this.dbase.equals(mf.getDBase())))
			return ;
		this.changeQuantity(mf.getIDMedFarm(), quantity);
	}
}
