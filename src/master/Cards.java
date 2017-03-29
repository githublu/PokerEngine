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
	
	@Override public boolean equals(Object obj) {
		if(obj instanceof Cards)
		{
			Cards card = (Cards) obj;
			return card.Number == this.Number && card.suit == this.suit;
		}
		else
		{
			return false;
		}
	}
}
