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
	public static File generateFile(int numberOfFiles) {
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>();
		
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		
		String day;
		String month;
		String year;
		
		Random random = new Random();
		
		for (int i = 0; i < numberOfFiles; i++) {
			int monthIndex = random.nextInt(11);
			
			day = Integer.toString(random.nextInt(31));
			month = months[monthIndex];
			year = Integer.toString(random.nextInt(99));
			
			date.add(day + "-" + month + "-" + year);
			data.add(Integer.toString(random.nextInt(1085500032)));
		}
		
		return writeToFile(data, date, "newfile.text", numberOfFiles);
	}
	
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
	
	private static File writeToFile(ArrayList<String> data, ArrayList<String> date, String path, int numberOfFiles) {
		try {
			File file = new File(path);
			Files.deleteIfExists(file.toPath());
			
			file = new File(path);
			boolean fvar = file.createNewFile();
			if (fvar){
				BufferedWriter out = new BufferedWriter(new FileWriter(path));
				for (int i = 0; i < numberOfFiles; i++) {
					out.write(date.get(i) + "\t" + data.get(i));
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
		File file = generateFile(10);
		
		if (file != null) {
			Charset charset = Charset.forName("ISO-8859-1");
			List<String> lines;
			try {
				lines = Files.readAllLines(file.toPath(), charset);
				String[] arr = lines.toArray(new String[lines.size()]);
				String[] ans = Heap.sort(arr);
				writeToFile(ans, "sortedfile.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
