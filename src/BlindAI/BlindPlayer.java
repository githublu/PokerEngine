package BlindAI;

import master.BasePlayer;
import master.Cards;
import master.StrengthCalculator;
import master.TableInfo;

public class BlindPlayer extends BasePlayer{

	@Override
	public int PreflopMove(TableInfo tableInfo, int myPostition, int[] previousMoves, int BB) {
		System.out.println("cards in hand:" + cardsInHand.get(0) + ", " + cardsInHand.get(1));
		
		// determine winner
		for (Cards card : tableInfo.CardsInTable)
		{
			System.out.println(card.toString());
		}
		
		// Find my strength
		int numberOfGames = 1000;
		int netWin = 0;
		for (int k = 0; k < numberOfGames; k++) {
			netWin += StrengthCalculator.WinVsRandomeHand(tableInfo.CardsInTable, cardsInHand);
		}
		double winRate = (double) netWin / numberOfGames;
		System.out.println("player " + myPostition + " winRate: " + winRate);
		
		// Determine MinRaise
		// if raise, minrasie = 2 * previous raise
		
		//if not raise, min raise = 0;
		
		// Call = previous amount
		
		// Compute Bet
		BetLevel bl = new BetLevel(1.0);
		int bet = bl.Bet(winRate, Chips, 0, 2, previousMoves[myPostition], 2);
		
		System.out.println("player " + myPostition + ": " + bet);
		return bet;
	}

	@Override
	public int FlopMove(TableInfo tableInfo, int myPostition, int[] previousMoves, int BB) {
		System.out.println("cards in hand:" + cardsInHand.get(0) + ", " + cardsInHand.get(1));
		// determine winner
		for (Cards card : tableInfo.CardsInTable)
		{
			System.out.println(card.toString());
		}
		
		// Find my strength
		int numberOfGames = 1000;
		int netWin = 0;
		for (int k = 0; k < numberOfGames; k++) {
			netWin += StrengthCalculator.WinVsRandomeHand(tableInfo.CardsInTable, cardsInHand);
		}
		double winRate = (double) netWin / numberOfGames;
		System.out.println("player " + myPostition + " winRate: " + winRate);
		// Compute Bet
		BetLevel bl = new BetLevel(3.0);
		int bet = bl.Bet(winRate, Chips, 0, 2, previousMoves[myPostition], 2);
		
		System.out.println("player " + myPostition + ": " + bet);
		return bet;
	}

	@Override
	public int TurnMove(TableInfo tableInfo, int myPostition, int[] previousMoves, int BB) {
		System.out.println("cards in hand:" + cardsInHand.get(0) + ", " + cardsInHand.get(1));
		// determine winner
		for (Cards card : tableInfo.CardsInTable)
		{
			System.out.println(card.toString());
		}
		
		// Find my strength
		int numberOfGames = 1000;
		int netWin = 0;
		for (int k = 0; k < numberOfGames; k++) {
			netWin += StrengthCalculator.WinVsRandomeHand(tableInfo.CardsInTable, cardsInHand);
		}
		double winRate = (double) netWin / numberOfGames;
		System.out.println("player " + myPostition + " winRate: " + winRate);
		// Compute Bet
		BetLevel bl = new BetLevel(2.0);
		int bet = bl.Bet(winRate, Chips, 0, 2, previousMoves[myPostition], 2);
		
		System.out.println("player " + myPostition + ": " + bet);
		return bet;
	}

	@Override
	public int RiverMove(TableInfo tableInfo, int myPostition, int[] previousMoves, int BB) {
		System.out.println("cards in hand:" + cardsInHand.get(0) + ", " + cardsInHand.get(1));
		// determine winner
		for (Cards card : tableInfo.CardsInTable)
		{
			System.out.println(card.toString());
		}
		
		// Find my strength
		int numberOfGames = 1000;
		int netWin = 0;
		for (int k = 0; k < numberOfGames; k++) {
			netWin += StrengthCalculator.WinVsRandomeHand(tableInfo.CardsInTable, cardsInHand);
		}
		double winRate = (double) netWin / numberOfGames;
		System.out.println("player " + myPostition + " winRate: " + winRate);
		// Compute Bet
		BetLevel bl = new BetLevel(1.0);
		int bet = bl.Bet(winRate, Chips, 0, 2, previousMoves[myPostition], 2);
		
		System.out.println("player " + myPostition + ": " + bet);
		return bet;
	}

}
