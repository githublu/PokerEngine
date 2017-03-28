package master;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
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
		SecureRandom random;
		int rand = 0;
		try {
			random = SecureRandom.getInstance("SHA-512");
			rand = random.nextInt(deck.size());
		}
		catch (NoSuchAlgorithmException e) {
			rand = ThreadLocalRandom.current().nextInt(0, deck.size());
		}
		
		Cards card = this.deck.get(rand);
		this.deck.remove(rand);
		return card;
	}
	
	public void RemoveCard(Cards card)
	{
		try
		{
			this.deck.remove(card);
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public int RemainingCards()
	{
		return this.deck.size();
	}
}
