package master;

public class Move {
	public static enum Action
	{
		Bet, Call, Fold
	}
	
	public int Amount;
	public Action Action;
	
	public Move(Action action, int amount){
		this.Action = action;
		this.Amount = amount;
	}
	
	public Move()
	{
		this.Action = Action.Fold;
		this.Amount = 0;
	}
	
	@Override public String toString()
	{
		return this.Action.toString() + ": " + this.Amount;
	}
}
