package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * @author putengfei
 * @created 2017-12-17
*/
public class Demo3_moreHead {
	public static void main(String[] args) {
		new Receive().start();
		
		new Send().start();
	}
}

class Receive extends Thread{
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(6666);
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
			
			while(true) {	
				socket.receive(packet);
				byte[] arr = packet.getData();
				int len = packet.getLength();
				String ip = packet.getAddress().getHostAddress();
				int port = packet.getPort();
				System.out.println(ip + ":" + port + ":" + new String(arr,0,len));
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

class Send extends Thread{
	public void run() {
		try {
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
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}