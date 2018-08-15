package Date;

public class Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date date = new java.util.Date();
		date.setTime(100000000000L);
		System.out.println(date.getTime());
		
		System.out.println(date.toString());
	}

}
