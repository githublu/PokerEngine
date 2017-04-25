package master;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePlayer {
	public int Chips = 100;
	public List<Cards> cardsInHand = new ArrayList<>();
	public abstract int PreflopMove(TableInfo tableInfo, int myPostition, int[] previousMoves);
	public abstract int FlopMove(TableInfo tableInfo, int myPostition, int[] previousMoves);
	public abstract int TurnMove(TableInfo tableInfo, int myPostition, int[] previousMoves);
	public abstract int RiverMove(TableInfo tableInfo, int myPostition, int[] previousMoves);
}
