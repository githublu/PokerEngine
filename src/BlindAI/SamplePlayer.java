package BlindAI;

import java.util.List;

import master.Cards;
import master.BasePlayer;
import master.TableInfo;

public class SamplePlayer extends BasePlayer{
	public int PreflopMove(TableInfo tableInfo, int myPostition, int[] previousMoves) {
		System.out.println("preflop move by sample player");
		return 0;
	}
	public int FlopMove(TableInfo tableInfo, int myPostition, int[] previousMoves) {
		System.out.println("Flop move by sample player");
		return 0;
	}
	public int TurnMove(TableInfo tableInfo, int myPostition, int[] previousMoves) {
		System.out.println("turn move by sample player");
		return 0;
	}
	public int RiverMove(TableInfo tableInfo, int myPostition, int[] previousMoves) {
		System.out.println("river move by sample player");
		return 0;
	}
	
	public SamplePlayer()
	{
		
	}
}
