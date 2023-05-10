
public class StrategyA extends strategyCreator{
	@Override
	public Strategy strategyFactor() {
		return new StratA();
	}
}