
public class Q_3_1_3 {
	public static void main(String[] args) {
		OrderedSequentialSearchST list = new OrderedSequentialSearchST();
		
		list.put('A', 1);
		list.put('D', 2);
		list.put('B', 3);
		list.put('C', 4);
		list.printValues();
		list.searchForValue(-1);
		list.deleteValue(1);
		list.printValues();
	}
}
