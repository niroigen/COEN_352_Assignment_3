public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
	private Node first; // first node in the linked list
	private class Node
	{ // linked-list node
		Key key;
		Value val;
		Node next;
		
		public Node(Key key, Value val, Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public void deleteValue(Value val) {
		Node previousNode = first;
		
		for (Node x = first; x != null; x = x.next) {
			if (val.equals(x.val)) {
				if (x.equals(first)) first = x.next;
				else previousNode.next = x.next;
				
				return;
			} 
			
			previousNode = x;
		}
		
		System.out.println("No value " + val + " has been found in the linked list");
	}
	
	public void put(Key key, Value val)
	{ // Search for key. Update value if found; grow table if new.
		Node previousNode = first;
		
		for (Node x = first; x != null; x = x.next) {
			if (x.key.compareTo(key) > 0) {
				Key tempKey = key;
				Value tempValue = val;
				
				key = x.key;
				val = x.val;
				
				x.key = tempKey;
				x.val = tempValue;
			}
			
			previousNode = x;
		}
		
		first = new Node(key, val, first); // Search miss: add new node.
	}
	
	public void printValues() {
		for (Node x = first; x != null; x = x.next)
			System.out.println(x.key + " " + x.val);
	}
	
	public void searchForValue(Value val) {
		for (Node x = first; x != null; x = x.next) {
			if (val.equals(x.val)) {
				System.out.println("Value found with key " + x.key);
				return;
			}
		}
		
		System.out.println("Value " + val.toString() + " not found");
	}
}
