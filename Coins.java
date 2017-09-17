
/**
 * This class is for incrementing and decrementing current 
 * user money to be used to purchase an item
 * @author Ian Turnbull
 * @version 2-19-2017
 * ITEC 324 Assignment #1
 */
public class Coins {
	
	private double total;

	/**
	 * Constructor for Coins class
	 */
	public Coins() {
		total = 0.00;
	}
	
	/**
	 * Adds one penny to total to be displayed
	 */
	public void addPenny() {
		total += 0.01;	
	}

	/**
	 * Adds one nickel to total to be displayed
	 */
	public void addNickel() {
		total += 0.05;
	}

	/**
	 * Adds one dime to total to be displayed
	 */
	public void addDime() {
		total += 0.10;	
	}

	/**
	 * Adds one quarter to total to be displayed
	 */
	public void addQuarter() {
		total += 0.25;
	}
	
	/**
	 * Get total to be displayed
	 * @return total amount to be displayed
	 */
	public double getTotal() {
		return total;
	}
	
	/**
	 * Changes total amount to be displayed after a 
	 * purchase has been made
	 * @param purchase the amount of the item purchased
	 */
	public void setTotal(double purchase) {
		total = total - purchase;
	}

	/**
	 * 
	 */
	public void coinReturn() {
		total = 0;
	}

}
