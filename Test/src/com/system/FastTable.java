package com.system;
/*
 * @author putengfei
 * @created 2017-11-28
*/
public class FastTable {
	//用户号
	private String userID;
	//虚页号
	private String virturalNumber;
	//主存页号
	private String storageNumber;
	
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

	
	public FastTable(String userID, String virturalNumber, String storageNumber){
		this.userID = userID;
		this.virturalNumber = virturalNumber;
		this.storageNumber = storageNumber;
	}
}