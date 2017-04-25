package master;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import BlindAI.SamplePlayer;
import master.TableInfo.CurrentState;

public class GameWorkflow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start a new game");
		
		Deck deck = new Deck();
		
		SamplePlayer p1 = new SamplePlayer();
		p1.cardsInHand.add(deck.DealACard());
		p1.cardsInHand.add(deck.DealACard());
		List<BasePlayer> players = new ArrayList<>();
		players.add(p1);
		GameWorkflow gameWorkflow = new GameWorkflow();
		
		int winner = gameWorkflow.PlayGames(players);
		System.out.println(winner);
	}
	
	public GameWorkflow()
	{
	}
	
	public int PlayGames(List<BasePlayer> players)
	{
		Deck deck = new Deck();
		List<Cards> cardsOntable = new ArrayList<>();
		TableInfo tableInfo = new TableInfo(cardsOntable, CurrentState.Preflop);
		int winnerNumber = -1;
		int sb = 1;
		int bb = 2;
		// player.get(0) is sb
		// player.get(1) is bb
		// player.get(size-1) is dealer
		
		int[]preflopMoves = new int[players.size()-1];
		int preflopMaxPlayer = players.size();
//		int[] flopMoves = new int[players.size()-1];
//		int[] turnMoves = new int[players.size()-1];
//		int[] riverMoves = new int[players.size()-1];
		List<Integer> foldPlayer = new ArrayList<>();
		int size = players.size();
		if (size < 2)
		{
			return 0;
		}
		
		int maxBet = 0;
		
		while (winnerNumber != -1) {
			switch (tableInfo.CurrentState) {
			case Initialize:
				players.get(0).Chips -= sb;
				
				players.get(1).Chips -= bb;
				
				// deal cards to player
				for(int i = 0; i < players.size(); i++)
				{
					players.get(i).cardsInHand.add(deck.DealACard());
					players.get(i).cardsInHand.add(deck.DealACard());
				}
				break;
			case Preflop:
				
				// UTG fist move
				for (int i = 2; i < preflopMaxPlayer; i++)
				{
					// skip players who have already fold
					if(foldPlayer.contains(i))
					{
						//preflopMoves.add(i, 0);
						continue;
					}
					
					// existing player get move
					int move = players.get(i).PreflopMove(tableInfo, i, preflopMoves);
					preflopMoves[i] += move;
					
					// Check player action
					if (preflopMoves[i] == maxBet)
					{
						// call no action
					}
					else if (preflopMoves[i] > maxBet)
					{
						// raise
						maxBet = preflopMoves[i];
						preflopMaxPlayer = i;
					}
					else 
					{
						// fold
						foldPlayer.add(i);
					}
					
					ApplyMoveToPlayer(players.get(i), move);
				}
				
				// SB and BB move
				for (int i = 0; i < 2; i++)
				{
					// skip players who have already fold
					if(foldPlayer.contains(i))
					{
						//preflopMoves.add(i, 0);
						continue;
					}
					
					// existing player get move
					int move = players.get(i).PreflopMove(tableInfo, i, preflopMoves);
					preflopMoves[i] += move;
					
					// Check player action
					if (preflopMoves[i] == maxBet)
					{
						// call no action
					}
					else if (preflopMoves[i] > maxBet)
					{
						// raise
						maxBet = preflopMoves[i];
						preflopMaxPlayer = i;
					}
					else 
					{
						// fold
						foldPlayer.add(i);
					}
					
					ApplyMoveToPlayer(players.get(i), move);
				}
				
				// check if gameover
				if (players.size() - foldPlayer.size() == 1)
				{
					// game over
					return preflopMaxPlayer;
				}
				else if (players.size() - foldPlayer.size() == 0)
				{
					throw new IllegalArgumentException("all player fold in preflop. Impossible ending");
				}
				
				// Move State
				if (!isEven(preflopMoves, preflopMaxPlayer))
				{
					tableInfo.CurrentState = CurrentState.Preflop;
				}
				else
				{
					tableInfo.CurrentState = CurrentState.Flop;
					preflopMaxPlayer = players.size();
					tableInfo.CardsInTable.add(deck.DealACard());
					tableInfo.CardsInTable.add(deck.DealACard());
					tableInfo.CardsInTable.add(deck.DealACard());
				}
				
				break;
			case Flop:
				for (int i = 0; i < preflopMaxPlayer; i++)
				{
					// skip players who have already fold
					if(foldPlayer.contains(i))
					{
						//preflopMoves.add(i, 0);
						continue;
					}
					
					// existing player get move
					int move = players.get(i).PreflopMove(tableInfo, i, preflopMoves);
					preflopMoves[i] += move;
					
					// Check player action
					if (preflopMoves[i] == maxBet)
					{
						// call no action
					}
					else if (preflopMoves[i] > maxBet)
					{
						// raise
						maxBet = preflopMoves[i];
						preflopMaxPlayer = i;
					}
					else 
					{
						// fold
						foldPlayer.add(i);
					}
					
					ApplyMoveToPlayer(players.get(i), move);
				}
				
				// check if gameover
				if (players.size() - foldPlayer.size() == 1)
				{
					// game over
					return preflopMaxPlayer;
				}
				else if (players.size() - foldPlayer.size() == 0)
				{
					throw new IllegalArgumentException("all player fold in preflop. Impossible ending");
				}
				
				// Move State
				if (!isEven(preflopMoves, preflopMaxPlayer))
				{
					tableInfo.CurrentState = CurrentState.Flop;
				}
				else
				{
					tableInfo.CurrentState = CurrentState.Turn;
					preflopMaxPlayer = players.size();
					tableInfo.CardsInTable.add(deck.DealACard());
				}
				break;
			case Turn:
				for (int i = 0; i < preflopMaxPlayer; i++)
				{
					// skip players who have already fold
					if(foldPlayer.contains(i))
					{
						//preflopMoves.add(i, 0);
						continue;
					}
					
					// existing player get move
					int move = players.get(i).PreflopMove(tableInfo, i, preflopMoves);
					preflopMoves[i] += move;
					
					// Check player action
					if (preflopMoves[i] == maxBet)
					{
						// call no action
					}
					else if (preflopMoves[i] > maxBet)
					{
						// raise
						maxBet = preflopMoves[i];
						preflopMaxPlayer = i;
					}
					else 
					{
						// fold
						foldPlayer.add(i);
					}
					
					ApplyMoveToPlayer(players.get(i), move);
				}
				
				// check if gameover
				if (players.size() - foldPlayer.size() == 1)
				{
					// game over
					return preflopMaxPlayer;
				}
				else if (players.size() - foldPlayer.size() == 0)
				{
					throw new IllegalArgumentException("all player fold in preflop. Impossible ending");
				}
				
				// Move State
				if (!isEven(preflopMoves, preflopMaxPlayer))
				{
					tableInfo.CurrentState = CurrentState.Turn;
				}
				else
				{
					tableInfo.CurrentState = CurrentState.River;
					preflopMaxPlayer = players.size();
					tableInfo.CardsInTable.add(deck.DealACard());
				}
				break;
			case River:
				for (int i = 0; i < preflopMaxPlayer; i++)
				{
					// skip players who have already fold
					if(foldPlayer.contains(i))
					{
						//preflopMoves.add(i, 0);
						continue;
					}
					
					// existing player get move
					int move = players.get(i).PreflopMove(tableInfo, i, preflopMoves);
					preflopMoves[i] += move;
					
					// Check player action
					if (preflopMoves[i] == maxBet)
					{
						// call no action
					}
					else if (preflopMoves[i] > maxBet)
					{
						// raise
						maxBet = preflopMoves[i];
						preflopMaxPlayer = i;
					}
					else 
					{
						// fold
						foldPlayer.add(i);
					}
					
					ApplyMoveToPlayer(players.get(i), move);
				}
				
				// check if gameover
				if (players.size() - foldPlayer.size() == 1)
				{
					// game over
					return preflopMaxPlayer;
				}
				else if (players.size() - foldPlayer.size() == 0)
				{
					throw new IllegalArgumentException("all player fold in preflop. Impossible ending");
				}
				
				// Move State
				if (!isEven(preflopMoves, preflopMaxPlayer))
				{
					tableInfo.CurrentState = CurrentState.River;
				}
				else
				{
					tableInfo.CurrentState = CurrentState.GameFinish;
				}
				break;
			case GameFinish:
				// determin winner
				GameJudge judge = new GameJudge();
				List<List<Cards>> remainingPlayer = new ArrayList<>();
				for (int i = 0; i < players.size(); i++)
				{
					if(!foldPlayer.contains(i))
					{
						remainingPlayer.add(players.get(i).cardsInHand);
					}
				}
				judge.JudgeGame(tableInfo.CardsInTable, remainingPlayer);
				break;
			default:
				throw new IllegalArgumentException("invalid current state" + tableInfo.CurrentState.toString());
			}
			
			winnerNumber = DetermineWinner();
			
		}
		
		return winnerNumber;
	}
	
	private static void ApplyMoveToPlayer(BasePlayer player, int move)
	{
		player.Chips -= move;
	}
	
	private static int DetermineWinner()
	{
		return 0;
	}
	
	private static boolean isEven(int[] previousMoves, int maxBetter)
	{
		int amount = -1;
		if(maxBetter > previousMoves.length)
		{
			throw new IllegalArgumentException("maxBetter > previousMoves.length" + maxBetter + " : " + previousMoves.length);
		}
		
		for(int i = 0; i < maxBetter; i++)
		{
			if ( amount == -1)
			{
				if (previousMoves[i] != 0)
				{
					amount = previousMoves[i];
				}
			}
			else
			{
				if (previousMoves[i] != 0 && amount != previousMoves[i])
				{
					return false;
				}
			}
		}
		
		return true;
	}
}
