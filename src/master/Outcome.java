package master;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Outcome {
	public enum Kind {
		HighCard, Pair, TwoPairs, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush,
	}

	public Integer FourOfAKind;
	public Integer ThreeOfAKind;
	public List<Integer> Flush;
	public List<Integer> Straight;
	public List<Integer> Singles;
	public List<Integer> Pairs;

	public Kind kind;

	public Outcome() {
		Flush = new ArrayList<Integer>();
		Straight = new ArrayList<Integer>();
		Singles = new ArrayList<Integer>();
		Pairs = new ArrayList<Integer>();
		FourOfAKind = 0;
		ThreeOfAKind = 0;
	}

	public void Clear() {
		this.kind = null;
		FourOfAKind = 0;
		ThreeOfAKind = 0;
		Flush.clear();
		Straight.clear();
		Singles.clear();
		Pairs.clear();
	}

	public void GetMaxFive()
	{
		if(this.kind == null)
		{
			throw new IllegalArgumentException("determine kind first");
		}
		
		int largestIndex = 0;
		int secondLargestIndex = 0;
		int largest = 0;
		int secondLargest = 0;
		int thirdLargest = 0;
		int thirdLargestIndex = 0;
		
		Outcome originalOutcome = new Outcome();
		originalOutcome.Flush = this.Flush;
		originalOutcome.Straight = this.Straight;
		originalOutcome.Singles = this.Singles;
		originalOutcome.Pairs = this.Pairs;
		originalOutcome.FourOfAKind = this.FourOfAKind;
		originalOutcome.ThreeOfAKind = this.ThreeOfAKind;
		originalOutcome.kind = this.kind;
		
		try
		{
			switch(this.kind)
			{
			
			case StraightFlush:
			case Straight:
				FourOfAKind = 0;
				ThreeOfAKind = 0;
				Flush.clear();
				//Straight.clear();
				for (int i = 0; i < Straight.size()-5; i++) {
					Straight.remove(i);
				}
				Singles.clear();
				Pairs.clear();
				break;
			case Flush:
				FourOfAKind = 0;
				ThreeOfAKind = 0;
				//Flush.clear();
				for (int i = 0; i < Flush.size()-5; i++) {
					Flush.remove(i);
				}
				Straight.clear();
				Singles.clear();
				Pairs.clear();
				break;
			case FourOfAKind:
				//FourOfAKind = 0;
				ThreeOfAKind = 0;
				Flush.clear();
				Straight.clear();
				largestIndex = Singles.size()-1;
				largest = Singles.get(largestIndex);
				Singles.clear();
				Singles.add(largest);
				Pairs.clear();
				break;
			case FullHouse:
				FourOfAKind = 0;
				//ThreeOfAKind = 0;
				Flush.clear();
				Straight.clear();
				Singles.clear();
				int pair = Collections.max(Pairs);
				Pairs.clear();
				Pairs.add(pair);
				break;
			case ThreeOfAKind:
				FourOfAKind = 0;
				//ThreeOfAKind = 0;
				Flush.clear();
				Straight.clear();
				Pairs.clear();
				largestIndex = Singles.size()-1;
				secondLargestIndex = Singles.size()-2;
				largest = Singles.get(largestIndex);
				secondLargest = Singles.get(secondLargestIndex);
				Singles.clear();
				Singles.add(secondLargest);
				Singles.add(largest);
				break;
			case TwoPairs:
				FourOfAKind = 0;
				ThreeOfAKind = 0;
				Flush.clear();
				Straight.clear();
				largestIndex = Singles.size()-1;
				largest = Singles.get(largestIndex);
				Singles.clear();
				Singles.add(largest);
				
				largestIndex = Pairs.size()-1;
				secondLargestIndex = Pairs.size()-2;
				largest = Pairs.get(largestIndex);
				secondLargest = Pairs.get(secondLargestIndex);
				Pairs.clear();
				Pairs.add(secondLargest);
				Pairs.add(largest);
				break;
			case Pair:
				FourOfAKind = 0;
				ThreeOfAKind = 0;
				Flush.clear();
				Straight.clear();
				
				largestIndex = Singles.size()-1;
				secondLargestIndex = Singles.size()-2;
				thirdLargestIndex = Singles.size()-3;
				largest = Singles.get(largestIndex);
				secondLargest = Singles.get(secondLargestIndex);
				thirdLargest = Singles.get(thirdLargestIndex);
				
				Singles.clear();
				Singles.add(thirdLargest);
				Singles.add(secondLargest);
				Singles.add(largest);
				
				//Pairs.clear();
				break;
			case HighCard:
				FourOfAKind = 0;
				ThreeOfAKind = 0;
				Flush.clear();
				Straight.clear();
				Singles.remove(0);
				Singles.remove(1);
				Pairs.clear();
				break;
			default:
				break;
			}
			
			int numFourOfAKind = this.FourOfAKind == 0 ? 0 : 4;
			int numThreeOfAKind = this.ThreeOfAKind == 0 ? 0 : 3;
			int numberOfCards = numFourOfAKind + numThreeOfAKind + this.Flush.size() + this.Straight.size() + this.Singles.size() + this.Pairs.size()*2; 
			
			if(numberOfCards != 5)
			{
				throw new IllegalArgumentException("not 5 cards in the end for Kind: " + this.kind + " number of cards: " + numberOfCards);
			}
		}
		catch(Exception ex)
		{
			System.out.println("--- original outcome ---");
			PrintOutcome(originalOutcome);
			System.out.println("--- after outcome ---");
			PrintOutcome(this);
			throw ex;
		}
	}
	
	public void PrintOutcome(Outcome outcome)
	{
		System.out.println("Kind: " + outcome.kind);
		System.out.println("FourofAKind: " + outcome.FourOfAKind);
		System.out.println("ThreeOfAKind: " + outcome.ThreeOfAKind);
		System.out.println("Flush: " + outcome.Flush);
		System.out.println("Straight: " + outcome.Straight);
		System.out.println("Singles: " + outcome.Singles);
		System.out.println("Pairs: " + outcome.Pairs);
	}
}