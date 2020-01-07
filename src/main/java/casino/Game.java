package casino;

import java.util.Map;

public class Game {

	private boolean multipleBet;
	private GamblingAuthority gamblingAuthority;
	private BettingRound currentBetRound;
	private Map<Bet, String> listOfBets;
	private int nrOfWinNumber;


	/**
	 * constructe of the betting round
	 * @param gamblingAuthority
	 */
	public Game(GamblingAuthority gamblingAuthority, int nrOfWinNumber) {
		// TODO - implement Game.Game
		throw new UnsupportedOperationException();
	}

	/**
	 *Create the bettinground method
	 * @param listOfBets
	 */
	public BettingRound createBetRound(Map<Bet, String> listOfBets) {
		// TODO - implement Game.createBetRound
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
	 * this method also logging the betting round with timestamp
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

	/**
	 * it should check the update method
	 *this method also logging the betting round with timestamp
	 */

	public void updateOutValueOfTheBet() {
		// TODO - implement Game.updateOutValueOfTheBet
		throw new UnsupportedOperationException();
	}

}