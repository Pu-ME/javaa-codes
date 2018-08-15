package com.socket;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * @author putengfei
 * @created 2017-12-17
*/
public class chat extends JFrame{
	public chat() {
		southPanel();
		init();
	}
	public void southPanel() {
		JPanel south = new JPanel();
		JTextField jtf = new JTextField(8);
		JButton send = new JButton("发 送");
		JButton log = new JButton("记 录");
		JButton clear = new JButton("清 屏");
		JButton shake = new JButton("震 动");
		south.add(jtf);
		south.add(send);
		south.add(log);
		south.add(clear);
		south.add(shake);
		this.add(south,BorderLayout.SOUTH);
	}
	public void init() {
		this.setTitle("chat");
		this.setLocation(400, 50);
		this.setSize(400, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new chat();
	}
}
