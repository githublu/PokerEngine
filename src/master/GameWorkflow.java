package master;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import BlindAI.BlindPlayer;
import BlindAI.HumanPlayer;
import BlindAI.SamplePlayer;
import master.TableInfo.CurrentState;

public class GameWorkflow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start a new game");

		BlindPlayer p1 = new BlindPlayer();
		BlindPlayer p2 = new BlindPlayer();
		List<BasePlayer> players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
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
		TableInfo tableInfo = new TableInfo(cardsOntable, CurrentState.Initialize);
		int winnerNumber = -1;
		int sb = 1;
		int bb = 2;
		// player.get(0) is sb
		// player.get(1) is bb
		// player.get(size-1) is dealer
		
		int totalPlayers = players.size();
		int[]preflopMoves = new int[totalPlayers];
		int preflopMaxPlayer = players.size();
		
		boolean firstFlop = true;
		boolean firstTurn = true;
		boolean firstRiver = true;
		
		List<Integer> foldPlayer = new ArrayList<>();
		int size = players.size();
		if (size < 2)
		{
			return 0;
		}
		
		int maxBet = 0;
		
		while (true) {
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
				
				tableInfo.CurrentState = CurrentState.FirstRound;
				break;
			case FirstRound:
				System.out.println("FirstRound");
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
					int move = players.get(i).PreflopMove(tableInfo, i, preflopMoves, bb);
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
					int move = players.get(i).PreflopMove(tableInfo, i, preflopMoves, bb);
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
				if (!isEven(preflopMoves, foldPlayer))
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
					for (Cards card : tableInfo.CardsInTable)
					{
						System.out.println(card.toString());
					}
				}
				break;
			case Preflop:
				System.out.println("Preflop");
				for (int i = 0; i < totalPlayers; i++)
				{
					// skip players who have already fold
					if(foldPlayer.contains(i) || preflopMoves[i] == maxBet)
					{
						//preflopMoves.add(i, 0);
						continue;
					}
					
					if (preflopMoves[i] > maxBet)
					{
						throw new IllegalArgumentException("exising move is more than maxbet: " + preflopMoves[i] + " : " + maxBet);
					}
					
					// existing player get move
					int move = players.get(i).PreflopMove(tableInfo, i, preflopMoves, bb);
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
				if (!isEven(preflopMoves, foldPlayer))
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
					for (Cards card : tableInfo.CardsInTable)
					{
						System.out.println(card.toString());
					}
				}
				
				break;
			case Flop:
				System.out.println("Flop");
				for (int i = 0; i < totalPlayers; i++)
				{
					// skip players who have already fold
					if(foldPlayer.contains(i))
					{
						//preflopMoves.add(i, 0);
						continue;
					}
					
					if (!firstFlop &&  preflopMoves[i] == maxBet)
					{
						continue;
					}
					
					if (preflopMoves[i] > maxBet)
					{
						throw new IllegalArgumentException("exising move is more than maxbet: " + preflopMoves[i] + " : " + maxBet);
					}
					
					// existing player get move
					int move = players.get(i).FlopMove(tableInfo, i, preflopMoves, bb);
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
				if (!isEven(preflopMoves, foldPlayer))
				{
					tableInfo.CurrentState = CurrentState.Flop;
					firstFlop = false;
				}
				else
				{
					tableInfo.CurrentState = CurrentState.Turn;
					preflopMaxPlayer = players.size();
					tableInfo.CardsInTable.add(deck.DealACard());
					for (Cards card : tableInfo.CardsInTable)
					{
						System.out.println(card.toString());
					}
				}
				break;
			case Turn:
				System.out.println("Turn");
				for (int i = 0; i < totalPlayers; i++)
				{
					// skip players who have already fold
					if(foldPlayer.contains(i))
					{
						//preflopMoves.add(i, 0);
						continue;
					}
					
					if (!firstTurn &&  preflopMoves[i] == maxBet)
					{
						continue;
					}
					
					if (preflopMoves[i] > maxBet)
					{
						throw new IllegalArgumentException("exising move is more than maxbet: " + preflopMoves[i] + " : " + maxBet);
					}
					// existing player get move
					int move = players.get(i).TurnMove(tableInfo, i, preflopMoves, bb);
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
				if (!isEven(preflopMoves, foldPlayer))
				{
					tableInfo.CurrentState = CurrentState.Turn;
					firstTurn = false;
				}
				else
				{
					tableInfo.CurrentState = CurrentState.River;
					preflopMaxPlayer = players.size();
					tableInfo.CardsInTable.add(deck.DealACard());
					for (Cards card : tableInfo.CardsInTable)
					{
						System.out.println(card.toString());
					}
				}
				break;
			case River:
				System.out.println("River");
				for (int i = 0; i < totalPlayers; i++)
				{
					// skip players who have already fold
					if(foldPlayer.contains(i))
					{
						//preflopMoves.add(i, 0);
						continue;
					}
					
					if (!firstRiver &&  preflopMoves[i] == maxBet)
					{
						continue;
					}
					
					if (preflopMoves[i] > maxBet)
					{
						throw new IllegalArgumentException("exising move is more than maxbet: " + preflopMoves[i] + " : " + maxBet);
					}
					
					// existing player get move
					int move = players.get(i).RiverMove(tableInfo, i, preflopMoves, bb);
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
				if (!isEven(preflopMoves, foldPlayer))
				{
					tableInfo.CurrentState = CurrentState.River;
					firstRiver = false;
				}
				else
				{
					tableInfo.CurrentState = CurrentState.GameFinish;
				}
				break;
			case GameFinish:
				// determine winner
				for (Cards card : tableInfo.CardsInTable)
				{
					System.out.println(card.toString());
				}
				
				GameJudge judge = new GameJudge();
				List<List<Cards>> remainingPlayer = new ArrayList<>();
				for (int i = 0; i < players.size(); i++)
				{
					if(!foldPlayer.contains(i))
					{
						remainingPlayer.add(players.get(i).cardsInHand);
					}
					else
					{
						remainingPlayer.add(new ArrayList<Cards>());
					}
				}
				winnerNumber = judge.JudgeGame(tableInfo.CardsInTable, remainingPlayer);
				return winnerNumber;
			default:
				throw new IllegalArgumentException("invalid current state" + tableInfo.CurrentState.toString());
			}			
		}
	}
	
	private static void ApplyMoveToPlayer(BasePlayer player, int move)
	{
		player.Chips -= move;
	}
	
	private static int DetermineWinner()
	{
		return 0;
	}
	
	private static boolean isEven(int[] previousMoves, List<Integer> foldPlayers)
	{
		int amount = -1;
		for (int i = 0; i < previousMoves.length; i++)
		{
			if (!foldPlayers.contains(i))
			{
				if (amount == -1)
				{
					amount = previousMoves[i];
				}
				else if(amount != previousMoves[i])
				{
					return false;
				}
			}
		}
		
		return true;
	}
}
