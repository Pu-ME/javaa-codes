package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * @author putengfei
 * @created 2017-12-17
*/
public class demo2_receive {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(6666);
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
		
		while(true) {	
			socket.receive(packet);
			byte[] arr = packet.getData();
			int len = packet.getLength();
			String ip = packet.getAddress().getHostAddress();
			int port = packet.getPort();
			System.out.println(ip + ":" + port + new String(arr,0,len));
		}

	}
}
