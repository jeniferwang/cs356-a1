package cs356.a1;

// Student class with constructor for studentID and student answers
public class Student {

	private int studentID;
	private String answers;
	
	public Student(int studentID, String studentAnswers) {
		this.studentID = studentID;
		this.answers = studentAnswers;
	}

	void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	int getStudentID() {
		return studentID;
	}
	
	void setAnswers(String answers) {
		this.answers = answers;
	}
	
	String getAnswers() {
		return answers;
	}
}
