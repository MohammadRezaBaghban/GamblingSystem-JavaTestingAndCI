package casino;

import java.util.Date;
import java.util.List;

public class GamblerCard {

	/**
	 * The Initial amount is determined on the assignment of the card to gambler by bank teller
	 */
	private double initialAmount;
	/**
	 * initial amount is stored on the card, together with a timestamp
	 */
	private Date timeStamp;
	/**
	 * list of all generated betIDs is stored on the card
	 */
	private List<String> listOfBet;
	private String cardID;
	private boolean assignedStatus;
	private double credit;

	public double getInitialAmount() {
		return this.initialAmount;
	}

	public Date getTimeStamp() {
		return this.timeStamp;
	}

	public List<String> getListOfBet() {
		return this.listOfBet;
	}

	/**
	 * Get the gambler card's id
	 */
	public String getCardID() {
		return null; // to satisfy the compiler
	}

	/**
	 * The stored betID's on the card are also removed. The card become anonymous and can be reused.
	 */
	public void checkOut() {

	}

	/**
	 * check the status of the card
	 */
	public boolean getAssignedStatus() {
		return true; // to satisfy the compiler
	}

	/**
	 * total amount of money credit handed to gambler
	 */
	public double getCredit() {
		return 0.0; // to satisfy the compiler
	}

	/**
	 * top up the money to the card
	 * @param amount
	 */
	public boolean setCredit(double amount) {
		return true; // to satisfy the compiler
	}

	/**
	 * the person who makes the bet with unique bet id
	 * @param betId
	 */
	public void addBet(String betId) {

	}

	/**
	 * returns the string with all the information in order to log it.
	 */
	@Override
	public String toString() {
		return "GamblerCard{" +
				"initialAmount=" + initialAmount +
				", timeStamp=" + timeStamp +
				", listOfBet=" + listOfBet +
				", cardID='" + cardID + '\'' +
				", assignedStatus=" + assignedStatus +
				", credit=" + credit +
				'}';
	}
}