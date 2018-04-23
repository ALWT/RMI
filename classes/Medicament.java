package classes;
import java.rmi.*;



public class Medicament implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	private int id_medicament;
	private double pret;
    private String nume,descriere,poza,host,dbase;
    
    public Medicament(int id_medicament,String nume,double pret,String poza,String descriere,String host,String dbase)
    {
    	this.id_medicament=id_medicament;
	    this.nume=nume;
	    this.descriere=descriere;
	    this.poza=poza;
	    this.pret=pret;	    
	    this.host=host;
	    this.dbase=dbase;
     }
    
    public int getID() throws RemoteException
    {
    	return this.id_medicament;
    }
    public String getNume() throws RemoteException
    {
    	return this.nume;
    }
    public String getPoza() throws RemoteException
    {
    	return this.poza;
    }
    public String getDescriere() throws RemoteException
    {
    	return this.descriere;
    }
    public double getPret() throws RemoteException
    {
    	return this.pret;
    }
    public String getHost() throws RemoteException
    {
    	return this.host;
    }
    public String getDBase() throws RemoteException
    {
    	return this.dbase;
    }
}