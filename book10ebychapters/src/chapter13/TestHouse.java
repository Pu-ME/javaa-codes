package chapter13;

public class TestHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House house1=new House(1,1720.50);
		House house2=(House)house1.clone();
		System.out.println(house2);
	}

}
