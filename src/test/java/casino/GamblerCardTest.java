package casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GamblerCardTest {

    GamblerCard GamblerCard_SUT_Object;
    @Before
    public void Setup(){
        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();
    }

    /**
     * CheckOut An Unassigned Card Throws Illegal Operation Exception
     *
     * If a gambler card that has not been assigned to an gambler wants to checkout
     * a IllegalOperation should be thrown
     */
    //Direct Inputs
    @Test
    public void checkOut_CheckOutAnUnassignedCard_ThrowsNotificationException(){
        // Act & Assert
        Assertions.assertThrows(NotificationException.class,

                ()->{GamblerCard_SUT_Object.checkOut();},
                "A Gambler Card cannot be checkout if it was not be assigned"
        );
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
    //Direct Inputs
    public void checkOut_CheckOutCardSuccessfully_ResetItsDetails(){

        //Arrange

        //Act

        //Assert

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
    //Indirect Inputs
    public void setCredit_OnValidAmount_CreditChangeAndReturnTrue(){

        //Arrange

        //Act

        //Assert


    }

    /**
     * On Calling setCredit Method Invalid Amount (negative), throw a IllegalExceptionOperation
     */
    @Test
    //Indirect Inputs
    public void setCredit_OvInvalidAmount_ThrowIllegalOperationException(){

        //Arrange

        //Act

        //Assert


    }

    /**
     * On Adding Non Duplicate Bet, The Bet Would Be Added To BetList
     *
     * Check if the number of items in betList has been increased our not.
     */
    @Test
    //Indirect Inputs
    public void addBet_OnAddingNonDuplicateBet_TheBetWouldBeAddedToBetList(){

        //Arrange

        //Act

        //Assert


    }

    /**
     * On Adding Duplicate Bet Throw Illegal Operation
     */
    @Test
    //Indirect Inputs
    public void addBet_OnAddingDuplicateBet_ThrowIllegalOperation(){

        //Arrange

        //Act

        //Assert


    }

    /**
     * On calling to string method, the string includes all the Gambler card details
     */
    @Test
    public void ToString_OnCalling_IncludesAllImportantDetailOfGamblercard(){

        //Arrange

        //Act

        //Assert


    }


}