package casino;

import java.util.Map;

public class GamblingMachine implements IGamblingMachine {
	private BettingRound betRound;
	private BankTeller bankTeller;
	private String machineID;
	private Map<Bet, String> listOfBetsOfCurrentRound;
	private Game game;

	/**
	 * Place the bet on the current betRound of the game on the Game Machine
	 *
	 * <p>
	 * On the placing the bet this method is going to be called to make the bet
	 * <ol>
	 *     <li>
	 *         Check if the betRound is null as representation of the game has not been started
	 *     </li>
	 *     <li>
	 *     		Check if the GamblerCard is valid and assigned.
	 *     </li>
	 *     <li>
	 *      	Check if the Gambler has enough credit for the bet amount
	 *     </li>
	 *     <li>
	 *         	Withdraw the amount of bet from gamblerCard credit
	 *     </li>
	 *     <li>
	 *         	Create a Bet instance and add it to list of bets of current round.
	 *     </li>
 *     </ol>
	 * </p>
	 * @param gamblerCardID the unique GamblerCardId that the bet is placing with it
	 * @param amount the amount of money that gambler want to put on the bet
	 * @param selectedNumber the selected number among options that the gambler put the bet on it.
	 */
	public boolean placeBet(String gamblerCardID, double amount, Integer selectedNumber) {
		// TODO - implement GamblingMachine.placeBet
		throw new UnsupportedOperationException();
	}

	/**
	 * Create the Bet Round as the representation of Start the Game by passing the list of Bet to game of Machine
	 * @return Betting Round that has been created and its winned would be determined
	 */
	public BettingRound createBetRound() {
		// TODO - implement GamblingMachine.createBetRound
		throw new UnsupportedOperationException();
	}


	/**
	 * On the finishing of the Game round it will request for the
	 */
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