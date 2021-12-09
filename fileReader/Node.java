package fileReader;

public class Node {
	
	Node next;
	Node prev;
	double value;
	
	public Node(double value) {
		this.value = value;
		next = null;
		prev = null;
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}