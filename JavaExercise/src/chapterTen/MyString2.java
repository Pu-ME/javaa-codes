package chapterTen;

/*
 * @author putengfei
 * @created 2017-11-17
*/
public class MyString2 {
	private String string;

	public MyString2(String s) {
		this.string = s;
	}

	public int compare(String s) {
		return string.compareTo(s);
	}

	public MyString2 substring(int begin) {
		return new MyString2(string.substring(begin));
	}

	public MyString2 toUpperCase() {
		return new MyString2(string.toUpperCase());
	}

	public char[] toChars() {
		char[] temp = new char[string.length()];
		temp = string.toCharArray();
		return temp;
	}

	public static MyString2 valueOf(boolean b) {
			return  b ? new MyString2("true") : new MyString2("false");
	}

	public void print() {
		System.out.println(string);
	}

	public int length() {
		return string.length();
	}

	public static void main(String[] args) {
		MyString2 s1 = new MyString2("abcdeFG");
		s1.print();
		
		System.out.print("compare: ");
		System.out.println(s1.compare("bcdef"));
		
		System.out.print("substring: ");
		MyString2 s2 = s1.substring(3);
		s2.print();
		
		System.out.print("toUpperCase: ");
		MyString2 s3 = s1.toUpperCase();
		s3.print();
		
		System.out.print("toChars: ");
		char[] ch = new char[s1.length()];
		ch = s1.toChars();
		for (int i = 0; i < ch.length; i++) {
			System.out.print(ch[i] + " ");
		}
		System.out.println();
		
		System.out.print("valueOf: ");
		MyString2.valueOf(true).print();
	}
}