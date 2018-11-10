import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q_3_4_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the keys separated by spaces:");
		String keys = scanner.nextLine().replaceAll(" ", "");
		
        findAAndM(keys);
    }
	
	private static void findAAndM(String text) {
		for (int M = text.length();;M++) {
			for (int a = 1; a < M; a++) {
				Set<Integer> indices = new HashSet();
				for (int i = 0; i < text.length(); i++) {
					if (!indices.add((a * calculateK(text.charAt(i))) % M)) break;
				}
				
				if (text.length() == indices.size()) {
					System.out.println("M = " + M);
					System.out.println("a = " + a);
					return;
				}
			}
		}
	}
	
	private static int calculateK(char character) {
		return (int)character - (int)'A';
	}
}
