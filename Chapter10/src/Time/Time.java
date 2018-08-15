package Time;

public class Time {
	private long hour,minute,second;
	private long time;
	public Time() {
		time=System.currentTimeMillis();
	}
	public Time(long time) {
		this.time=time;
	}
	public Time(long hour,long minute,long second) {
		this.time=(hour*60*60+minute*60+second)*1000;
	}
	public long getHour() {
		hour=(time/1000/60/60)%24+8;
		return hour;
	}
	public long getMinte() {
		 minute=(time/1000/60)%60;
		 return minute;
	}
	public long getSecond() {
		 second=(time/1000)%60;
		 return second;
	}
	public void setTime(long elapseTime) {
		this.time=elapseTime;
	}
}
