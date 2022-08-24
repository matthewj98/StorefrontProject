package miniproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class logind {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logind window = new logind();
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
	public logind() {
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
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(289, 37, 135, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(199, 127, 66, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(199, 190, 66, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(275, 124, 149, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(275, 187, 149, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("SignUp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signupd ss=new signupd();
				ss.frame.setVisible(true);
				frame.setVisible(false);
			    frame.dispose();
			
			}
		});
		btnNewButton.setBounds(74, 301, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database db = new database("root", "root");
				try {
					if(textField.getText().equals("admin"))
					{
					if(db.login(textField.getText(),textField_1.getText()))
					{
						JOptionPane.showMessageDialog (frame, "you are sucessfully logined");
						admind dd=new admind();
						dd.adminde();
						frame.setVisible(false);
					    frame.dispose();
						
					}
					else
					{
						JOptionPane.showMessageDialog (frame, "Invalid username or password");
					}
					}
					else
					{
						if(db.login(textField.getText(),textField_1.getText()))
						{
							JOptionPane.showMessageDialog (frame, "you are sucessfully logined");
							productd pd=new productd();
							pd.productde();
							frame.setVisible(false);
						    frame.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog (frame, "Invalid username or password");
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(469, 301, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
