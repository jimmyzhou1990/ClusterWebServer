package main.service.socket.server;

import main.domain.socket.server.SocketServer;

public class ServerManager {
	
	private static SocketServer Manager = new SocketServer();
	
	//设置ip 重置ip需要设为offline
	public static void  setIP(String ip) {
		Manager.setIp(ip);
		Manager.setCon("offline");
	}
	
	//设置状态
	public static void setCon(String con) {
		Manager.setCon(con);
	}
	
	//获取ip 返回"/1.1.1.1"
	public static String getIP() {
		return "/".concat(Manager.getIp());
	}
	
	//获取状态
	public static String getStatus() {
		return Manager.toJasonString();
	}
}
