package demo;

/*
 * @author putengfei
 * @created 2017-11-28
*/
public class Fast_Table {
	private String userNum;     //用户号
	private String virtualNum;	//虚页号
	private String storageNum;	//主存页号
	
	public Fast_Table(String userNum, String virtualNum, String storageNum) {
		super();
		this.userNum = userNum;
		this.virtualNum = virtualNum;
		this.storageNum = storageNum;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getVirtualNum() {
		return virtualNum;
	}

	public void setVirtualNum(String virtualNum) {
		this.virtualNum = virtualNum;
	}

	public String getStorageNum() {
		return storageNum;
	}

	public void setStorageNum(String storageNum) {
		this.storageNum = storageNum;
	}

}
