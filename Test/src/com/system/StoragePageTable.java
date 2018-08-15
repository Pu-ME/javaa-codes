package com.system;
/*
 * @author putengfei
 * @created 2017-11-28
*/
public class StoragePageTable {
	//主存页号
	private String storageNumber;
	//使用位
	private boolean isUsing;
	//占用位
	private boolean isOccuping;
	//历史位
	private int hs;
	
	public String getStorageNumber() {
		return storageNumber;
	}
	public void setStorageNumber(String storageNumber) {
		this.storageNumber = storageNumber;
	}
	public boolean isUsing() {
		return isUsing;
	}
	public void setUsing(boolean isUsing) {
		this.isUsing = isUsing;
	}
	public boolean isOccuping() {
		return isOccuping;
	}
	public void setOccuping(boolean isOccuping) {
		this.isOccuping = isOccuping;
	}
	public int getHs() {
		return hs;
	}
	public void setHs(int hs) {
		this.hs = hs;
	}
	
	public StoragePageTable(String storageNumber) {
		this.storageNumber = storageNumber;
		isUsing = false;
		isOccuping = true;
		hs = 0;
	}
}
