package miniproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import java.awt.List;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;

public class productd {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productd window = new productd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public productd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		TextField textField = new TextField();
		textField.setBounds(152, 144, 74, 21);
		frame.getContentPane().add(textField);
		
		
		Label label = new Label("product");
		label.setBounds(10, 22, 60, 21);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Category");
		label_1.setBounds(10, 60, 60, 21);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("products");
		label_2.setBounds(10, 104, 60, 21);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("QTY");
		label_3.setBounds(10, 144, 60, 21);
		frame.getContentPane().add(label_3);
		
		Button button = new Button("clear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(10, 212, 68, 21);
		frame.getContentPane().add(button);
		
		
		
		Button button_1 = new Button("bill");
		button_1.setBounds(152, 212, 68, 21);
		frame.getContentPane().add(button_1);
		
		Button button_2 = new Button("confirm");
		button_2.setBounds(277, 212, 68, 21);
		frame.getContentPane().add(button_2);
		
		JRadioButton r1=new JRadioButton("Snack");
		JRadioButton r2=new JRadioButton("Beverage");
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		frame.add(r1);
		frame.add(r2);
	
		
		
		
		
		
		
		
		
		
	}
}
