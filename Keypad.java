import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

/**
 * This class is responsible for displaying the inventory of products
 * and the input from the coins. 
 * @author Ian Turnbull
 * @version 2-19-2017
 * ITEC 324 Assignment #1
 */
public class Keypad {


	/**
	 * This is the main method
	 * @param args main method
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Keypad window = new Keypad();
					window.frmVendingMachine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor for Keypad class
	 */
	public Keypad() {
		admin = new Admin();
		productDesc = admin.getProductDesc();
		initialize();
		coins = new Coins();
	}

	/**
	 * Initialize the contents of Keypad
	 */
	private void initialize() {
		frmVendingMachine = new JFrame();
		frmVendingMachine.setTitle("Vending Machine");
		frmVendingMachine.setBounds(100, 100, 450, 230);
		frmVendingMachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVendingMachine.getContentPane().setLayout(null);
		frmVendingMachine.setLocationRelativeTo(null);
		
		/*
		 * slot 1 item btn
		 */
		JButton btnSlot1 = new JButton("");
		btnSlot1.setText(productDesc[0].getName().toUpperCase());
		btnSlot1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSlot1.setBounds(21, 11, 71, 50);
		btnSlot1.setBorder(new LineBorder(Color.BLACK));
		btnSlot1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productDesc[0].getInventory() <= 0) {
					coins.coinReturn();
					setLabelTotal();
					JOptionPane.showMessageDialog(null, productDesc[0].getName().toUpperCase() + " is sold out", "SOLD OUT!",JOptionPane.PLAIN_MESSAGE);
				}
				else if(productDesc[0].getPrice() <= coins.getTotal()) {
					productDesc[0].soldInventory();
					admin.setProfit(productDesc[0].getPrice());
					coins.setTotal(productDesc[0].getPrice());
					setLabelTotal();
					JOptionPane.showMessageDialog(null,"Thanks for purchasing " + productDesc[0].getName().toUpperCase(), "THANK YOU!",JOptionPane.PLAIN_MESSAGE);
				}
				else{
					coins.coinReturn();
					setLabelTotal();
					JOptionPane.showMessageDialog(null,"Please insert more change to purchase " + productDesc[0].getName().toUpperCase(), "OOPS!",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		frmVendingMachine.getContentPane().add(btnSlot1);
		
		/*
		 * slot 1 price label
		 */
		slot1 = new JLabel("");
		slot1.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(productDesc[0].getPrice()));
		slot1.setBounds(102, 29, 40, 14);
		frmVendingMachine.getContentPane().add(slot1);

		/*
		 * slot 2 item btn
		 */
		JButton btnSlot2 = new JButton("");
		btnSlot2.setText(productDesc[1].getName().toUpperCase());
		btnSlot2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productDesc[1].getInventory() <= 0) {
					coins.coinReturn();
					setLabelTotal();
					JOptionPane.showMessageDialog(null, productDesc[1].getName().toUpperCase() + " is sold out", "SOLD OUT!",JOptionPane.PLAIN_MESSAGE);
				}
				else if(productDesc[1].getPrice() <= coins.getTotal()) {
					productDesc[1].soldInventory();
					admin.setProfit(productDesc[1].getPrice());
					coins.setTotal(productDesc[1].getPrice());
					setLabelTotal();
					JOptionPane.showMessageDialog(null,"Thanks for purchasing " + productDesc[1].getName().toUpperCase(), "THANK YOU!",JOptionPane.PLAIN_MESSAGE);
				}
				else{
					coins.coinReturn();
					setLabelTotal();
					JOptionPane.showMessageDialog(null,"Please insert more change to purchase " + productDesc[1].getName().toUpperCase(), "OOPS!",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnSlot2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSlot2.setBounds(21, 72, 71, 50);
		btnSlot2.setBorder(new LineBorder(Color.BLACK));
		frmVendingMachine.getContentPane().add(btnSlot2);
		
		/* 
		 * slot 2 price label
		 */
		slot2 = new JLabel("");
		slot2.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(productDesc[1].getPrice()));
		slot2.setBounds(102, 90, 40, 14);
		frmVendingMachine.getContentPane().add(slot2);
		
		/*
		 * slot 3 item btn
		 */
		JButton btnSlot3 = new JButton("");
		btnSlot3.setText(productDesc[2].getName().toUpperCase());
		btnSlot3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productDesc[2].getInventory() <= 0) {
					coins.coinReturn();
					setLabelTotal();
					JOptionPane.showMessageDialog(null, productDesc[2].getName().toUpperCase() + " is sold out", "SOLD OUT!",JOptionPane.PLAIN_MESSAGE);
				}
				else if(productDesc[2].getPrice() <= coins.getTotal()) {
					productDesc[2].soldInventory();
					admin.setProfit(productDesc[2].getPrice());
					coins.setTotal(productDesc[2].getPrice());
					setLabelTotal();
					JOptionPane.showMessageDialog(null,"Thanks for purchasing " + productDesc[2].getName().toUpperCase(), "THANK YOU!",JOptionPane.PLAIN_MESSAGE);
				}
				else{
					coins.coinReturn();
					setLabelTotal();
					JOptionPane.showMessageDialog(null,"Please insert more change to purchase " + productDesc[2].getName().toUpperCase(), "OOPS!",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnSlot3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSlot3.setBounds(21, 133, 71, 50);
		btnSlot3.setBorder(new LineBorder(Color.BLACK));
		frmVendingMachine.getContentPane().add(btnSlot3);
		
		/*
		 * slot 3 price label
		 */
		
		slot3 = new JLabel("");
		slot3.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(productDesc[2].getPrice()));
		slot3.setBounds(102, 151, 40, 14);
		frmVendingMachine.getContentPane().add(slot3);
		
		/*
		 * slot 4 item btn
		 */
		JButton btnSlot4 = new JButton("");
		btnSlot4.setText(productDesc[3].getName().toUpperCase());
		btnSlot4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productDesc[3].getInventory() <= 0) {
					coins.coinReturn();
					setLabelTotal();
					JOptionPane.showMessageDialog(null, productDesc[3].getName().toUpperCase() + " is sold out", "SOLD OUT!",JOptionPane.PLAIN_MESSAGE);
				}
				else if(productDesc[3].getPrice() <= coins.getTotal()) {
					productDesc[3].soldInventory();
					admin.setProfit(productDesc[3].getPrice());
					coins.setTotal(productDesc[3].getPrice());
					setLabelTotal();
					JOptionPane.showMessageDialog(null,"Thanks for purchasing " + productDesc[3].getName().toUpperCase(), "THANK YOU!",JOptionPane.PLAIN_MESSAGE);
				}
				else{
					coins.coinReturn();
					setLabelTotal();
					JOptionPane.showMessageDialog(null,"Please insert more change to purchase " + productDesc[3].getName().toUpperCase(), "OOPS!",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnSlot4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSlot4.setBounds(162, 11, 71, 50);
		btnSlot4.setBorder(new LineBorder(Color.BLACK));
		frmVendingMachine.getContentPane().add(btnSlot4);
		
		/*
		 * slot 4 price label
		 */
		slot4 = new JLabel("");
		slot4.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(productDesc[3].getPrice()));
		slot4.setBounds(243, 29, 40, 14);
		frmVendingMachine.getContentPane().add(slot4);
		
		/*
		 * slot 5 item btn
		 */
		JButton btnSlot5 = new JButton("");
		btnSlot5.setText(productDesc[4].getName().toUpperCase());
		btnSlot5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productDesc[4].getInventory() <= 0) {
					coins.coinReturn();
					setLabelTotal();
					JOptionPane.showMessageDialog(null, productDesc[4].getName().toUpperCase() + " is sold out", "SOLD OUT!",JOptionPane.PLAIN_MESSAGE);
				}
				else if(productDesc[4].getPrice() <= coins.getTotal()) {
					productDesc[4].soldInventory();
					admin.setProfit(productDesc[4].getPrice());
					coins.setTotal(productDesc[4].getPrice());
					setLabelTotal();
					JOptionPane.showMessageDialog(null,"Thanks for purchasing " + productDesc[4].getName().toUpperCase(), "THANK YOU!",JOptionPane.PLAIN_MESSAGE);
				}
				else{
					coins.coinReturn();
					setLabelTotal();
					JOptionPane.showMessageDialog(null,"Please insert more change to purchase " + productDesc[4].getName().toUpperCase(), "OOPS!",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnSlot5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSlot5.setBounds(162, 72, 71, 50);
		btnSlot5.setBorder(new LineBorder(Color.BLACK));
		frmVendingMachine.getContentPane().add(btnSlot5);
		
		/*
		 * slot 5 price label
		 */
		slot5 = new JLabel("");
		slot5.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(productDesc[4].getPrice()));
		slot5.setBounds(243, 90, 40, 14);
		frmVendingMachine.getContentPane().add(slot5);
		
		/*
		 * slot 6 item btn
		 */
		JButton btnSlot6 = new JButton("");
		btnSlot6.setText(productDesc[5].getName().toUpperCase());
		btnSlot6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productDesc[5].getInventory() <= 0) {
					coins.coinReturn();
					setLabelTotal();
					JOptionPane.showMessageDialog(null, productDesc[5].getName().toUpperCase() + " is sold out", "SOLD OUT!",JOptionPane.PLAIN_MESSAGE);
				}
				else if(productDesc[5].getPrice() <= coins.getTotal()) {
					productDesc[5].soldInventory();
					admin.setProfit(productDesc[5].getPrice());
					coins.setTotal(productDesc[5].getPrice());
					setLabelTotal();
					JOptionPane.showMessageDialog(null,"Thanks for purchasing " + productDesc[5].getName().toUpperCase(), "THANK YOU!",JOptionPane.PLAIN_MESSAGE);
				}
				else{
					coins.coinReturn();
					setLabelTotal();
					JOptionPane.showMessageDialog(null,"Please insert more change to purchase " + productDesc[5].getName().toUpperCase(), "OOPS!",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnSlot6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSlot6.setBounds(162, 133, 71, 50);
		btnSlot6.setBorder(new LineBorder(Color.BLACK));
		frmVendingMachine.getContentPane().add(btnSlot6);

		/*
		 * slot 6 price label
		 */
		slot6 = new JLabel("");
		slot6.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(productDesc[5].getPrice()));
		slot6.setBounds(243, 151, 40, 14);
		frmVendingMachine.getContentPane().add(slot6);
		
		/*
		 * displays the current total added by user
		 */
		labelTotal = new JLabel("$0.00");
		labelTotal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelTotal.setBounds(313, 11, 90, 24);
		frmVendingMachine.getContentPane().add(labelTotal);
		
		/*
		 * add a penny to total
		 */
		JButton btnPenny = new JButton("1 \u00A2");
		btnPenny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coins.addPenny();
				setLabelTotal();
			}
		});
		btnPenny.setBounds(313, 40, 90, 30);
		btnPenny.setBorder(new LineBorder(Color.BLACK));
		frmVendingMachine.getContentPane().add(btnPenny);
		
		/*
		 * add a nickel to total
		 */
		JButton btnNickel = new JButton("5 \u00A2");
		btnNickel.setBounds(313, 71, 90, 30);
		btnNickel.setBorder(new LineBorder(Color.BLACK));
		btnNickel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coins.addNickel();
				setLabelTotal();
			}
		});
		frmVendingMachine.getContentPane().add(btnNickel);
		
		/*
		 * add a dime to total
		 */
		JButton btnDime = new JButton("10 \u00A2");
		btnDime.setBounds(313, 102, 90, 30);
		btnDime.setBorder(new LineBorder(Color.BLACK));
		btnDime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coins.addDime();
				setLabelTotal();
			}
		});
		frmVendingMachine.getContentPane().add(btnDime);
		
		/*
		 * add a quarter to total
		 */
		JButton btnQuarter = new JButton("25 \u00A2");
		btnQuarter.setBounds(313, 133, 90, 30);
		btnQuarter.setBorder(new LineBorder(Color.BLACK));
		btnQuarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coins.addQuarter();
				setLabelTotal();
			}
		});
		frmVendingMachine.getContentPane().add(btnQuarter);
		
		/*
		 * opens admin menu
		 */
		JButton btnAdmin = new JButton("admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String product = "";
				int attempts = 5;
				try{
					while(!product.equals(admin.getPin()) && attempts > 0) {
						product = JOptionPane.showInputDialog(
								frmVendingMachine, 
								"ENTER OPERATOR PIN(5 trys):", 
								"OPERATOR PIN", 
								JOptionPane.WARNING_MESSAGE
								);
						attempts--;
					}
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				if(product.equals(admin.getPin()))
					new AdminWindow(admin);
				else
					JOptionPane.showMessageDialog(null,"Too many attempts, try again later.","OOPS!",JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAdmin.setBounds(371, 168, 56, 15);
		frmVendingMachine.getContentPane().add(btnAdmin);
		
		/*
		 * sets total back to zero
		 */
		JButton btnReturn = new JButton("");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coins.coinReturn();
				setLabelTotal();
			}
		});
		btnReturn.setIcon(new ImageIcon("C:\\Users\\Ian\\Resilio Sync\\ru\\2017 SPRING\\ITEC 324\\project_one\\Project_One\\src\\coinReturn.png"));
		btnReturn.setBounds(409, 41, 20, 122);
		btnReturn.setBorder(new LineBorder(Color.BLACK));
		frmVendingMachine.getContentPane().add(btnReturn);
		
		/*
		 * update btn
		 */
		JButton btnUpdate = new JButton("update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slot1.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(productDesc[0].getPrice()));
				slot2.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(productDesc[1].getPrice()));
				slot3.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(productDesc[2].getPrice()));
				slot4.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(productDesc[3].getPrice()));
				slot5.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(productDesc[4].getPrice()));
				slot6.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(productDesc[5].getPrice()));
				btnSlot1.setText(productDesc[0].getName().toUpperCase());
				btnSlot2.setText(productDesc[1].getName().toUpperCase());
				btnSlot3.setText(productDesc[2].getName().toUpperCase());
				btnSlot4.setText(productDesc[3].getName().toUpperCase());
				btnSlot5.setText(productDesc[4].getName().toUpperCase());
				btnSlot6.setText(productDesc[5].getName().toUpperCase());
			}
		});
		btnUpdate.setBounds(313, 168, 61, 15);
		frmVendingMachine.getContentPane().add(btnUpdate);
		
	}
	
	/**
	 * gets the total from coins class and updates the total on the display
	 */
	private void setLabelTotal() {
		double total = coins.getTotal();
		labelTotal.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(total));
	}
	
	private JFrame frmVendingMachine;
	private JLabel labelTotal;
	private JLabel slot1;
	private JLabel slot2;
	private JLabel slot3;
	private JLabel slot4;
	private JLabel slot5;
	private JLabel slot6;
	private Coins coins;
	private Admin admin;
	private Products[] productDesc;
}
