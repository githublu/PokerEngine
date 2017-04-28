package BlindAI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import master.Cards;
import master.BasePlayer;
import master.TableInfo;
import java.util.concurrent.ThreadLocalRandom;

public class SamplePlayer extends BasePlayer{
	public int PreflopMove(TableInfo tableInfo, int myPostition, int[] previousMoves, int BB) {
		//int randomNum = ThreadLocalRandom.current().nextInt(0, 10 + 1);
		int i = 0;
		System.out.println("cards in hand:" + cardsInHand.get(0) + ", " + cardsInHand.get(1));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Preflop bet:");
            try {
				i = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("Postion: " + myPostition + " bet: " + i);
		return i;
	}
	public int FlopMove(TableInfo tableInfo, int myPostition, int[] previousMoves, int BB) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 10 + 1);
		System.out.println("Postion: " + myPostition + " bet: " + randomNum);
		return randomNum;
	}
	public int TurnMove(TableInfo tableInfo, int myPostition, int[] previousMoves, int BB) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 10 + 1);
		System.out.println("Postion: " + myPostition + " bet: " + randomNum);
		return randomNum;
	}
	public int RiverMove(TableInfo tableInfo, int myPostition, int[] previousMoves, int BB) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 10 + 1);
		System.out.println("Postion: " + myPostition + " bet: " + randomNum);
		return randomNum;
	}
	
	public SamplePlayer()
	{
		
	}
}
