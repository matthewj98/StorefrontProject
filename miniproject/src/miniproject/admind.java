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

public class admind {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Super Market");
		lblNewLabel.setBounds(171, 11, 130, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		
		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				
			}
		});
		btnClear.setBounds(10, 220, 89, 23);
		frame.getContentPane().add(btnClear);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database db=new database("root","root");
				try {
					db.newitem(Integer.parseInt(textField.getText()),textField_1.getText(),textField_2.getText(),Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_4.getText()));
					
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog (frame, "New Item Added");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				
			}
		});
		btnAdd.setBounds(109, 220, 89, 23);
		frame.getContentPane().add(btnAdd);
		btnAdd.setVisible(false);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logind in=new logind();
				in.frame.setVisible(true);
			    frame.setVisible(false);
			    frame.dispose();
			    JOptionPane.showMessageDialog (in.frame, "Logged Out");
			}
		});
		btnLogOut.setBounds(339, 220, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		textField = new JTextField();
		textField.setBounds(83, 62, 82, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Product ID");     
		lblNewLabel_1.setBounds(10, 65, 48, 14);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Product Name");
		lblNewLabel_2.setBounds(10, 90, 48, 14);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(83, 87, 82, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setVisible(false);
		
		JLabel lblNewLabel_2_1 = new JLabel("Product Category");
		lblNewLabel_2_1.setBounds(10, 115, 48, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		lblNewLabel_2_1.setVisible(false);
		
		JLabel lblNewLabel_2_2 = new JLabel("Quantity");
		lblNewLabel_2_2.setBounds(10, 140, 48, 14);
		frame.getContentPane().add(lblNewLabel_2_2);
		lblNewLabel_2_2.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(83, 112, 82, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(83, 137, 82, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setVisible(false);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(83, 162, 82, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setVisible(false);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Prize");
		lblNewLabel_2_2_1.setBounds(10, 165, 48, 14);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		lblNewLabel_2_2_1.setVisible(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product ID");
		lblNewLabel_1_1.setBounds(230, 65, 48, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		lblNewLabel_1_1.setVisible(false);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quantity");
		lblNewLabel_1_2.setBounds(230, 93, 48, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		lblNewLabel_1_2.setVisible(false);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(314, 62, 82, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setVisible(false);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(314, 87, 82, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setVisible(false);

		
		
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				database db=new database("root","root");
				try {
					db.updateitem(Integer.parseInt(textField_5.getText()),Integer.parseInt(textField_6.getText()));
					
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog (frame, "Item updated");
				textField_5.setText("");
				textField_6.setText("");
			}
		});
		btnUpdate.setBounds(224, 220, 89, 23);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.setVisible(false);
		
		JButton btnNewButton = new JButton("NEW Item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1_1.setVisible(false);
				lblNewLabel_1_2.setVisible(false);
				btnUpdate.setVisible(false);
				textField_5.setVisible(false);
				textField_6.setVisible(false);
				lblNewLabel_1.setVisible(true);
				lblNewLabel_2.setVisible(true);
				lblNewLabel_2_1.setVisible(true);
				lblNewLabel_2_2.setVisible(true);
				lblNewLabel_2_2_1.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				textField_3.setVisible(true);
				textField_4.setVisible(true);
				btnAdd.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(37, 31, 89, 23);
		frame.getContentPane().add(btnNewButton);
		JButton btnAddItem = new JButton("Update Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setVisible(false);
				lblNewLabel_2.setVisible(false);
				lblNewLabel_2_1.setVisible(false);
				lblNewLabel_2_2.setVisible(false);
				lblNewLabel_2_2_1.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				textField_3.setVisible(false);
				textField_4.setVisible(false);
				
				btnAdd.setVisible(false);
				
				lblNewLabel_1_1.setVisible(true);
				lblNewLabel_1_2.setVisible(true);

				textField_5.setVisible(true);
				textField_6.setVisible(true);
				
				btnUpdate.setVisible(true);
				
			
			}
		});

		btnAddItem.setBounds(286, 31, 89, 23);
		frame.getContentPane().add(btnAddItem);
	}
}
