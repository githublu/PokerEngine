package test;

import java.util.ArrayList;
import java.util.List;

import master.Cards;

public class GetKinds {
	public GetKinds()
	{
		
	}
	
	public static List<Cards> GetStraightFlush()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(4, Cards.Suits.Club));
		total.add(new Cards(8, Cards.Suits.Spade));
		total.add(new Cards(9, Cards.Suits.Spade));
		total.add(new Cards(10, Cards.Suits.Spade));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetStraight()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(4, Cards.Suits.Club));
		total.add(new Cards(8, Cards.Suits.Spade));
		total.add(new Cards(9, Cards.Suits.Diamond));
		total.add(new Cards(10, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetStraightSmall()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(7, Cards.Suits.Club));
		total.add(new Cards(8, Cards.Suits.Spade));
		total.add(new Cards(9, Cards.Suits.Diamond));
		total.add(new Cards(10, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(5, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetFlush()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(4, Cards.Suits.Club));
		total.add(new Cards(8, Cards.Suits.Spade));
		total.add(new Cards(3, Cards.Suits.Spade));
		total.add(new Cards(4, Cards.Suits.Spade));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetFlushSmall()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(4, Cards.Suits.Club));
		total.add(new Cards(8, Cards.Suits.Spade));
		total.add(new Cards(3, Cards.Suits.Spade));
		total.add(new Cards(4, Cards.Suits.Spade));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(2, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetFourOfAKind()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(3, Cards.Suits.Club));
		total.add(new Cards(3, Cards.Suits.Club));
		total.add(new Cards(3, Cards.Suits.Spade));
		total.add(new Cards(3, Cards.Suits.Diamond));
		total.add(new Cards(4, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetFourOfAKindSmall()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(2, Cards.Suits.Spade));
		total.add(new Cards(2, Cards.Suits.Diamond));
		total.add(new Cards(4, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetThreeOfAKind()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(6, Cards.Suits.Club));
		total.add(new Cards(6, Cards.Suits.Club));
		total.add(new Cards(3, Cards.Suits.Spade));
		total.add(new Cards(6, Cards.Suits.Diamond));
		total.add(new Cards(4, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetThreeOfAKindSmall()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(2, Cards.Suits.Diamond));
		total.add(new Cards(3, Cards.Suits.Spade));
		total.add(new Cards(4, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetFullHouse()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(5, Cards.Suits.Club));
		total.add(new Cards(5, Cards.Suits.Club));
		total.add(new Cards(3, Cards.Suits.Spade));
		total.add(new Cards(5, Cards.Suits.Diamond));
		total.add(new Cards(3, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetFullHouseSmall()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(3, Cards.Suits.Spade));
		total.add(new Cards(2, Cards.Suits.Diamond));
		total.add(new Cards(3, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetTwoPairs()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(4, Cards.Suits.Club));
		total.add(new Cards(4, Cards.Suits.Club));
		total.add(new Cards(3, Cards.Suits.Spade));
		total.add(new Cards(5, Cards.Suits.Diamond));
		total.add(new Cards(3, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetTwoPairsSmall()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(3, Cards.Suits.Spade));
		total.add(new Cards(5, Cards.Suits.Diamond));
		total.add(new Cards(3, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetPair()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(7, Cards.Suits.Club));
		total.add(new Cards(7, Cards.Suits.Club));
		total.add(new Cards(4, Cards.Suits.Spade));
		total.add(new Cards(9, Cards.Suits.Diamond));
		total.add(new Cards(3, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetPairSmall()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(4, Cards.Suits.Spade));
		total.add(new Cards(9, Cards.Suits.Diamond));
		total.add(new Cards(3, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetHighCards()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(4, Cards.Suits.Club));
		total.add(new Cards(6, Cards.Suits.Spade));
		total.add(new Cards(8, Cards.Suits.Diamond));
		total.add(new Cards(10, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(12, Cards.Suits.Spade));
		
		return total;
	}
	
	public static List<Cards> GetHighCardsSmall()
	{
		List<Cards> total = new ArrayList<>();
		total.add(new Cards(2, Cards.Suits.Club));
		total.add(new Cards(4, Cards.Suits.Club));
		total.add(new Cards(6, Cards.Suits.Spade));
		total.add(new Cards(8, Cards.Suits.Diamond));
		total.add(new Cards(10, Cards.Suits.Heart));
		total.add(new Cards(11, Cards.Suits.Spade));
		total.add(new Cards(5, Cards.Suits.Spade));
		
		return total;
	}
}
