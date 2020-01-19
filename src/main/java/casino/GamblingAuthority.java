package casino;

import org.mockito.internal.matchers.Not;

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

	/**
	 * This method also logs this request.
	 * @param bet
	 */
	public void addBet(Bet bet) {
		// TODO - implement GamblingAuthority.addBet
		throw new UnsupportedOperationException();
	}

	/**
	 * it returns the unique token for the betting round and it should check the token status.
	 * This method also logs this request.
	 * @param bettingRound
	 */
	public String getToken(BettingRound bettingRound) throws NotificationException {
		if(bettingRound==null)
			throw new NotificationException("Betting Round Cannot be NUll");
		String id =  UUID.randomUUID().toString();
		return id;
	}

	/**
	 * 
	 * @param bettingRound
	 */
	public void addBettingRound(BettingRound bettingRound) {
		// TODO - implement GamblingAuthority.addBettingRound
		throw new UnsupportedOperationException();
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

	}
}