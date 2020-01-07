package casino;

import java.util.Map;

public class GamblingMachine implements IGamblingMachine {

	private BankTeller bankTeller;
	private String machineID;
	private Map<Bet, String> listOfBetsOfCurrentRound;
	private Game game;

	/**
	 * 
	 * @param gamblerCardID
	 * @param amount
	 * @param selectedNumber
	 */
	public boolean placeBet(String gamblerCardID, double amount, Integer selectedNumber) {
		// TODO - implement GamblingMachine.placeBet
		throw new UnsupportedOperationException();
	}

	public BettingRound createBetRound() {
		// TODO - implement GamblingMachine.createBetRound
		throw new UnsupportedOperationException();
	}

	public void reward() {
		// TODO - implement GamblingMachine.reward
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param game
	 * @param bankteller
	 */
	public GamblingMachine(Game game, BankTeller bankteller) {
		// TODO - implement GamblingMachine.GamblingMachine
		throw new UnsupportedOperationException();
	}

}