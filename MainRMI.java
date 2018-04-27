import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import classes.*;
import interfaces.*;
import interfacesch.*;
import implement.*;
import implementch.*;

public class MainRMI {
    public static void main(String args[]) {
        List<Farmacie> l;
        System.out.println(args.length);
        String host,dba,user,pass;
        if(args.length<2)
        {System.out.println("Usage <host> <dbase> <user> <pass>");
        return;}
        /*for(String s:args)
        	System.out.println(s);*/
        host=args[0];
        dba=args[1];
        user=(args.length<3)?"":args[2];
        pass=(args.length<4)?"":args[3];
        try {
            String name1 = "DBManage-"+dba;
            DBManageinter db = new DBManageReal(host,dba,user,pass);
            DBManageinter db_stub=(DBManageinter) UnicastRemoteObject.exportObject(db, 0);
            String name2 = "Medicament-"+dba;
            Medicamentinter prod = new MedicamentReal(host,dba,user,pass);
            Medicamentinter prod_stub =(Medicamentinter) UnicastRemoteObject.exportObject(prod, 0);
            String name3 = "Med_Farm-"+dba;
            Med_Farmacieinter st = new Med_FarmacieReal(host,dba,user,pass);
            Med_Farmacieinter st_stub =(Med_Farmacieinter) UnicastRemoteObject.exportObject(st, 0);
            String name4 = "Farmacie-"+dba;
            Farmacieinter fa = new FarmacieReal(host,dba,user,pass);
            Farmacieinter fa_stub =(Farmacieinter) UnicastRemoteObject.exportObject(fa, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name1, db_stub);
            System.out.println("DB bound");
            registry.rebind(name2, prod_stub);
            System.out.println("Produs bound");
            registry.rebind(name3, st_stub);
            System.out.println("Stoc bound");
            registry.rebind(name4, fa_stub);
            System.out.println("Farmacie bound");
            String name5 = "DBManagech-"+dba;
            DBManageinterch dbch = new DBManagech(host,dba,user,pass);
            DBManageinterch dbch_stub=(DBManageinterch) UnicastRemoteObject.exportObject(dbch, 0);
            String name6 = "Medicamentch-"+dba;
            Medicamentinterch prodch = new Medicamentch(host,dba,user,pass);
            Medicamentinterch prodch_stub =(Medicamentinterch) UnicastRemoteObject.exportObject(prodch, 0);
            String name7 = "Med_Farmch-"+dba;
            Med_Farmacieinterch stch = new Med_Farmaciech(host,dba,user,pass);
            Med_Farmacieinterch stch_stub =(Med_Farmacieinterch) UnicastRemoteObject.exportObject(stch, 0);
            String name8 = "Farmaciech-"+dba;
            Farmacieinterch fach = new Farmaciech(host,dba,user,pass);
            Farmacieinterch fach_stub =(Farmacieinterch) UnicastRemoteObject.exportObject(fach, 0);
            registry.rebind(name5, dbch_stub);
            System.out.println("DBch bound");
            registry.rebind(name6, prodch_stub);
            System.out.println("Produsch bound");
            registry.rebind(name7, stch_stub);
            System.out.println("Stocch bound");
            registry.rebind(name8, fach_stub);
            System.out.println("Farmaciech bound");
            l=db.getFarmacii();
    	for(Farmacie f:l)
    	{System.out.println(f.getHost()+" "+f.getID()+"  "+f.getNume()+" "+f.getAdresa()+" "+f.getNrtel());
    	}
      } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
