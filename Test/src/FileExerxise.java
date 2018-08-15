import java.io.File;
import java.util.Scanner;

/*
 * @author putengfei
 * @created 2017-12-09
*/
public class FileExerxise {
		public static void main(String[] args) {
			File file = getdir();
			printJavaFile(file);
		}

		private static void printJavaFile(File file) {
			File[] lists = file.listFiles();
			for (File list : lists) {
				if(list.isFile() && list.getName().endsWith(".java")) {
					System.out.println(list);
				}else if(list.isDirectory()){
					printJavaFile(list);
				}
			}
		}

		private static File getdir() {
			Scanner in = new Scanner(System.in);
			System.out.print("请输入一个路径：");
			
			while(true) {
				String path = in.nextLine();
				in.close();
				File file = new File(path);
				if(!file.exists()) {
					System.out.println("你输入的路径不存在！请重新输入：");
				}else if(file.isFile()) {
					System.out.println("你输入的是一个文件路径！请重新输入：");
				}else {
					return file;
				}
			}
		}
}
