package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*
 * @author putengfei
 * @created 2017-12-17
*/
public class demo2_send {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		DatagramSocket socket = new DatagramSocket();
		while(true) {
			String line = in.nextLine();
			if("quit".equals(line)) {
				break;
			}
			DatagramPacket packet = 
					new DatagramPacket(line.getBytes(), line.getBytes().length,InetAddress.getByName("127.0.0.1"),6666);
			socket.send(packet);
		}
		socket.close();
	}
}
