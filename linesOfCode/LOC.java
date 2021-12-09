package linesOfCode;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LOC {

	private JFrame frame;
	private JFileChooser fileChooser;
	private JTextField loc;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOC window = new LOC();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LOC() {
		initialize();
		int countLines = 0;
		boolean noCount = false;
		
		int r = fileChooser.showOpenDialog(null);
		
		
		if (r == JFileChooser.APPROVE_OPTION) {
			try {
				Scanner java_doc_scan = new Scanner(fileChooser.getSelectedFile());
				
				while(java_doc_scan.hasNextLine()) {
					String current_line = java_doc_scan.nextLine().strip();
					
					if (!noCount) {
						if (current_line.contains("/*")) {
							noCount = true;
						}
						else if (!current_line.contains("//") && current_line != "") { 
							countLines++;
						}
					}
					else {
						if(current_line.contains("*/")){
							noCount = false;
						}
					}
				}
			}
			catch (FileNotFoundException e){
				e.printStackTrace();
			}
			
			String sum = Integer.toString(countLines);
			
			loc.setText(sum);
			
		}

	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 829, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		fileChooser = new JFileChooser();
		fileChooser.setApproveButtonText("Select");
		fileChooser.setBounds(6, 6, 174, 57);
		frame.getContentPane().add(fileChooser);
		
		loc = new JTextField();
		loc.setBounds(299, 185, 221, 26);
		frame.getContentPane().add(loc);
		loc.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Lines of Code:");
		lblNewLabel.setBounds(181, 188, 106, 21);
		frame.getContentPane().add(lblNewLabel);
		
	}

}