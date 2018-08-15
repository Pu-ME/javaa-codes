package Time;

public class TestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time time1=new Time();
		Time time2=new Time(555550000-8*60*60*1000);
		System.out.println("Time1 is "+time1.getHour()+":"+time1.getMinte()+":"+time1.getSecond()+"GMT");
		System.out.println("Time2 is "+time2.getHour()+":"+time2.getMinte()+":"+time2.getSecond()+"GMT");
	}

}
