package classes;
import java.rmi.RemoteException;


public class Med_Farmacie implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id_medicament;
	private int id_farmacie;
	private int id_med_farm,cantitate;
    private String host,dbase;
    
    public Med_Farmacie(int id_farmacie,int id_medicament,int id_med_farm,int cantitate,String host,String dbase)
    {
    	this.id_farmacie=id_farmacie;
    	this.id_medicament=id_medicament;
    	this.id_med_farm=id_med_farm;
	    this.cantitate=cantitate;
	    this.host=host;
	    this.dbase=dbase;
    }
    public int getIDFarmacie() throws RemoteException
    {
    	return this.id_farmacie;
    }
    public int getIDMedicament() throws RemoteException
    {
    	return this.id_medicament;
    }
    public int getIDMedFarm() throws RemoteException
    {
    	return this.id_med_farm;
    }
    public int getCantitate() throws RemoteException
    {
    	return this.cantitate;
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
