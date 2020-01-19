package casino;

import java.util.Date;
import java.util.List;

public class GamblerCard {

	/**
	 * The Initial amount is determined on the assignment of the card to gambler by bank teller
	 */
	private double initialAmount;
	private Date timeStamp;
	private List<String> listOfBet;
	private String cardID;
	private boolean assignedStatus;
	private double credit;

	public GamblerCard(){
		assignedStatus = false;
		cardID =  java.util.UUID.randomUUID().toString();
	}

	/**
	 * A getter method for taking InitialAmount that card has been created with
	 * @return The initial amount that gambler charge on its assignment
	 */
	public double getInitialAmount() {
		return this.initialAmount;
	}

	/**
	 * A getter method for taking the timeStamp of the moment that card has been given to a Gambler
	 * @return The last moment that the card has been assigned to a gambler
	 */
	public Date getTimeStamp() {
		return this.timeStamp;
	}

	/**
	 * A getter method for accessing the list of bets that gambler has been made
	 * @return List of bets that the Gambler has been made with card
	 */
	public List<String> getListOfBet() {
		return this.listOfBet;
	}

	/**
	 * A getter method for accessing the unique id of gambler card
	 * @return The unique ID of gambler card
	 */
	public String getCardID() {
		return this.cardID;
	}

	/**
	 * A getter method for checking if the card has been assigned to a person or not
	 * @return boolean status of card assignment to a gambler
	 */
	public boolean getAssignedStatus() {
		return this.assignedStatus;
	}

	/**
	 * A getter method for retrieving the current balance of gambler card
	 * @return the current balance of gamblerCard
	 */
	public double getCredit() {
		return this.credit;
	}

	/**
	 * Check out the gambler card to make it ready for new assignment
	 *
	 * <p>
	 *     Reset the timestamp, initial amount and credit to zero
	 *     and clear list of bets.
	 * </p>
	 */
	public void checkOut() throws NotificationException {
		if(assignedStatus){

		}else{
			throw new NotificationException("It is not possible to checkout an unassigned card");
		}
	}



	/**
	 * Change the current Balance of card
	 *
	 * <p>
	 *     Throws an NotificationException on providing negative amount
	 * </p>
	 *
	 * @param amount should be positive value.
	 */
	public boolean setCredit(double amount) {
		// TODO - implement GamblerCard.setCredit
		throw new UnsupportedOperationException();
	}

	/**
	 * Add a new bet to BetList of gambler card
	 *
	 * <p>
	 *     It will check if the gamblerCard has not the given bet Id in its betList
	 *     On not having that, it will
	 * </p>
	 * @param betId
	 */
	public void addBet(String betId) {
		// TODO - implement GamblerCard.addBet
		throw new UnsupportedOperationException();
	}


	/**
	 * Generate a statement including all the information upon the status of GamblerCard
	 * @return status of of gambler card
	 */
	public String ToString() {
		// TODO - implement GamblerCard.ToString
		throw new UnsupportedOperationException();
	}

	public void AssignCard(int i) {
	}
}