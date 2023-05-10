/** This class represents the data structure that will store broker information
allowing access to that information when needed.
*/
public class BrokerManipulator {
	
	// Array holding brokers
	private Broker[] brokerData;
	// integer holding next index of the array
	private int nextIndex;
	
	/**
	 *  Constructor initializing the array and its index.
	 * <p>
	 *  @author Khalid Saeed-Khalifa
	 */
	public BrokerManipulator() {
		brokerData = new Broker[1];
		nextIndex = 0;
	}
	
	/**
	 * Method to add a New broker to the array.
	 * <p>
	 * @param newBroker, new broker to add.
	 * <p>
	 * @author Khalid Saeed-Khalifa
	 */
	public void addBroker(Broker newBroker) {
		if (nextIndex >= brokerData.length) {
			increaseSize();
		}
		brokerData[nextIndex] = newBroker;
		nextIndex++;
	}
	
	/**
	 * Method returns first broker stored and removes it from the array.
	 * <p>
	 * @return broker, the first broker in the array.
	 * @author Khalid Saeed-Khalifa
	 * <p>
	 */
	public Broker[] getBroker() {
		//nextIndex -= 1;
		//return brokerData[this.nextIndex];
		
		//starts from first broker
		return brokerData;
	}
	
	/**
	 * Method that removes the a broker from the array adjusting the rest of the array
	 * <p>
	 * @param newBroker
	 * <p>
	 * @author Khalid Saeed-Khalifa
	 */
	private void removeBroker(Broker newBroker) {
		int j = 0;
		for (int i=0; i<nextIndex; i++) {
			if (brokerData[i].getName() == newBroker.getName()) {
				j++;
				nextIndex--;
			}	
			brokerData[i] = brokerData[i+j];
			
		}
	}
	
	/**
	 * Method that returns the currency list associated with a given broker name
	 * <p>
	 * @param brokerName, name of broker
	 * @return Currency list, 
	 * <p>
	 * @author Khalid Saeed-Khalifa
	 */
	public Currency[] getCurrency(String brokerName) {
		int index = findBroker(brokerName);
		return brokerData[index].getCurrency();
	}
	
	/**
	 * method that returns the Strategy associated with a with a given broker name
	 * <p>
	 * @param brokerName
	 * @return
	 * <p>
	 * @author Khalid Saeed-Khalifa
	 */
	public Strategy getStrategy(String brokerName) {
		int index = findBroker(brokerName);
		return brokerData[index].getStrategy();
	}
	
	/**
	 * method that finds a broker given the name
	 * <p>
	 * @param name, name of broker
	 * @return name
	 * <p>
	 * @author Khalid Saeed-Khalifa
	 */
	private int findBroker(String name) {
		for (int i=0; i<nextIndex; i++) {
			if (brokerData[i].getName() == name)
				return i;
		}
		return -1;
	}
	
	/**
	 * method that increases the array size of the broker array
	 * @author Eyoel Hailemariam
	 */
	private void increaseSize() {
		Broker[] clone = new Broker[brokerData.length+1];
		for (int i = 0; i < brokerData.length; i++) {
			clone[i] = brokerData[i];
		}
		brokerData = clone;
	}

}