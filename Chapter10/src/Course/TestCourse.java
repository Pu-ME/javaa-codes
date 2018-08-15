package Course;
public class TestCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course course1 = new Course("Data Structures");
	    Course course2 = new Course("Database Systems");
	    course1.addStudent("s1");
	    course1.addStudent("s2");
	    course1.addStudent("s3");
	    course1.addStudent("s4");
	    course1.addStudent("s5");
	    System.out.println(course1.getCourseName()+" has "+course1.getNumberOfStudents()+
	    " students"		);
	    String[] students = course1.getStudents();
	    for(int i=0;i<course1.getNumberOfStudents();i++)
	    System.out.print(students[i]+" ");
	    System.out.println();
	    course1.dropStudent("s3");
	    System.out.println(course1.getCourseName()+" has "+course1.getNumberOfStudents()+
	    	    " students"		);
	   students = course1.getStudents();
	    for(int i=0;i<course1.getNumberOfStudents();i++)
	    System.out.print(students[i]+" ");
	    System.out.println();
	    course2.addStudent("s2");
	    course2.addStudent("s3");
	    course2.addStudent("s4");
	    course2.addStudent("s5");
	    System.out.println(course2.getCourseName()+" has "+course2.getNumberOfStudents()+
	    	    " students"		);
	    course2.clear();
	    System.out.println(course2.getCourseName()+" has "+course2.getNumberOfStudents()+
	    	    " students"		);
	  
	    
	}

}
