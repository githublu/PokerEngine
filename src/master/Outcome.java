package master;
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
	}
}