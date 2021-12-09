package scrabbleapp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;


public class Main {

	private JFrame frame;
	private JTextField textInput;
	private JButton btnGo;
	private JScrollPane scrollPane;
	private JTextArea textArea_1;


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
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scrabble n = new Scrabble(textInput.getText());
				n.mix();
				textArea_1.setText(n.getAnswer());
			}
		});
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textInput = new JTextField();
		textInput.setBounds(153, 43, 130, 26);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		btnGo = new JButton("Go");
		btnGo.setBounds(294, 43, 117, 29);
		frame.getContentPane().add(btnGo);
		
		JLabel title = new JLabel("Scrabble App");
		title.setBounds(172, 15, 88, 16);
		frame.getContentPane().add(title);
		
		JLabel lblNewLabel = new JLabel("Enter 4 letter word:");
		lblNewLabel.setBounds(6, 48, 135, 16);
		frame.getContentPane().add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 133, 363, 105);
		frame.getContentPane().add(scrollPane);
		
		textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
	}
}