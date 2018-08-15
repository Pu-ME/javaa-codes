package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * @author putengfei
 * @created 2017-11-28
*/
public class PageManage implements ActionListener {
	Frame frame;
	ArrayList<Fast_Table> fTable;
	ArrayList<Slow_Table> sTable;
	ArrayList<Storage_Table> cTable;
	static boolean isFirst = true;

	public PageManage() {
		frame = new Frame();
		// 事件监听
		frame.jb.addActionListener(this);
		frame.jb.setActionCommand("ensure");
		// 初始化主存表
		cTable = new ArrayList<>();
		cTable.add(new Storage_Table("0", "0"));
		cTable.add(new Storage_Table("1", "1"));
		cTable.add(new Storage_Table("2", "2"));
		cTable.add(new Storage_Table("3", "3"));
		// 初始化快表
		fTable = new ArrayList<>();
		fTable.add(new Fast_Table("6", String.valueOf(hash(0)), "0"));
		fTable.add(new Fast_Table("6", String.valueOf(hash(1)), "1"));
		fTable.add(new Fast_Table("6", String.valueOf(hash(2)), "2"));
		fTable.add(new Fast_Table("6", String.valueOf(hash(3)), "3"));

		// 初始化慢表
		sTable = new ArrayList<>();
		sTable.add(new Slow_Table("6", "0", "0", 1));
		sTable.add(new Slow_Table("6", "1", "1", 1));
		sTable.add(new Slow_Table("6", "2", "2", 1));
		sTable.add(new Slow_Table("6", "3", "3", 1));
		sTable.add(new Slow_Table("6", "4", "-1", 0));
		sTable.add(new Slow_Table("6", "5", "-1", 0));
		sTable.add(new Slow_Table("6", "6", "-1", 0));
		sTable.add(new Slow_Table("6", "7", "-1", 0));
		sTable.add(new Slow_Table("6", "8", "-1", 0));
		sTable.add(new Slow_Table("6", "9", "-1", 0));

		refresh();
	}
	
	public int hash(int virtualNum) {
		return virtualNum % 5;
	}

