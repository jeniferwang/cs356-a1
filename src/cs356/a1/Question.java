package cs356.a1;

public interface Question {

	public void setQuestion(String question);
	
	public String getQuestion();
	
	public void setOptions(String[] options);
	
	public String[] getOptions();
	
	public void setAnswers(String qAnswer);
	
	public String getAnswers();
	
}
