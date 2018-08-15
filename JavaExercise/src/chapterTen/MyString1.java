package chapterTen;

/*
 * @author putengfei
 * @created 2017-11-17
*/
public class MyString1 {
	private char[] chars;

	public MyString1(char[] chars) {
		this.chars = new char[chars.length];
		System.arraycopy(chars, 0, this.chars, 0, chars.length);
	}

	public char charAt(int index) {
		return chars[index];
	}

	public int length() {
		return chars.length;
	}

	public MyString1 substring(int begin, int end) {
		char[] temp = new char[end - begin];
		for (int i = begin; i < end; i++) {
			temp[i - begin] = chars[i];
		}
		return new MyString1(temp);
	}

	public MyString1 toLowerCase() {
		char[] temp = new char[chars.length];
		for (int i = 0; i < chars.length; i++) {
			temp[i] = Character.toLowerCase(chars[i]);
		}
		return new MyString1(temp);
	}

	public boolean equals(MyString1 s) {
		if (chars.length == s.length()) {
			int flag = 0;
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == s.charAt(i)) {
					flag = 0;
				} else {
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				return true;
			else
				return false;
		} else
			return false;

	}

	public static MyString1 valueOf(int i) {
		char[] temp = new char[30];
		int size = 0;
		while (i != 0) {
			int number = i % 10;
			i = i / 10;
			temp[size] = (char) (number + '0');
			size++;
		}
		char[] temp2 = new char[size];
		for (int j = size - 1, k = 0; j >= 0; j--, k++) {
			temp2[k] = temp[j];
		}

		return new MyString1(temp2);
	}

	public void print() {
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyString1 s = new MyString1(new char[] { 'A', 'b', 'c' ,'d','e'});
		s.print();
		
		
		MyString1 s1 = s.substring(1, 3);
		System.out.print("Substring: ");
		s1.print();
		
		MyString1 str = s.toLowerCase();
		System.out.print("tolowercase: ");
		str.print();
		// 长度
		System.out.print("length: ");
		System.out.println(s.length());
		// 指定下标字符
		System.out.print("charAt: ");
		System.out.println(s.charAt(1));
		// 判断两个MyString1相等
		System.out.print("equals: ");
		System.out.println(s.equals(new MyString1(new char[] { 'A', 'b', 'c' ,'d','e'})));
		// 数字转换字符串
		System.out.print("valueOf: ");
		MyString1.valueOf(123456).print();
		;
	}
}
