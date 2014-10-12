package cs356.a1;

import java.util.Hashtable;
import java.util.Random;


public class SimulationDriver {
	
	private static Random random;
	private static int questionType;
	private static Hashtable<Integer, String> table;
	private static IClickerService start;
	
	// Driver main method to start iClicker Service
	public static void main(String[] args) {
		startiClickerServices();
	}
	
	// Start iClickerServices and initialize question and answer
	private static void startiClickerServices() {
		start = new IClickerService();
		
		// 0 for Multiple Choice, 1 for T/F
		int[] type = {0, 1};
		
		System.out.println("Question #1: Multiple Choice Question");
		questionType = type[0];
		String q1 = "What is 1 + 1?";
		String[] o1 = {"A. 1", "B. 2", "C. 3", "D. 4"};  
		String a1 = "B";
	
		start.serviceStart(questionType, q1, o1, a1);
		generateStudents();
		
		System.out.println();
		
		System.out.println("Question #2: True or False Question");
		questionType = type[1];
		String q2 = "Penguins can fly. True or False";
		String[] o2 = {"1. True" , "2. False"};  
		String a2 = "2";
		
		start.serviceStart(questionType, q2, o2, a2);
		generateStudents();
	}
	
	// Generate a random total number of students
	private static void generateStudents() {
		random = new Random();
		int totalStudents = 5; // random.nextInt(26) + 5;
		generateStudentAnswers(totalStudents);
	}
	
	// Generate student IDs and answers
	private static void generateStudentAnswers(int totalStudents){
		table = new Hashtable<Integer, String>();
		
		
		for (int i = 0; i < totalStudents; i++) {
			int studentID = random.nextInt(500) + 1;
			char[] studentSingleAnswer;
			String choices = "";
			int studentChoices = 0;
			if (questionType == 0) {
				choices = "ABCD";
				studentChoices = random.nextInt(4) + 1;
			} else if (questionType == 1) {
				choices = "12";
				studentChoices = 1;
			} else {
				System.out.println("No such question type");
			}
			studentSingleAnswer = new char[studentChoices];
			for (int k = 0; k < studentSingleAnswer.length; k++) {
				
				char temp = choices.charAt(random.nextInt(choices.length()));
				
				while ((String.valueOf(studentSingleAnswer).contains(String.valueOf(temp)))) {
					temp = choices.charAt(random.nextInt(choices.length()));
				}
				
				studentSingleAnswer[k] = temp;
			}
			
			String studentAnswers = new String(studentSingleAnswer);
			if (table.containsKey(studentID)) {
				table.remove(studentID);
			}
			
			table.put(studentID, studentAnswers);
			
			
		}
		
		System.out.println("Hash table size = " + table.size());
		
		// Sent student submissions to iClicker Service
		start.collectSubmissions(table);
		
	}

}

