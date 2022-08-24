package miniproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JList;

public class admind {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public  void adminde() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admind window = new admind();
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
	public admind() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 631, 412);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Update Items", null, panel, null);
		panel.setLayout(null);
		
		JList foodListAdmin = new JList();
		foodListAdmin.setBounds(120, 65, 106, 27);
		panel.add(foodListAdmin);
		
		JLabel lblNewLabel = new JLabel("Product");
		lblNewLabel.setBounds(30, 66, 46, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(120, 117, 106, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New Quantity");
		lblNewLabel_1.setBounds(30, 120, 68, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Update Food");
		lblNewLabel_2.setBounds(88, 21, 75, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Update Beverages");
		lblNewLabel_3.setBounds(437, 21, 96, 14);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Update Food Item");
		btnNewButton.setBounds(74, 181, 130, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Beverage Item");
		btnNewButton_1.setBounds(390, 181, 156, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Product");
		lblNewLabel_4.setBounds(362, 66, 46, 14);
		panel.add(lblNewLabel_4);
		
		JList BevListAdmin = new JList();
		BevListAdmin.setBounds(455, 65, 106, 27);
		panel.add(BevListAdmin);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(455, 117, 106, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Quantity");
		lblNewLabel_1_1.setBounds(362, 120, 83, 14);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.setBounds(455, 253, 89, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Orders", null, panel_1, null);
	}
}
