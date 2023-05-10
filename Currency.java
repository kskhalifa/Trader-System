
import java.text.SimpleDateFormat;
import java.util.Date; 

/**This class is for the currency object that represents an individual crypto currency
*/
public class Currency {

	// This String Stores the ID of a Currency.
	private String id;
	// This object will all access to the currency information.
	private double price;
	
	/**
	 * Constructor creates a new currency given its ID
	 * <p>
	 * @param currencyID, string holding ID
	 * @author Khalid Saeed-Khalifa
	 * <p>
	 */
	Currency(String currencyID){
		id = currencyID;
	}

	/**
	 * method the gets the ID of the currency
	 * <p>
	 * @return id, String holding ID
	 * <p>
	 * @author Khalid Saeed-Khalifa
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * Method get the current price of the currency.
	 * <p>
	 * @return Price The price of the given currency at the current time
	 * <p>
	 * @author Khalid Saeed-Khalifa
	 */
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Method gets the date at which the method was called
	 * <p>
	 * @return date The "date and time"
	 * <p>
	 * @author Khalid Saeed-Khalifa
	 */
	private String getDate() {
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		return date;
	}
	
	
	

}