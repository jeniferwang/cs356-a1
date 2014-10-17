package cs356.a1;

	/* Interface for the different types of questions with question properties
 	   of: the 'question', student 'options', and student qAnswers */
interface Question {

	public void setQuestion(String question);
	
	public String getQuestion();
	
	public void setOptions(String[] options);
	
	public String[] getOptions();
	
	public void setAnswers(String qAnswer);
	
	public String getAnswers();
	
}
