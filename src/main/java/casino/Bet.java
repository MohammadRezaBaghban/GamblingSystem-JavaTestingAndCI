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
	 * @param InValue
	 * @param SelectedNumber
	 * @param cardInfo
	 */
	public Bet(double InValue, int SelectedNumber, String cardInfo) {
		inValue = InValue;
		selectedNumber = SelectedNumber;
		cardInformation = cardInfo;
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

	public String getId() {
		return this.id;
	}
}