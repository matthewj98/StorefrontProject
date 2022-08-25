package miniproject;
import javax.swing.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class admind {

	JFrame frame;
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
		frame.getContentPane().setBackground(new Color(80, 80, 80));
		frame.setBounds(100, 100, 650, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 631, 412);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 161, 31));
		tabbedPane.addTab("Update Items", null, panel, null);
		panel.setLayout(null);
		
		String food[]= {"TooYum","Lays","Snickers"};
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(food);
		JComboBox<String> foodListAdmin = new JComboBox<>(food);
		
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				database db=new database("root","root");
				try {
					db.updateitem(foodListAdmin.getItemAt(foodListAdmin.getSelectedIndex()),Integer.parseInt(textField.getText()));
					
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog (frame, "Item updated");
				textField.setText("");
				
			}
		});
		btnNewButton.setBounds(74, 181, 130, 23);
		panel.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Product");
		lblNewLabel_4.setBounds(362, 66, 46, 14);
		panel.add(lblNewLabel_4);
		
		String bev[]= {"Coke","pepsi","fanta"};
		DefaultComboBoxModel<String> comboModel1 = new DefaultComboBoxModel<String>(bev);
		JComboBox<String> BevListAdmin = new JComboBox<>(bev);
		BevListAdmin.setBounds(455, 65, 106, 27);
		panel.add(BevListAdmin);
		
		JButton btnNewButton_1 = new JButton("Update Beverage Item");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				database db=new database("root","root");
				try {
					db.updateitem(BevListAdmin.getItemAt(BevListAdmin.getSelectedIndex()),Integer.parseInt(textField_1.getText()));
					
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog (frame, "Item updated");
				textField_1.setText("");
				
			}
		});
		btnNewButton_1.setBounds(390, 181, 156, 23);
		panel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(455, 117, 106, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Quantity");
		lblNewLabel_1_1.setBounds(362, 120, 83, 14);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logind in=new logind();
				in.frame.setVisible(true);
			    frame.setVisible(false);
			    frame.dispose();
			    JOptionPane.showMessageDialog (in.frame, "Logged Out");
			}
		});
		btnNewButton_2.setBounds(455, 253, 89, 23);
		panel.add(btnNewButton_2);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(221, 161, 31));
		tabbedPane.addTab("Orders", null, panel_1, null);
	}
}

