package GregorianCalendar;

public class GregorianCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.GregorianCalendar date =new java.util.GregorianCalendar();
		System.out.println("Y:"+date.get(java.util.GregorianCalendar.YEAR));
		System.out.println("M:"+date.get(java.util.GregorianCalendar.MONTH));//月份从0开始
		System.out.println("D:"+date.get(java.util.GregorianCalendar.DAY_OF_MONTH));
		System.out.println();
		date.setTimeInMillis(1234567898765L);
		
		System.out.println("Y:"+date.get(java.util.GregorianCalendar.YEAR));
		System.out.println("M:"+date.get(java.util.GregorianCalendar.MONTH));
		System.out.println("D:"+date.get(java.util.GregorianCalendar.DAY_OF_MONTH));
	}

}
