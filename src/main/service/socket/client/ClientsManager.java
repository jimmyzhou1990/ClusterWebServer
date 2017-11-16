package main.service.socket.client;


public class ClientsManager
{
	static String SCStatus = new String();
	
	public static void setClientsStatus(String buf) {
		SCStatus = buf;
	}
	
	public static String getClientsStatus() {
		return SCStatus;
	}
}

/*
public class ClientsManager {
	private static LinkedList<SocketClient> Manager = new LinkedList<SocketClient>();
	
	public ClientsManager() {
		// TODO Auto-generated constructor stub
		//Manager = new LinkedList<SocketClientBean>();
	}
	
	//添加
	public static boolean add(SocketClient client) {
		//ip是否已存在
		for(Iterator<SocketClient> iter = Manager.iterator(); iter.hasNext();)
		{
			if (((SocketClient)iter.next()).getIp() == client.getIp())
			{
				System.out.println("The ip <" + client.getIp() + "> is already exist!");
				return false;
			}
		}	
		
		Manager.add(client);
		return true;
	}
	
	//更新
	public static boolean overwrite(SocketClient client) {
		//ip是否已存在
		int position = 0;
		for(Iterator<SocketClient> iter = Manager.iterator(); iter.hasNext();)
		{
			if (((SocketClient)iter.next()).getIp() == client.getIp())
			{
				Manager.add(position, client);
				Manager.remove(position+1);
				return true;
			}
			position++;
		}	
		
		System.out.println("The client <" + client.getIp() + "> is not exist!");
		return false;
	}	
	
	//删除
	public boolean delete(SocketClient client) {
		return Manager.remove(client);
	}
	
	//打印
	public static void printConsole() {
		for(Iterator<SocketClient> iter = Manager.iterator(); iter.hasNext();)
		{
			SocketClient c = (SocketClient)iter.next();
			System.out.print("<" + c.getIp() + ">");
			System.out.print("  con: " + c.getCon());
			System.out.println("  mem: " + c.getMem());	
		}
	}
	
	//转换为jason字符串
	public static String toJasonString() {
		String jasonString = null;
		for(Iterator<SocketClient> iter = Manager.iterator(); iter.hasNext();)
		{
			SocketClient c = (SocketClient)iter.next();
			jasonString += c.toJasonString();
		}
		
		return jasonString;
	}
	
	public static void main(String[] args)
	{
		SocketClient c1 = new SocketClient("1.1.1.1", "online", "10");
		SocketClient c2 = new SocketClient("2.2.2.2", "offline", "20");
		SocketClient c2_new = new SocketClient("2.2.2.2", "online", "80");
		
		//LinkedListBean listBean = new LinkedListBean();
		
		ClientsManager.add(c1);
		ClientsManager.add(c2);
		
		ClientsManager.printConsole();
		
		System.out.println("after overwrite-------------");	
		ClientsManager.overwrite(c2_new);
		
		ClientsManager.printConsole();
	}
	
}
*/