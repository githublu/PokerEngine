import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
	public List<Cards> deck;
	
	public Deck()
	{
		this.deck = new ArrayList<Cards>();
		for (Cards.Suits suit : Cards.Suits.values())
		{
			for (int i = 2; i <= 14; i++)
			{
				this.deck.add(new Cards(i, suit));
			}
		}
	}
	
	public Cards DealACard()
	{
		int rand = ThreadLocalRandom.current().nextInt(0, deck.size());
		Cards card = this.deck.get(rand);
		this.deck.remove(rand);
		return card;
	}
	
	public int RemainingCards()
	{
		return this.deck.size();
	}
}
