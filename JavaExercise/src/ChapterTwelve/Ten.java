package ChapterTwelve;
/*
 * @author putengfei
 * @created 2017-12-08
 * 
 * OutOfMemoryError  
*/
public class Ten {
	public static void main(String[] args) {
		try{
			int[] array = new int[Integer.MAX_VALUE];
		}catch(Error er){
			er.printStackTrace();
			System.out.println("You are outOfMemoryError");
			
		}
		
	}
	
}
