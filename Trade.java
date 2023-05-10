/**
 * This class creates a trade entity that performs all trades given brokerData and stores them in a TradeResult.
 */

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Trade {
	
	// object to hold the results of all the trades performed
	private TradeResult results;
	private boolean tradePerformed;
	
	/**
	 * Constructor that initializes the result variable to a given TradeResults object, and tradePerformed boolean object to false.
	 * @author Khalid Saeed-Khalifa
	 */
	Trade() {
		results = new TradeResult();
		tradePerformed = false;
	}
	
	
	/**
	 * Method performs all trades given broker data
	 * @param brokerData
	 * @return results, the result of all trades 
	 * @author Khalid Saeed-Khalifa
	 */
	public String[][] PerformTrade(BrokerManipulator brokerData) {
		System.out.println("performStarts");
		Broker[] allBrokers = brokerData.getBroker();
		int noCoins = 0;
		System.out.println(allBrokers.length + " " + allBrokers[0].getName());
		for (int i = 0; i < allBrokers.length; i++) {
			for (int j = 0; j < allBrokers[i].getCurrency().length; j++) {
				noCoins++;
			}
		}
		double[] price = new double[noCoins];
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		int counter = 0;
		for (int i = 0; i < allBrokers.length; i++) {
			for (int j = 0; j < allBrokers[i].getCurrency().length; j++) {
				price[counter] = DataFetcher.getPriceForCoin(allBrokers[i].getCurrency()[j].getID(),date);
				allBrokers[i].getCurrency()[j].setPrice(price[counter]);
				counter++;
			}
		}
		
		String[][] curResults = new String[allBrokers.length][8];
		
		for (int i=0; i<allBrokers.length; i++) {
			
			String successTrade = computeTrade(allBrokers[i].getStrategy(),allBrokers[i].getCurrency());
			
			if (successTrade.equals("Success")) {
				curResults[i][0] = allBrokers[i].getName();
				curResults[i][1] = allBrokers[i].getStrategy().getName();
				curResults[i][2] = allBrokers[i].getStrategy().getCoinName();
				curResults[i][3] = allBrokers[i].getStrategy().getAction();
				curResults[i][4] = String.valueOf(allBrokers[i].getStrategy().getQuantity());
				for (int j = 0; j < allBrokers[i].getCurrency().length; j++) {
					if (allBrokers[i].getCurrency()[j].getID().equals(allBrokers[i].getStrategy().getCoin())) {
						curResults[i][5] = String.valueOf(allBrokers[i].getCurrency()[j].getPrice());
					}
				}
				curResults[i][6] = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				curResults[i][7] = successTrade;
			} else {
				curResults[i][0] = allBrokers[i].getName();
				curResults[i][1] = allBrokers[i].getStrategy().getName();
				curResults[i][2] = "Null";
				curResults[i][3] = "Null";
				curResults[i][4] = "Null";
				curResults[i][5] = "Null";
				curResults[i][6] = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				curResults[i][7] = successTrade;
			}
			System.out.println("ResutlDone");
		}
		
		return curResults;
	}
	
	/**
	 * Method to get the trade results after a performing a trade.
	 * @return results, variable holding the trade results from the last performTrade.
	 * @author Khalid Saeed-Khalifa
	 */
	public TradeResult GetTradeResults() {
		if (tradePerformed == true)
			return results;
		else return null;
	}


	public String computeTrade (Strategy strat, Currency[] currenc) {
		
		for(int i = 0; i < currenc.length; i++) {
			System.out.println(String.valueOf("A: " + currenc[i].getPrice()));
		}
		
		Currency[] curr = currenc;
		String[] mockCurr = new String[strat.getCurrency().length];
		for (int i = 0; i < strat.getCurrency().length; i++) {
			mockCurr[i] = strat.getCurrency()[i].getID();
		}

		String[] mockCurrenc = new String[currenc.length];
		for (int i = 0; i < currenc.length; i++) {
			mockCurrenc[i] = currenc[i].getID();
		}

		Arrays.sort(mockCurr);
		Arrays.sort(mockCurrenc);
		
		double[] sPrice = strat.getPrice();
		String[] operation = strat.getOperation();
		String success = "Fail";
		
		if (!Arrays.equals(mockCurr, mockCurrenc)) {
			return success;
		}
		
		for (int i = 0; i < operation.length; i++) {
			success = "Fail";
			if (operation[i].equals("less than")) {
				if (curr[i].getPrice() < sPrice[i]) {
					success = "Success";
				} else {
					System.out.println(curr[i].getPrice() + " " + sPrice[i]);
					System.out.println(curr[i].getPrice() < sPrice[i]);
					success = "Fail";
				}
			} else {
				if (curr[i].getPrice() > sPrice[i]) {
					success = "Success";
				} else {
					System.out.println(curr[i].getPrice() + " " + sPrice[i]);
					System.out.println(curr[i].getPrice() > sPrice[i]);
					success = "Fail";
				}
			}
		}
		
		return success;
		
	}
}