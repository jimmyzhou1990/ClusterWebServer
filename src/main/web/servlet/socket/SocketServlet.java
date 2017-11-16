package main.web.servlet.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.service.socket.client.ClientsManager;
import main.service.socket.server.ServerManager;

import  main.service.socket.data.SocketTransBuffer;


public class SocketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SocketManager socketManager = null;
	
	
	//get方法
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//System.out.println("This is SocketServlet!");
		String ssip = request.getParameter("ssip");
		System.out.println("Get ssip: " + ssip);
		socketManager.setSocketServerName(ssip);
		
		ServletContext SC = getServletContext();
	}
	
	//post方法
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//状态管理类
	public class SocketManager
	{
		private String SocketServerName = null;
		//ReentrantLock lock = null; 
		
		/*
		 *  构造方法
		 */
		public SocketManager(String ip)
		{
			SocketServerName = "/".concat(ip);
			//lock = new ReentrantLock();
		}
		
		/* 重置socketServer ip
		 * example: setSocketServerName("111.111.111.111")
		 */
		public synchronized void setSocketServerName(String ip) {
			if (ip != null)
			{
				SocketServerName = "/".concat(ip);
			}
		}
		
		/* 获取socketServer ip
		 * example: String name = getSocketServerName()
		 */
		public synchronized String getSocketServerName() {
			return SocketServerName;
		}
		
		public boolean equalTo(String ip) {
			return  (SocketServerName.equals("/".concat(ip)));
		}
	}
	
	//socket master线程, 监听socket服务器处理接收
	public class SocketMasterThread extends Thread
	{
		private BufferedReader bufferedReader;
		private PrintWriter printWriter;
		
		public SocketMasterThread() {
			start();
		}
		
		public void run() 
		{
			
			//创建Server
			int port = 8887;
			int backlog = 30;
			InetAddress bindAddr;
			try {
				bindAddr = InetAddress.getLocalHost();
				System.out.println("本地IP = " + bindAddr);
				
				//创建socket server
				ServerSocket server = new ServerSocket(port, backlog, bindAddr);
				
				
				while(true)
				{
					//监听
					System.out.println("start to listen <" + ServerManager.getIP() + ">");
					
					Socket socket = server.accept();
					
					socket.setSoTimeout(1000);
					String client = socket.getInetAddress().toString();
					System.out.println("get connection with <" + client + "> !");
					bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
					printWriter = new PrintWriter(socket.getOutputStream(), true);
					
					while (true)
					{
						//判断ip是否为需要监听的ip
						if (ServerManager.getIP().equals(client))
						{	
							ServerManager.setCon("online");
						}
						else
						{
							//ip有更改,退出
							System.out.println(client + " is not equal to " + ServerManager.getIP() + ", refuse to connect!");
							break;
						}
						
						//创建发送线程
						String trans = SocketTransBuffer.getNode();
						if (trans != null)
						{
							new SocketTransThread(socket, trans);
						}
						
						//读接收
						String line;
						try {
							line = bufferedReader.readLine();
							System.out.println(line);	
							ClientsManager.setClientsStatus(line);	
						}
						catch (SocketTimeoutException e) {
							// 连接超时
							System.out.println("read form <" + ServerManager.getIP() + "> time out!");
						}
						catch (IOException e)
						{
							//连接出错
							System.out.println("lose connect to <" +  ServerManager.getIP() + ">");
							break;
						}
						
					}
					
					//设置为offline
					ServerManager.setCon("offline");
					socket.close();  //关闭连接	
				}
			}
			catch (IOException e) {
				// TODO: handle exception
				System.out.println("cannot create SocketServer!");
			}
		}
	}
	
	//socket 发送线程
	public class SocketTransThread extends Thread
	{
		private Socket socket;
		private String transBuf;
		public SocketTransThread(Socket socket, String transBuf) {
			super();
			this.socket = socket;
			this.transBuf = transBuf;
			
			start();
		}
		
		public void run()
		{
			try {
				System.out.println("Send \"" + transBuf + "\"");
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
				printWriter.println(transBuf);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Send \"" + transBuf + "\" fail!");
			}
		}
	}
	
	
	//控制台线程, 处理输入命令
	public class ConsoleThread extends Thread
	{
		public ConsoleThread() {
			start();
		}
		
		//命令处理类
		public class ConsoleCommand
		{
			private String commandLine = null;
			
			private static final String cmdSET = "set";
			private static final String cmdADD = "add";
			private static final String objSocketServerName = "ss";
			private static final String objSocketClientName = "sc";
			
			public ConsoleCommand(String cmd) {
				commandLine = cmd;
			}
			
			public void parse() {
				String[] command = {"cmd", "object", "value"};
				int i = 0;
				StringTokenizer st = new StringTokenizer(commandLine, " "); 
				
		        while(st.hasMoreElements()) {  
		        	command[i++] = st.nextElement().toString();
		        	if (i >= 3)    break;  //只接受3个单词
		        } 
		       
/*				for (String cmd : command)
		        {
		        	System.out.println(cmd);
		        }*/
		        
				switch (command[0])
				{
					case  cmdSET:
						switch (command[1])
						{
							case objSocketServerName:
								ServerManager.setIP(command[2]);
								break;
							case objSocketClientName:
								
								break;
						}
						break;
					case  cmdADD:
						switch (command[1]) 
						{
							case objSocketClientName:
								SocketTransBuffer.insertNode(commandLine);
								break;

							default:
								break;
						}
						break;
					
					case  "sc":
						switch (command[1])
						{
							case "???":
								SocketTransBuffer.insertNode(commandLine);
								break;
						}
					
					case "clients":
						System.out.println(ClientsManager.getClientsStatus());
						break;
				}
			}
		}
		
		public void run() {
			
			while(true)
			{
				BufferedReader sysBuff = new BufferedReader(new InputStreamReader(System.in));
				String cmd;
				
				try {
					cmd = sysBuff.readLine();
					ConsoleCommand consoleCommand = new ConsoleCommand(cmd);
					consoleCommand.parse();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(getName() + ": Wrong input, try again");
					System.out.println("clients--query all the clients online!");
				}
			}
		}
	}
	
	//SocketServlet被tomcat加载后执行init()
	public void init() throws ServletException {
		
		new ConsoleThread();
		new SocketMasterThread();
		
    }
}

