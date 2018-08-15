package ChapterTwelve;

import java.util.Scanner;

/*
 * @author putengfei
 * @created 2017-12-08
*/
public class Seven {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);		
		while (true) {
			System.out.print("enter the binaryString:");
			String binaryString = in.nextLine();
			System.out.println(bin2Dec(binaryString));			
		}
		
	}

	/*
	 * @ param binaryString
	 * 
	 * @return
	 */
	public static int bin2Dec(String binaryString) {
		int value = 0;
		for (int i = 0; i < binaryString.length(); i++) {
			char ch = binaryString.charAt(i);
			if (ch == '0' || ch == '1') {
				value = value * 2 + binaryString.charAt(i) - '0';
			} else {
				throw new NumberFormatException("a error binaryString " + binaryString);
			}
		}
		return value;
	}
}
