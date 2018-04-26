import java.util.List;

import classes.*;
import interfaces.*;
import interfacesch.*;
import implement.*;
import implementch.*;
public class Main {
    public static void main(String args[]) {
        List<Farmacie> l;
        try {
    	DBManageinter ai=new DBManageReal("localhost","PAD","root","");
    	//Med_Farmacieinter si=new StocReal("localhost","Test","root","");
    	Medicamentinter pi=new MedicamentReal("localhost","PAD","root","");
    	Farmacieinter fi=new FarmacieReal("localhost","PAD","root","");
    	Farmacieinterch fich=new Farmaciech("localhost","PAD","root","");
    	DBManageinterch dbmch=new DBManagech("localhost","PAD","root","");
    	//DBManageinterch mic=new DBManagech("localhost","Test","root",""); 
    	//mic.addFarmacie("Ceva","Panselute 7","0778909787", "Temesvarin ", "18:00-22:00");
    	//mic.addProdus("SET", "CLASS");
    	dbmch.addFarmacie("FarmanotL.srl", "str coton nr6", "11897779779");
    	dbmch.addMedicament("AspirinaL","pastila",12.3,"ceva.png");
    	dbmch.addMed_Farmacie("FarmanotL.srl", "AspirinaL", 50);
    	l=ai.getFarmacii();
    	for(Farmacie f:l)
    	{System.out.println(f.getHost()+" "+f.getID()+"  "+f.getNume()+" "+" "+f.getAdresa()+" "+" "+f.getNrtel());   	
    	for(Medicament m:fi.getMedicamentsFarmacie(f.getID()))
    		System.out.println(m.getID()+" "+m.getNume()+"  "+m.getPoza()+" "+m.getPret()+" "+pi.getMed_Farm(m,f).getCantitate());
    	
    	
    	}
    	dbmch.deleteMedicament("AspirinaL");
    	dbmch.deleteFarmacie("FarmanotL.srl");
    	
    	//dbmch.deleteMed_Farmacie(pi.getMed_Farm(ai.getMedicamentName("AspirinaL"), ai.getFarmacieNume("FarmanotL.srl")));
        }
        catch(Exception e)
        {e.printStackTrace();}
    	}
}
