package casino;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class BankTeller implements IBetLoggingAuthority {

	private List<GamblerCard> listOfGamblerCard;
	private IBetLoggingAuthority logger;
	private GamblingAuthority gamblingAuthority;
	/**
	 * This class is responsible for managing gambling card information and logging all the activities.
	 */
	public BankTeller(IBetLoggingAuthority logger, GamblingAuthority gamblingAuthority) {
		this.logger = logger;
		this.gamblingAuthority = gamblingAuthority;
		this.listOfGamblerCard = new ArrayList<>();
	}

	/**
	 * The total amount of money credit is physically handed to the gambler
	 * This method also logs the GamblingCard information.
	 */
	public void CashOut(String gamblerCardID) throws NotificationException {
		this.logger.Log("/log.txt", gamblerCardID);
		this.clearCard(gamblerCardID);
	}

	/**
	 * Get the list of all gambler cards
	 */
	public List<GamblerCard> getListOfGamblerCard() {
		return listOfGamblerCard; // to satisfy the compiler
	}

	/**
	 *
	 * @param listOfGamblerCard
	 */
	public void setListOfGamblerCard(List<GamblerCard> listOfGamblerCard) {
		this.listOfGamblerCard = listOfGamblerCard;
	}

	/**
	 * It sets the initial value of the card's credit and set it's status as assigned.
	 * @param gamblerCardId
	 * @param amount
	 */
	public boolean assignCard(String gamblerCardId, double amount, Timestamp timestamp) throws NotificationException {
		if(isGamblerCardValid(gamblerCardId))
		{
			GamblerCard gamblerCard = getGamblingCard(gamblerCardId);
			if(gamblerCard.getAssignedStatus())
				throw new NotificationException("Card already assigned.");
			gamblerCard.AssignCard(amount, timestamp);
			return true;
		}
		return false;
	}

	/**
	 * This method clears the betID's stored in it  and the amount making card anonymous, and can be reused.
	 * @param gamblerCardID
	 */
	public void clearCard(String gamblerCardID) throws NotificationException {
		if(isGamblerCardValid(gamblerCardID)){
			GamblerCard gamblerCard = this.getGamblingCard(gamblerCardID);
			gamblerCard.setCredit(0.0);
			gamblerCard.checkOut();
		}
		else
			throw new NotificationException("gamblerCard is Invalid.");
	}

	/**
	 * returns the GamblingCard object if the gamblerCardID exists in the gamblingCardList.
	 * otherwise returns null
	 * @param gamblerCardID
	 * @return
	 */
	public GamblerCard getGamblingCard(String gamblerCardID) {
		GamblerCard card = null;
		for(GamblerCard c : listOfGamblerCard)
			if (c.getCardID().equals(gamblerCardID))
				card = c;
		return card;
	}

	/**
	 * check the current amount for specific person
	 * @param gamblerCardID
	 * @param amount
	 */
	public boolean checkCredit(String gamblerCardID, double amount) {
		if (isGamblerCardValid(gamblerCardID))
		{
			GamblerCard gamblerCard = getGamblingCard(gamblerCardID);
			double rest = gamblerCard.getCredit() - amount;
			if(rest>=0)
				return true;
		}
		return false;
	}

	/**
	 * tops up the card with amount
	 * @param gamblerCardID
	 * @param amount
	 */
	public void deposit(String gamblerCardID, double amount) throws NotificationException {
		if(amount < 0.0)
			throw new NotificationException("Amount cannot be negative.");
		if(isGamblerCardValid(gamblerCardID)) {
			GamblerCard gamblerCard = getGamblingCard(gamblerCardID);
			gamblerCard.setCredit(amount);
		}
	}

	/**
	 * withdraw amount from the card by cashier.
	 * @param gamblerCardID
	 * @param amount
	 */
	public void withdraw(String gamblerCardID, double amount) throws NotificationException {
		GamblerCard gamblerCard = getGamblingCard(gamblerCardID);
		if(gamblerCard.getCredit()>=amount)
			gamblerCard.setCredit(gamblerCard.getCredit()-amount);
		else
			throw new NotificationException("Not sufficient balance on card.");
	}

	/**
	 * Add bet to the Gambler card
	 * @param gamblerCardID
	 * @param bet
	 */
	public void AddBetToGamblerCard(String gamblerCardID, Bet bet) throws NotificationException {
		if(!isGamblerCardValid(gamblerCardID))
			throw new NotificationException("Card is not valid.");
		GamblerCard gamblerCard = getGamblingCard(gamblerCardID);
		gamblerCard.addBet(bet.getId());
	}

	public Bet getBet(String betId){
		return null; //to satisfy compiler
	}

	public boolean isGamblerCardValid(String gamblerCardID) {
		if(this.getGamblingCard(gamblerCardID)!=null)
			return true;
		return false;
	}

	@Override
	public void Log(String filePath, String info) {

	}

	public void addCard(GamblerCard gamblerCard) {
		this.listOfGamblerCard.add(gamblerCard);
	}
}