package fileReader;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Main {

	private JFrame frame;
	private JFileChooser fileChooser;
	private JTextField textMean;
	private JTextField textSD;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main() {
		initialize();
		LinkedList list = new LinkedList();
		int r = fileChooser.showOpenDialog(null);
		int count = 0;
		String firstError = "";
		int errorOne = 0;
		
		switch (r){
			case JFileChooser.APPROVE_OPTION:
				
				
				try {
					Scanner scanner = new Scanner(fileChooser.getSelectedFile());
					
					if(!scanner.hasNextLine()) {
						textMean.setText("Error"); textSD.setText("No data found.");
						break;
					}
					while (scanner.hasNextLine()) {
						String temp = scanner.nextLine();
						if(verify(temp)) {
							list.add(Double.parseDouble(temp));
							count++;
						}
						else {
							firstError = temp;
							errorOne = count;
						}

					}
					scanner.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				if (errorOne == 0) {
					textMean.setText(Double.toString(list.getMean()));
					textSD.setText(Double.toString(list.getSD(list.getMean())));
				}
				else {
					textMean.setText("line " + errorOne + " reads: " + firstError);
					textSD.setText("This is not a number");
				}
				
				break;
				
			case JFileChooser.CANCEL_OPTION:
				
				
				break;
			
			case JFileChooser.ERROR_OPTION:
				
				
				
				break;
		}
		
	}
	
	private boolean verify(String s) {
		double d = 0;
	    if (s == null) {
	        return false;
	    }
	    try {
	        d = Double.parseDouble(s);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 829, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		fileChooser = new JFileChooser();
		fileChooser.setApproveButtonText("Select");
		fileChooser.setBounds(6, 6, 174, 57);
		frame.getContentPane().add(fileChooser);
		
		textMean = new JTextField();
		textMean.setBounds(254, 183, 221, 26);
		frame.getContentPane().add(textMean);
		textMean.setColumns(10);
		
		textSD = new JTextField();
		textSD.setBounds(254, 211, 221, 26);
		frame.getContentPane().add(textSD);
		textSD.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mean");
		lblNewLabel.setBounds(181, 188, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Standard Deviation");
		lblNewLabel_1.setBounds(98, 216, 130, 16);
		frame.getContentPane().add(lblNewLabel_1);
	}
}