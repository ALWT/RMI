package classes;
import java.rmi.RemoteException;


public class Farmacist implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id_farmacist;
	private int id_farmacie;
    private String nume,parola,host,dbase;
    
    public Farmacist(int id_farmacie,int id_farmacist,String nume,String parola,String host,String dbase)
    {
    	this.id_farmacie=id_farmacie;
    	this.id_farmacist=id_farmacist;
	    this.nume=nume;
	    this.parola=parola;
	    this.host=host;
	    this.dbase=dbase;
    }
    public int getIDFarmacie() throws RemoteException
    {
    	return this.id_farmacie;
    }
    public int getIDFarmacist() throws RemoteException
    {
    	return this.id_farmacist;
    }
    public String getNume() throws RemoteException
    {
    	return this.nume;
    }
    public String getHost() throws RemoteException
    {
    	return this.host;
    }
    public String getDBase() throws RemoteException
    {
    	return this.dbase;
    }
    
    public String getParola() throws RemoteException
    {
    	return this.parola;
    }
   
     
}
