package homework1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class Main {

	private JFrame frame;
	private JTextField Xnum;
	private JTextField Ynum;
	private JTextField answerBox;
	private JButton btnADD;

	// DATA ELEMENTS
	private String bigNumOne;
	private String bigNumTwo;
	private String regex;


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
		initializer();

		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
	}

	private void go() {
		bigNumOne = Xnum.getText();
		bigNumTwo = Ynum.getText();

		regex = "[0-9]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(bigNumOne);
		Matcher n = p.matcher(bigNumTwo);

		if (bigNumOne == null || bigNumTwo == null) { 
			answerBox.setText("Warning Invalid Input");
		} else if (m.matches() == true && n.matches() == true) { 
			BigNumberAdder x = new BigNumberAdder(Xnum.getText());
			BigNumberAdder y = new BigNumberAdder(Ynum.getText());
			String z = x.add(y);
			answerBox.setText(z);
		} else { 									
			answerBox.setText("Warning! Invalid Input");
		}

	}


	private void initializer() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Xnum = new JTextField();
		Xnum.setBounds(6, 49, 438, 26);
		frame.getContentPane().add(Xnum);
		Xnum.setColumns(10);

		Ynum = new JTextField();
		Ynum.setBounds(6, 98, 438, 26);
		frame.getContentPane().add(Ynum);
		Ynum.setColumns(10);

		JLabel xLabel = new JLabel("Integer X");
		xLabel.setBounds(194, 21, 61, 16);
		frame.getContentPane().add(xLabel);

		JLabel yLabel = new JLabel("Integer Y");
		yLabel.setBounds(194, 80, 61, 16);
		frame.getContentPane().add(yLabel);

		btnADD = new JButton("ADD");
		btnADD.setBounds(166, 136, 117, 29);
		frame.getContentPane().add(btnADD);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 171, 438, 82);
		frame.getContentPane().add(scrollPane);

		answerBox = new JTextField();
		answerBox.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		scrollPane.setViewportView(answerBox);
		answerBox.setColumns(10);
	}

}