	public void refresh() {
		int flag = 0;
		// 获取主存页面表的信息
		for (int i = 0; i < cTable.size(); i++) {
			if (!isFirst) {
				if (cTable.get(i).getUsing() == 0) {
					cTable.get(i).setHs(1 + cTable.get(i).getHs());
				} else {
					cTable.get(i).setHs(0);
					flag = i;
				}
			}
			frame.data_storage[i][0] = cTable.get(i).getStorageNum();
			frame.data_storage[i][1] = cTable.get(i).getVirtualNum();
			frame.data_storage[i][2] = String.valueOf(cTable.get(i).getUsing());
			frame.data_storage[i][3] = String.valueOf(cTable.get(i).getHs());
		}
		// 获取快表信息
		for (int i = 0; i < fTable.size(); i++) {
			frame.data_fast[i][0] = fTable.get(i).getUserNum();
			frame.data_fast[i][1] = fTable.get(i).getVirtualNum();
			frame.data_fast[i][2] = fTable.get(i).getStorageNum();
		}
		// 获取慢表信息
		for (int i = 0; i < sTable.size();i++) {
			frame.data_slow[i][0] = sTable.get(i).getUserNum();
			frame.data_slow[i][1] = sTable.get(i).getVirtualNum();
			frame.data_slow[i][2] = sTable.get(i).getStorageNum();
			frame.data_slow[i][3] = String.valueOf(sTable.get(i).getUsing());
		}
		
		frame.jtb_fast.updateUI();
		frame.jsp_fast.updateUI();
		frame.jtb_slow.updateUI();
		frame.jsp_slow.updateUI();
		frame.jtb_storage.updateUI();
		frame.jsp_storage.updateUI();
		isFirst = false;
		cTable.get(flag).setUsing(0);
	}
	//快表中查找得到的虚页号
	public boolean findInFast(String string) {
		boolean isFind = false;
		for(int i = 0; i < fTable.size();i++) {
			if(string.equals(fTable.get(i).getVirtualNum())) {		//查找与输入的虚页号相等
				String str = fTable.get(i).getStorageNum();
				for(int j = 0; j < cTable.size(); j++) {
					if(str.equals(cTable.get(j).getStorageNum())) {
						cTable.get(j).setUsing(1);       //设置主存表中使用位
						cTable.get(j).setVirtualNum(string);	//设置主存表中虚页号；
						break;
					}
				}
				isFind = true;
				break;
			}
		}
		return isFind;
	}
	//在慢表中查找
	public boolean findInSlow(String string) {
		boolean isFind = false;
		for(int i = 0; i < sTable.size();i++) {
			if(sTable.get(i).getVirtualNum().equals(string)) {
				String temp = "";
				if(!sTable.get(i).getStorageNum().equals("-1")) {
					for(int j = 0; j < cTable.size(); j++) {
						if(cTable.get(j).getStorageNum().equals(sTable.get(i).getStorageNum())) {
							temp = cTable.get(j).getStorageNum();
							cTable.get(j).setUsing(1);
							cTable.get(j).setVirtualNum(string);
							break;
						}
					}
					
					sTable.get(i).setUsing(1);
					sTable.get(i).setStorageNum(temp);
			
					updateFast(string, sTable.get(i).getStorageNum());
					isFind = true ;
				}
				break;
			}
		}
		
		return isFind;
	}
	//更新快表
	public void updateFast(String string,String storageNum) {
		int flag = 0;
		if(fTable.size() < 5) {		//快表有空闲
			fTable.add(hash(Integer.valueOf(string)), new Fast_Table("6",string,storageNum));
		}
		else {		//快表无空闲，将最久未使用的页面调出，进行页面替换
			flag = getLongNoUseInFast();
			String storageNumber = cTable.get(flag).getStorageNum();	//获得主存中最久未使用的主存页号
			for(int j = 0; j < fTable.size(); j++) {
				if(storageNumber.equals(fTable.get(j).getStorageNum())) {
					fTable.remove(j);  //**********问题*********
					fTable.add(hash(Integer.valueOf(string)), new Fast_Table("6",string,storageNum));
					break;
				}
			}
		}
		
	}
	//获得快表中最久未使用
	public int getLongNoUseInFast() {
		int flag = 0;
		int max = 0;
		for(int j = 0;j<cTable.size();j++) {
			for(int k=0;k<fTable.size();k++) {
				if(fTable.get(k).getStorageNum().equals(cTable.get(j).getStorageNum())) {
					if(cTable.get(j).getHs()>max) {
						max=cTable.get(j).getHs();
						flag=j;
					}
				}
			}
		}
		return flag;
	}
	//获得主存页面Hs最大位下标
	public int getMaxHsInC() {
		int flag=0,max=0;
		for(int i=0;i<cTable.size();i++) {
			if(cTable.get(i).getHs()>max) {
				flag = i;
				max = cTable.get(i).getHs();
			}
		}
		return flag;
	}
	//在0-6之中获取尚未被装入的主存页号
	public String getStorageNumber() {
		StringBuilder temp = new StringBuilder();
		for(int i=0;i<6;i++) {
			temp.append(i);
		}
		for(int i=0;i<cTable.size();i++) {
			for(int j=0;j<temp.length();j++) {
				if(cTable.get(i).getStorageNum().equals(String.valueOf(temp.charAt(j)))) {
					temp.deleteCharAt(j);
					break;
				}
			}
		}
		return String.valueOf(temp.charAt(0));
	}
	public void interruptHandle(String string) {
		String storageNumber="",leaveNumber = "";
		//主存页面表有有剩余空间
		if(cTable.size()<6) {
			storageNumber = getStorageNumber();
			cTable.add(new Storage_Table(storageNumber,string));
		}else {
			int flag = getMaxHsInC();
			storageNumber = cTable.get(flag).getStorageNum();
			leaveNumber = cTable.get(flag).getStorageNum();
			cTable.add(new Storage_Table(storageNumber,string));
			cTable.remove(flag);
		}
		//更新主存表
		for(int j=0;j<cTable.size();j++) {
			if(cTable.get(j).getStorageNum().equals(storageNumber)) {
				cTable.get(j).setUsing(1);
				break;
			}
		}
		//更新慢表
		for(int i =0;i<sTable.size();i++) {
			if(sTable.get(i).getStorageNum().equals(leaveNumber)&&
					!sTable.get(i).getVirtualNum().equals(string)) {
				sTable.get(i).setStorageNum("-1");
				sTable.get(i).setUsing(0);
			}else if(sTable.get(i).getVirtualNum().equals(string)) {
				sTable.get(i).setStorageNum(storageNumber);
				sTable.get(i).setUsing(1);
			}
		}
		//更新快表
		updateFast(string, storageNumber);
	}
	//界面监听
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ensure")) {
			String virtualNumber = frame.jtf.getText();
			if(!virtualNumber.matches("[0-9]")) {
				JOptionPane.showMessageDialog(null, "无效的虚页号","警告",JOptionPane.INFORMATION_MESSAGE);		
			}else {
				//快表查找
				if(findInFast(virtualNumber)) {
					JOptionPane.showMessageDialog(null, "快表命中","提示",JOptionPane.INFORMATION_MESSAGE);
				}else { //不在快表，慢表中检查是否在主存
					if(findInSlow(virtualNumber)) {
						JOptionPane.showMessageDialog(null, "从慢表调入快表", "提示", JOptionPane.INFORMATION_MESSAGE);
					}else { //不在主存，产生缺页中断
						JOptionPane.showMessageDialog(null, "缺页中断", "提示", JOptionPane.INFORMATION_MESSAGE);
						interruptHandle(virtualNumber);
					}
				}
				refresh();
			}
			frame.jtf.setText("");
		}
	}

	public static void main(String[] args) {
		new PageManage();
	}
}
