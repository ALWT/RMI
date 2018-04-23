package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;
import classes.*;

public interface Farmacieinter extends Remote {
    public List<Medicament> getMedicamentsFarmacie(Farmacie f) throws RemoteException;
    public List<Medicament> getMedicamentsFarmacie(int fid) throws RemoteException;
    public List<Medicament> getMedicamentsFarmacie(String f) throws RemoteException;
    public List<Med_Farmacie> getStocFarmacie(Farmacie f) throws RemoteException;
    public List<Med_Farmacie> getStocFarmacie(int fid) throws RemoteException;
    public List<Med_Farmacie> getStocFarmacie(String f) throws RemoteException;
    
}
