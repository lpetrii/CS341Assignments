package homework9;

import java.util.ArrayList;

public class LinearRegression {
	
	private ArrayList<Double> x_value = new ArrayList<>();
	private ArrayList<Double> y_value = new ArrayList<>();
	
	public LinearRegression(ArrayList<Double> x_value, ArrayList<Double> y_value) {
		this.x_value = x_value;
		this.y_value = y_value;
	}

	public Boolean verify_arrays() {
		if(x_value.size() != y_value.size()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	private Double sum_x() {
		double sum = 0.0;
		for (int i = 0; i < x_value.size(); i++) {
			sum += x_value.get(i);
		}
		return sum;
	}
	
	private Double sum_y() {
		double sum = 0.0;
		for (int i =0; i < x_value.size(); i++) {
			sum += y_value.get(i);
		}
		return sum;
	}
	
	
	private Double mean_x() {
		return sum_x()/x_value.size();
	}
	
	private Double mean_y() {
		return sum_y()/x_value.size();
	}
	
	
	private Double getSS() {
		double sum = 0.0;
		
		for (int i = 0; i < x_value.size(); i++) {
			sum += Math.pow(x_value.get(i) - mean_x(), 2);
		}
		return sum;
	}
	
	private Double getSP() {
		double sum = 0.0; 
		
		for (int i = 0; i < x_value.size(); i++) {
			sum += (x_value.get(i) - mean_x()) * (y_value.get(i) - mean_y());
		}
		return sum;
	}
	
	
	
	private double b_value() {
		return getSP()/getSS();
	}
	
	private double a_value() {
		return mean_y() - (b_value() * mean_x());
	}
	
	
	public double linear_regression(int x) {
		System.out.println("a: " + a_value());
		System.out.println("b: " + b_value());
		System.out.println("sp: " + getSP());
		System.out.println("ss: " + getSS());
		System.out.println("mean x " + mean_x());
		System.out.println("mean y " + mean_y());
		System.out.println("sum x " + sum_x());
		System.out.println("sum y " + sum_y());
		return a_value() + (b_value() * x);

	}
	
	
}