package StopWatch;

import java.util.Arrays;

public class StopWatch {
	private long startTime;
	private long endTime;
	
	public StopWatch() {
		this.startTime=System.currentTimeMillis();
	}
	
	public void start() {
		this.startTime=System.currentTimeMillis();
	}
	
	public void end() {
		this.endTime=System.currentTimeMillis();
	}
	
	public long getElapsedTime() {
		return  endTime-startTime;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StopWatch sw=new StopWatch();
		java.util.Random rd=new java.util.Random();
		int[] array=new int[100000];
		
		for(int i=0;i<100000;i++) {
			array[i]=rd.nextInt()*1000;
		}
		sw.start();
		Arrays.sort(array);
		sw.end();
		
		System.out.println(sw.getElapsedTime());
	}

}
