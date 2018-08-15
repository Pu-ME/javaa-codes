package com.system;
/*
 * @author putengfei
 * @created 2017-11-28
*/
public class SlowTable {
	//用户号
	private String userID;
	//虚页号
	private String virturalNumber;
	//主存页号
	private String storageNumber;
	//装入位
	private boolean using = false;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getVirturalNumber() {
		return virturalNumber;
	}

	public void setVirturalNumber(String virturalNumber) {
		this.virturalNumber = virturalNumber;
	}

	public String getStorageNumber() {
		return storageNumber;
	}

	public void setStorageNumber(String storageNumber) {
		this.storageNumber = storageNumber;
	}

	public boolean isUsing() {
		return using;
	}

	public void setUsing(boolean isUsing) {
		this.using = isUsing;
	}


	public SlowTable(String userID, String virturalNumber, String storageNumber, boolean using){
		this.userID = userID;
		this.virturalNumber = virturalNumber;
		this.storageNumber = storageNumber;
		this.using = using;
	}
	
}

