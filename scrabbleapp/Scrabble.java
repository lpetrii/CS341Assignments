package scrabbleapp;


public class Scrabble {
	
	public String s;
	public String answer;
	
	public Scrabble(String str) {
		this.s = str;
	}
	
	public void setAnswer(String a) {
		this.answer = a;
	}
	
	public void mix() {
		answer = "";
		
		if ((s.length() > 4) || (!s.matches("[a-zA-Z]+"))) {
			answer = "The value you have entered is incorrect.";
		}
		else {
			perm(s, answer);
		}
		
	}
	
	public void perm(String s, String a) {
	    String str = "";
		
		if (s.length() == 0) {
	        answer += a + ", ";
	        return;
	    }
	     
	    for(int i = 0 ;i < s.length(); i++)
	    {
	        char c = s.charAt(i);
	        String l = s.substring(0, i);
	        String r = s.substring(i + 1);
	        String rest = l + r;
	        perm(rest, a + c);
	    }
	}
	
	
	
	public String getAnswer() {
		return answer;
	}
}