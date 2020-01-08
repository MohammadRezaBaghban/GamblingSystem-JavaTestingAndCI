package casino;

public interface IBetTokenAuthority {

	/**
	 * 
	 * @param bettingRound
	 */
	String getToken(BettingRound bettingRound);

}