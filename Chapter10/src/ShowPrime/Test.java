package ShowPrime;
import Practice.StackOfIntegers;
public class Test {
	
	public static boolean isPrime(int value) {
		if(value==1) return false;
		for(int i=2;i<=Math.sqrt(value);i++) {
			if(value%i==0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackOfIntegers stack =new StackOfIntegers();
		
		for(int i=2;i<120;i++) {
			if(isPrime(i)) stack.push(i);
		}
		while(!stack.empty())
			System.out.println(stack.pop()+" ");
	}

}
