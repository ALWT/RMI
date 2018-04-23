package interfacesch;

import java.rmi.Remote;
import java.rmi.RemoteException;

import classes.*;

public interface Medicamentinterch extends Remote{
	public void changeNume(int pid,String nume) throws RemoteException;
	public void changeNume(Medicament p,String nume) throws RemoteException;
	public void changeDescriere(int pid,String clasa) throws RemoteException;
	public void changeDescriere(Medicament p,String clasa) throws RemoteException;
	public void changePret(int pid,String clasa) throws RemoteException;
	public void changePret(Medicament p,String clasa) throws RemoteException;
	public void changePoza(int pid,String clasa) throws RemoteException;
	public void changePoza(Medicament p,String clasa) throws RemoteException;
}
