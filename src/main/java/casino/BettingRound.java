package casino;

import java.util.Date;
import java.util.List;

public class BettingRound {

	private String bettingRoundID;
	private List<Bet> listOfBets;
	private String token = null;
	private Date timeStamp;
	private Integer winNumber;
	private boolean winNrStatus = false;
	private boolean tokenStatus = false;

	/**
	 * 
	 * @param ListOfBets
	 */
	public BettingRound(List<Bet> ListOfBets) {
		listOfBets = ListOfBets;
	}

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
	 * 
	 * @param winNr
	 */
	public boolean setWinNr(Integer winNr) {
		// TODO - implement BettingRound.setWinNr
		throw new UnsupportedOperationException();
	}

	public Integer getWinNr() {
		// TODO - implement BettingRound.getWinNr
		throw new UnsupportedOperationException();
	}

}