package main.servlets.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.backend.Sender;

import main.domain.socket.client.SocketClient;
import main.service.socket.client.ClientsManager;
import  main.service.socket.data.SocketTransBuffer;


public class ClientsManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().write("hello! I am servlet...");
		//读取jason数据
		Enumeration<String> enu = request.getParameterNames();  
		while(enu.hasMoreElements()){  
			String paraName=(String)enu.nextElement();  
			System.out.println(paraName+": "+request.getParameter(paraName));  
		}
		
		//获取所有clients状态    {get : "all"}
		try {
			String subGet = request.getParameter("get");
			if (subGet.equals("all"))
			{
				String response_jason = ClientsManager.getClientsStatus();
				System.out.println("Send to browser: "+response_jason);
				response.getWriter().println(response_jason);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		//添加client    {add : "192.168.1.105"}
		try {
			String subAdd = request.getParameter("add");
			
			if (!subAdd.equals("null"))
			{
				SocketTransBuffer.insertNode("add sc " + subAdd);
				response.getWriter().println("{\"add\" : \"ok\"}");
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		//删除client    {remove : "192.168.1.105"}
		try {
			String subAdd = request.getParameter("remove");
			
			if (!subAdd.equals("null"))
			{
				SocketTransBuffer.insertNode("remove sc " + subAdd);
				response.getWriter().println("{\"remove\" : \"ok\"}");
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}