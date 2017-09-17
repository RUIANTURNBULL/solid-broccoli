
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

/**
 * This class is for managing and changing products in the vending machine
 * it has a frame with options to re-stock,change price,add items and displays
 * the total profit.
 * @author Ian Turnbull
 * @version 2-19-2017
 * ITEC 324 Assignment #1
 */
public class AdminWindow{

	private JFrame frmAdminWindow;
	private Admin admin;
	private Products[] productDesc;

	/**
	 * Constructor for AdminWindow class
	 * @param _admin an instance of the Admin class from the Keypad class
	 */
	public AdminWindow(Admin _admin) {
		this.admin = _admin;
		productDesc = admin.getProductDesc();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminWindow = new JFrame();
		frmAdminWindow.setTitle("**ADMIN ACCESS**");
		frmAdminWindow.setBounds(100, 100, 450, 230);
		frmAdminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminWindow.getContentPane().setLayout(null);
		
		/*
		 * back btn
		 */
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminWindow.dispose();
			}
		});
		btnBack.setBounds(265, 128, 89, 23);
		frmAdminWindow.getContentPane().add(btnBack);
		
		/*
		 * profit label
		 */
		JLabel labelProfit = new JLabel("");
		labelProfit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelProfit.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(admin.getProfit()));
		labelProfit.setBounds(350, 47, 59, 37);
		frmAdminWindow.getContentPane().add(labelProfit);
		
		/*
		 * change price btn
		 */
		JButton btnChangeprice = new JButton("CHANGE ITEM PRICE");
		btnChangeprice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String slot = (String)JOptionPane.showInputDialog(null,
		            "CHOOSE ITEM SLOT", "ITEM SLOT",
		            JOptionPane.QUESTION_MESSAGE, null, new String[] {"1","2","3","4","5","6"},
		            "1");
		        int productSlot = Integer.parseInt(slot);
		        String price = JOptionPane.showInputDialog(
		                frmAdminWindow, 
		                "ENTER NEW PRICE:", 
		                "CHANGE PRICE", 
		                JOptionPane.WARNING_MESSAGE
		            );
		        double productPrice = Double.parseDouble(price);
		        String name = productDesc[productSlot-1].getName();
		        productDesc[productSlot-1] = new Products(name,productPrice);
			}
		});
		btnChangeprice.setBounds(10, 11, 180, 40);
		frmAdminWindow.getContentPane().add(btnChangeprice);
		
		/*
		 * new item btn
		 */
		JButton btnNewitem = new JButton("ADD NEW ITEM");
		btnNewitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String slot = (String)JOptionPane.showInputDialog(null,
		            "CHOOSE ITEM SLOT", "ITEM SLOT",
		            JOptionPane.QUESTION_MESSAGE, null, new String[] {"1","2","3","4","5","6"},
		            "1");
		        int productSlot = Integer.parseInt(slot);
		        String product = JOptionPane.showInputDialog(
		                frmAdminWindow, 
		                "ENTER NEW PRODUCT NAME:", 
		                "NEW ITEM", 
		                JOptionPane.WARNING_MESSAGE
		            );
		        double name = productDesc[productSlot-1].getPrice();
		        productDesc[productSlot-1] = new Products(product,name);
			}
		});
		btnNewitem.setBounds(10, 55, 180, 40);
		frmAdminWindow.getContentPane().add(btnNewitem);
		
		/*
		 * amt label
		 */
		JLabel labelAmt = new JLabel("TOTAL PROFIT:");
		labelAmt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAmt.setBounds(239, 53, 118, 24);
		frmAdminWindow.getContentPane().add(labelAmt);
		
		/*
		 * restock btn
		 */
		JButton btnRestock = new JButton("RESTOCK ITEMS");
		btnRestock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < 6; i++) {
					productDesc[i].restock();
				}
			}
		});
		btnRestock.setBounds(10, 98, 180, 40);
		frmAdminWindow.getContentPane().add(btnRestock);
		
		/*
		 * new pin btn
		 */
		JButton btnNewPin = new JButton("CREATE NEW PIN");
		btnNewPin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pin = JOptionPane.showInputDialog(
		                frmAdminWindow, 
		                "ENTER NEW PIN NUMBER:", 
		                "NEW PIN", 
		                JOptionPane.WARNING_MESSAGE
		            );			
				admin.setPin(pin);
			}
		});
		btnNewPin.setBounds(10, 140, 180, 40);
		frmAdminWindow.getContentPane().add(btnNewPin);
		frmAdminWindow.setVisible(true);
		frmAdminWindow.setLocationRelativeTo(null);
	}

}
