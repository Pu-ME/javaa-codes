package demo;

/*
 * @author putengfei
 * @created 2017-11-28
*/
public class Slow_Table {
	private String userNum;		//用户号
	private String virtualNum;	//虚页号
	private String storageNum; //主存页号
	private int using = 0;	//装入位

	public Slow_Table(String userNum, String virtualNum, String storageNum, int using) {
		super();
		this.userNum = userNum;
		this.virtualNum = virtualNum;
		this.storageNum = storageNum;
		this.using = using;
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

	public int getUsing() {
		return using;
	}

	public void setUsing(int using) {
		this.using = using;
	}

}
