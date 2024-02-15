/* Ethan Ellis
 * CNT 4714 – Spring 2024
 * Project 1 - Event-driven Enterprise Simulation
 * Tuesday January 30, 2024
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Error3Win extends JFrame implements ActionListener {
	
	JButton okButton;

	Error3Win(String quantity) {
		
		JLabel label = new JLabel();
		label.setText("Insufficient stock. Only " + quantity + " on hand. Please reduce the quantity.");
		label.setBounds(10, 10, 580, 40);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.LEFT);
		
		
		okButton = new JButton();
		okButton.addActionListener(this);
		okButton.setBounds(250, 80, 80, 50);
		okButton.setText("Ok");
		okButton.setFocusable(false);
		
		this.setTitle("Nile.Com - ERROR");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 200);
		this.setResizable(false);
		
		this.add(label);
		this.add(okButton);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == okButton) {
			
			dispose();
		}
	}
}