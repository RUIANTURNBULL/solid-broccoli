
/**
 * This class is the product description with
 * product name, product cost, and inventory of product
 * @author Ian Turnbull
 * @version 2-19-2017
 * ITEC 324 Assignment #1
 */
public class Products {
	
	private String name;
	private double price;
	private int inventory;
	
	/**
	 * Constructor for Products class
	 * @param _name name of the product
	 * @param _price price of the product
	 */
	public Products(String _name, double _price) {
		this.name = _name;
		this.price = _price;
		this.inventory = 3;
	}
	
	/**
	 * For changing item name
	 * @param _name name of new product
	 */
	public void setName(String _name) {
		this.name = _name;
	}
	
	/**
	 * Get product name
	 * @return product name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * For changing item price
	 * @param _price new item price
	 */
	public void setPrice(double _price) {
		this.price = _price;
	}
	
	/**
	 * Get item price
	 * @return item price
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * Removes one item from the inventory from the item
	 */
	public void soldInventory() {
		inventory--;
	}
	
	/**
	 * Re-stocks all inventory to max inventory
	 */
	public void restock() {
		inventory = 3;
	}
	
	/**
	 * Get Inventory amount
	 * @return inventory amount
	 */
	public int getInventory() {
		return this.inventory;
	}
}

