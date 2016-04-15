/**
 * File: Driver.java
 * The program implements a very basic social network.
 */
package project3;

import java.awt.event.*;
import javax.swing.*;

public class Driver {

	public static void main(String[] args) {
		
		ProfileDatabase s = new ProfileDatabase();
		//s.loadProfiles("profiles"); // Uncomment once you write the ProfileDatabase class
		
		// create a window that says MyWorld
		JFrame frame = new JFrame ("MyWorld"); 
	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	   
	    // create the main panel
	    MainPanel panel = new MainPanel(s);
	    frame.add(panel);
	    frame.pack();
	    frame.setVisible(true);
	}

}
