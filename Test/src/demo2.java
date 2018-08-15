import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * @author putengfei
 * @created 2017-12-07
*/
public class demo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("xxx");
		int b;
		while((b = fis.read()) != -1) {
			System.out.println(b);
		}
		
		fis.close();
	}
}
