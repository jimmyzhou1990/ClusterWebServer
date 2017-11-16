package main.domain.socket.client;

public class SocketClient
{
	private String ip;
	private String con;
	private String mem;
	
	public SocketClient(String iip, String ccon, String mmem) {
		ip = iip;
		con = ccon;
		mem = mmem;
	}
	
	//转化为jason格式的字符串
	public String toJasonString() {
		return null;
	}
	
	//由jason格式转化为对象
	public void fromJason() {
		
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
	public String getMem() {
		return mem;
	}
	public void setMem(String mem) {
		this.mem = mem;
	}
	
}

