package salesList;

public class Test {

	public static void main(String[] args) {
		List l = new List();
		
		l.add(5.25, 1, "bacon");
		l.add(2.25, 2, "peach");
		l.add(5.0, 2, "ice cream");
		
		
		System.out.println(l.getSum());
		System.out.println(l.printList());
	}

}