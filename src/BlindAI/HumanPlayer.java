package BlindAI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

import master.BasePlayer;
import master.TableInfo;

public class HumanPlayer extends BasePlayer{
	public int PreflopMove(TableInfo tableInfo, int myPostition, int[] previousMoves, int BB) {
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
		int i = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Flop bet:");
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
	public int TurnMove(TableInfo tableInfo, int myPostition, int[] previousMoves, int BB) {
		int i = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Turn bet:");
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
	public int RiverMove(TableInfo tableInfo, int myPostition, int[] previousMoves, int BB) {
		int i = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter River bet:");
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
	
	public HumanPlayer()
	{
		
	}
}
