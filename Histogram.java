/*
 * the method updateDataset() must be used before getting the data set if changes to data have been made
 */
import org.jfree.data.category.DefaultCategoryDataset;


public class Histogram {
	
	// Category Dataset for histogram data.
	private DefaultCategoryDataset dataset;
	// Map organizing data in the string array.
	// map with have the brokers be the index in the outer array and strategy be the index of the inner array
	private int[][] brokerStrategyMap;
	// Array holding a list of all unique broker names in the data.
	private String[] brokerList;
	// Array holding a list of all strategy names in the data.
	private String[] stratList;
	// instance variable holding the instance of the class
	private static Histogram instance = null;
	
	/**
	 * Constructor Intializing all class variables
	 * @author Khalid Saeed-Khalifa
	 */
	private Histogram() {
		dataset = new DefaultCategoryDataset();
		brokerList = new String[1];
		stratList = new String[4];
		stratList[0] = "Strategy-A";
		stratList[1] = "Strategy-B";
		stratList[2] = "Strategy-C";
		stratList[3] = "Strategy-D";
	}
	
	/**
	 * Method that gets the dataset.
	 * @return dataset, the dataset held in the class.
	 * @author Khalid Saeed-Khalifa
	 */
	public DefaultCategoryDataset getDataset() {
		return dataset;
	}
	
	/**
	 * Method to get the instance of the class.
	 * @return instance, instance of the class.
	 * @author Khalid Saeed-Khalifa
	 */
	public static Histogram getInstance() {
		if (instance == null) 
			instance = new Histogram();
		return instance;
	}
	
	/** 
	 * Method that updates dataset, given the data.
	 * this Method is needed before accessing the dataset;
	 * @param results
	 * @author Khalid Saeed-Khalifa
	 */
	public void updateDataset(String[][] results) {
		String[][] brokerinfo = results;
		uniqueBrokers(results);
		brokerStrategyMap = new int[brokerList.length][stratList.length];
		
		// Initialize all values in the map to 0
		for (int i=0; i<brokerList.length; i++) {
			for (int j=0; j<stratList.length; j++) {
				brokerStrategyMap[i][j] = 0;
			}
		}
		
		// fill in the map
		String name;
		String strat;
		int broker;
		int stratPos;
		
		for (int i=0; i<brokerinfo.length; i++) {
			// broker name
			name = brokerinfo[i][0];
			// strategy name
			strat = brokerinfo[i][1];
			
			// position of the broker name
			broker = linearSearch(name, brokerList);
			// position of the strategy  name
			stratPos = linearSearch(strat, stratList);
			// add one to that position on the map
			brokerStrategyMap[broker][stratPos]++;
		}
		
		// fill in dataset
		// loop through the unique brokers list
		for (int b=0; b<brokerList.length; b++) {
			// loop though the strategy list
			for (int s=0; s<stratList.length; s++) {
				// following the format in the example: dataset.setValue(# of times used, which broker, which strategy);
				dataset.setValue(brokerStrategyMap[b][s], brokerList[b], stratList[s]);
			}
		}
	}
	
	/**
	 * Method finds all broker names and adds them to brokerList.
	 * @param results, the data holding trade information.
	 * @author Khalid Saeed-Khalifa
	 */
	private void uniqueBrokers(String[][] results) {
		String[][] brokerinfo = results;
		String[] brokerlist = new String[1];
		int position = 0;
		
		// counting and adding unique brokers.
		for (int i=0; i<brokerinfo.length; i++) {
			if(linearSearch(brokerinfo[i][0], brokerlist) == -1) {
				// Increasing the length of the array by 1 before adding to the array
				if (position > brokerlist.length-1)
					brokerlist = increaseArray(brokerlist);
				brokerlist[position] = brokerinfo[i][0];
				position++;
				}
		}
		// setting the broker list.
		brokerList = brokerlist;
	}
	
	/**
	 * Method to increase the size of an array by 1 given an array;
	 * @param array, string array the is being increased.
	 * @return clone, new increased list.
	 * @author Eyoel Hailemariam.
	 */
	private String[] increaseArray(String[] array) {
		String[] clone = new String[array.length+1];
		for (int i=0; i<array.length; i++)
			clone[i] = array[i];
		return clone;
	}
	
	/**
	 * Method that performs linear search on String array, given a name.
	 * @param name, name searching for.
	 * @param nameList, list of name.
	 * @return the index at which the name is located, if not located in the array 
	 * @author Khalid Saeed-Khalifa
	 */
	private int linearSearch(String name, String[] nameList) {
		if (nameList[0] != null)
			for (int i=0; i<nameList.length; i++) 
				if (nameList[i].equals(name))
					return i;
		return -1;
	}
	
}
