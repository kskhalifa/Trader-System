/** This class represents one of the given strategies to be used by the systems brokers
*/
public class StratA extends Strategy{
	
	/** Constructor Method to initialize the nescessary info for the given strat
	* <p>
	* @param strat Description of the strat
	* @param name name of the strat
	* @param action action to be executed
	* @param coin coin of choice
	* @param quantity amount to act
	* @param curr ticker stored in the array
	* @param sPrice given set price
	* @param operation operator used for logic purposes
	*/
	public StratA() {
		strat = "If the price of BNB is less than 500$ then buy 100 BNB coins";
		name = "Strategy-A";
		action = "buy";
		coin = "bnb";
		coinName = "BNB";
		quantity = 100;
		curr = new Currency[1];
		curr[0] = new Currency("bnb");
		sPrice = new double[1];
		sPrice[0] = 500;
		operation = new String[1];
		operation[0] = "less than";
	}
	/** Getter Method for accessing the name
	* <p>
	* @return name 
	*/
	public String getName() {
		return name;
	}
	/** Getter Method for accessing the action
	* <p>
	* @return action 
	*/
	public String getAction() {
		return action;
	}
	/** Getter Method for accessing the coin
	* <p>
	* @return coin 
	*/
	public String getCoin() {
		return coin;
	}
	
	public String getCoinName() {
		return coinName;
	}
	/** Getter Method for accessing the quantity
	* <p>
	* @return quantity 
	*/
	public int getQuantity() {
		return quantity;
	}
	/** Getter Method for accessing the curr
	* <p>
	* @return curr 
	*/
	public Currency[] getCurrency() {
		return curr;
	}
	/** Getter Method for accessing the sPrice
	* <p>
	* @return sPrice 
	*/
	public double[] getPrice() {
		return sPrice;
	}
	/** Getter Method for accessing the operation
	* <p>
	* @return operation 
	*/
	public String[] getOperation() {
		return operation;
	}
	/** Getter Method for accessing the Object array
	* <p>
	* @return Object[] The given Object's array 
	*/
	public Object[] getStrategy() {
		return new Object[] {name,action,coin,quantity,curr,sPrice,operation};
	}
}
