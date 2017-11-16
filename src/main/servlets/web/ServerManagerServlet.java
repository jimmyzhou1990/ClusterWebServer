package main.servlets.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.service.socket.server.ServerManager;

public class ServerManagerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().write("hello! I am ServerManagerServlet...");
		
		//System.out.println("doGet...");
		Enumeration<String> enu = request.getParameterNames();  
		while(enu.hasMoreElements()){  
			String paraName=(String)enu.nextElement();  
			System.out.println(paraName+": "+request.getParameter(paraName));  
		}
		
		String ssip = request.getParameter("ssip");
		if (ssip != null)
		{
			System.out.println("ssip: " + ssip);
			ServerManager.setIP(ssip);
			
			String response_jason = ServerManager.getStatus();
			
			System.out.println(response_jason);
			
			response.getWriter().println(response_jason);
			//System.out.println("Get ssip: " + ssip);
		}
		
		String sscon = request.getParameter("sscon");
		if (sscon != null)
		{
			//System.out.println("sscon: " + sscon);
			
			String response_jason = ServerManager.getStatus();
			System.out.println(response_jason);
			response.getWriter().println(response_jason);
		}
		
		
		 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
