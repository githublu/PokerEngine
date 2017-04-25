package test;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import master.Cards;
import master.Deck;
import master.GameJudge;
import master.Outcome;

public class UnitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("Should be 1, actually is: " + PairsVsHighCard());
		//CheckIfFlush();
		//CheckIfStraight();
		//CheckPairs();
		//CheckTwoPairs();
		//CheckThreeOfAKind();
		//CheckDeterminKind();
		//CheckIfPlay1Win();
		//CheckDeck();
		int[]preflopMoves = new int[6-1];
		int i = preflopMoves[2];
		System.out.print(i);
	}
	
	private static void CheckDeck()
	{
		Deck deck = new Deck();
		deck.DealACard();
	}
	
	private static void CheckIfPlay1Win()
	{
		List<Cards> p1 = new ArrayList<>();
		List<Cards> p2 = new ArrayList<>();
		GameJudge judge = new GameJudge();
		
		p1 = GetKinds.GetStraightFlush();
		p2 = GetKinds.GetFourOfAKind();
		Outcome player1Outcome = judge.DetermineKind(p1);
		Outcome player2Outcome = judge.DetermineKind(p2);
		
		if(judge.isPlayer1Win(player1Outcome, player2Outcome) <= 0)
		{
			System.out.println("[FAILED] expect GetStraightFlush>GetFourOfAKind but no");
		}
		
		p1 = GetKinds.GetStraight();
		p2 = GetKinds.GetStraightSmall();
		player1Outcome = judge.DetermineKind(p1);
		player2Outcome = judge.DetermineKind(p2);
		if(judge.isPlayer1Win(player1Outcome, player2Outcome) <= 0)
		{
			System.out.println("[FAILED] expect GetStraight>GetStraightSmall but no");
		}
		
		p1 = GetKinds.GetFlush();
		p2 = GetKinds.GetFlushSmall();
		player1Outcome = judge.DetermineKind(p1);
		player2Outcome = judge.DetermineKind(p2);
		if(judge.isPlayer1Win(player1Outcome, player2Outcome) <= 0)
		{
			System.out.println("[FAILED] expect GetFlush>GetFlushSmall but no");
		}
		
		p1 = GetKinds.GetFourOfAKind();
		p2 = GetKinds.GetFourOfAKindSmall();
		player1Outcome = judge.DetermineKind(p1);
		player2Outcome = judge.DetermineKind(p2);
		if(judge.isPlayer1Win(player1Outcome, player2Outcome) <= 0)
		{
			System.out.println("[FAILED] expect GetFourOfAKind>GetFourOfAKindSmall but no");
		}
		
		p1 = GetKinds.GetFullHouse();
		p2 = GetKinds.GetFullHouseSmall();
		player1Outcome = judge.DetermineKind(p1);
		player2Outcome = judge.DetermineKind(p2);
		if(judge.isPlayer1Win(player1Outcome, player2Outcome) <= 0)
		{
			System.out.println("[FAILED] expect GetFullHouse>GetFullHouseSmall but no");
		}
		
		p1 = GetKinds.GetThreeOfAKind();
		p2 = GetKinds.GetThreeOfAKindSmall();
		player1Outcome = judge.DetermineKind(p1);
		player2Outcome = judge.DetermineKind(p2);
		if(judge.isPlayer1Win(player1Outcome, player2Outcome) <= 0)
		{
			System.out.println("[FAILED] expect GetThreeOfAKind>GetThreeOfAKindSmall but no");
		}
		
		p1 = GetKinds.GetTwoPairs();
		p2 = GetKinds.GetTwoPairsSmall();
		player1Outcome = judge.DetermineKind(p1);
		player2Outcome = judge.DetermineKind(p2);
		if(judge.isPlayer1Win(player1Outcome, player2Outcome) <= 0)
		{
			System.out.println("[FAILED] expect GetTwoPairs>GetTwoPairsSmall but no");
		}
		
		p1 = GetKinds.GetPair();
		p2 = GetKinds.GetPairSmall();
		player1Outcome = judge.DetermineKind(p1);
		player2Outcome = judge.DetermineKind(p2);
		if(judge.isPlayer1Win(player1Outcome, player2Outcome) <= 0)
		{
			System.out.println("[FAILED] expect GetPair>GetPairSmall but no");
		}
		
		p1 = GetKinds.GetHighCards();
		p2 = GetKinds.GetHighCardsSmall();
		player1Outcome = judge.DetermineKind(p1);
		player2Outcome = judge.DetermineKind(p2);
		if(judge.isPlayer1Win(player1Outcome, player2Outcome) <= 0)
		{
			System.out.println("[FAILED] expect GetHighCards>GetHighCardsSmall but no");
		}
		
		System.out.println("[PASS] CheckIfPlay1Win");
	}
	
	private static void CheckDeterminKind()
	{
		List<Cards> total = new ArrayList<>();
		total = GetKinds.GetFlush();
		GameJudge judge = new GameJudge();
		if(judge.DetermineKind(total).kind != Outcome.Kind.Flush)
		{
			System.out.println("[FAILED] expect flush but no");
			return;
		}
		
		total = GetKinds.GetFourOfAKind();
		if(judge.DetermineKind(total).kind != Outcome.Kind.FourOfAKind)
		{
			System.out.println("[FAILED] expect FourOfAKind but no");
			return;
		}
		
		total = GetKinds.GetHighCards();
		if(judge.DetermineKind(total).kind != Outcome.Kind.HighCard)
		{
			System.out.println("[FAILED] expect HighCard but no");
			return;
		}
		
		total = GetKinds.GetStraight();
		if(judge.DetermineKind(total).kind != Outcome.Kind.Straight)
		{
			System.out.println("[FAILED] expect Straight but no");
			return;
		}
		
		total = GetKinds.GetStraightFlush();
		if(judge.DetermineKind(total).kind != Outcome.Kind.StraightFlush)
		{
			System.out.println("[FAILED] expect StraightFlush but no");
			return;
		}
		
		total = GetKinds.GetFullHouse();
		if(judge.DetermineKind(total).kind != Outcome.Kind.FullHouse)
		{
			System.out.println("[FAILED] expect FullHouse but no");
			return;
		}
		
		total = GetKinds.GetThreeOfAKind();
		if(judge.DetermineKind(total).kind != Outcome.Kind.ThreeOfAKind)
		{
			System.out.println("[FAILED] expect ThreeOfAKind but no");
			return;
		}
		
		total = GetKinds.GetTwoPairs();
		if(judge.DetermineKind(total).kind != Outcome.Kind.TwoPairs)
		{
			System.out.println("[FAILED] expect TwoPairs but no");
			return;
		}
		
		total = GetKinds.GetPair();
		if(judge.DetermineKind(total).kind != Outcome.Kind.Pair)
		{
			System.out.println("[FAILED] expect Pair but no");
			return;
		}
		
		System.out.print("[PASS] CheckDeterminKind");
	}
	
	private static void CheckIfFlush()
	{
		List<Cards> total = new ArrayList<>();
		total = GetKinds.GetFlush();
		
		GameJudge judge = new GameJudge();
		Outcome outcome = new Outcome();
		if(judge.CheckIfFlush(total, outcome).Flush.isEmpty())
		{
			System.out.println("[FAILED]expect Flush, actual no");
			return;
		}
		
		total = GetKinds.GetHighCards();
		
		outcome.Clear();
		if(!judge.CheckIfFlush(total, outcome).Flush.isEmpty())
		{
			System.out.println("[FAILED]expect no, actual Flush");
			return;
		}
		
		System.out.println("[PASS] CheckIfFlush");
	}
	
	private static void CheckIfStraight()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(1, Cards.Suits.Spade));
		total.add(new Cards(2, Cards.Suits.Spade));
		total.add(new Cards(4, Cards.Suits.Club));
		total.add(new Cards(5, Cards.Suits.Club));
		total.add(new Cards(6, Cards.Suits.Heart));
		total.add(new Cards(7, Cards.Suits.Spade));
		total.add(new Cards(8, Cards.Suits.Spade));
		
		GameJudge judge = new GameJudge();
		Outcome outcome = new Outcome();
		List<Integer> straight= judge.CheckIfStraight(total, outcome).Straight;
		if(straight.isEmpty())
		{
			System.out.println("[FAILED]expect Straight, actual no");
			return;
		}
		else if(straight.get(4) != 8)
		{
			System.out.println("[FAILED]expect straight to have max 8, actual " + straight.get(4));
			return;
		}
		
		total.clear();
		total.add(new Cards(2, Cards.Suits.Spade));
		total.add(new Cards(4, Cards.Suits.Spade));
		total.add(new Cards(6, Cards.Suits.Club));
		total.add(new Cards(8, Cards.Suits.Club));
		total.add(new Cards(10, Cards.Suits.Heart));
		total.add(new Cards(13, Cards.Suits.Heart));
		total.add(new Cards(14, Cards.Suits.Heart));
		
		outcome.Clear();
		if(!judge.CheckIfStraight(total, outcome).Straight.isEmpty())
		{
			System.out.println("[FAILED]expect no, actual Straight");
			return;
		}
		
		System.out.println("[PASS] CheckIfStraight");
	}
	
	private static void CheckPairs()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(1, Cards.Suits.Spade));
		total.add(new Cards(2, Cards.Suits.Spade));
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(5, Cards.Suits.Club));
		total.add(new Cards(6, Cards.Suits.Heart));
		total.add(new Cards(10, Cards.Suits.Spade));
		total.add(new Cards(8, Cards.Suits.Spade));
		
		GameJudge judge = new GameJudge();
		Outcome outcome = new Outcome();
		List<Integer> pair= judge.CheckPairs(total, outcome).Pairs;
		if(pair.isEmpty())
		{
			System.out.println("[FAILED]expect pair, actual no");
			return;
		}
		else if(pair.get(0) != 2)
		{
			System.out.println("[FAILED]expect pair to be 2, actual " + pair.get(0));
			return;
		}
		
		System.out.println("[PASS] CheckPairs");
	}
	
	private static void CheckTwoPairs()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(1, Cards.Suits.Spade));
		total.add(new Cards(2, Cards.Suits.Spade));
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(5, Cards.Suits.Club));
		total.add(new Cards(10, Cards.Suits.Heart));
		total.add(new Cards(10, Cards.Suits.Spade));
		total.add(new Cards(8, Cards.Suits.Spade));
		
		GameJudge judge = new GameJudge();
		Outcome outcome = new Outcome();
		List<Integer> pair= judge.CheckPairs(total, outcome).Pairs;
		if(pair.size() != 2)
		{
			System.out.println("[FAILED]expect two pair, actual no");
			return;
		}
		else if(pair.get(0) != 2 || pair.get(1) != 10)
		{
			System.out.println("[FAILED]expect pair to be 2, actual " + pair.get(0));
			return;
		}
		
		System.out.println("[PASS] CheckTwoPairs");
	}
	
	private static void CheckThreeOfAKind()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(1, Cards.Suits.Spade));
		total.add(new Cards(2, Cards.Suits.Spade));
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(9, Cards.Suits.Heart));
		total.add(new Cards(10, Cards.Suits.Spade));
		total.add(new Cards(8, Cards.Suits.Spade));
		
		GameJudge judge = new GameJudge();
		Outcome outcome = new Outcome();
		int threeOfAKind = judge.CheckPairs(total, outcome).ThreeOfAKind;
		if(threeOfAKind == 0)
		{
			System.out.println("[FAILED]expect three of a kind, actual no");
			return;
		}
		else if(threeOfAKind != 2)
		{
			System.out.println("[FAILED]expect pair to be 2, actual " + threeOfAKind);
			return;
		}
		
		System.out.println("[PASS] CheckThreeOfAKind");
	}
}
