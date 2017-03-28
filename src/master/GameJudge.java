package master;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameJudge {

	public int Judge(List<Cards> table, List<Cards> player1, List<Cards> player2) {
		Integer totalCards = table.size() + player1.size();
		if (totalCards != 7) {
			throw new IllegalArgumentException("not 7 hards in total");
		}

		List<Cards> play1Cards = new ArrayList<>();
		List<Cards> play2Cards = new ArrayList<>();
		
		play1Cards.addAll(table);
		play1Cards.addAll(player1);
		play2Cards.addAll(table);
		play2Cards.addAll(player2);
		Outcome player1Outcome = DetermineKind(play1Cards);
		Outcome player2Outcome = DetermineKind(play2Cards);
		player1Outcome.GetMaxFive();
		player2Outcome.GetMaxFive();
		return isPlayer1Win(player1Outcome, player2Outcome);
	}

	public int isPlayer1Win(Outcome player1, Outcome player2)
	{
		int result = player1.kind.compareTo(player2.kind);
		if(result == 0)
		{
			switch(player1.kind)
			{
				case StraightFlush:
				case Straight:
					result = Collections.max(player1.Straight).compareTo(Collections.max(player2.Straight));
					break;
				
				case Flush:
					result = CompareTwoList(player1.Flush, player2.Flush);
					break;
				case FourOfAKind:
					result = player1.FourOfAKind - player2.FourOfAKind;
					if(result == 0)
					{
						result = player1.Singles.get(0) - player2.Singles.get(0); 
					}
					break;
				case FullHouse:
					result = player1.ThreeOfAKind - player2.ThreeOfAKind;
					if (result == 0)
					{
						result = player1.Pairs.get(0) - player2.Pairs.get(0);
					}
					break;
				case ThreeOfAKind:
					result = player1.ThreeOfAKind - player2.ThreeOfAKind;
					if (result == 0)
					{
						result = CompareTwoList(player1.Singles, player2.Singles);
					}
					break;
				case TwoPairs:
				case Pair:
					result = CompareTwoList(player1.Pairs, player2.Pairs);
					if(result == 0)
					{
						result = CompareTwoList(player1.Singles, player2.Singles);
					}
					break;
				case HighCard:
					result = CompareTwoList(player1.Singles, player2.Singles);
					break;
				default:
					throw new IllegalArgumentException("no kind initialized");
			}
		}
		
		return result;
	}

	public Outcome DetermineKind(List<Cards> player) {
		Outcome playerOutcome = new Outcome();
		Outcome isFlush = CheckIfFlush(player, playerOutcome);
		Outcome isStraight = CheckIfStraight(player, isFlush);
		playerOutcome = CheckPairs(player, isStraight);

		if (!playerOutcome.Flush.isEmpty() && !playerOutcome.Straight.isEmpty()) {
			playerOutcome.kind = Outcome.Kind.StraightFlush;
		} else if (!playerOutcome.Flush.isEmpty()) {
			playerOutcome.kind = Outcome.Kind.Flush;
		} else if (!playerOutcome.Straight.isEmpty()) {
			playerOutcome.kind = Outcome.Kind.Straight;
		} else if (playerOutcome.FourOfAKind != 0) {
			playerOutcome.kind = Outcome.Kind.FourOfAKind;
			int single = Collections.max(playerOutcome.Singles);
			playerOutcome.Singles.clear();
			playerOutcome.Singles.add(single);
		} else if (playerOutcome.ThreeOfAKind != 0 && !playerOutcome.Pairs.isEmpty()) {
			playerOutcome.kind = Outcome.Kind.FullHouse;
		} else if (playerOutcome.ThreeOfAKind != 0) {
			playerOutcome.kind = Outcome.Kind.ThreeOfAKind;
		} else if (!playerOutcome.Pairs.isEmpty()) {
			if (playerOutcome.Pairs.size() >= 2) {
				playerOutcome.kind = Outcome.Kind.TwoPairs;
			} else {
				playerOutcome.kind = Outcome.Kind.Pair;
			}
		} else {
			playerOutcome.kind = Outcome.Kind.HighCard;
		}

		return playerOutcome;
	}

	public Outcome CheckIfFlush(List<Cards> cards, Outcome outcome) {
		if (cards.size() != 7) {
			throw new IllegalArgumentException("not 7 hards in total");
		}
		int coutsOfSpade = 0;
		int coutsOfClube = 0;
		int coutsOfHeart = 0;
		int coutsOfDiamond = 0;
		Cards.Suits suit = null;
		Map<Cards.Suits, List<Integer>> map = new HashMap<>();
		map.put(Cards.Suits.Spade, new ArrayList<Integer>());
		map.put(Cards.Suits.Club, new ArrayList<Integer>());
		map.put(Cards.Suits.Heart, new ArrayList<Integer>());
		map.put(Cards.Suits.Diamond, new ArrayList<Integer>());
		for (Cards card : cards) {
			switch (card.suit) {
			case Spade:
				coutsOfSpade++;
				List<Integer> list1 = map.get(Cards.Suits.Spade);
				list1.add(card.Number);
				map.put(Cards.Suits.Spade, list1);
				if (coutsOfSpade >= 5) {
					suit = Cards.Suits.Spade;
				}
				break;
			case Club:
				coutsOfClube++;
				List<Integer> list2 = map.get(Cards.Suits.Club);
				list2.add(card.Number);
				map.put(Cards.Suits.Club, list2);
				if (coutsOfClube >= 5) {
					suit = Cards.Suits.Club;
				}
				break;
			case Heart:
				coutsOfHeart++;
				List<Integer> list3 = map.get(Cards.Suits.Heart);
				list3.add(card.Number);
				map.put(Cards.Suits.Heart, list3);
				if (coutsOfHeart >= 5) {
					suit = Cards.Suits.Heart;
				}
				break;
			case Diamond:
				coutsOfDiamond++;
				List<Integer> list4 = map.get(Cards.Suits.Diamond);
				list4.add(card.Number);
				map.put(Cards.Suits.Diamond, list4);
				if (coutsOfDiamond >= 5) {
					suit = Cards.Suits.Diamond;
				}
				break;
			}
		}

		if (suit != null) {
			List<Integer> list = map.get(suit);
			Collections.sort(list);
			outcome.Flush = list;
		}

		return outcome;
	}

	public Outcome CheckIfStraight(List<Cards> cards, Outcome outcome) {
		List<Integer> numbers = new ArrayList<>();
		boolean isStraight = false;
		for (Cards card : cards) {
			numbers.add(card.Number);
		}

		Collections.sort(numbers);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (!isStraight) {
				int cur = numbers.get(i);
				list.clear();
				list.add(numbers.get(i));
				for (int j = i + 1; j < i + 5; j++) {
					int next = numbers.get(j);
					if (next != cur + 1) {
						isStraight = false;
						break;
					} else {
						list.add(next);
						cur = next;
						if (j == i + 4) {
							isStraight = true;
						}
					}
				}
			}
		}

		if (isStraight) {
			Collections.sort(list);
			outcome.Straight = list;
		}

		return outcome;
	}

	public Outcome CheckPairs(List<Cards> cards, Outcome outcome) {
		Map<Integer, Integer> map = new HashMap<>();

		for (Cards card : cards) {
			int originalCounts = map.get(card.Number) == null ? 0 : map.get(card.Number);
			originalCounts++;
			map.put(card.Number, originalCounts);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 4) {
				outcome.FourOfAKind = entry.getKey();
			} else if (entry.getValue() == 3) {
				outcome.ThreeOfAKind = entry.getKey();
			} else if (entry.getValue() == 2) {
				outcome.Pairs.add(entry.getKey());
			} else {
				outcome.Singles.add(entry.getKey());
			}
		}

		return outcome;
	}
	
	private int CompareTwoList(List<Integer> l1, List<Integer> l2)
	{
		int size = l1.size();
		for(int i = size - 1; i >= 0; i--)
		{
			if(l1.get(i) > l2.get(i))
			{
				return 1;
			}
			else if (l1.get(i) < l2.get(i))
			{
				return -1;
			}
		}
		
		return 0;
	}
}
