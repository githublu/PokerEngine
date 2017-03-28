package master;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrengthCalculator {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Deck deck = new Deck();
		double[][] table = new double[13][13];
		List<Cards> visibleCards = new ArrayList<>();
		table = GetUnSuitedStengthTable(visibleCards, 3000);
		System.out.println(Arrays.deepToString(table));
	}

	public static double[][] GetUnSuitedStengthTable(List<Cards> visibleCards, int numberOfGames) {
		double[][] strengthTable = new double[13][13];

		for (int i = 2; i <= 14; i++) {
			for (int j = i; j <= 14; j++) {
				Cards c1 = new Cards(i, Cards.Suits.Spade);
				Cards c2 = new Cards(j, Cards.Suits.Club);
				List<Cards> cardsInHand = new ArrayList<>();
				cardsInHand.add(c1);
				cardsInHand.add(c2);
				int netWin = 0;
				for (int k = 0; k < numberOfGames; k++) {
					netWin += WinVsRandomeHand(visibleCards, cardsInHand);
				}
				double winRate = (double)netWin / numberOfGames;
				strengthTable[i - 2][j - 2] = winRate;
			}
		}

		return strengthTable;
	}

	private static int WinVsRandomeHand(List<Cards> visibleCards, List<Cards> cardsInHand) {
		int size = visibleCards.size();
		Deck deck = new Deck();
		deck.RemoveCard(cardsInHand.get(0));
		deck.RemoveCard(cardsInHand.get(1));
		
		for (int i = 0; i < 5 - size; i++) {
			visibleCards.add(deck.DealACard());
		}

		if (visibleCards.size() != 5) {
			throw new IllegalArgumentException("not 5 cards on table");
		}
		
		if (cardsInHand.size() != 2) {
			throw new IllegalArgumentException("not 2 cards in hand");
		}

		List<Cards> opponent = new ArrayList<>();
		opponent.add(deck.DealACard());
		opponent.add(deck.DealACard());

		GameJudge judge = new GameJudge();
		int result = judge.Judge(visibleCards, cardsInHand, opponent);
		if (result > 0) {
			return 1;
		} else if (result < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
