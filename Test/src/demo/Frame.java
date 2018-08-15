package demo;

import java.awt.Color;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/*
 * @author putengfei
 * @created 2017-11-28
*/
@SuppressWarnings("serial")
public class Frame extends JFrame {
	JTextField jtf;
	JLabel jl1, jl2, jl3, jl4;
	JButton jb;
	JTable jtb_fast, jtb_slow, jtb_storage;
	JScrollPane jsp_fast, jsp_slow, jsp_storage;
	String[] columnName_fast, columnName_slow, columnName_storage;
	Object[][] data_fast, data_slow, data_storage;
	ImageIcon image = new ImageIcon("icon/22.jpg");
	public Frame() {
		// 初始化组件
		jl1 = new JLabel("虚页号:");
		jl2 = new JLabel("快表：");
		jl3 = new JLabel("慢表：");
		jl4 = new JLabel("主存页面表：");
		jtf = new JTextField();
		jb = new JButton("确定");
		// 初始化表头
		columnName_fast = new String[3];
		columnName_slow = new String[4];
		columnName_storage = new String[4];
		columnName_fast[0] = "用户号";
		columnName_fast[1] = "虚页号";
		columnName_fast[2] = "主存页号";
		columnName_slow[0] = "用户号";
		columnName_slow[1] = "虚页号";
		columnName_slow[2] = "主存页号";
		columnName_slow[3] = "装入位";
		columnName_storage[0] = "主存页号";
		columnName_storage[1] = "虚页号";
		columnName_storage[2] = "使用位";
		columnName_storage[3] = "Hs";
		//创建表格
		data_fast = new String[5][3];
		data_slow = new String[10][4];
		data_storage = new String[6][4];
		
		jtb_fast = new JTable(data_fast, columnName_fast);
		jtb_slow = new JTable(data_slow, columnName_slow);
		jtb_storage = new JTable(data_storage, columnName_storage);
		jsp_fast = new JScrollPane(jtb_fast);
		jsp_slow = new JScrollPane(jtb_slow);
		jsp_storage = new JScrollPane(jtb_storage);
		//设置组件位置
		setLayout(null);
		jl1.setBounds(30, 25, 70, 30);
		jtf.setBounds(85, 25, 80, 30);
		jb.setBounds(180, 25, 70, 25);	
		jl2.setBounds(30, 65, 70, 30);			//快表
		jsp_fast.setBounds(30, 95, 300, 103);
		jl3.setBounds(400, 65, 70, 30);			//慢表
		jsp_slow.setBounds(400, 95, 300, 183);
		jl4.setBounds(30, 280, 100, 30);		//主存表
		jsp_storage.setBounds(30, 310, 300, 119);
		//添加组件
		this.add(jl1);
		this.add(jtf);
		this.add(jb);
		this.add(jl2);
		this.add(jsp_fast);
		this.add(jl3);
		this.add(jsp_slow);
		this.add(jl4);
		this.add(jsp_storage);
		
		//设置表格不可编辑
		jtb_fast.setEnabled(false);
		jtb_slow.setEnabled(false);
		jtb_storage.setEnabled(false);
		
		//设置页面属性
		this.setTitle("页式虚拟存储管理");
		this.setSize(750, 550);
		this.setLocation(150, 80);
		this.getContentPane().setBackground(Color.lightGray);
		this.setIconImage(image.getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
}
