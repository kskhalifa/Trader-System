
public class StrategyB extends strategyCreator{

	@Override
	public Strategy strategyFactor() {
		return new StratB();
	}
	
}
