package homework1;

import java.util.ArrayList;
import java.util.Arrays;



public class BigNumberAdder {
	/**
	 * @author laurenpetri
	 * @version 1.0
	 */

	/**
	 * @param String num
	 *
	 */

	private String num;

	public BigNumberAdder(String bigInt) {
		this.num = bigInt;
	}

	public String getStr() {
		return num;
	}

	public void setStr(String newNum) {
		this.num = newNum;
	}

	public String add(BigNumberAdder num2) {
		String sum = "";
		Integer temp = 0;
		Integer count = 0;
		Integer diff;

		
		if (num.length() > num2.getStr().length()) {
			diff = num.length() - num2.getStr().length();
			for (int j = 0; j < diff; j++) {
				num2.setStr("0" + num2.getStr());
			}
		} else if (num.length() < num2.getStr().length()) {
			diff = num2.getStr().length() - num.length();
			for (int k = 0; k < diff; k++) {
				num = "0" + num;
			}
		}
		
		
		

		String[] str = num.split(""); 
		String[] stx = num2.getStr().split("");

		ArrayList<String> listOne = new ArrayList<String>(Arrays.asList(str)); 

		ArrayList<String> listTwo = new ArrayList<String>(Arrays.asList(stx)); 

		
		

		for (int i = listOne.size() - 1; i >= 0; i--) {
			temp = Integer.parseInt(listOne.get(i)) + Integer.parseInt(listTwo.get(i)); 
			if (count == 1) { 
				temp += 1;
				count = 0;
			}

			if (temp < 10) { 
				sum = temp.toString() + sum;

			}
			if (temp >= 10) { 
				count = 1;
				temp = temp - 10;
				sum = temp.toString() + sum;
			}
		}
		for (int y = 0; y <= sum.length(); y++) { 
			if (sum.charAt(0) == '0') {			
				sum = sum.substring(1);
			}
		}
		return sum;
	}
}