package casino;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {

	private boolean multipleBet;
	private GamblingAuthority gamblingAuthority;
	private BettingRound currentBetRound;
	private Map<Bet, String> listOfBets;
	private List<Bet> ArrayList;

	/**
	 * 
	 * @param ListOfBets
	 */
	public BettingRound createBetRound(Map<Bet, String> ListOfBets) {
		listOfBets = ListOfBets;
		ArrayList = new ArrayList<>(listOfBets.keySet());
		currentBetRound = new BettingRound(ArrayList);
		return currentBetRound;
	}

	/**
	 * 
	 * @param gamblingAuthority
	 */
	public Game(GamblingAuthority gamblingAuthority) {
		// TODO - implement Game.Game
		throw new UnsupportedOperationException();
	}

	/**
	 * it should check the token status.
	 */
	public void requestToken() {
		// TODO - implement Game.requestToken
		throw new UnsupportedOperationException();
	}

	/**
	 * it should check the token status.
	 * @param betRound
	 */
	public void requestWinNumber(BettingRound betRound) {
		// TODO - implement Game.requestWinNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * winNumber should only be set once. In the Setter, we will check if the winNumber is already assigned or not, if the winNrAssigned is false before setting as a representation of not assigned winNumber and if true then it shows that the winNumber has already assigned and throw an exception.
	 * @param winNumber
	 */
	public void setWinNumber(Integer winNumber) {
		// TODO - implement Game.setWinNumber
		throw new UnsupportedOperationException();
	}

	public void updateOutValueOfTheBet() {
		// TODO - implement Game.updateOutValueOfTheBet
		throw new UnsupportedOperationException();
	}

}