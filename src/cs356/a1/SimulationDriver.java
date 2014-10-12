package cs356.a1;

import java.util.Hashtable;
import java.util.Random;


public class SimulationDriver {
	
	private static Random random;
	private static int questionType;
	private static Hashtable<Integer, String> table;
	private static IClickerService start;
	
	public static void main(String[] args) {
		startiClickerServices();
		generateStudents();
	}
	
	// Start iClickerServices and initialize question and answer
	public static void startiClickerServices() {
		start = new IClickerService();
		
		// 0 for Multiple Choice, 1 for T/F
		int[] type = {0, 1};
		
		System.out.println("Question #1: Multiple Choice Question");
		questionType = type[0];
		String q1 = "What is 1 + 1?";
		String[] o1 = {"A. 1", "B. 2", "C. 3", "D. 4"};  
		String a1 = "B";
	
		start.serviceStart(questionType, q1, o1, a1);
		
		/*System.out.println("Question #2: True or False Question");
		questionType = type[1];
		String q2 = "What is 1 + 1?";
		String[] o2 = {"A. 1", "B. 2", "C. 3", "D. 4"};  
		String a2 = "B";
		
		start.serviceStart(questionType, q2, o2, a2);*/
	}
	
	// Generate a random total number of students
	public static void generateStudents() {
		random = new Random();
		int totalStudents = 5; // random.nextInt(26) + 5;
		generateStudentAnswers(totalStudents);
	}
	
	// Generate student IDs and answers
	public static void generateStudentAnswers(int totalStudents){
		table = new Hashtable<Integer, String>();
		
		// Generate for Multiple Choice Question
		if (questionType == 0) {
			for (int i = 0; i < totalStudents; i++) {
				
				String letters = "ABCD";
				
				int choices = random.nextInt(4) + 1;
				int studentID = random.nextInt(500) + 1;
				
				char[] studentSingleAnswer = new char[choices];
				
				//System.out.println("Choices: " + choices);
				
				for (int k = 0; k < studentSingleAnswer.length; k++) {
					
					char temp = letters.charAt(random.nextInt(letters.length()));
					
					while ((String.valueOf(studentSingleAnswer).contains(String.valueOf(temp)))) {
						temp = letters.charAt(random.nextInt(letters.length()));
					}
					
					studentSingleAnswer[k] = temp;
				}
				String studentAnswers = new String(studentSingleAnswer);
				if (table.containsKey(studentID)) {
					table.remove(studentID);
				}
				
				table.put(studentID, studentAnswers);
				
				/*System.out.println("Student ID = " + studentID);
				System.out.println("Student's Answers = " + studentAnswers);*/
			}			
		// Generate for TrueFalse Question
		} else if (questionType == 1) {
			for (int i = 0; i < totalStudents; i++) {
				String numbers = "12";
				
				int choices = random.nextInt(4) + 1;
				int studentID = random.nextInt(500) + 1;
				
				
			}
		} else {
			System.out.println("No such question type");
		}
		
		System.out.println("Hash table size = " + table.size());
		start.collectSubmissions(table);
		
	}

}

