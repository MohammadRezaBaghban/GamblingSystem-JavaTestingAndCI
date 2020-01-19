package casino;

import org.mockito.internal.matchers.Not;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class GamblingAuthority implements IBetTokenAuthority, IBetLoggingAuthority {

	/**
	 * list of all the bets created by game.
	 */
	private List<Bet> listOfBets;
	/**
	 * list of all the bettingRound.
	 */
	private List<BettingRound> listOfBettingRound;
	/**
	 * Instance of Logger interface for logging all the bets and betting round.
	 */
	private IBetLoggingAuthority logger;

	public GamblingAuthority() {
		listOfBets = new ArrayList<>();
		listOfBettingRound = new ArrayList<>();
	}

	/**
	 * This method also logs this request.
	 * @param bet
	 */
	public void addBet(Bet bet) {
		if(bet==null)
			throw new NullPointerException("Bet Can not be NUll");
		this.listOfBets.add(bet);
	}

	/**
	 * it returns the unique token for the betting round and it should check the token status.
	 * This method also logs this request.
	 * @param bettingRound
	 */
	public String getToken(BettingRound bettingRound) throws NotificationException {
		if(bettingRound==null)
			throw new NotificationException("Betting Round Can not be NUll");
		String id =  UUID.randomUUID().toString();
		return id;
	}

	/**
	 * 
	 * @param bettingRound
	 */
	public void addBettingRound(BettingRound bettingRound) {
		listOfBettingRound.add(bettingRound);
	}

	/**
	 * it returns the whole integer as winning number. it should check the token status.
	 * This method also logs this request.
	 * @param bettingRound
	 */
	public int getWinNo(BettingRound bettingRound) {
		return 0; // to satisfy the compiler
	}

	@Override
	public void Log(String filePath, String info) {
		// logging
	}

	public ArrayList<Bet> getBetList() {
		ArrayList<Bet> tempList = (ArrayList<Bet>) this.listOfBets;
		return tempList;
	}
}