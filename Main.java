import java.util.List;

import classes.*;
import interfaces.*;
import interfacesch.DBManageinterch;
import implement.*;
import implementch.DBManagech;
public class Main {
    public static void main(String args[]) {
        List<Farmacie> l;
        try {
    	DBManageinter ai=new DBManageReal("localhost","PAD","root","");
    	//Med_Farmacieinter si=new StocReal("localhost","Test","root","");
    	//Medicamentinter pi=new ProdusReal("localhost","Test","root","");
    	//Farmacieinter fi=new FarmacieReal("localhost","Test","root","");
    	//DBManageinterch mic=new DBManagech("localhost","Test","root",""); 
    	//mic.addFarmacie("Ceva","Panselute 7","0778909787", "Temesvarin ", "18:00-22:00");
    	//mic.addProdus("SET", "CLASS");
    	l=ai.getFarmacii();
    	for(Farmacie f:l)
    	{System.out.println(f.getHost()+" "+f.getID()+"  "+f.getNume()+" "+" "+f.getAdresa()+" "+" "+f.getNrtel());   	
    	}
        }catch(Exception e)
        {e.printStackTrace();}
    	}
}
