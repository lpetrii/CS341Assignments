package scrabbleapp;

public class TestMain {

	public static void main(String[] args) {
		Scrabble n = new Scrabble("abcd");
		
		n.mix();
		
		String s = n.getAnswer();
		
		System.out.print(s);
	}

}