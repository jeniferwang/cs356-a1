package cs356.a1;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Map;


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
		
		System.out.println("\nCollecting answers...\n");
	}
	
	public void printQuestion() {
		System.out.println(q1.getQuestion());
		for (String element : q1.getOptions()) {
			System.out.println(element);
		}
	}
	
	public void collectSubmissions(Hashtable<Integer, String> table) {
		Iterator<Map.Entry<Integer,String>>  itr;
		Map.Entry<Integer,String> entry;
		
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
		
		itr = table.entrySet().iterator();
		System.out.println("\nStudent input summary:");
		while (itr.hasNext()) {
		    entry = itr.next();
		    String id = entry.getKey().toString();
		    String values = entry.getValue().toString();
		    System.out.println("Student ID: " + id + "    " + "Student answers: " + values);
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
		printAnswers();
	}
	
	public void printResults(String[] options, int[] total) {
		int totalCount = 0;
		System.out.println("\n Results:");
		for (int i = 0; i < options.length; i++) {
			System.out.println(options[i] + " : " + total[i] + "");
			totalCount = totalCount + total[i];
		}
		
		System.out.println("\nTotal student answers:" + totalCount);
	}
	
	public void printAnswers() {
		if (questionType == 0) {
			System.out.println("The answer is: " + q1.getAnswers());
		}
	}
	
}

