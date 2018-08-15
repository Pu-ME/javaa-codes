package MyInteger;

public class MyInteger {
	private int value;
	public MyInteger(int value) {
		this.value=value;
	}
	public int getValue() {
		return value;
	}
	public boolean isEven() {
		return value%2==0 ?true:false;
	}
	public boolean isOdd() {
		return value%2==1 ?true:false;
	}
	public boolean isPrime() {
		if(value==1) return false;
		for(int i=2;i<=Math.sqrt(value);i++) {
			if(value%i==0) return false;
		}
		return true;
	}
	public static boolean isEven(int num) {
		return num%2==0 ?true:false;
	}
	public static boolean isOdd(int num) {
		return num%2==1 ?true:false;
	}
	public static boolean isPrime(int num) {
		if(num==1) return false;
		for(int i=2;i<Math.sqrt(num);i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	public boolean equals(int num){
        return this.value == num;
    }

    public boolean equals(MyInteger num){
        return this.value == num.getValue();
    }

    public static int parseInt(char[] c){
        return Integer.parseInt(String.valueOf(c));
    }

    public static int parseInt(String s){
        return Integer.parseInt(s);
    }
}
