/** This class creates individual Broker Objects for representing the individual Trading Brokers,
with respect to their own name, currency list, and trading strategy.
**/

public class Broker {

	private String brokerName;
	private Strategy strategy;
	private Currency[] coinList;
	
	/** Constructor Creates a new object of Type Broker
	<p>
	@param brokerName The name of the Respective Broker
	@param strategy The Strategy to be used by the Broker
	@param coinList The list of currencies to be used by the Broker
	<p>
	@author Christopher Co-Dyre	
	**/
	public Broker (String brokerName, Currency[] currencyList, Strategy tradeStrategy)
	{
		this.brokerName = brokerName;
		this.strategy = tradeStrategy;
		this.coinList = currencyList;		
	}
	
	/** Getter Method to get the Broker's Name
	<p>
	@return brokerName The name of the broker
	<p>
	@author 
	**/
	public String getName() 
	{
		return this.brokerName;
	}
	
	/** Getter Method to get the Broker's currencyList
	<p>
	@return coinList The list of currencies
	<p>
	@author 
	**/
	public Currency[] getCurrency() 
	{
		return this.coinList;
	}
	
	/** Getter Method to get the Broker's Trading Strategy
	<p>
	@return strategy The Broker's trading strategy
	<p>
	@author 
	**/
	public Strategy getStrategy() 
	{
		return this.strategy;
	}
	
	/** Setter Method to set the Broker's Name
	<p>
	@param name The name of the Broker to be assigned
	<p>
	@author 
	**/
	public void setName(String name) 
	{
		this.brokerName = name;
	}
	
	/** Setter Method to set the Broker's currency List
	<p>
	@param currencyList The Currency array object to be set as the Broker's coinList
	<p>
	@author 
	**/
	public void setCurrency(Currency[] currencyList) 
	{
		this.coinList = currencyList;
	}
	
	/** Setter Method to set the Broker's Trading Strategy
	<p>
	@param tradeStrategy The strategy assigned to this Broker
	<p>
	@author 
	**/
	public void setStrategy(Strategy tradeStrategy) 
	{
		this.strategy = tradeStrategy;
	}
}