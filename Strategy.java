
public abstract class Strategy {
	public String strat;
	public String name;
	public String action;
	public String coin;
	public String coinName;
	public int quantity;
	public Currency[] curr;
	public double[] sPrice;
	public String[] operation;
	
	public Strategy() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getAction() {
		return action;
	}
	
	public String getCoin() {
		return coin;
	}
	
	public String getCoinName() {
		return coinName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public Currency[] getCurrency() {
		return curr;
	}
	
	public double[] getPrice() {
		return sPrice;
	}
	
	public String[] getOperation() {
		return operation;
	}
	
	public Object[] getStrategy() {
		return new Object[] {name,action,coin,quantity,curr,sPrice,operation};
	}
}
