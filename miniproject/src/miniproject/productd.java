package miniproject;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
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
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

public class productd {

	JFrame frame;
	private JTextField foodQty;
	private JTextField bevQty;

	/**
	 * Launch the application.
	 */
	public  void productde() {
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
		frame.setBounds(100, 100, 646, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ButtonGroup bg=new ButtonGroup();
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 630, 391);
		frame.getContentPane().add(tabbedPane);
		
		JPanel foodPanel = new JPanel();
		tabbedPane.addTab("Food", null, foodPanel, null);
		foodPanel.setLayout(null);
		
		String food[]= {"TooYum","Lays","Snickers"};
		JComboBox<String> foodList = new JComboBox<>(food);
		foodList.setBounds(218, 11, 270, 27);
		foodPanel.add(foodList);
		
		JLabel foodProductLabel = new JLabel("Product");
		foodProductLabel.setBounds(73, 11, 98, 27);
		foodPanel.add(foodProductLabel);
		
		JTextArea foodTA = new JTextArea();
		foodTA.setEditable(false);
		foodTA.setBounds(218, 54, 269, 64);
		foodPanel.add(foodTA);
		
		JLabel foodDescLabel = new JLabel("Description:");
		foodDescLabel.setBounds(73, 59, 98, 14);
		foodPanel.add(foodDescLabel);
		
		JTextArea foodPriceTA = new JTextArea();
		foodPriceTA.setEditable(false);
		foodPriceTA.setBounds(218, 134, 269, 27);
		foodPanel.add(foodPriceTA);
		
		JLabel foodPriceLabel = new JLabel("Price:");
		foodPriceLabel.setBounds(73, 139, 98, 14);
		foodPanel.add(foodPriceLabel);
		
		JButton foodAddBtn = new JButton("Add To Cart");
		foodAddBtn.setBounds(368, 273, 119, 23);
		foodPanel.add(foodAddBtn);
		
		foodQty = new JTextField();
		foodQty.setText("1");
		foodQty.setBounds(218, 172, 86, 20);
		foodPanel.add(foodQty);
		foodQty.setColumns(10);
		
		JLabel foodQtyLabel = new JLabel("Quantity:");
		foodQtyLabel.setBounds(73, 175, 98, 14);
		foodPanel.add(foodQtyLabel);
		
		JPanel beveragesPanel = new JPanel();
		tabbedPane.addTab("Beverages", null, beveragesPanel, null);
		beveragesPanel.setLayout(null);
		
		String bev[]= {"Coke","pepsi","fanta"};
		JComboBox<String> bevList = new JComboBox<>(bev);

		bevList.setBounds(218, 11, 270, 27);
		beveragesPanel.add(bevList);
		
		JLabel bevProductLabel = new JLabel("Product");
		bevProductLabel.setBounds(73, 11, 98, 27);
		beveragesPanel.add(bevProductLabel);
		
		JTextArea bevTA = new JTextArea();
		bevTA.setEditable(false);
		bevTA.setBounds(218, 54, 269, 64);
		beveragesPanel.add(bevTA);
		
		JLabel bevDescLabel = new JLabel("Description:");
		bevDescLabel.setBounds(73, 59, 98, 14);
		beveragesPanel.add(bevDescLabel);
		
		JTextArea bevPriceTA = new JTextArea();
		bevPriceTA.setEditable(false);
		bevPriceTA.setBounds(218, 134, 269, 27);
		beveragesPanel.add(bevPriceTA);
		
		JLabel bevPriceLabel = new JLabel("Price:");
		bevPriceLabel.setBounds(73, 139, 98, 14);
		beveragesPanel.add(bevPriceLabel);
		
		JButton bevAddBtn = new JButton("Add To Cart");
		bevAddBtn.setBounds(368, 273, 119, 23);
		beveragesPanel.add(bevAddBtn);
		
		bevQty = new JTextField();
		bevQty.setText("1");
		bevQty.setColumns(10);
		bevQty.setBounds(218, 172, 86, 20);
		beveragesPanel.add(bevQty);
		
		JLabel bevQtyLabel = new JLabel("Quantity:");
		bevQtyLabel.setBounds(73, 175, 98, 14);
		beveragesPanel.add(bevQtyLabel);
		
		JPanel checkoutPanel = new JPanel();
		tabbedPane.addTab("Checkout", null, checkoutPanel, null);
		checkoutPanel.setLayout(null);
	
		
		
		
		
		
		
		
		
		
	}
}
