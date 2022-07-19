package miniproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class choice implements ItemListener {

	// choice
	static Choice c;

	// frame
	static JFrame f;

	// label
	static Label l;

	// default constructor
	choice()
	{
	}

	// Main Method
	public static void main(String args[])
	{

		// create a frame
		f = new JFrame("choice");

		// object
		choice ch = new choice();

		// create e panel
		JPanel p = new JPanel();

		// create a choice
		c = new Choice();

		// add element to the list
		c.add("Andrew");
		c.add("Arnab");
		c.add("Ankit");

		// add itemListener to it
		c.addItemListener(ch);

		// create a label
		l = new Label();

		// set the label text
		l.setText(c.getSelectedItem() + " selected");

		// add choice to panel
		p.add(c);
		p.add(l);

		// add panel to the frame
		f.add(p);

		// show the frame
		f.show();
		f.setSize(300, 300);
	}

	// if an item is selected
	public void itemStateChanged(ItemEvent e)
	{
		l.setText(c.getSelectedItem() + " selected");
	}
}