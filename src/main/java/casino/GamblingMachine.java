package casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GamblingMachine implements IGamblingMachine {
	private BettingRound betRound;
	private BankTeller bankTeller;
	private String machineID;
	public Map<Bet, String> listOfBetsOfCurrentRound;
	private Game game;




	/**
	 *
	 * @param gameObject
	 * @param banktellerObject
	 */
	public GamblingMachine(Game gameObject, BankTeller banktellerObject) {
		listOfBetsOfCurrentRound = new HashMap<>();
		this.bankTeller = banktellerObject;
		this.game = gameObject;
		betRound = null;
	}

	/**
	 * return true if
	 */
	public boolean IsRoundFinished() {
		if(betRound==null){
			return false;
		}else{
			return true;
		}
	}

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
	 * @exception throw NotificationException <p> if the betRound has already assigned as a representation of valid time
	 * to place a bet has already finished</p>
	 * @exception throw NotificationException when the gambler card is not valid
	 * @exception throw NotificationException when the user does not have enough credit for bet amount
	 * @exception throw NotificationException when a GamblerCard want to put more than one bet on a BetRound
	 */
	public boolean placeBet(String gamblerCardID, double amount, Integer selectedNumber) throws Exception {

		GamblerCard card = new GamblerCard();
		if(this.IsRoundFinished()){

			throw new NotificationException("Bets cannot be placed after bettingRound being finished");

		}else if(bankTeller.getGamblingCard(gamblerCardID)==null){

			throw new NotificationException("The Card is Invalid for placing a bet");

		} else {

			if(listOfBetsOfCurrentRound.containsValue(gamblerCardID)){

				throw new NotificationException("It is not possible to put more than one bet per gamblerCard on each Game Round");

			}else if(!bankTeller.checkCredit(gamblerCardID,amount)){

				throw new NotificationException("Balance is insufficient for this amount of bet");

			}else{
				bankTeller.withdraw(gamblerCardID,amount);
				Bet bet = new Bet(amount,selectedNumber,bankTeller.getGamblingCard(gamblerCardID).toString());
				listOfBetsOfCurrentRound.putIfAbsent(bet,gamblerCardID);
				return true;
			}
		}
	}

	/**
	 * Create the Bet Round as the representation of Start the Game by passing the list of Bet to game of Machine
	 * @return Betting Round that has been created and its winned would be determined
	 * @exception throws NotificationException on the empty list of bets of current round
	 * @exception throws NotificationException if the betRound Object of the Gambling machine has already been assigned
	 */
	public BettingRound createBetRound() throws NotificationException {

		if(getNumberOfBetsInBettingRound()<1){
			throw new NotificationException("It is not possible createBet when there is no bet in betRound");
		}else{
			if(betRound!=null){
				throw new NotificationException("It is not possible to start another betRound before this betround being processed");
			}else{
				betRound = game.createBetRound(listOfBetsOfCurrentRound);
				return  betRound;
			}

		}

	}

	/**
	 * Give the number of element in the listOfBetsOfGameRound
	 */
	public int getNumberOfBetsInBettingRound(){
		return listOfBetsOfCurrentRound.size();
	}

	/**
	 * On the finishing of the Game round and generation of BetRound, it will process it and renew the game
	 *
	 * <p>
	 *     This method is responsible for doing following actions:
	 *     <ol>
	 *         <li>It will loop for the each  bets in the current round and check if the outValue is positive in order to deposit the prize to gambler card</li>
	 *         <li> Reinitialize the list of bets of current round and assign null to the current betroundObject attribute</li>
	 *     </ol>
	 *
	 * </p>
	 * @exception throw NotificationException when the BetRound object has not been assigned.
	 */
	public void reward() throws NotificationException {
		if(IsRoundFinished()){
			listOfBetsOfCurrentRound.forEach((bet, s)->{
				if (bet.getSelectedNumber()==betRound.getWinNr()){
					try {
						bankTeller.deposit(s,bet.getInValue()*2);
					} catch (NotificationException e) {
						e.printStackTrace();
					}
				}
			});
		}else{
			throw new NotificationException("It is not possible start reward process until having the the GameRound finish");
		}

	}



}