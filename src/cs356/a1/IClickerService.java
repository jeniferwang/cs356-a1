package cs356.a1;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Arrays;


public class IClickerService {

	MultipleChoiceQuestion q1;
	TrueFalseQuestion q2;
	
	public void serviceStart(int t, String q, String[] o, String a) {
		
		if (t == 0) {
			q1 = new MultipleChoiceQuestion();
			q1.setQuestion(q);
			q1.setOptions(Arrays.copyOf(o, o.length));
			q1.setAnswers(a);
		} else if (t == 1) {
			q2 = new TrueFalseQuestion();
		} else {
			System.out.println("No such question type");
		}
		printQuestion();
		
		System.out.println("Collecting answers...");
		
		Hashtable submissions = new Hashtable();
		
		
		
		//System.out.println("Results");
		
		//System.out.println("Solution");
		
	}
	
	public void printQuestion() {
		System.out.println(q1.getQuestion());
		for (String element : q1.getOptions()) {
			System.out.println(element);
		}
	}
	
	public void printResults() {
		
	}
	
}

