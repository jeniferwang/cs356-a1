/* CS356 
 * Assignment #1 : iClickerService
   Jenifer Wang */

package cs356.a1;

import java.util.Hashtable;
import java.util.Random;

/* Driver class to execute the iClicker Service. 3 Cases that were tested: 
 * one MC with one answer, one MC with multiple answers, and one T/F. Remove 
 * override comments to print out override procedure */

public class SimulationDriver {
	
	private static Random random;
	private static int questionType;
	private static Hashtable<Integer, Student> table;
	private static IClickerService start;
	
	// Driver main method to start iClicker Service
	public static void main(String[] args) {
		startiClickerServices();
	}
	
	// Start iClickerServices and initialize questions and answers
	private static void startiClickerServices() {
		start = new IClickerService();
		
		// 0 for Multiple Choice, 1 for T/F
		int[] type = {0, 1};
		
		// Case 1: Multiple Choice with one answer
		System.out.println("Question #1: Multiple Choice Question");
		questionType = type[0];
		String q1 = "What is 1 + 1?";
		String[] o1 = {"A. 1", "B. 2", "C. 3", "D. 4"};  
		String a1 = "B";
	
		start.serviceStart(questionType, q1, o1, a1);
		generateStudents();
		
		System.out.println();
		
		// Case 2: Multiple Choice with more than one answer
		System.out.println("Question #2: Multiple Choice Question");
		questionType = type[0];
		String q2 = "Which ones are programming languages?";
		String[] o2 = {"A. Java", "B. Cookies", "C. C++", "D. Perl"};  
		String a2 = "ACD";
	
		start.serviceStart(questionType, q2, o2, a2);
		generateStudents();
		
		System.out.println();
		
		// Case 3: True/False question
		System.out.println("Question #3: True or False Question");
		questionType = type[1];
		String q3 = "Penguins can fly. True or False";
		String[] o3 = {"1. True" , "2. False"};  
		String a3 = "2";
		
		start.serviceStart(questionType, q3, o3, a3);
		generateStudents();
	}
	
	// Generates a random total number of student inputs
	private static void generateStudents() {
		random = new Random();
		int totalStudentInputs = random.nextInt(26) + 5;
		generateStudentAnswers(totalStudentInputs);
	}
	
	// Generates student IDs and answers and stores data to hashtable
	private static void generateStudentAnswers(int totalStudentInputs) {
		table = new Hashtable<Integer, Student>();
		
		for (int i = 0; i <= totalStudentInputs; i++) {
			int studentID = random.nextInt(500) + 1;
			char[] studentSingleAnswer;
			String choices = "";
			int studentChoices = 0;
			
			/* Let studentChoices be 1-4 for Multiple Choice (enable multiple answers) and 
			 * choices be letters and let studentChoices be 1 for T/F and choices be numbers */		
			if (questionType == 0) {
				choices = "ABCD";
				studentChoices = random.nextInt(4) + 1;
			} else if (questionType == 1) {
				choices = "12";
				studentChoices = 1;
			} else {
				throw new IllegalArgumentException("No such question type");
			}
			studentSingleAnswer = new char[studentChoices];
			
			// Generate students' answers
			for (int k = 0; k < studentSingleAnswer.length; k++) {
				char temp = choices.charAt(random.nextInt(choices.length()));
				while ((String.valueOf(studentSingleAnswer).contains(String.valueOf(temp)))) {
					temp = choices.charAt(random.nextInt(choices.length()));
				}
				studentSingleAnswer[k] = temp;
			}
			
			String studentAnswers = new String(studentSingleAnswer);
			
			// If studentID already exists, override the old one
			if (table.containsKey(studentID)) {
				//System.out.println("Student ID: " + studentID + "'s answer has changed to " + studentAnswers);
				table.remove(studentID);
			} else {
				//System.out.println("Student ID: " + studentID + " has selected " + studentAnswers);
			}
			
			table.put(studentID, new Student(studentID, studentAnswers));
			
		}
		
		// Prints total # of students
		System.out.println("\nStudent size = " + table.size());
		
		// Send student submissions to iClicker Service
		start.collectSubmissions(table);
		
	}

}

