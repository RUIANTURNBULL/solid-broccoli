
/**
 * This class is for holding sensitive information that only the operator can
 * access, including the pin and profit. It is also responsible for initiating
 * the inventory array
 * 
 * @author Ian Turnbull
 * @version 2-19-2017
 * ITEC 324 Assignment #1
 */
public class Admin {
	
	private Products[] productDesc;
	private double profit;
	private String pin;
	
	/**
	 * Constructor for Admin class
	 */
	public Admin() {
		productDesc = new Products[6];
		inventory();
		profit = 0;
		pin = "1234";
	}

	/**
	 * builds the inventory array that holds item descriptions
	 */
	public void inventory() {
		productDesc[0] = new Products("COKE",1.00);
		productDesc[1] = new Products("DIET COKE",1.00);
		productDesc[2] = new Products("SKITTLES",0.45);
		productDesc[3] = new Products("DORITOS",0.76);
		productDesc[4] = new Products("PRETZELS",1.45);
		productDesc[5] = new Products("CRACKERS",1.75);
	}
	
	/**
	 * Gets productDesc array
	 * @return productDesc array that contains all the items and descriptions
	 */
	public Products[] getProductDesc() {
		return productDesc;
	}

	/**
	 * increments the profit when a product is purchased
	 * @param purchase the cost of the product purchased
	 */
	public void setProfit(double purchase) {
		profit += purchase;
	}
	
	/**
	 * Gets profit
	 * @return profit total amount of money made from products
	 */
	public double getProfit() {
		return profit;
	}
	
	/**
	 * Creates a new pin number
	 * @param _pin new pin number
	 */
	public void setPin(String _pin) {
		pin = _pin;
	}
	
	/**
	 * Gets pin number
	 * @return pin pin number to access operator menu
	 */
	public String getPin() {
		return pin;
	}
}
