/* Ethan Ellis
 * CNT 4714 – Spring 2024
 * Project 1 - Event-driven Enterprise Simulation
 * Tuesday January 30, 2024
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.File;


public class MainWin extends JFrame implements ActionListener {
	
	private static Scanner x;
	
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel item1;
	JLabel item2;
	JLabel item3;
	JLabel item4;
	JLabel item5;
	
	JButton findButton;
	JButton addButton;
	JButton viewButton;
	JButton checkButton;
	JButton emptyButton;
	JButton exitButton;
	
	JTextField itemID;
	JTextField itemQuantity;
	JLabel details;
	JLabel subtotal;
	
	String ID = new String();
	String quantity = new String();
	
	String[] itemRow;
	
	// Represents the shopping cart. The 5 represents the 5 items, and the 8 is as follows: ID, Description, Stock, Inventory, Price, Quantity, Subtotal, and Discount
	String[][] cart = new String[5][8];
	
	int itemNum = 1;
	int itemCount = 0;
	int cartCount = 0;
	
	float multipleItemTotal = 0.00f;
	float subTotal = 0.00f;
	
	
	
	// Constructor for the main Window:
	MainWin() {
		
		// Create labels:
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		
		item1 = new JLabel();
		item2 = new JLabel();
		item3 = new JLabel();
		item4 = new JLabel();
		item5 = new JLabel();
		
		
		// Set positions and text for labels:
		label1.setText("Enter item ID for Item #" + itemNum + ":");
		label1.setForeground(Color.black);
		label1.setVerticalAlignment(JLabel.CENTER);
		label1.setHorizontalAlignment(JLabel.RIGHT);
		label1.setBounds(0, 10, 295, 35);
		
		label2.setText("Enter quantity for Item #" + itemNum + ":");
		label2.setForeground(Color.black);
		label2.setVerticalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.RIGHT);
		label2.setBounds(0, 50, 295, 35);
		
		label3.setText("Details for Item #" + itemNum + ":");
		label3.setForeground(Color.red);
		label3.setVerticalAlignment(JLabel.CENTER);
		label3.setHorizontalAlignment(JLabel.RIGHT);
		label3.setBounds(0, 90, 295, 35);
		
		label4.setText("Order subtotal for " + itemCount + " item(s):");
		label4.setForeground(Color.red);
		label4.setVerticalAlignment(JLabel.CENTER);
		label4.setHorizontalAlignment(JLabel.RIGHT);
		label4.setBounds(0, 130, 295, 35);
		
		label5.setText("Your shopping cart is empty");
		label5.setForeground(Color.red);
		label5.setVerticalAlignment(JLabel.CENTER);
		label5.setHorizontalAlignment(JLabel.CENTER);
		label5.setBounds(0, 170, 1000, 35);
		
		// JLabels for shopping car items:
		item1.setBounds(10, 210, 900, 35);
		item1.setVerticalAlignment(JLabel.CENTER);
		item1.setHorizontalAlignment(JLabel.LEFT);
		
		item2.setBounds(10, 250, 900, 35);
		item2.setVerticalAlignment(JLabel.CENTER);
		item2.setHorizontalAlignment(JLabel.LEFT);
		
		item3.setBounds(10, 290, 900, 35);
		item3.setVerticalAlignment(JLabel.CENTER);
		item3.setHorizontalAlignment(JLabel.LEFT);
		
		item4.setBounds(10, 330, 900, 35);
		item4.setVerticalAlignment(JLabel.CENTER);
		item4.setHorizontalAlignment(JLabel.LEFT);
		
		item5.setBounds(10, 370, 900, 35);
		item5.setVerticalAlignment(JLabel.CENTER);
		item5.setHorizontalAlignment(JLabel.LEFT);
		
		
		// Create buttons and set positions and text for buttons:
		findButton = new JButton();
		findButton.setBounds(10, 435, 475, 60);
		findButton.addActionListener(this);
		findButton.setText("Find Item #" + itemNum);
		findButton.setFocusable(false);
		
		addButton = new JButton();
		addButton.setBounds(495, 435, 475, 60);
		addButton.addActionListener(this);
		addButton.setText("Add Item #" + itemNum + " to Cart");
		addButton.setFocusable(false);
		addButton.setEnabled(false);
		
		viewButton = new JButton();
		viewButton.setBounds(10, 505, 475, 60);
		viewButton.addActionListener(this);
		viewButton.setText("View Cart");
		viewButton.setFocusable(false);
		viewButton.setEnabled(false);
		
		checkButton = new JButton();
		checkButton.setBounds(495, 505, 475, 60);
		checkButton.addActionListener(this);
		checkButton.setText("Check Out");
		checkButton.setFocusable(false);
		checkButton.setEnabled(false);
		
		emptyButton = new JButton();
		emptyButton.setBounds(10, 575, 475, 60);
		emptyButton.addActionListener(this);
		emptyButton.setText("Empty Cart - Start a new Order");
		emptyButton.setFocusable(false);
		
		exitButton = new JButton();
		exitButton.setBounds(495, 575, 475, 60);
		exitButton.addActionListener(this);
		exitButton.setText("Exit (Close App)");
		exitButton.setFocusable(false);
		
		
		// Create Text Fields and set positions:
		itemID = new JTextField();
		itemID.setBounds(305, 10, 400, 35);
		
		itemQuantity = new JTextField();
		itemQuantity.setBounds(305, 50, 400, 35);
		
		details = new JLabel();
		details.setBounds(305, 90, 800, 35);
		details.setVerticalAlignment(JLabel.CENTER);
		details.setHorizontalAlignment(JLabel.LEFT);
		
		subtotal = new JLabel();
		subtotal.setBounds(305, 130, 800, 35);
		subtotal.setVerticalAlignment(JLabel.CENTER);
		subtotal.setHorizontalAlignment(JLabel.LEFT);
	
		
		// Add everything to the JFrame:
		this.setTitle("Nile.Com - Fall 2023");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 685);
		this.setResizable(false);
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(label5);
		this.add(item1);
		this.add(item2);
		this.add(item3);
		this.add(item4);
		this.add(item5);
		this.add(findButton);
		this.add(addButton);
		this.add(viewButton);
		this.add(checkButton);
		this.add(emptyButton);
		this.add(exitButton);
		this.add(itemID);
		this.add(itemQuantity);
		this.add(details);
		this.add(subtotal);
		
		this.setVisible(true);

	}

	
	// Event Listener for determining if the user has made an action:
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Initialize variables:
		float discount = 1.00f;
		int displayDiscount = 0;
		float quantity1 = 1;
		float price1 = 0;
		
		itemRow = new String[5];
		
		
		// Exit Button:
		if(e.getSource() == exitButton) {
			System.exit(0);
		}
		
		// Find Item Button:
		else if(e.getSource() == findButton) {
			
			ID = itemID.getText();
			quantity = itemQuantity.getText();
			if (quantity.isEmpty()) {
				quantity = "1";
			}
			
			itemRow = readRow(ID, "inventory.csv");
			
			// If item is not found:
			if(itemRow == null) {
				
				itemID.setText("");
				itemQuantity.setText("");
				Error1Win error = new Error1Win(ID);
			}
			
			// If item is out of stock:
			else if (itemRow[3].equals("0")) {
				
				itemID.setText("");
				itemQuantity.setText("");
				Error2Win error1 = new Error2Win();
				findButton.setEnabled(true);
			}
			
			// If requested amount is higher than what is in stock:
			else if (Integer.parseInt(itemRow[3]) < Integer.parseInt(quantity)) {
				
				Error3Win error2 = new Error3Win(itemRow[3]);
				findButton.setEnabled(true);
			}
			
			// If item is found:
			else {
				addButton.setEnabled(true);
				findButton.setEnabled(false);
				
				if (cartCount > 0) {
					
					label3.setText("Details for Item #" + itemNum + ":");
				}
				
				quantity1 = Float.parseFloat(quantity);
				price1 = Float.parseFloat(itemRow[4]);
				discount = getDiscount(quantity1);
				displayDiscount = Math.round((1 - discount) * 100);
				cart[cartCount][7] = String.valueOf(displayDiscount);
				
				multipleItemTotal = quantity1 * price1 * discount;
				
				details.setText(itemRow[0] + " " + itemRow[1] + " $" + itemRow[4] + " " + quantity + " " + displayDiscount + "% $" + ((Math.round(multipleItemTotal * 100.0)) / 100.0));

			}
			
			
		}
		
		// Add to cart Button:
		else if(e.getSource() == addButton) {
			
			itemRow = readRow(ID, "inventory.csv");
			subTotal += multipleItemTotal;
			
			itemNum++;
			findButton.setText("Find Item #" + itemNum);
			findButton.setEnabled(true);
			addButton.setText("Add Item #" + itemNum + " to Cart");
			addButton.setEnabled(false);
			viewButton.setEnabled(true);
			checkButton.setEnabled(true);
			itemID.setText("");
			itemQuantity.setText("");
			label1.setText("Enter item ID for Item #" + itemNum + ":");
			label2.setText("Enter quantity for Item #" + itemNum + ":");
			
			// Add the item and its information to the cart:
			cart[cartCount][0] = itemRow[0];
			cart[cartCount][1] = itemRow[1];
			cart[cartCount][2] = itemRow[2];
			cart[cartCount][3] = itemRow[3];
			cart[cartCount][4] = itemRow[4];
			cart[cartCount][5] = quantity;
			cart[cartCount][6] = String.valueOf(multipleItemTotal);
			
			cartCount++;
			
			label4.setText("Order subtotal for " + cartCount + " items:");
			label5.setText("Your current shopping cart with " + cartCount + " Item(s)");
			subtotal.setText("$" + ((Math.round(subTotal * 100.0)) / 100.0));
			
			// If the cart is full, ensure no new items can be added to the cart:
			if (cartCount == 5) {
				
				findButton.setEnabled(false);
				addButton.setEnabled(false);
				itemID.setEnabled(false);
				itemQuantity.setEnabled(false);
			}
			
			// Display the items to the cart:
			if (cartCount == 1) {
				
				item1.setText("Item 1 - SKU: " + itemRow[0] + ", Desc: " + itemRow[1] + ", Price Ea. $" + itemRow[4] + ", Qty: " + quantity + ", Total: $" + ((Math.round(multipleItemTotal * 100.0)) / 100.0));
			}
			
			else if (cartCount == 2) {
				
				item2.setText("Item 2 - SKU: " + itemRow[0] + ", Desc: " + itemRow[1] + ", Price Ea. $" + itemRow[4] + ", Qty: " + quantity + ", Total: $" + ((Math.round(multipleItemTotal * 100.0)) / 100.0));
			}
			
			else if (cartCount == 3) {
				
				item3.setText("Item 3 - SKU: " + itemRow[0] + ", Desc: " + itemRow[1] + ", Price Ea. $" + itemRow[4] + ", Qty: " + quantity + ", Total: $" + ((Math.round(multipleItemTotal * 100.0)) / 100.0));
			}
			
			else if (cartCount == 4) {
				
				item4.setText("Item 4 - SKU: " + itemRow[0] + ", Desc: " + itemRow[1] + ", Price Ea. $" + itemRow[4] + ", Qty: " + quantity + ", Total: $" + ((Math.round(multipleItemTotal * 100.0)) / 100.0));
			}
			
			else if (cartCount == 5) {
				
				item5.setText("Item 5 - SKU: " + itemRow[0] + ", Desc: " + itemRow[1] + ", Price Ea. $" + itemRow[4] + ", Qty: " + quantity + ", Total: $" + ((Math.round(multipleItemTotal * 100.0)) / 100.0));
			}
				
		}
		
		// View cart button opens new window:
		else if(e.getSource() == viewButton) {
			
			ShoppingCart cartWindow = new ShoppingCart(cart, cartCount);
		}
		
		else if(e.getSource() == checkButton) {
			
			invoice receipt = new invoice(cart, cartCount, subTotal);
			
			itemID.setEnabled(false);
			itemQuantity.setEnabled(false);
			
			findButton.setEnabled(false);
			addButton.setEnabled(false);
			checkButton.setEnabled(false);
		}
		
		// Empty cart button:
		else if(e.getSource() == emptyButton) {
			
			// Reset all variables and text fields:
			itemRow = new String[5];
			cart = new String[5][8];
			
			itemNum = 1;
			itemCount = 0;
			cartCount = 0;
			
			multipleItemTotal = 0.00f;
			subTotal = 0.00f;
			
			label1.setText("Enter item ID for Item #" + itemNum + ":");
			label2.setText("Enter quantity for item #" + itemNum + ":");
			label3.setText("Details for Item #" + itemNum + ":");
			label4.setText("Order subtotal for " + itemCount + " item(s):");
			label5.setText("Your shopping cart is empty");
			
			item1.setText("");
			item2.setText("");
			item3.setText("");
			item4.setText("");
			item5.setText("");
			
			itemID.setText("");
			itemQuantity.setText("");
			
			details.setText("");
			subtotal.setText("");
			
			findButton.setText("Find Item #" + itemNum);
			addButton.setText("Add Item #" + itemNum + " to Cart");
			
			itemID.setEnabled(true);
			itemQuantity.setEnabled(true);
			
			findButton.setEnabled(true);
			addButton.setEnabled(false);
			viewButton.setEnabled(false);
			checkButton.setEnabled(false);
		}
		
		
	}
	
	
	// Method for finding a specific inventory item and returning its information:
	public static String[] readRow(String searchTerm, String filepath) {
		
		// Declare variables:
		String[] itemInfo = new String[5];
		boolean found = false;
		String ID1 = "";
		String desc = "";
		String inStock = "";
		String inventory = "";
		String price = "";
		
		try {
			
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			
			// Search through the file for the ID:
			while(x.hasNext() && found == false) {
				
				ID1 = x.next();
				desc = x.next();
				inStock = x.next();
				inventory = x.next();
				price = x.next();
				
				// End the while loop if found:
				if(searchTerm.equals(ID1) == true) {
					
					found = true;
				}
			}
			
			// Set the itemInfo into a String[] and return it:
			if (found == true) {
				itemInfo[0] = ID1;
				itemInfo[1] = desc;
				itemInfo[2] = inStock;
				itemInfo[3] = inventory;
				itemInfo[4] = price;
				return itemInfo;
			}
		}
		
		catch(Exception e) {
			
			System.out.println(e);
			return(null);
		}
		
		// Return null if the ID is not found.
		return (null);
	}
	
	
	// Determines the discount for the purchase depending on the quantity of the product bought:
	public static float getDiscount(float num) {
		
		if (num <= 4) {
			return 1f;
		}
		
		else if (num > 4 && num <= 9) {
			return 0.9f;
		}
		
		else if (num > 9 && num <= 14) {
			return 0.85f;
		}
		
		return 0.8f;
	}
}
