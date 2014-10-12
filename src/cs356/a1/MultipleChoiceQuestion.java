package cs356.a1;

import java.util.Arrays;


public class MultipleChoiceQuestion implements Question {

	private String question;
	private String[] options;
	private String answers = "";
	
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
		/*for (String element : this.options) {
			System.out.println(element);
		}*/
	}

	@Override
	public String[] getOptions() {
		return options;
	}

	@Override
	public void setAnswers(String qAnswer) {
		char[] ch = qAnswer.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			this.answers += ch[i] + " ";
		}

	}

	@Override
	public String getAnswers() {
		return answers;
	}

}
