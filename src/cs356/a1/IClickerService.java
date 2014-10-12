package cs356.a1;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Arrays;


public class IClickerService {

	MultipleChoiceQuestion q1;
	TrueFalseQuestion q2;
	private int questionType;
	
	public void serviceStart(int t, String q, String[] o, String a) {
		questionType = t;
		if (questionType == 0) {
			q1 = new MultipleChoiceQuestion();
			q1.setQuestion(q);
			q1.setOptions(Arrays.copyOf(o, o.length));
			q1.setAnswers(a);
		} else if (questionType == 1) {
			q2 = new TrueFalseQuestion();
		} else {
			System.out.println("No such question type");
		}
		printQuestion();
		
		System.out.println("Collecting answers...");
		
		//System.out.println("Solution");
		
	}
	
	public void printQuestion() {
		System.out.println(q1.getQuestion());
		for (String element : q1.getOptions()) {
			System.out.println(element);
		}
	}
	
	public void collectSubmissions(Hashtable table) {
		Collection c = table.values();
		Iterator itr = c.iterator();
		
		String[] options = null;
		int[] total;
		
		if (questionType == 0) {
			options = new String[] {"A", "B", "C", "D"};
		}
		else if (questionType == 1) {
			options = new String[] {"1", "2"};
		}
		else
			System.out.println("No such question type");
		
		total = new int[options.length];
		
		while(itr.hasNext()) {
			String values = (String) itr.next();
			System.out.println(values);
			String[] valuesSeparate = values.split("");
			for (int i = 0; i < valuesSeparate.length; i++) {
				for (int j = 0; j < options.length; j++) {
					if (valuesSeparate[i].equals(options[j])) {
						total[j]++;
					}
				}
			}
		}
		
		printResults(options, total);
	}
	
	public void printResults(String[] options, int[] total) {
		int totalCount = 0;
		System.out.println("\n Results:");
		for (int i = 0; i < options.length; i++) {
			System.out.println(options[i] + " : " + total[i] + "");
			totalCount = totalCount + total[i];
		}
		
		System.out.println("Total student answers:" + totalCount);
	}
	
}

