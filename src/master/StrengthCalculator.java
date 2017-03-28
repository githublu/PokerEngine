package master;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrengthCalculator {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck deck = new Deck();
		
		System.out.println(deck.deck.get(0).Number + " : " + deck.deck.get(0).suit);
		deck.DealACard();
		System.out.println(deck.deck.get(0).Number + " : " + deck.deck.get(0).suit);
	}

	public Map<Integer, Integer> GetStengthTable(List<Cards> visibleCards, List<Cards> cardsInHand, int numberOfGames) {
		Map<Integer, Integer> initialStrengthTable = new HashMap<Integer, Integer>();
		
		return initialStrengthTable;
	}
}
