/** This class is utilized for accessing the info in regards to a specific trades result, and storing such results
*/
public class TradeResult {
	
	private String[][] tradeResult;
	private int nextIndex;
	
	/** Constructor which initializes the trade result objects string matrix for storing results
	* <p>
	* @author Khalid Saeed-kahlifa 
	*/
	
	TradeResult() {
		tradeResult = new String[50][7];
		nextIndex = 0;
	}
	
	// Add the results of a single result
	public void addTrade(String[] newSingleTrade) {
		tradeResult[nextIndex] = newSingleTrade;
		nextIndex++;
	}

	/** Getter Method that returns the given trade result objects string matrix
	* <p>
	* @return tradeResult The given objects string matrix of stored results
	* <p>
	* @author Khalid Saeed-kahlifa
	*/
	public String[][] getTradeinfo() {
		return tradeResult;
	}
}