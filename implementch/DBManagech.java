package implementch;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Farmacie;
import classes.Med_Farmacie;
import classes.Medicament;
import interfacesch.*;
import implement.*;
import interfaces.DBManageinter;

public class DBManagech implements DBManageinterch{
	private String JDBC_DRIVER = "com.mysql.jdbc.Driver",host;  
	private String DB_URL,dbase;
	private String USER;
	private String PASS;
	private Connection conn = null;
	private Statement stmt = null;
    public DBManagech(String host,String dbase,String USER,String PASS)
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
public void addFarmacie(String nume, String adresa, String nrtel) throws RemoteException{
	 try{Class.forName(JDBC_DRIVER);
	  System.out.println("Connecting to database...");
	  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
          stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "INSERT INTO farmacie (nume,adresa,telefon) VALUES ('"+nume+"','"+adresa+"','"+nrtel+"')";
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
public void addMedicament(String nume, String desc,double pret,String poza) throws RemoteException{
	try{Class.forName(JDBC_DRIVER);
	  System.out.println("Connecting to database...");
	  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "INSERT INTO medicament (nume,descriere,pret,poza) VALUES ('"+nume+"','"+desc+"',"+pret+",'"+poza+"')";
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
public void addMed_Farmacie(int id_farmacie, int id_medicament, int cantitate) throws RemoteException{
	try{Class.forName(JDBC_DRIVER);
	  System.out.println("Connecting to database...");
	  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "INSERT INTO med_farmacie (id_farmacie,id_medicament,cantitate) VALUES ("+id_farmacie+","+id_medicament+","+cantitate+")";
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
public void addMed_Farmacie(String fNume, String pNume, int cantitate) throws RemoteException{
	DBManageinter mi=new DBManageReal(this.host,this.dbase,this.USER,this.PASS);
		Farmacie f=mi.getFarmacieNume(fNume);
		Medicament m=mi.getMedicamentName(pNume);
		if(f!=null&&m!=null)
		{if(!(this.host.equals(m.getHost())&&this.dbase.equals(m.getDBase()))||!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
			return ;
		this.addMed_Farmacie(f.getID(), m.getID(), cantitate);}}

@Override
public void addMed_Farmacie(Farmacie f, Medicament m, int cantitate) throws RemoteException {
	if(!(this.host.equals(m.getHost())&&this.dbase.equals(m.getDBase()))||!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
		return ;
	this.addMed_Farmacie(f.getID(), m.getID(), cantitate);}



@Override
public void deleteMed_Farmacie(Farmacie f, Medicament p) throws RemoteException {
	if(!(this.host.equals(p.getHost())&&this.dbase.equals(p.getDBase()))||!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
		return ;
	this.deleteMed_Farmacie(f.getID(), p.getID());
	
}

@Override
public void deleteMed_Farmacie(int id_farmacie, int id_medicament) throws RemoteException {
	try{Class.forName(JDBC_DRIVER);
	  System.out.println("Connecting to database...");
	  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "DELETE * FROM med_farmacie WHERE id_farmacie="+id_farmacie+" AND id_medicament="+id_medicament;
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
public void deleteMed_Farmacie(Med_Farmacie s) throws RemoteException {
	if(!(this.host.equals(s.getHost())&&this.dbase.equals(s.getDBase())))
		return ;
	this.deleteMed_Farmacie(s.getIDMedFarm());
	
}

@Override
public void deleteMed_Farmacie(int id_med_farmacie) throws RemoteException {
	try{Class.forName(JDBC_DRIVER);
	  System.out.println("Connecting to database...");
	  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "DELETE * FROM med_farmacie WHERE ID="+id_med_farmacie;
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
public void deleteMedicament(Medicament m) throws RemoteException {
	if(!(this.host.equals(m.getHost())&&this.dbase.equals(m.getDBase())))
		return ;
	this.deleteMedicament(m.getID());
	
}

@Override
public void deleteMedicament(int id_medicament) throws RemoteException {
	try{Class.forName(JDBC_DRIVER);
	  System.out.println("Connecting to database...");
	  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "DELETE S,P FROM med_farmacie S RIGHT JOIN medicament P ON P.id_medicament=S.id_medicament WHERE P.id_medicament="+id_medicament;
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
public void deleteMedicament(String mNume) throws RemoteException {
	DBManageinter mi=new DBManageReal(this.host,this.dbase,this.USER,this.PASS);
	Medicament p=mi.getMedicamentName(mNume);
	if(p!=null)
	{if(!(this.host.equals(p.getHost())&&this.dbase.equals(p.getDBase())))
		return ;
	this.deleteMedicament(p.getID());}
	
}

@Override
public void deleteFarmacie(Farmacie f) throws RemoteException {
	if(!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
		return ;
	this.deleteFarmacie(f.getID());
	
}

@Override
public void deleteFarmacie(int id_farmacie) throws RemoteException {
	try{Class.forName(JDBC_DRIVER);
	  System.out.println("Connecting to database...");
	  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
    stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "DELETE S,F FROM med_farmacie S RIGHT JOIN farmacie F ON F.id_farmacie=S.id_farmacie WHERE F.id_farmacie="+id_farmacie;
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
public void deleteFarmacie(String fNume) throws RemoteException {
	DBManageinter mi=new DBManageReal(this.host,this.dbase,this.USER,this.PASS);
	Farmacie f=mi.getFarmacieNume(fNume);
	if(f!=null)
	{if(!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
		return ;
	this.deleteFarmacie(f.getID());}
	
}
}
