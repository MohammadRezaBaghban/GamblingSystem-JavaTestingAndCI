package casino;

import java.util.Date;

public class Bet {

	private String id;
	private Date time;
	private double inValue;
	private double outValue;
	private boolean inValueStatus = false;
	private boolean outValueStatus = false;
	private String cardInformation;
	private Integer selectedNumber;

	/**
	 * 
	 * @param inValue
	 * @param selectedNumber
	 * @param cardInfo
	 */
	public Bet(double inValue, int selectedNumber, String cardInfo) {
		// TODO - implement Bet.Bet
		throw new UnsupportedOperationException();
	}

	public double getInValue() {
		return this.inValue;
	}

	/**
	 * 
	 * @param inValue
	 */
	public void setInValue(double inValue) {
		this.inValue = inValue;
	}

	public Integer getSelectedNumber() {
		return this.selectedNumber;
	}

	public double getOutValue() {
		return this.outValue;
	}

	/**
	 * 
	 * @param outValue
	 */
	public void setOutValue(double outValue) {
		this.outValue = outValue;
	}

	public String getCardInformation() {
		return this.cardInformation;
	}

}