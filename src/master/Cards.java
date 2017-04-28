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
		if (number > 14 || number < 2)
		{
			throw new IllegalArgumentException("Invalid number for a card");
		}
		
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
	
	@Override public String toString()
	{
		String result = this.suit.toString() + this.Number.toString(); 
		return result;
	}
}
