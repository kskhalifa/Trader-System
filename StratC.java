/** This class is to be utilized by a given broker on the system
*/
public class StratC extends Strategy{
	/** Constructor for given strat
	* <p>
	* @param strat given strat description
	* @param name name of strat
	* @param action action to be executed
	* @param coin given strats coin
	* @param quantity amount to be acted on
	* @param curr ticker stored in curr array
	* @param operation operator to be used in logic for given strat
	* @param sPrice set price for given strat
	*/
	public StratC () {
		strat = "If the price of MKR is less than 2000$ and the price of ETH is less than 3000$ then buy 300 ETH coins";
		name = "Strategy-C";
		action = "buy";
		coin = "ethereum";
		coinName = "ETH";
		quantity = 300;
		curr = new Currency[2];
		curr[0] = new Currency("maker");
		curr[1] = new Currency("ethereum");
		sPrice = new double[2];
		sPrice[0] = 2000;
		sPrice[1] = 3000;
		operation = new String[2];
		operation[0] = "less than";
		operation[1] = "less than";
	}
	/** Getter Method to access the name
	* <p>
	* @return name
	*/
	public String getName() {
		return name;
	}
	/** Getter Method to access the action
	* <p>
	* @return action
	*/
	public String getAction() {
		return action;
	}
	/** Getter Method to access the coin
	* <p>
	* @return coin
	*/
	public String getCoin() {
		return coin;
	}
	
	public String getCoinName() {
		return coinName;
	}
	/** Getter Method to access the quantity
	* <p>
	* @return quantity
	*/
	public int getQuantity() {
		return quantity;
	}
	/** Getter Method to access the curr
	* <p>
	* @return curr
	*/
	public Currency[] getCurrency() {
		return curr;
	}
	/** Getter Method to access the sPrice
	* <p>
	* @return sPrice
	*/
	public double[] getPrice() {
		return sPrice;
	}
	/** Getter Method to access the operation
	* <p>
	* @return operation
	*/
	public String[] getOperation() {
		return operation;
	}
	/** Getter Method to access the Object array
	* <p>
	* @return Object[]
	*/
	public Object[] getStrategy() {
		return new Object[] {name,action,coin,quantity,curr,sPrice,operation};
	}
}
