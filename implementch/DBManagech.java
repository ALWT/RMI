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
   
   public String getHost() 
   {return this.host;}
   
   public String getDBase() 
   {return this.dbase;}

@Override
public void addFarmacie(String nume, String adresa, String nrtel) {
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
public void addMedicament(String nume, String desc,double pret,String poza) {
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
public void addMed_Farmacie(int id_farmacie, int id_medicament, int cantitate) {
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
public void addMed_Farmacie(String fNume, String pNume, int cantitate) {
	try {DBManageinter mi=new DBManageReal(this.host,this.dbase,this.USER,this.PASS);
		Farmacie f=mi.getFarmacieNume(fNume);
		Medicament m;
		
			m = mi.getMedicamentName(pNume);
		
		if(f!=null&&m!=null)
		{if(!(this.host.equals(m.getHost())&&this.dbase.equals(m.getDBase()))||!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
			return ;
		this.addMed_Farmacie(f.getID(), m.getID(), cantitate);}
	} catch (RemoteException e) {
		e.printStackTrace();
	}}

@Override
public void addMed_Farmacie(Farmacie f, Medicament m, int cantitate)  {
	if(!(this.host.equals(m.getHost())&&this.dbase.equals(m.getDBase()))||!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
		return ;
	this.addMed_Farmacie(f.getID(), m.getID(), cantitate);}



@Override
public void deleteMed_Farmacie(Farmacie f, Medicament p)  {
	if(!(this.host.equals(p.getHost())&&this.dbase.equals(p.getDBase()))||!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
		return ;
	this.deleteMed_Farmacie(f.getID(), p.getID());
	
}

@Override
public void deleteMed_Farmacie(int id_farmacie, int id_medicament)  {
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
public void deleteMed_Farmacie(Med_Farmacie s)  {
	if(!(this.host.equals(s.getHost())&&this.dbase.equals(s.getDBase())))
		return ;
	this.deleteMed_Farmacie(s.getIDMedFarm());
	
}

@Override
public void deleteMed_Farmacie(int id_med_farmacie)  {
	try{Class.forName(JDBC_DRIVER);
	  System.out.println("Connecting to database...");
	  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "DELETE FROM med_farmacie WHERE id_medfarm="+id_med_farmacie;
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
public void deleteMedicament(Medicament m)  {
	if(!(this.host.equals(m.getHost())&&this.dbase.equals(m.getDBase())))
		return ;
	this.deleteMedicament(m.getID());
	
}

@Override
public void deleteMedicament(int id_medicament)  {
	try{Class.forName(JDBC_DRIVER);
	  System.out.println("Connecting to database...");
	  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "DELETE FROM med_farmacie WHERE id_medicament="+id_medicament;
		      stmt.executeUpdate(sql);
		      sql="DELETE FROM medicament WHERE id_medicament="+id_medicament;	
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
public void deleteMedicament(String mNume)  {
	try {
	DBManageinter mi=new DBManageReal(this.host,this.dbase,this.USER,this.PASS);
	Medicament p;
	
		p = mi.getMedicamentName(mNume);
	if(p!=null)
	{if(!(this.host.equals(p.getHost())&&this.dbase.equals(p.getDBase())))
		return ;
	this.deleteMedicament(p.getID());}
	} catch (RemoteException e) {
		e.printStackTrace();
	}
}

@Override
public void deleteFarmacie(Farmacie f)  {
	if(!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
		return ;
	this.deleteFarmacie(f.getID());
	
}

@Override
public void deleteFarmacie(int id_farmacie)  {
	try{Class.forName(JDBC_DRIVER);
	  System.out.println("Connecting to database...");
	  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
    stmt = (Statement) conn.createStatement();
		      String sql;
		      sql = "DELETE FROM med_farmacie WHERE id_medicament="+id_farmacie;
		      stmt.executeUpdate(sql);
		      sql="DELETE FROM farmacie WHERE id_farmacie="+id_farmacie;;
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
public void deleteFarmacie(String fNume)  {
	try{
	DBManageinter mi=new DBManageReal(this.host,this.dbase,this.USER,this.PASS);
	Farmacie f=mi.getFarmacieNume(fNume);
	if(f!=null)
	{if(!(this.host.equals(f.getHost())&&this.dbase.equals(f.getDBase())))
		return ;
	this.deleteFarmacie(f.getID());}
	}catch(Exception e) {}
}
}