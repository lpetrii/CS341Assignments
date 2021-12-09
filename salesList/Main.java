package salesList;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;


import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {

	private JFrame frame;
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textQuantity;
	private JButton btnAdd;
	private JTextArea textListArea;
	private JTextArea textTotal;
	private JTextArea textArea;
	private JLabel lblNewLabel_5;


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
		List list = new List();
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double p = Double.parseDouble(textPrice.getText());
				Integer q = Integer.parseInt(textQuantity.getText());
				String n = textName.getText();
				
				
				list.add(p, q, n);
				
				textListArea.setText(list.printList());
				
				textTotal.setText("$" + list.getSum().toString());
				
				textArea.setText(list.getQuantity().toString());
				
				textPrice.setText("");
				textQuantity.setText("");
				textName.setText("");

			}
		});
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sale List");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(180, 6, 74, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textName = new JTextField();
		textName.setBounds(6, 52, 130, 26);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setBounds(149, 52, 130, 26);
		frame.getContentPane().add(textPrice);
		textPrice.setColumns(10);
		
		textQuantity = new JTextField();
		textQuantity.setBounds(291, 52, 130, 26);
		frame.getContentPane().add(textQuantity);
		textQuantity.setColumns(10);
		
		btnAdd = new JButton("Add item to sales list");
		btnAdd.setBounds(128, 90, 178, 29);
		frame.getContentPane().add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 137, 389, 89);
		frame.getContentPane().add(scrollPane);
		
		textListArea = new JTextArea();
		scrollPane.setViewportView(textListArea);
		
		textTotal = new JTextArea();
		textTotal.setBounds(303, 238, 118, 28);
		frame.getContentPane().add(textTotal);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(46, 35, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(193, 35, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setBounds(327, 35, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total Sales:");
		lblNewLabel_4.setBounds(230, 250, 74, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		textArea = new JTextArea();
		textArea.setBounds(104, 238, 114, 28);
		frame.getContentPane().add(textArea);
		
		lblNewLabel_5 = new JLabel("Total Items:");
		lblNewLabel_5.setBounds(6, 250, 87, 16);
		frame.getContentPane().add(lblNewLabel_5);
	}
}