package master;

import java.util.List;

public class TableInfo {
	public List<Cards> CardsInTable;
	public int MyPosition;
	public List<Move> PreviousMoves;
	
	public TableInfo(List<Cards> cardsInTable, int myPostition, List<Move> previousMove)
	{
		if (cardsInTable.size() > 7 || cardsInTable.size() < 0)
		{
			throw new IllegalArgumentException("invalid number of cards in table:  " + cardsInTable.size());
		}
		
		if (myPostition < 0)
		{
			throw new IllegalArgumentException("myPostiion cannot be less than 0: " + myPostition);
		}
		
		int previousMoveSize = previousMove.size();
		if (previousMoveSize > myPostition || previousMoveSize < 0)
		{
			throw new IllegalArgumentException("invalid previousMove:  " + previousMoveSize + "myPostion: " + myPostition);
		}
		
		this.CardsInTable = cardsInTable;
		this.MyPosition = myPostition;
		this.PreviousMoves = previousMove;
	}
	
}
