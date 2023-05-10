/** This class is to be used as one of the strategies by a given broker
*/
public class StratB extends Strategy{
	/** Constructor Method for the given strat
	* <p>
	* @param strat given strat description
	* @param name name of strat used
	* @param action action to be executed
	* @param coin given coin
	* @param quantity amount to be acted on
	* @param curr ticker stored in curr array
	* @param sPrice given set price w.r.t. strat given
	* @param option operator to be used in logic requirements
	*/
	public StratB() {
		strat = "If the price of BTC is more than 10000$ then sell 50 BTC coins";
		name = "Strategy-B";
		action = "sell";
		coin = "bitcoin";
		coinName = "BTC";
		quantity = 50;
		curr = new Currency[1];
		curr[0] = new Currency("bitcoin");
		sPrice = new double[1];
		sPrice[0] = 10000;
		operation = new String[1];
		operation[0] = "more than";
	}
	/** Getter Method to get name
	* <p>
	* @return name 
	*<p>
	*/
	public String getName() {
		return name;
	}
	/** Getter Method to get action
	* <p>
	* @return action 
	*<p>
	*/
	public String getAction() {
		return action;
	}
	/** Getter Method to get coin
	* <p>
	* @return coin 
	*<p>
	*/
	public String getCoin() {
		return coin;
	}
	
	public String getCoinName() {
		return coinName;
	}
	/** Getter Method to get quantity
	* <p>
	* @return quantity 
	*<p>
	*/
	public int getQuantity() {
		return quantity;
	}
	/** Getter Method to get curr
	* <p>
	* @return curr 
	*<p>
	*/
	public Currency[] getCurrency() {
		return curr;
	}
	/** Getter Method to get sPrice
	* <p>
	* @return sPrice 
	*<p>
	*/
	public double[] getPrice() {
		return sPrice;
	}
	/** Getter Method to get operation
	* <p>
	* @return operation 
	*<p>
	*/
	public String[] getOperation() {
		return operation;
	}
	/** Getter Method to get Object array
	* <p>
	* @return Object[] 
	*<p>
	*/
	public Object[] getStrategy() {
		return new Object[] {name,action,coin,quantity,curr,sPrice,operation};
	}
}
