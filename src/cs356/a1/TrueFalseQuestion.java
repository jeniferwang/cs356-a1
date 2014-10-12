package cs356.a1;

import java.util.Arrays;

public class TrueFalseQuestion implements Question {

	private String question;
	private String[] options;
	private String answers;
	
	@Override
	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	public void setOptions(String[] options) {
		this.options = Arrays.copyOf(options, options.length);
	}

	@Override
	public String[] getOptions() {
		return options;
	}

	@Override
	public void setAnswers(String qAnswer) {
		this.answers = qAnswer;
	}

	@Override
	public String getAnswers() {
		return answers;
	}

}
