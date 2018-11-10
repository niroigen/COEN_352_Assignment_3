import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q_2_5_9 {
	private static File writeToFile(String[] a, String path) {
		try {
			File file = new File(path);
			Files.deleteIfExists(file.toPath());
			
			file = new File(path);
			boolean fvar = file.createNewFile();
			if (fvar){
				BufferedWriter out = new BufferedWriter(new FileWriter(path));
				for (int i = 0; i < a.length; i++) {
					out.write(a[i]);
				    out.newLine();
				}
				out.close();
			}
			
			return file;
		} catch (IOException e) {
			System.out.println("Exception Occurred:");
		    e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		File file = new File("input.txt");
		
		if (file != null) {
			Charset charset = Charset.forName("ISO-8859-1");
			List<String> lines;
			try {
				lines = Files.readAllLines(file.toPath(), charset);
				String[] arr = lines.toArray(new String[lines.size()]);
				String[] ans = Heap.sort(arr);
				writeToFile(ans, "output.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
