/**
 * CIS 120 Game HW
 * Anna Orosz
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
	public void run() {
		// NOTE : recall that the 'final' keyword notes inmutability
		// even for local variables.

		// Top-level frame in which game components live
		// Be sure to change "TOP LEVEL FRAME" to the name of your game
		final JFrame frame = new JFrame("TOP LEVEL FRAME");
		frame.setLocation(300, 300);

		// Status panel
		final JPanel status_panel = new JPanel();
		frame.add(status_panel, BorderLayout.SOUTH);
		final JLabel status = new JLabel("Running...");
		status_panel.add(status);

		// Main playing area
		final GameCourt court = new GameCourt(status);
		frame.add(court, BorderLayout.CENTER);
		court.setBackground(Color.darkGray);
		

		// Reset button
		final JPanel control_panel = new JPanel();
		frame.add(control_panel, BorderLayout.NORTH);

		// Note here that when we add an action listener to the reset
		// button, we define it as an anonymous inner class that is
		// an instance of ActionListener with its actionPerformed()
		// method overridden. When the button is pressed,
		// actionPerformed() will be called.
		final JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					court.reset();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		control_panel.add(reset);
		
		final JButton hscores = new JButton("High Scores");
        hscores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader("scores.txt"));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
                String s = null;
				try {
					s = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
                String[] sa = s.split(";");
                String scores = "";
                for(int i = sa.length - 1; i >= 0; i--){
                	scores = scores + (10 - i) + ". " + sa[i] + "\n";
                	
                }
            	JOptionPane.showMessageDialog(null, scores);
            }
        });
        control_panel.add(hscores);

		// Put the frame on the screen
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Start game
		try {
			court.reset();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		try {
			//GameCourt.sort();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	
	/*
	 * Main method run to start and run the game Initializes the GUI elements
	 * specified in Game and runs it IMPORTANT: Do NOT delete! You MUST include
	 * this in the final submission of your game.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game());
	}
}
