import java.util.HashMap;
import java.util.Scanner;

public class Q_3_1_1 {
	HashMap<String, Double> gradesMap;
	
	Q_3_1_1() {
		init();
	}
	
	private void init() {
		gradesMap = new HashMap<String, Double>();
		
		gradesMap.put("A+", 4.33);
		gradesMap.put("A", 4.00);
		gradesMap.put("A-", 3.67);
		gradesMap.put("B+", 3.33);
		gradesMap.put("B", 3.00);
		gradesMap.put("B-", 2.67);
		gradesMap.put("C+", 2.33);
		gradesMap.put("C", 2.00);
		gradesMap.put("C-", 1.67);
		gradesMap.put("D", 1.00);
		gradesMap.put("F", 0.00);
	}
	
	public void calculateAverage(String gradesString) {
		String[] grades = gradesString.split(" ");
		
		double average = 0.0;
		int size = grades.length;
		
		System.out.println();
		System.out.println("Grades with GPA");
		
		for (int i = 0; i < size; i++) {
			System.out.println(grades[i] + "\t: " + gradesMap.get(grades[i]));
			average += gradesMap.get(grades[i]);
		}
		
		average /= size;
		average = Math.round(average * 100.0) / 100.0;
		
		System.out.println();
		System.out.println("Average grade is " + average);
	}
	
	public static void main(String[] args) {
		System.out.println("Enter your grades");
		Scanner scanner = new Scanner(System.in);
		String grades = scanner.nextLine();
		
		Q_3_1_1 gradesTool = new Q_3_1_1();
		
		gradesTool.calculateAverage(grades);
	}
}
