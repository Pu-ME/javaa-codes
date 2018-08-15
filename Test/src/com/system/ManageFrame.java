package com.system;
/*
 * @author putengfei
 * @created 2017-11-28
*/
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class ManageFrame extends JFrame{
	
	//定义控件
	JTextField jtf;
	JLabel jLabel, jLabel2, jLabel3, jLabel4;
	JButton jButton_ensure, jButton_exit;
	JScrollPane jsp_fast, jsp_slow, jsp_storage;
	JTable jtb_fast, jtb_slow, jtb_storage;
	String[] columnName_fast, columnName_slow, columnName_storage;
	Object[][] data_fast, data_slow, data_storage;
	//Font font = new Font("楷书", Font.BOLD, 15);
	
	public ManageFrame(){
		//初始化各控件
		jLabel = new JLabel("虚页号:");
		//jLabel.setFont(font);
		jLabel2 = new JLabel("快    表:");
	//	jLabel2.setFont(font);
		jLabel3 = new JLabel("慢    表:");
	//	jLabel3.setFont(font);
		jLabel4 = new JLabel("主存页表");
		jtf = new JTextField();
		jButton_ensure = new JButton("确    定");
		//jButton_ensure.setFont(font);
		jButton_exit = new JButton("退    出");
		//jButton_exit.setFont(font);
		
		//初始化表头
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
		columnName_storage[1] = "占用位";
		columnName_storage[2] = "使用位";
		columnName_storage[3] = "历史位";
		
		//初始化列表
		data_fast = new String[4][3];
		data_slow = new String[9][4];
		data_storage = new String[6][4];
		jtb_fast = new JTable(data_fast, columnName_fast);
		jtb_slow = new JTable(data_slow, columnName_slow);
		jtb_storage = new JTable(data_storage, columnName_storage);
		jsp_fast = new JScrollPane(jtb_fast);
		jsp_slow = new JScrollPane(jtb_slow);
		jsp_storage = new JScrollPane(jtb_storage);
		
		//设置控件位置
		setLayout(null);
		jLabel.setBounds(30, 25, 70, 30);
		jtf.setBounds(85, 25, 90, 30);
		jButton_ensure.setBounds(700, 25, 90, 30);
		jButton_exit.setBounds(700, 230, 90, 30);
		
		jLabel2.setBounds(30, 95, 70, 30);
		jsp_fast.setBounds(30, 135, 350, 87);
		jLabel3.setBounds(30, 270, 70, 30);
		jsp_slow.setBounds(30, 310, 350, 167);
		jLabel4.setBounds(450, 270, 70, 30);
		jsp_storage.setBounds(450, 310, 350, 119);
		
		//使文字居中显示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		jtb_fast.setDefaultRenderer(Object.class, r);
		jtb_slow.setDefaultRenderer(Object.class, r);
		jtb_storage.setDefaultRenderer(Object.class, r);
		
		//添加控件
		add(jLabel);
		add(jtf);
		add(jButton_ensure);
		add(jButton_exit);
		add(jLabel2);
		add(jsp_fast);
		add(jLabel3);
		add(jsp_slow);
		add(jLabel4);
		add(jsp_storage);
		
		//设置标题大小等
		setTitle("页式虚拟存储管理");
		setSize(850, 550);
		setLocation(150, 80);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ManageFrame mf=new ManageFrame();
	}
}

