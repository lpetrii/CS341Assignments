package btsDictionary;

public class Word {
	
	String key;
	Word parent;
	Word leftKid;
	Word rightKid;
	
	public Word(String word) {
		this.key = word;
		leftKid = null;
		rightKid = null;
	}
	public Word() {
		key = "";
		leftKid = null;
		rightKid = null;
	}
	
	
	// GETTERS AND SETTERS
	
	public String getKey() {
		return key;
	}
	public void setKey(String word) {
		this.key = word;
	}
	public Word getParent() {
		return parent;
	}
	public void setParent(Word p) {
		this.parent = p;
	}
	public Word getLeftKid() {
		return leftKid;
	}
	public void setLeftKid(Word lk) {
		this.leftKid = lk;
	}
	public Word getRightKid() {
		return rightKid;
	}
	public void setRightKid(Word rk) {
		this.rightKid = rk;
	}
}