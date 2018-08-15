package com.system;

/*
 * @author putengfei
 * @created 2017-11-28
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Deal implements ActionListener {

	// 界面
	ManageFrame mFrame;
	// 快表
	Vector<FastTable> fTables;
	// 慢表
	Vector<SlowTable> sTables;
	// 主存页面表
	Vector<StoragePageTable> mTables;
	// 第一次刷新的标志
	static boolean isFirst = true;

	public static void main(String[] args) {
		new Deal();
	}

	public Deal() {
		mFrame = new ManageFrame();
		// 添加事件监听
		mFrame.jButton_ensure.addActionListener(this);
		mFrame.jButton_ensure.setActionCommand("ensure");
		mFrame.jButton_exit.addActionListener(this);
		mFrame.jButton_exit.setActionCommand("exit");

		// 初始化主存页面表
		mTables = new Vector<>();
		mTables.add(new StoragePageTable("0"));
		mTables.add(new StoragePageTable("1"));
		mTables.add(new StoragePageTable("2"));

		// 初始化页表
		sTables = new Vector<>();
		sTables.add(new SlowTable("1", "0", "0", true));
		sTables.add(new SlowTable("1", "1", "1", true));
		sTables.add(new SlowTable("1", "2", "2", true));
		sTables.add(new SlowTable("1", "3", "-1", false));
		sTables.add(new SlowTable("1", "4", "-1", false));
		sTables.add(new SlowTable("1", "5", "-1", false));
		sTables.add(new SlowTable("1", "6", "-1", false));
		sTables.add(new SlowTable("1", "7", "-1", false));
		sTables.add(new SlowTable("1", "8", "-1", false));

		// 初始化快表
		fTables = new Vector<>();
		fTables.add(new FastTable("1", String.valueOf(hash(0)), "0"));
		fTables.add(new FastTable("1", String.valueOf(hash(1)), "1"));
		fTables.add(new FastTable("1", String.valueOf(hash(2)), "2"));

		refresh();
	}

	/**
	 * 获取在块表中的位置
	 * 
	 * @param virturalNumber
	 * @return
	 */
	public int hash(int virturalNumber) {
		return virturalNumber % 4;
	}

	/**
	 * 更新界面
	 */
	public void refresh() {
		int flag = 0;
		// 获取主存页面表的信息
		for (int i = 0; i < mTables.size(); i++) {
			if (!isFirst) {
				// System.out.println("i = " + i + " " + mTables.get(i).isUsing());
				if (false == mTables.get(i).isUsing()) {
					mTables.get(i).setHs(mTables.get(i).getHs() + 1);
				} else {
					mTables.get(i).setHs(0);
					flag = i;
				}
			}
			mFrame.data_storage[i][0] = mTables.get(i).getStorageNumber();
			mFrame.data_storage[i][1] = String.valueOf(mTables.get(i).isOccuping());
			mFrame.data_storage[i][2] = String.valueOf(mTables.get(i).isUsing());
			mFrame.data_storage[i][3] = String.valueOf(mTables.get(i).getHs());
		}
		// 获取慢表的信息
		for (int i = 0; i < sTables.size(); i++) {
			mFrame.data_slow[i][0] = sTables.get(i).getUserID();
			mFrame.data_slow[i][1] = sTables.get(i).getVirturalNumber();
			mFrame.data_slow[i][2] = sTables.get(i).getStorageNumber();
			mFrame.data_slow[i][3] = String.valueOf(sTables.get(i).isUsing());
		}
		// 获取快表的信息
		for (int i = 0; i < fTables.size(); i++) {
			mFrame.data_fast[i][0] = fTables.get(i).getUserID();
			mFrame.data_fast[i][1] = fTables.get(i).getVirturalNumber();
			mFrame.data_fast[i][2] = fTables.get(i).getStorageNumber();
		}
		mFrame.jtb_fast.updateUI();
		mFrame.jsp_fast.updateUI();
		mFrame.jtb_slow.updateUI();
		mFrame.jsp_slow.updateUI();
		mFrame.jtb_storage.updateUI();
		mFrame.jsp_storage.updateUI();
		isFirst = false;
		mTables.get(flag).setUsing(false);
	}

	/**
	 * 在快表中查找输入的虚页号
	 * 
	 * @param string
	 * @return
	 */
	public boolean findInFast(String string) {
		boolean isHaving = false;
		for (int i = 0; i < fTables.size(); i++) {
			if (string.equals(fTables.get(i).getVirturalNumber())) {
				String str = fTables.get(i).getStorageNumber();
				for (int j = 0; j < mTables.size(); j++) {
					if (str.equals(mTables.get(j).getStorageNumber())) {
						mTables.get(j).setUsing(true);
						break;
					}
				}
				isHaving = true;
				break;
			}
		}
		return isHaving;
	}

	/**
	 * 在慢表中查找输入的虚页号
	 * 
	 * @param string
	 * @return
	 */
	public boolean findInSlow(String string) {
		boolean isHaving = false;
		for (int i = 0; i < sTables.size(); i++) {
			if (sTables.get(i).getVirturalNumber().equals(string)) {
				// flag 记录主存页表中历史位最大的下标
				String temp = "";
				// 该页面在主存
				if (!sTables.get(i).getStorageNumber().equals("-1")) {
					// 更新主存页面表
					for (int j = 0; j < mTables.size(); j++) {
						if (mTables.get(j).getStorageNumber().equals(sTables.get(i).getStorageNumber())) {
							temp = mTables.get(j).getStorageNumber();
							mTables.get(j).setUsing(true);
							break;
						}
					}
					// 更新慢表
					sTables.get(i).setUsing(true);
					sTables.get(i).setStorageNumber(temp);

					// 更新快表
					updateFast(string, sTables.get(i).getStorageNumber());
					isHaving = true;
				}
				break;
			}
		}
		return isHaving;
	}

	/**
	 * 返回主存页面中历史位最大的下标
	 * 
	 * @return
	 */
	public int getMaxSubscriptInM() {
		int flag = 0, max = 0;
		// 查找主存页面表中最大历史位的下标
		for (int j = 0; j < mTables.size(); j++) {
			if (mTables.get(j).getHs() > max) {
				flag = j;
				max = mTables.get(j).getHs();
			}
		}
		return flag;
	}

	/**
	 * 返回快表中应该被撤出的页面的下标
	 * 
	 * @return
	 */
	public int getMaxSubscriptInF() {
		int flag = 0;
		int max = 0;
		// 查找快表中最大历史位的下标
		for (int j = 0; j < mTables.size(); j++) {
			for (int k = 0; k < fTables.size(); k++) {
				if (fTables.get(k).getStorageNumber().equals(mTables.get(j).getStorageNumber())) {
					if (mTables.get(j).getHs() > max) {
						max = mTables.get(j).getHs();
						flag = j;
					}
				}
			}
		}
		return flag;
	}

	/**
	 * 处理缺页中断
	 */
	public void interruptHandle(String string) {
		String storageNumber = "", leaveSNumber = "";
		// 如果主存页表还有空间
		if (mTables.size() < 6) {
			storageNumber = getStorageNumber();
			mTables.add(new StoragePageTable(storageNumber));
		} else {
			int flag = getMaxSubscriptInM();
			storageNumber = mTables.get(flag).getStorageNumber();
			leaveSNumber = mTables.get(flag).getStorageNumber();
			mTables.add(new StoragePageTable(storageNumber));
			mTables.remove(flag);
		}
		// 更新主存页表信息
		for (int j = 0; j < mTables.size(); j++) {
			if (mTables.get(j).getStorageNumber().equals(storageNumber)) {
				mTables.get(j).setUsing(true);
				break;
			}
		}
		// 更新慢表中的信息
		for (int i = 0; i < sTables.size(); i++) {
			if (sTables.get(i).getStorageNumber().equals(leaveSNumber)
					&& !sTables.get(i).getVirturalNumber().equals(string)) {
				sTables.get(i).setStorageNumber("-1");
				sTables.get(i).setUsing(false);
			} else if (sTables.get(i).getVirturalNumber().equals(string)) {
				sTables.get(i).setStorageNumber(storageNumber);
				sTables.get(i).setUsing(true);
			}
		}
		// 更新快表中的信息
		updateFast(string, storageNumber);
	}

	public void updateFast(String string, String storageNumber) {
		int flag = 0;
		if (fTables.size() < 4) {
			fTables.add(hash(Integer.valueOf(string)), new FastTable("1", string, storageNumber));
		} else {// 快表没有空闲页面,则将最近最久未使用的页面调出，进行替换
			flag = getMaxSubscriptInF();
			String storageNumber1 = mTables.get(flag).getStorageNumber();
			// 在快表中找到要被替换的页面，将其替换
			for (int j = 0; j < fTables.size(); j++) {
				if (storageNumber1.equals(fTables.get(j).getStorageNumber())) {
					fTables.remove(j);
					fTables.add(hash(Integer.valueOf(string)), new FastTable("1", string, storageNumber));
					break;
				}
			}
		}
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getStorageNumber() {
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			temp.append(i);
		}
		for (int i = 0; i < mTables.size(); i++) {
			for (int j = 0; j < temp.length(); j++) {
				if (mTables.get(i).getStorageNumber().equals(String.valueOf(temp.charAt(j)))) {
					temp.deleteCharAt(j);
					break;
				}
			}
		}
		return String.valueOf(temp.charAt(0));
	}

	/**
	 * 界面监听以及执行动作
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 用户按下确定键
		if (e.getActionCommand().equals("ensure")) {
			String virturalNumber = mFrame.jtf.getText();
			// 判断输入是否规范
			if (!virturalNumber.matches("[0-8]")) {
				JOptionPane.showMessageDialog(null, "无效的虚页号", "警告信息", JOptionPane.WARNING_MESSAGE);
			} else {
				// 在快表中查找该页
				if (findInFast(virturalNumber)) {// 如果快表进行过改动，则更新
					JOptionPane.showMessageDialog(null, "已在快表中", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				} else {// 快表中没有，在慢表中查找该页是否装入主存
					if (findInSlow(virturalNumber)) {// 如果慢表有改动，则更新
						JOptionPane.showMessageDialog(null, "正在从慢表调入快表。。。", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					} else {// 如果该页没有装入主存，则产生缺页中断
						JOptionPane.showMessageDialog(null, "缺页中断，正在调入。。。", "提示信息", JOptionPane.INFORMATION_MESSAGE);
						interruptHandle(virturalNumber);
					}
				}
				refresh();
			}
			mFrame.jtf.setText("");
		} else if (e.getActionCommand().equals("exit")) {
			System.exit(0);
		}
	}
}
