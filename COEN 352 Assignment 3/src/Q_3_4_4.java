import java.util.HashSet;
import java.util.Set;

public class Q_3_4_4 {
	public static void main(String[] args) {
        findAAndM("SEARCHXMPL");
    }
	
	private static void findAAndM(String text) {
		for (int M = text.length();;M++) {
			for (int a = 1; a < M; a++) {
				Set<Integer> indices = new HashSet();
				for (int i = 0; i < text.length(); i++) {
					if (!indices.add((a * calculateK(text.charAt(i))) % M)) break;
				}
				
				System.out.println("M = " + M);
				System.out.println("a = " + a);
				
				if (text.length() == indices.size()) {
					System.out.println("A perfect hash function");
					return;
				} else {
					System.out.println("A non perfect hash function where the indices size are " + indices.size());
				}
			}
		}
	}
	
	private static int calculateK(char character) {
		System.out.println((int)character);
		System.out.println((int)'A');
		System.out.println((int)character - (int)'A');
		return (int)character - (int)'A';
	}
}
