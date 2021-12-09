package salesList;

public class Item {
	
	public Item next;
	public Double price;
	public Integer quantity;
	public String name;
	
	// constructors
	public Item(Double p, Integer q, String n) {
		next = null;
		this.price = p;
		this.quantity = q;
		this.name = n;
	}
	public Item() {
		next = null;
	}
	
	public Double getPrice() {
		return price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public String getName() {
		return name;
	}
}