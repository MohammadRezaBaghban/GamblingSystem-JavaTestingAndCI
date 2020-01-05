package casino;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Date;
import static org.junit.Assert.*;

public class GamblerCardTest {

    /**
     * CheckOut An Unassigned Card Throws Illegal Operation Exception
     *
     * If a gambler card that has not been assigned to an gambler wants to checkout
     * a IllegalOperation should be thrown
     */
    @Test
    public void checkOut_CheckOutAnUnassignedCard_ThrowsIllegalOperationException(){

    }

    /**
     * Check Out Card Successfully will result in Reset the Details of GamblerCard
     *
     * <p>
     *     It supposed to check if the credit, assignedStatus, listOfBet,initialAmount and timeStamp
     *     would be rested successfully on the performing the checkout operation on Card.
     * </p>
     */
    @Test
    public void checkOut_CheckOutCardSuccessfully_ResetItsDetails(){

    }

    /**
     * On Valid Amount, Credit change and return true;
     *
     * <p>
     *     On calling the method check if the amount is valid (positive)
     *     credit has been change successfully And return true
     * </p>
     */
    @Test
    public void setCredit_OnValidAmount_CreditChangeAndReturnTrue(){

    }

    /**
     * On Calling setCredit Method Invalid Amount (negative), throw a IllegalExceptionOperation
     */
    @Test
    public void setCredit_OvInvalidAmount_ThrowIllegalOperationException(){

    }

    /**
     * On Adding Non Duplicate Bet, The Bet Would Be Added To BetList
     *
     * Check if the number of items in betList has been increased our not.
     */
    @Test
    public void addBet_OnAddingNonDuplicateBet_TheBetWouldBeAddedToBetList(){

    }

    /**
     * On Adding Duplicate Bet Throw Illegal Operation
     */
    @Test
    public void addBet_OnAddingDuplicateBet_ThrowIllegalOperation(){

    }

    /**
     * On calling to string method, the string includes all the Gambler card details
     */
    @Test
    public void ToString_OnCalling_IncludesAllImportantDetailOfGamblercard(){

    }


}