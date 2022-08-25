package miniproject;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.ItemSelectable;
import java.awt.List;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.Color;

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
		 HashMap<String,Integer> map=new HashMap<String,Integer>();  
		 database db=new database("root","root");
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(80, 80, 80));
		frame.setBounds(100, 100, 646, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ButtonGroup bg=new ButtonGroup();
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 630, 391);
		frame.getContentPane().add(tabbedPane);
		
		JPanel foodPanel = new JPanel();
		foodPanel.setBackground(new Color(221, 161, 31));
		tabbedPane.addTab("Food", null, foodPanel, null);
		foodPanel.setLayout(null);
		
		
		
		JLabel foodProductLabel = new JLabel("Product");
		foodProductLabel.setBounds(73, 101, 98, 27);
		foodPanel.add(foodProductLabel);
		
		JTextArea foodPriceTA = new JTextArea();
		foodPriceTA.setEditable(false);
		foodPriceTA.setBounds(218, 134, 269, 27);
		foodPanel.add(foodPriceTA);
		String food[]= {"TooYum","Lays","Snickers"};
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(food);
        JComboBox foodList = new JComboBox<>(comboModel);
       
		
		foodList.setBounds(218, 101, 270, 27);
		foodPanel.add(foodList);
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		        int state = itemEvent.getStateChange();
		        if(state == ItemEvent.SELECTED)
		        {
		        	try {
		        		foodPriceTA.setText(String.valueOf(db.prize((String)itemEvent.getItem())));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		        }
		        
		       
		      }
		    };
		    foodList.addItemListener(itemListener);
		
		JLabel foodPriceLabel = new JLabel("Price:");
		foodPriceLabel.setBounds(73, 139, 98, 14);
		foodPanel.add(foodPriceLabel);

		foodQty = new JTextField();
		
		foodQty.setBounds(218, 172, 86, 20);
		foodPanel.add(foodQty);
		foodQty.setColumns(10);
		
		
		JButton foodAddBtn = new JButton("Add To Cart");
		foodAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(db.buy ((String) foodList.getItemAt(foodList.getSelectedIndex()),Integer.parseInt(foodQty.getText()) ))
					{
					if (map.containsKey((String) foodList.getItemAt(foodList.getSelectedIndex())))
					{
						
					map.put((String) foodList.getItemAt(foodList.getSelectedIndex()),map.get((String) foodList.getItemAt(foodList.getSelectedIndex()))+Integer.parseInt(foodQty.getText()));
					foodQty.setText("");
					foodPriceTA.setText("");
					}
					else
						map.put((String) foodList.getItemAt(foodList.getSelectedIndex()),Integer.parseInt(foodQty.getText()));
					foodQty.setText("");
					foodPriceTA.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog (frame, "Item not Available");
						foodQty.setText("");
						foodPriceTA.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		foodAddBtn.setBounds(368, 273, 119, 23);
		foodPanel.add(foodAddBtn);
		
		
		JLabel foodQtyLabel = new JLabel("Quantity:");
		foodQtyLabel.setBounds(73, 175, 98, 14);
		foodPanel.add(foodQtyLabel);
		
		JPanel beveragesPanel = new JPanel();
		beveragesPanel.setBackground(new Color(221, 161, 31));
		tabbedPane.addTab("Beverages", null, beveragesPanel, null);
		beveragesPanel.setLayout(null);
		
		
		
		JLabel bevProductLabel = new JLabel("Product");
		bevProductLabel.setBounds(73, 101, 98, 27);
		beveragesPanel.add(bevProductLabel);
		
		JTextArea bevPriceTA = new JTextArea();
		bevPriceTA.setEditable(false);
		bevPriceTA.setBounds(218, 134, 269, 27);
		beveragesPanel.add(bevPriceTA);
		
		String bev[]= {"Coke","pepsi","fanta"};
		
		DefaultComboBoxModel<String> comboModel1 = new DefaultComboBoxModel<String>(bev);
        JComboBox bevList = new JComboBox<>(comboModel1);

		bevList.setBounds(218, 101, 270, 27);
		beveragesPanel.add(bevList);
		ItemListener itemListener1 = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		        int state = itemEvent.getStateChange();
		        if(state == ItemEvent.SELECTED)
		        {
		        	try {
		        		bevPriceTA.setText(String.valueOf(db.prize((String)itemEvent.getItem())));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		        }
		        
		       
		      }
		    };
		    bevList.addItemListener(itemListener1);
		
		JLabel bevPriceLabel = new JLabel("Price:");
		bevPriceLabel.setBounds(73, 139, 98, 14);
		beveragesPanel.add(bevPriceLabel);
		
		
		
		bevQty = new JTextField();
		
		bevQty.setColumns(10);
		bevQty.setBounds(218, 172, 86, 20);
		beveragesPanel.add(bevQty);
		
