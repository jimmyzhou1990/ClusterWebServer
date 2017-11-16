package main.service.socket.data;

import java.util.LinkedList;
import java.util.Queue;

public class SocketTransBuffer {
	static Queue<String> bufQueue = new LinkedList<String>();
	
	public static void insertNode(String node) {
		bufQueue.offer(node);
	}
		
	public static String getNode() {
		return bufQueue.poll();
	}
}
