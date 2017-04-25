package master;

import java.util.List;

public class TableInfo {
	public static enum CurrentState
	{
		Initialize, Preflop, Flop, Turn, River, GameFinish
	}
	
	public List<Cards> CardsInTable;
	public CurrentState CurrentState;
	
	public TableInfo(List<Cards> cardsInTable, CurrentState currentState)
	{
		if (cardsInTable.size() > 7 || cardsInTable.size() < 0)
		{
			throw new IllegalArgumentException("invalid number of cards in table:  " + cardsInTable.size());
		}
		
		
		this.CardsInTable = cardsInTable;
		this.CurrentState = currentState;
	}
	
}
