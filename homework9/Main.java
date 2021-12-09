package homework9;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Main {

	private JFrame frame;
	private JTextField EHC_textField;
	private JTextField answer_textField;
	private JButton fileSelectBtn;
	private JButton linreg_btn;
	private JFileChooser fileChooser;
	private JLabel lblNewLabel_1;


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
		ArrayList<Double> x_value = new ArrayList<>();
		ArrayList<Double> y_value = new ArrayList<>();
		
		
		fileSelectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = fileChooser.showOpenDialog(null);
				
				switch (r){
				case JFileChooser.APPROVE_OPTION:
					try {
						Scanner scanner = new Scanner(fileChooser.getSelectedFile());
						

						if(!scanner.hasNextLine()) {
							answer_textField.setText("Ooops. There's nothing in this file..."); 
							break;
						}
						

						while (scanner.hasNextLine()) {
							try {
								String[] arr = scanner.next().split(",");
								x_value.add(Double.parseDouble(arr[0]));
								y_value.add(Double.parseDouble(arr[1]));
								
								
							}catch (NumberFormatException v) {
								answer_textField.setText("An error occured when parsing the data."); 
								v.printStackTrace();
								break;
							}
						}
						scanner.close();
					}catch (FileNotFoundException w) {
						w.printStackTrace();
					}
				}

			}
		});
		

		linreg_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent z) {
				LinearRegression linReg = new LinearRegression(x_value, y_value);
				try {
					int estimate = Integer.parseInt(EHC_textField.getText());
					double answer = linReg.linear_regression(estimate);
					answer_textField.setText(String.valueOf(Math.round(answer)) + " bugs are predicted for " + String.valueOf(estimate) + " lines of code"); // decided to round the estimated bugs number... looks cleaner?
				}catch(NumberFormatException q) {
					answer_textField.setText("The EHC you have entered is invalid");
					q.printStackTrace();
				}
				
			}
		});
		
	}
	

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		fileSelectBtn = new JButton("Select File");
		fileSelectBtn.setBounds(153, 84, 117, 29);
		frame.getContentPane().add(fileSelectBtn);
		
		EHC_textField = new JTextField();
		EHC_textField.setBounds(241, 46, 130, 26);
		frame.getContentPane().add(EHC_textField);
		EHC_textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Expected Hours of Coding:");
		lblNewLabel.setBounds(43, 51, 186, 16);
		frame.getContentPane().add(lblNewLabel);
		
		answer_textField = new JTextField();
		answer_textField.setBounds(53, 217, 342, 26);
		frame.getContentPane().add(answer_textField);
		answer_textField.setColumns(10);
		
		linreg_btn = new JButton("Perform Linear Regression");
		linreg_btn.setBounds(105, 163, 227, 29);
		frame.getContentPane().add(linreg_btn);
		
		fileChooser = new JFileChooser();
		fileChooser.setApproveButtonText("Select");
		frame.getContentPane().add(fileChooser);
		
		lblNewLabel_1 = new JLabel("Note: the txt file data must be in \"number,number\" format");
		lblNewLabel_1.setBounds(32, 135, 383, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}