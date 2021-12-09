package homework9;

import java.util.ArrayList;

public class Testing {

	public static void main(String[] args) {
		

		ArrayList<Double> x = new ArrayList<Double>();
		ArrayList<Double> y = new ArrayList<Double>();
		
		
		x.add(2.0); x.add(4.0); x.add(6.0); x.add(8.0);
		
		y.add(3.0); y.add(5.0); y.add(7.0); y.add(9.0); 
		
		
		String a = "12,34";
		
		String[] arr = a.split(",",2);
		System.out.println(arr[1]);
		
	}

}