package master;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StrengthCalculator {
		// TODO Auto-generated method stub
		// Deck deck = new Deck();
//		List<Cards> ownCards = new ArrayList<>();
//		List<Cards> visibleCards = new ArrayList<>();
		// ownCards.add(new Cards(2, Cards.Suits.Spade));
		// ownCards.add(new Cards(2, Cards.Suits.Club));
		// table = GetAllCardsStengthTable(visibleCards, ownCards, 1000);
		// System.out.println(Arrays.deepToString(table));
		//PrintStrengthTable(GetAllCardsStengthTable(visibleCards, ownCards, 100));

	public static Map<Cards, Map<Cards, Double>> GetAllCardsStengthTable(List<Cards> visibleCards, List<Cards> ownCards,
			int numberOfGames) {
		Map<Cards, Map<Cards, Double>> strengthTable = new LinkedHashMap<Cards, Map<Cards, Double>>();

		Deck deck = new Deck();
		deck.RemoveAllCards(visibleCards);
		deck.RemoveAllCards(ownCards);

		for (int s1 = 0; s1 < Cards.Suits.values().length; s1++) {
			for (int i = 2; i <= 14; i++) {
				Map<Cards, Double> card2Map = new LinkedHashMap<Cards, Double>();
				Cards card1 = new Cards(i, Cards.Suits.values()[s1]);
				for (int s2 = 0; s2 < Cards.Suits.values().length; s2++) {
					for (int j = 2; j <= 14; j++) {
						int netWin = 0;
						Double winRate = (double) 0;
						List<Cards> cardsInHand = new ArrayList<>();
						
						Cards card2 = new Cards(j, Cards.Suits.values()[s2]);
						if (!(j < i || s2 < s1 || visibleCards.contains(card1) || visibleCards.contains(card2) || ownCards.contains(card1)
								|| ownCards.contains(card2) || card1.equals(card2))) {
							cardsInHand.add(card1);
							cardsInHand.add(card2);
							for (int k = 0; k < numberOfGames; k++) {

								netWin += WinVsRandomeHand(visibleCards, cardsInHand);
							}
							winRate = (double) netWin / numberOfGames;
						}
						card2Map.put(card2, winRate);
					}
					strengthTable.put(card1, card2Map);
				}
			}
		}

		return strengthTable;
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
				double winRate = (double) netWin / numberOfGames;
				strengthTable[i - 2][j - 2] = winRate;
			}
		}

		return strengthTable;
	}

	public static double[][] GetSuitedStengthTable(List<Cards> visibleCards, int numberOfGames) {
		double[][] strengthTable = new double[13][13];

		for (int i = 2; i <= 14; i++) {
			for (int j = i; j <= 14; j++) {
				Cards c1 = new Cards(i, Cards.Suits.Spade);
				Cards c2 = new Cards(j, Cards.Suits.Spade);
				List<Cards> cardsInHand = new ArrayList<>();
				cardsInHand.add(c1);
				cardsInHand.add(c2);
				int netWin = 0;
				for (int k = 0; k < numberOfGames; k++) {
					netWin += WinVsRandomeHand(visibleCards, cardsInHand);
				}
				double winRate = (double) netWin / numberOfGames;
				strengthTable[i - 2][j - 2] = winRate;
			}
		}

		return strengthTable;
	}

	public static int WinVsRandomeHand(List<Cards> visibleCards, List<Cards> cardsInHand) {
		int size = visibleCards.size();
		Deck deck = new Deck();
		deck.RemoveCard(cardsInHand.get(0));
		deck.RemoveCard(cardsInHand.get(1));

		List<Cards> table = new ArrayList<>();
		table.addAll(visibleCards);

		for (int i = 0; i < 5 - size; i++) {
			table.add(deck.DealACard());
		}

		if (table.size() != 5) {
			throw new IllegalArgumentException("not 5 cards on table");
		}

		if (cardsInHand.size() != 2) {
			throw new IllegalArgumentException("not 2 cards in hand");
		}

		List<Cards> opponent = new ArrayList<>();
		opponent.add(deck.DealACard());
		opponent.add(deck.DealACard());

		GameJudge judge = new GameJudge();
		int result = judge.Judge(table, cardsInHand, opponent);
		if (result > 0) {
			return 1;
		} else if (result < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	private static void PrintStrengthTable(Map<Cards, Map<Cards, Double>> map) {
		for (Entry<Cards, Map<Cards, Double>> entry : map.entrySet()) {
			for (Entry<Cards, Double> entry2 : entry.getValue().entrySet()) {
//				System.out.print(entry.getKey().Number + "|" + entry.getKey().suit + " " + entry2.getKey().Number + "|"
//						+ entry2.getKey().suit + " : " + entry2.getValue() + ", ");
				System.out.print(entry2.getValue() + ", ");
			}
			System.out.print("\n");
		}
	}
}
