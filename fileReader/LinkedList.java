package fileReader;

public class LinkedList {
	
	Node head;
	Node tail;
	
	public LinkedList() {
		head = null;
		tail = null;
	}
	
	
	public void print() {
		Node n = head;
		
		while (n != null) {
			System.out.println(n.value);
			n = n.next;
		}
	}
	
	public void add(double value) {
		
		Node node = new Node(value);
		
		if (head == null) {
			head = node;
			tail = node;
		}
		else {
			tail.next = node;
			tail = node;
		}
	}
	
	
	public double getMean() {
		Node n = head;
		double mean = 0;
		int count = 0;
		
		while (n != null) {
			mean += n.value;
			count++;
			n = n.next;
		}
		mean = mean / count;
		return mean;
	}
	
	public double getSD(double mean) {
		
		Node n = head;
		
		double num = 0;
		
		double sum = 0;
		
		int count = 0;
		
		while (n != null) {
			num = (n.value - mean) * (n.value - mean);
			count++;
			sum += num;
			n = n.next;
		}
		sum = sum / count;
		
		return Math.sqrt(sum);
	}
	
}