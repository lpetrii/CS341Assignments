package btsDictionary;

public class Main {

	public static void main(String[] args) {
		
		Tree myTree = new Tree();
		
		myTree.insertWordNode("light");
		myTree.insertWordNode("window");
		myTree.insertWordNode("picture");
		myTree.insertWordNode("softball");
		myTree.insertWordNode("water bottle");
		myTree.insertWordNode("shoes");
		myTree.insertWordNode("chair");
		myTree.insertWordNode("clock");
		myTree.insertWordNode("earring");
		myTree.insertWordNode("fork");
		
		myTree.inOrderTreeSearch(myTree.getRoot());
		
		myTree.deleteWordNode("fork");
		myTree.deleteWordNode("chair");
		myTree.deleteWordNode("window");
		myTree.deleteWordNode("shoes");
		
		System.out.println("   ");
		
		myTree.inOrderTreeSearch(myTree.getRoot());
		
		
		System.out.println(myTree.spellCheck("softball"));
		
	}

}