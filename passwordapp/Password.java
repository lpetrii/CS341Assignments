package passwordapp;

public class Password {
	
	private String str;
	
	
	public Password(String s) {
		this.str = s;
	}
	
	public String getPassword() {
		return str;
	}
	
	public String block() {
		Integer count = 0;
		Integer max = 0;
		
		if(str.length() < 8 || str.length() > 12) {
			return "Password must be between 8 and 12 characters long";
		}
		else {
			for (int i = 0; i < str.length(); i++) {
				if(i == 0) {
					count ++;
					max = count;
				}
				else {
					if (str.charAt(i) == str.charAt(i-1)) {
						count ++;
						if(max < count) {
							max = count;
						}
					}
					else {
						count = 1;
					}
				}
			}
		}
		Integer b = Math.abs(2 - max);
		
		if(max > 2) {
			return "The largest block in your password is " + max.toString() + ". Make this password stronger by reducing this block by " + b.toString() + ".";
		}
		else {
			return "The largest block in the password is "+ max.toString() + ". This is a acceptable password.";
		}
		
	}

}