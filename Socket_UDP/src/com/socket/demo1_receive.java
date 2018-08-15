package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * @author putengfei
 * @created 2017-12-17
*/
public class demo1_receive {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(6666);
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
		socket.receive(packet);
		byte[] arr = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(arr,0,len));
		socket.close();
	}
}
