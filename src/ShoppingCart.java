/* Ethan Ellis
 * CNT 4714 – Spring 2024
 * Project 1 - Event-driven Enterprise Simulation
 * Tuesday January 30, 2024
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShoppingCart extends JFrame implements ActionListener {
	
	JButton okButton;

	ShoppingCart(String cart[][], int num) {
		
		// Print out the lines for the cart:
		if (num >= 1) {
			
			JLabel label1 = new JLabel();
			label1.setBounds(10, 0, 725, 35);
			label1.setText("1. " + cart[0][0] + " " + cart[0][1] + " $" + cart[0][4] + " " + cart[0][5] + " " + cart[0][7] + "% $" + ((Math.round((Float.parseFloat(cart[0][6])) * 100.0)) / 100.0));
			this.add(label1);
		}
		
		if (num >= 2) {
			
			JLabel label2 = new JLabel();
			label2.setBounds(10, 40, 725, 35);
			label2.setText("2. " + cart[1][0] + " " + cart[1][1] + " $" + cart[1][4] + " " + cart[1][5] + " " + cart[1][7] + "% $" + ((Math.round((Float.parseFloat(cart[1][6])) * 100.0)) / 100.0));
			this.add(label2);
		}
		
		if (num >= 3) {
			
			JLabel label3 = new JLabel();
			label3.setBounds(10, 80, 725, 35);
			label3.setText("3. " + cart[2][0] + " " + cart[2][1] + " $" + cart[2][4] + " " + cart[2][5] + " " + cart[2][7] + "% $" + ((Math.round((Float.parseFloat(cart[2][6])) * 100.0)) / 100.0));
			this.add(label3);
		}
		
		if (num >= 4) {
			
			JLabel label4 = new JLabel();
			label4.setBounds(10, 120, 725, 35);
			label4.setText("4. " + cart[3][0] + " " + cart[3][1] + " $" + cart[3][4] + " " + cart[3][5] + " " + cart[3][7] + "% $" + ((Math.round((Float.parseFloat(cart[3][6])) * 100.0)) / 100.0));
			this.add(label4);
		}
		
		if (num >= 5) {
			
			JLabel label5 = new JLabel();
			label5.setBounds(10, 160, 725, 35);
			label5.setText("5. " + cart[4][0] + " " + cart[4][1] + " $" + cart[4][4] + " " + cart[4][5] + " " + cart[4][7] + "% $" + ((Math.round((Float.parseFloat(cart[4][6])) * 100.0)) / 100.0));
			this.add(label5);
		}
		
		// Create the button to close the window:
		okButton = new JButton();
		okButton.addActionListener(this);
		okButton.setBounds(335, 225, 80, 50);
		okButton.setText("Ok");
		okButton.setFocusable(false);
		
		// Add everything to the frame:
		this.setTitle("Nile.Com - Current Shopping Cart Status");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(750, 350);
		this.setResizable(false);
		
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