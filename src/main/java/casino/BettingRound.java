package casino;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class BettingRound {

	private String bettingRoundID;
	private List<Bet> listOfBets;
	private String token = null;
	private Date timeStamp;
	private HashSet<Integer> winNumber;//there is not duplicate win number
	private boolean winNrStatus = false;
	private boolean tokenStatus = false;
	private int nrOfValidWiningNr;

	/**
	 * Create the construte of the bettinground
	 * @param listOfBets
	 */
	public BettingRound(List<Bet> listOfBets, int nrOfValidWiningNr) {
		// TODO - implement BettingRound.BettingRound
		throw new UnsupportedOperationException();
	}

	/**
	 * Get the betting round ID
	 * @return
	 */
	public String getBettingRoundID() {
		return this.bettingRoundID;
	}

	/**
	 * we use the token attribute to check if it has already assigned or not.
	 * Null - not assigned, anything else assigned.
	 */
	public boolean setToken() {
		// TODO - implement BettingRound.setToken
		throw new UnsupportedOperationException();
	}

	public boolean getTokenStatus() {
		return this.tokenStatus;
	}

	/**
	 * add the win number to the betting round, responding with game property
	 * @param winNr
	 */
	public boolean AddWinNr(Integer winNr) {
		// TODO - implement BettingRound.setWinNr
		throw new UnsupportedOperationException();
	}

	/**
	 * check the win number of the betting round
	 * @return
	 */
	public boolean IsWinNr(int number) {
		// TODO - implement BettingRound.getWinNr
		throw new UnsupportedOperationException();
	}

}