package demo;

/*
 * @author putengfei
 * @created 2017-11-28
*/
public class Storage_Table {
	private String storageNum;		//主存页号
	private String virtualNum;		//虚页号
	private int using = 0;			//使用位
	private int hs = 0;				//hs位

	public Storage_Table(String storageNum, String virtualNum) {
		super();
		this.storageNum = storageNum;
		this.virtualNum = virtualNum;
	}

	public String getStorageNum() {
		return storageNum;
	}

	public void setStorageNum(String storageNum) {
		this.storageNum = storageNum;
	}

	public int getHs() {
		return hs;
	}

	public void setHs(int hs) {
		this.hs = hs;
	}

	public String getVirtualNum() {
		return virtualNum;
	}

	public void setVirtualNum(String virtualNum) {
		this.virtualNum = virtualNum;
	}

	public int getUsing() {
		return using;
	}

	public void setUsing(int using) {
		this.using = using;
	}

}
