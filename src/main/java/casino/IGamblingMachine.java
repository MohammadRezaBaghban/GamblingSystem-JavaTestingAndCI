package casino;

public interface IGamblingMachine {

	/**
	 * 
	 * @param gamblerCardID
	 * @param amount
	 * @param selectedNumber
	 */
	boolean placeBet(String gamblerCardID, double amount, Integer selectedNumber) throws NotificationException;

	BettingRound createBetRound();

	void reward();

}