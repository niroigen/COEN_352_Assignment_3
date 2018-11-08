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
	
	public void put(Key key, Value val)
	{ // Search for key. Update value if found; grow table if new.
		if (first == null) {
			first = new Node(key, val, first);
			return;
		}
		
		Node previousNode = first;
		
		for (Node x = first; x != null; x = x.next) {
			if (x.key.compareTo(key) > 0) {
				if (first.equals(previousNode)) first = new Node(key, val, x);
				else previousNode.next = new Node(key, val, x);
				
				return;
			}
			
			previousNode = x;
		}
		
		previousNode.next = new Node(key, val, null);
		 // Search miss: add new node.
	}
	
	public void printValues() {
		for (Node x = first; x != null; x = x.next)
			System.out.println(x.key + " " + x.val);
	}
}
