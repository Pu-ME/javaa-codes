package Four;

import java.util.ArrayList;
import java.util.Scanner;

public class Four {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList<Integer>();
		Scanner input =new Scanner(System.in);
		int value;
		System.out.print("Enter integers (input ends with 0): ");
		do {
			value=input.nextInt();
			
			if(value!=0)
				list.add(value);
		}while(value!=0);
	System.out.print("The maximum number is " + max(list));
	}
	
	public static Integer max(ArrayList<Integer> list) {
		if(list.isEmpty()||list.size()==0)
			return null;
		int max=list.get(0);
		for(int i=1;i<list.size();i++) {
			if(max<list.get(i))
				max=list.get(i);}
		return max;
	}

}
