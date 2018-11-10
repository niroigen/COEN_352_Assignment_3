import java.nio.file.Path;
import java.util.ArrayList;

public class Heap {
	public static String[] sort(String[] a) {
		ArrayList<String> dates = createDates(a);
		ArrayList<Integer> datas = createData(a);
		
		int n = datas.size();
		for (int k = n/2; k >= 1; k--)
			sink(datas,dates,k,n);
		while(n>1) {
			exch(datas,dates,1,n);
			sink(datas,dates,1,--n);
		}
		
		for (int i = 0; i < datas.size(); i++) {
			a[i] = dates.get(i) + "\t" + datas.get(i);
		}
		
		return a;
	}
	
	private static ArrayList<String> createDates(String[] a) {
		ArrayList<String> datas = new ArrayList<String>();
		
		for (int i = 0; i < a.length; i++) {
			String[] data = a[i].split(" ");
			datas.add(data[0]);
		}
		
		return datas;
	}
	
	private static ArrayList<Integer> createData(String[] a) {
		ArrayList<Integer> datas = new ArrayList<Integer>();
		
		for (int i = 0; i < a.length; i++) {
			String[] data = a[i].split(" ");
			datas.add(Integer.parseInt(data[1]));
		}
		
		return datas;
	}
	
	private static void sink(ArrayList<Integer> datas, ArrayList<String> dates, int k, int n) {
		while(2*k <= n) {
			int j = 2*k;
			if (j < n && less(datas, j, j+1)) j++;
			if (!less(datas, k,j)) break;
			exch(datas, dates, k,j);
			k = j;
		}
	}
	
	private static boolean less(ArrayList<Integer> datas, int i, int j) {
		return datas.get(i - 1).compareTo(datas.get(j - 1)) < 0;
	}
	
	private static void exch(ArrayList<Integer> datas, ArrayList<String> dates, int i, int j) {
		Integer t = datas.get(i - 1);
		datas.set(i - 1, datas.get(j - 1));
		datas.set(j - 1, t);
		
		String d = dates.get(i - 1);
		dates.set(i - 1, dates.get(j - 1));
		dates.set(j - 1, d);
	}
}
