package master;

public class Cards {
	public Integer Number;
	public enum Suits
	{
		Spade, Club, Heart, Diamond
	}
	
	public Suits suit;
	
	public Cards(Integer number, Suits suit)
	{
		this.Number = number;
		this.suit = suit;
	}
}
