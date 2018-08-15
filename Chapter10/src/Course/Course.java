package Course;

public class Course {
	private String courseName;
	private String[] students=new String[100];
	private int numberOfStudents;
	public Course(String courseName) {
		this.courseName=courseName;
	}
	private void increaseSize() {
	    String[] temp = new String[students.length * 2];
	    System.arraycopy(students, 0, temp, 0, students.length);
	    students = temp;
	  }
	public void addStudent(String student) {
		students[numberOfStudents]=student;
		numberOfStudents++;
	}
	public String[] getStudents() {
		return students;
	}
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	public String getCourseName() {
		return courseName;
	}
	public void clear() {
	    for (int i = 0; i < numberOfStudents; i++) 
	      students[i] = null;
	    numberOfStudents = 0;
	  }
	
	public void dropStudent(String student) {
		 // Left as an exercise in Exercise 9.9
		for(int i = 0;i < numberOfStudents; i++) {
			if(students[i].equals(student)) {
				for(int k = i + 1;k < numberOfStudents; k++) {
					students[k - 1] = students[k];
				}
				 numberOfStudents--;
				 break;
			}
		
	}
  }
}