JButton bevAddBtn = new JButton("Add To Cart");
		
		bevAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(db.buy((String) bevList.getItemAt(bevList.getSelectedIndex()),Integer.parseInt(bevQty.getText())))
					{
					if (map.containsKey((String) bevList.getItemAt(bevList.getSelectedIndex())))
					{
						map.put((String) bevList.getItemAt(bevList.getSelectedIndex()),map.get((String) bevList.getItemAt(bevList.getSelectedIndex()))+Integer.parseInt(bevQty.getText()));
					bevQty.setText("");
					bevPriceTA.setText("");
					}
					else
					{
						map.put((String) bevList.getItemAt(bevList.getSelectedIndex()),Integer.parseInt(bevQty.getText()));
						bevQty.setText("");
						bevPriceTA.setText("");
						
					}
					}
					else
					{
						JOptionPane.showMessageDialog (frame, "Item not Available");
						bevQty.setText("");
						bevPriceTA.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		bevAddBtn.setBounds(368, 273, 119, 23);
		beveragesPanel.add(bevAddBtn);
		
		JLabel bevQtyLabel = new JLabel("Quantity:");
		bevQtyLabel.setBounds(73, 175, 98, 14);
		beveragesPanel.add(bevQtyLabel);
		
		JPanel checkoutPanel = new JPanel();
		checkoutPanel.setBackground(new Color(221, 161, 31));
		tabbedPane.addTab("Checkout", null, checkoutPanel, null);
		checkoutPanel.setLayout(null);
		
		JLabel itemsLabel = new JLabel("Items in Cart");
		itemsLabel.setBounds(50, 36, 104, 14);
		checkoutPanel.add(itemsLabel);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBounds(514, 329, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logind in=new logind();
				in.frame.setVisible(true);
			    frame.setVisible(false);
			    frame.dispose();
			    JOptionPane.showMessageDialog (in.frame, "Logged Out");
			}
		});
		checkoutPanel.add(btnNewButton_1);
	JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 31, 366, 169);
		checkoutPanel.add(scrollPane);
		
JTextArea cartTA = new JTextArea();
scrollPane.setViewportView(cartTA);
		
	
		JButton checkoutButton = new JButton("Checkout");
		checkoutButton.setBounds(50, 329, 89, 23);
		checkoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int total=0;
				String ss="Product"+"                   "+"Quantity"+"                   "+"Prize"+"                   "+"Total\n";
				 for(Entry<String, Integer> m:map.entrySet()){  
					   try {
						int prize=db.bill(m.getKey(),m.getValue());
						StringBuilder sb1 = new StringBuilder(m.getKey());
						String s1 = m.getValue().toString();
						StringBuilder sb2 = new StringBuilder(s1);
						System.out.println(m.getKey() + sb1.toString());
						System.out.println(m.getValue() + sb2.toString());
						int dif = 30 - sb1.length();
						int dif2 = 30 - sb2.length();
						for(int i = 0; i<dif;i++) {
							sb1.append(" ");
						}
						for(int i = 0; i<dif2;i++) {
							sb2.append(" ");
						}
					 ss+=sb1.toString()+sb2.toString()+prize+"                       "+m.getValue()*prize+"\n";
					 System.out.println(ss);
						total+=m.getValue()*prize;
					} catch (SQLException e1) {
						// TODO Auto-generated catch blockm.getValue()*prize
						e1.printStackTrace();
					} 
					  }
				ss+="Total amount"+"                                                                         "+total;
				 cartTA.setText(ss);
				
				
			}
			
		});
		checkoutPanel.add(checkoutButton);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
