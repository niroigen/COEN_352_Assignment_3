
public class Q_3_1_3 {
	public static void main(String[] args) {
		OrderedSequentialSearchST list = new OrderedSequentialSearchST();
		
		list.insert('S', 10);
		list.insert('B', 1);
		list.insert('A', 2);
		list.insert('C', 3);
		list.insert('D', 9);
		
		list.search(1);
		list.delete(1);
		list.print();
	}
}
