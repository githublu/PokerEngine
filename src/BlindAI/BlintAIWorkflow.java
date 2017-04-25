package BlindAI;

import java.util.List;

import master.Cards;
import master.StrengthCalculator;
import master.TableInfo;
import master.TableInfo.CurrentState;

public class BlintAIWorkflow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean gameOver = false;
		TableInfo tableInfo = null;
		while (!gameOver) {
			if (tableInfo == null)
			{
				throw new NullPointerException("tableInfo is null");
			}
			
			switch (tableInfo.CurrentState) {
			case Preflop:
				PreflopMove(tableInfo);
				break;
			}
		}
	}

	private static int PreflopMove(TableInfo tableInfo) {
//		Move move = new Move();
//		int numberOfGames = 100;
//		int netWin = 0;
//		for (int k = 0; k < numberOfGames; k++) {
//			netWin += StrengthCalculator.WinVsRandomeHand(tableInfo.CardsInTable, tableInfo.CardsInHand);
//		}
//		double winRate = (double) netWin / numberOfGames;
//		if (winRate > 0.5)
//		{
//			move.Action = Action.Call;
//		}
//		return move;
		return 0;
	}

	private static int FlopMove(TableInfo tableInfo) {
		return 0;
	}

	private static int TurnMove(TableInfo tableInfo) {
		return 0;
	}

	private static int RiverMove(TableInfo tableInfo) {
		return 0;
	}
}
