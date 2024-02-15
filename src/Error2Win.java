/* Ethan Ellis
 * CNT 4714 – Spring 2024
 * Project 1 - Event-driven Enterprise Simulation
 * Tuesday January 30, 2024
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Error2Win extends JFrame implements ActionListener {
	
	JButton okButton;

	Error2Win() {
		
		JLabel label = new JLabel();
		label.setText("Sorry... that item is out of stock, please try another item");
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