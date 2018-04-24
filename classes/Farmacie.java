package classes;
import java.rmi.RemoteException;


public class Farmacie implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id_farmacie;
    private String nume,adresa,host,dbase,telefon;
    
    public Farmacie(int id_farmacie,String nume,String adresa,String telefon,String host,String dbase)
    {
    	this.id_farmacie=id_farmacie;
	    this.nume=nume;
	    this.adresa=adresa;
	    this.telefon=telefon;
	    this.host=host;
	    this.dbase=dbase;
    }
    public int getID() throws RemoteException
    {
    	return this.id_farmacie;
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
    
    public String getAdresa() throws RemoteException
    {
    	return this.adresa;
    }
    public String getNrtel() throws RemoteException
    {
    	return this.telefon;
    }
     
}
