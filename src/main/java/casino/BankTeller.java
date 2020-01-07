package casino;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class BankTeller implements IBetLoggingAuthority {

	private List<GamblerCard> listOfGamblerCard;
	private IBetLoggingAuthority logger;

	/**
	 * This class is responsible for managing gambling card information and logging all the activities.
	 */
	public BankTeller() {
		this.listOfGamblerCard = new ArrayList<>();
	}

	/**
	 * The total amount of money credit is physically handed to the gambler
	 */
	public void CashOut() {

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
	public void clearCard(String gamblerCardID) {

	}

	/**
	 * check the current amount for specific person
	 * @param gamblerCardID
	 * @param amount
	 */
	public boolean checkCredit(String gamblerCardID, double amount) {
		return true; // to satisfy the compiler
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

	@Override
	public void Log(String filePath, String info) {

	}
}