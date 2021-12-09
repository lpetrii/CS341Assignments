package salesList;

public class List {
	
	private Item head;
	private Item tail;
	private Double sum = 0.0;
	private String list = "";
	private Integer total = 0;
	
	
	public List() {
		head = null;
		tail = null;
	}
	

	
	public boolean isEmpty() {
		return head == null;
	}
	

	public void add(Double p, Integer q, String n) {
		
		Item temp = new Item(p, q, n);
		
		total += q;
		
		sum += p * q; 
		
		list += n + "\t" + "$" + p.toString() + "\t" + q.toString() + "\n"; 
		
		if (isEmpty()) {
			head = temp;
			tail = temp;
		}
		else {
			tail.next = temp;
			tail = temp;
		}
	}
	
	public Double peekPrice() {
		return head.getPrice();
	}
	
	
	public Integer peekQuantity() {
		return head.getQuantity();
	}
	
	
	public String peekName() {
		return head.getName();
	}
	
	public Double getSum() {
		return sum;
	}
	
	public String printList() {
		return list;
	}
	
	public Integer getQuantity() {
		return total;
	}
	
	
}