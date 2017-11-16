package main.domain.socket.server;

import java.util.HashMap;

import net.sf.json.JSONObject;

public class SocketServer {
	private String ip;
	private String con;
	
	public SocketServer() {
		this.ip = "1.1.1.1";
		this.con = "offline";
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	
	public String toJasonString() {
		String jason = null;
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("ssip", getIp());
		map.put("con", getCon());
		
		jason = JSONObject.fromObject(map).toString();
		  
		return jason;
	}
}
