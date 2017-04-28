package BlindAI;

public class BetLevel {

	double betLevel = 1.0;
	
	public int Bet(double myStrength, int totalChips, int minRaise, int call, int previousAmount, int BB)
	{
		int amount = 0;
		if (myStrength <= 0)
		{
			return 0;
		}
		
		if (myStrength > 0.5)
		{
			return totalChips;
		}
		else
		{
			amount = (int)((myStrength * 10) * BB * betLevel);
			if (amount <= totalChips)
			{
				if (amount > call && amount < minRaise)
				{
					amount = call;
				}
				else if (amount < call)
				{
					return 0;
				}
			}
			else
			{
				amount = totalChips;
			}
		}
		
		if (myStrength < 0.3 && previousAmount != 0)
		{
			return 0;
		}
		else
		{
			return amount;
		}
		
	}
	
	public BetLevel(double betLevel)
	{
		this.betLevel = betLevel;
	}
	
	public BetLevel()
	{
		
	}
}
