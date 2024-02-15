/* Ethan Ellis
 * CNT 4714 – Spring 2024
 * Project 1 - Event-driven Enterprise Simulation
 * Tuesday January 30, 2024
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;


public class invoice extends JFrame implements ActionListener {
	
	JButton okButton;

	invoice(String cart[][], int num, float subTotal) {
		
		File list = new File("transactions.csv");
		String transactionID = new String();
		
		ZonedDateTime dateTime = ZonedDateTime.now();
		String format1 = "MMMM d, yyyy, hh:mm:ssa z";
		String format2 = "ddMMyyyyHHmmss";
		DateTimeFormatter pattern1 = DateTimeFormatter.ofPattern(format1);
		DateTimeFormatter pattern2 = DateTimeFormatter.ofPattern(format2);
		String time1 = dateTime.format(pattern1);
		String time2 = dateTime.format(pattern2);
		
		JLabel date = new JLabel();
		date.setBounds(10, 0, 725, 35);
		date.setText("Date: " + time1);
		this.add(date);
		
		JLabel lines = new JLabel();
		lines.setBounds(10, 40, 725, 35);
		lines.setText("Number of line items: " + num);
		this.add(lines);
		
		JLabel guide = new JLabel();
		guide.setBounds(10, 80, 725, 35);
		guide.setText("Item# / ID / Title / Price / Qty / Disc % / Subtotal:");
		this.add(guide);
		
		JLabel subtotal = new JLabel();
		subtotal.setBounds(10, 320, 725, 35);
		subtotal.setText("Order subtotal: $" + ((Math.round(subTotal * 100.0)) / 100.0));
		this.add(subtotal);
		
		JLabel taxRate = new JLabel();
		taxRate.setBounds(10, 360, 725, 35);
		taxRate.setText("Tax rate: 6%");
		this.add(taxRate);
		
		JLabel taxTotal = new JLabel();
		taxTotal.setBounds(10, 400, 725, 35);
		taxTotal.setText("Tax amount: $" + ((Math.round((subTotal * 0.06) * 100.0)) / 100.0));
		this.add(taxTotal);
		
		JLabel finalTotal = new JLabel();
		finalTotal.setBounds(10, 440, 725, 35);
		finalTotal.setText("ORDER TOTAL: $" + ((Math.round((subTotal * 1.06) * 100.0)) / 100.0));
		this.add(finalTotal);
		
		JLabel thanks = new JLabel();
		thanks.setBounds(10, 480, 725, 35);
		thanks.setText("Thanks for shopping at Nile.Com!");
		this.add(thanks);
		
		// Print out the lines for the cart:
		if (num >= 1) {
			
			JLabel label1 = new JLabel();
			label1.setBounds(10, 120, 725, 35);
			label1.setText("1. " + cart[0][0] + " " + cart[0][1] + " $" + cart[0][4] + " " + cart[0][5] + " " + cart[0][7] + "% $" + ((Math.round((Float.parseFloat(cart[0][6])) * 100.0)) / 100.0));
			this.add(label1);
		}
		
		if (num >= 2) {
			
			JLabel label2 = new JLabel();
			label2.setBounds(10, 160, 725, 35);
			label2.setText("2. " + cart[1][0] + " " + cart[1][1] + " $" + cart[1][4] + " " + cart[1][5] + " " + cart[1][7] + "% $" + ((Math.round((Float.parseFloat(cart[1][6])) * 100.0)) / 100.0));
			this.add(label2);
		}
		
		if (num >= 3) {
			
			JLabel label3 = new JLabel();
			label3.setBounds(10, 200, 725, 35);
			label3.setText("3. " + cart[2][0] + " " + cart[2][1] + " $" + cart[2][4] + " " + cart[2][5] + " " + cart[2][7] + "% $" + ((Math.round((Float.parseFloat(cart[2][6])) * 100.0)) / 100.0));
			this.add(label3);
		}
		
		if (num >= 4) {
			
			JLabel label4 = new JLabel();
			label4.setBounds(10, 240, 725, 35);
			label4.setText("4. " + cart[3][0] + " " + cart[3][1] + " $" + cart[3][4] + " " + cart[3][5] + " " + cart[3][7] + "% $" + ((Math.round((Float.parseFloat(cart[3][6])) * 100.0)) / 100.0));
			this.add(label4);
		}
		
		if (num >= 5) {
			
			JLabel label5 = new JLabel();
			label5.setBounds(10, 280, 725, 35);
			label5.setText("5. " + cart[4][0] + " " + cart[4][1] + " $" + cart[4][4] + " " + cart[4][5] + " " + cart[4][7] + "% $" + ((Math.round((Float.parseFloat(cart[4][6])) * 100.0)) / 100.0));
			this.add(label5);
		}
		
		
		// Export the information to a CSV file:
		try {
			
			FileWriter outputfile = new FileWriter(list, true);
			
			for (int i = 0; i < num; i++) {
				
				StringBuilder line = new StringBuilder();
				
				line.append(time2 + ", ");
				
				line.append(cart[i][0] + ", ");
				line.append(cart[i][1] + ", ");
				cart[i][4] = cart[i][4].replace("\n", "").replace("\r", "");
				line.append(cart[i][4] + ", ");
				line.append(cart[i][5] + ", ");
				line.append("0." + cart[i][7] + ", ");
				line.append(((Math.round((Float.parseFloat(cart[i][6])) * 100.0)) / 100.0) + ", ");
				
				line.append(time1);
				
				line.append("\n");
				
				if (i == (num - 1)) {
					
					line.append("\n");
				}
				
				outputfile.write(line.toString());
			}
			
			outputfile.close();
		}
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		// Create the button to close the window:
		okButton = new JButton();
		okButton.addActionListener(this);
		okButton.setBounds(335, 535, 80, 50);
		okButton.setText("Ok");
		okButton.setFocusable(false);
		
		// Add everything to the frame:
		this.setTitle("Nile.Com - FINAL INVOICE");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(750, 650);
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