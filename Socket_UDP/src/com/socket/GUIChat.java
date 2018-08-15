package com.socket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * @author putengfei
 * @created 2017-12-17
*/

public class GUIChat extends JFrame{
	private JTextField tf;
	private JButton send;
	private JButton log;
	private JButton clear;
	private JButton shake;
	private JTextArea viewText;
	private JTextArea sendText;
	/*
	 * 
	 */
	public  GUIChat(){
		new Receive().start();
		southPanel();
		centerPanel();
		init();
		event();
	}
	public void event() {
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					send();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}	
		});
		
	}
	private void send() throws IOException {
		String message = sendText.getText();
		String ip = tf.getText();
		DatagramSocket socket = new DatagramSocket();
		DatagramPacket packet = 
				new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getByName(ip),9999);
		socket.send(packet);
		String time = getCurrentTime();
		viewText.append(time + " 我对 " + tf.getText() + "说：\r\n" + message + "\r\n\r\n");
		sendText.setText("");
		socket.close();
	}
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		return sdf.format(date);
	}
	public void centerPanel() {
		JPanel center = new JPanel();
		viewText = new JTextArea();
		sendText = new JTextArea(5,1);
		center.setLayout(new BorderLayout());
		center.add(sendText,BorderLayout.SOUTH); 
		center.add(viewText,BorderLayout.CENTER);
		viewText.setEditable(false);
		viewText.setBackground(Color.LIGHT_GRAY);
		this.add(center,BorderLayout.CENTER);
	}
	public void southPanel() {
		JPanel south = new JPanel();
		tf = new JTextField(8);
		tf.setText("127.0.0.1");
		tf.setEditable(false);
		send = new JButton("发 送");
		log = new JButton("记 录");
		clear = new JButton("清 屏");
		shake = new JButton("震 动");
		south.add(tf);
		south.add(send);
		south.add(log);
		south.add(clear);
		south.add(shake);
		this.add(south,BorderLayout.SOUTH);
	}
	public void init() {	
		this.setLocation(500, 50);
		this.setSize(400, 600);
	
		this.setTitle("GUI聊天室");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private class Receive extends Thread{
		public void run() {
			try {
				DatagramSocket socket = new DatagramSocket();
				DatagramPacket packet = new DatagramPacket(new byte[8192], 8192);
				while(true) {	
				socket.receive(packet);
				byte[] arr = packet.getData();
				int len = packet.getLength();
				String message = new String(arr,0,len);
				String time = getCurrentTime();
				String ip = packet.getAddress().getHostAddress();
				viewText.append(time + ip + " 我对说：\r\n" + message + "\r\n\r\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new GUIChat();
	}
}
