package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/*
 * @author putengfei
 * @created 2017-12-17
*/
public class demo1_send {
	public static void main(String[] args) throws IOException {
		String str = "whar are you doing?";
		DatagramSocket socket = new DatagramSocket();
		DatagramPacket packet = 
				new DatagramPacket(str.getBytes(), str.getBytes().length,InetAddress.getByName("127.0.0.1"),6666);
		socket.send(packet);
		socket.close();
	}
}
