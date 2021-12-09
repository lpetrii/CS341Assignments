package homework8;


public class MyMain {

	public static void main(String[] args) {
		
		
		Inventory inv = new Inventory();
		
		inv.addTB(123);
		inv.addTB(124);
		inv.addTB(125);
		
		
		System.out.println(inv.containsText(124));
		
		inv.delete(124);
		System.out.println(inv.containsText(124));

		inv.addName("the bible", 123);
		inv.addPrice(69.69, 123);
		inv.addQuantity(1000000, 123);
		
		
		
		
		inv.traverseInventory(inv.root);
		
		System.out.println(inv.list);
		
		

	}

}