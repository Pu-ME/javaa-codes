package Course;

import java.util.ArrayList;

public class Course {
	 private ArrayList<String> students=new ArrayList<String>();
	 private String courseName;
	 public Course(String courseName) {
		 this.courseName=courseName;
	 }
	 public void addStudent(String student) {
		 students.add(student);
	 }
	 public String[] getStudents(){
		 String []temp=new String[students.size()];
		 students.toArray(temp);
		 return temp;
	 }
	 public int getNumberOfStudents() {
		 return students.size();
	 }
	 public String getCourse() {
		 return courseName;
	 }
	 
}
