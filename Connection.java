import java.util.ArrayList;
import java.util.List;

public class Connection 
{
	private static List<Server> serv_list=null;
	public static List<Server> getServ_list() 
	{
		if(serv_list==null)
		{
			serv_list=new ArrayList<Server>();
			serv_list.add(new Server("192.168.1.56","farmacie-arad"));
			serv_list.add(new Server("192.168.1.56","farmacie-timisoara"));
			
			//serv_list.add(new Server("localhost","farmacie-timisoara"));
			//serv_list.add(new Server("localhost","Test"));
			//serv_list.add(new Server("localhost","farmacie-arad"));
			//serv_list.add(new Server("192.168.43.129","PAD1"));
			//serv_list.add(new Server("192.168.43.129","PAD"));
		}
		return serv_list;
	}
}
