package cs356.a1;

public class Student {

	private int studentID;
	private String answers;
	
	protected void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	protected int getStudentID() {
		return studentID;
	}
	
	protected void setAnswers(String answers) {
		this.answers = answers;
	}
	
	protected String getAnswers() {
		return answers;
	}
}
