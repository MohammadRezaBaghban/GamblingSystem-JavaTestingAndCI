package casino;
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
		return null; // to satisfy the compiler
	}

	/**
	 *
	 * @param listOfGamblerCard
	 */
	public void setListOfGamblerCard(List<GamblerCard> listOfGamblerCard) {
		this.listOfGamblerCard = listOfGamblerCard;
	}

	/**
	 * Check if the amount is assigned
	 * @param amount
	 */
	public boolean assignCard(double amount) {
		return true; // to satisfy the compiler
	}

	/**
	 * This method clears the betID's stored in it  and the amount making card anonymous, and can be reused.
	 * @param gamblerCardID
	 */
	public void clearCard(String gamblerCardID) throws NotificationException {
		if(isGamblerCardValid(gamblerCardID)){
			GamblerCard gamblerCard = this.getGamblingCard(gamblerCardID);
			gamblerCard.setCredit(0.0);
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
	private GamblerCard getGamblingCard(String gamblerCardID) {
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
	public void deposit(String gamblerCardID, double amount) {

	}

	/**
	 * withdraw amount from the card by cashier.
	 * @param gamblerCardID
	 * @param amount
	 */
	public void withdraw(String gamblerCardID, double amount) {

	}

	/**
	 * Add bet to the Gambler card
	 * @param gamblerCardID
	 * @param bet
	 */
	public void AddBetToGamblerCard(String gamblerCardID, Bet bet) {

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