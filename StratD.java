/** This class is to be utilized by a given broker on the system
*/
public class StratD extends Strategy{
	/** Constructor Method for the given strat
	* <p>
	* @param strat description of the given strat
	* @param name The name of the strat
	* @param action the given a
	* @param coin the coin
	* @param amount to be acted on
	* @param curr ticker stored in curr array
	* @param sPrice set price for given strat
	* @param operation operator to be used for given strats logic
	*/
	public StratD () {
		strat = "If the price of LTC is less 100$ and the price of ICP is greater than 50$ then buy 500 LTC coins”";
		name = "Strategy-D";
		action = "buy";
		coin = "litecoin";
		coinName = "LTC";
		quantity = 500;
		curr = new Currency[2];
		curr[0] = new Currency("litecoin");
		curr[1] = new Currency("internet-computer");
		sPrice = new double[2];
		sPrice[0] = 100;
		sPrice[1] = 50;
		operation = new String[2];
		operation[0] = "less than";
		operation[1] = "greater than";
	}
	/** Getter Method for the name
	* <p>
	* @return name
	*/
	public String getName() {
		return name;
	}
	/** Getter Method for the action
	* <p>
	* @return action
	*/
	public String getAction() {
		return action;
	}
	/** Getter Method for the coin
	* <p>
	* @return coin
	*/
	public String getCoin() {
		return coin;
	}
	
	public String getCoinName() {
		return coinName;
	}
	/** Getter Method for the quantity
	* <p>
	* @return quantity
	*/
	public int getQuantity() {
		return quantity;
	}
	/** Getter Method for the curr
	* <p>
	* @return curr
	*/
	public Currency[] getCurrency() {
		return curr;
	}
	/** Getter Method for the sPrice
	* <p>
	* @return sPrice
	*/
	public double[] getPrice() {
		return sPrice;
	}
	/** Getter Method for the operation
	* <p>
	* @return operation
	*/
	public String[] getOperation() {
		return operation;
	}
	/** Getter Method for the Object array
	* <p>
	* @return Object[]
	*/
	public Object[] getStrategy() {
		return new Object[] {name,action,coin,quantity,curr,sPrice,operation};
	}
}
