package casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class GamblerCardTest {

    public GamblerCard GamblerCard_SUT_Object;
    public Timestamp Valid_AssignmentMoment;

    @Before
    public void Setup(){
        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();
        Valid_AssignmentMoment = Timestamp.valueOf(LocalDateTime.now());
    }

    /**
     * An exciting AssignCard cannot be reassign
     */
    //Direct Input
    @Test
    public void AssignCard_OnAssigningAnAssignedCard_ThrowNotificationException() throws NotificationException {

        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();
        GamblerCard_SUT_Object.AssignCard(100, Valid_AssignmentMoment);

        //Act and Assert
        Assertions.assertThrows(NotificationException.class,
                ()->{GamblerCard_SUT_Object.AssignCard(0, Valid_AssignmentMoment);},
                "An already assigned Gambler Card cannot be reassigned before checkout"
        );
    }

    /**
     * AssignCard to a Gambler with an initialAmount less than 5 euro throw NotificationException
     */
    //Direct Input
    @Test
    public void AssignCard_OnProvidingNegativeAmount_ThrowNotificationException(){

        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();

        //Act and Assert
        Assertions.assertThrows(NotificationException.class,
                ()->{GamblerCard_SUT_Object.AssignCard(0, Valid_AssignmentMoment);},
                "A Gambler Card cannot be assigned with an initial amount less than 5 euros"
        );
    }

    /**
     * Assigning an unassigned card with a value more than or equal to 5 make the card assigned
     */
    @Test //DirectInput //DirectOutPut
    public void AssignCard_OnSuccessfullCardAssigning_ValuesOfCardBeSetCorrectly() throws NotificationException {

        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();

        //Act
        GamblerCard_SUT_Object.AssignCard(200,Valid_AssignmentMoment);


        //Assert
        Assert.assertTrue("The InitialAmount is not being set correctly",GamblerCard_SUT_Object.getInitialAmount()==200);
        Assert.assertTrue("The Credit is not being set correctly",GamblerCard_SUT_Object.getCredit()==200);
        Assert.assertTrue("The bet list is not clear correctly",GamblerCard_SUT_Object.getListOfBet().size()==0);
        Assert.assertTrue("The timeStamp is not correctly set",GamblerCard_SUT_Object.getTimeStamp()==Valid_AssignmentMoment);
        Assert.assertTrue("The Gambler assigned status is set to True",GamblerCard_SUT_Object.getAssignedStatus() == true);
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
        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();
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
    public void checkOut_CheckOutCardSuccessfully_ResetItsDetails() throws NotificationException {

        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();
        GamblerCard_SUT_Object.AssignCard(100, Valid_AssignmentMoment);


        //Act
        GamblerCard_SUT_Object.checkOut();

        //Assert
        Assert.assertTrue("Initial amount was not rested",GamblerCard_SUT_Object.getInitialAmount()==0);
        Assert.assertTrue("The credit was not rested",GamblerCard_SUT_Object.getCredit()==0);
        Assert.assertTrue("The timestamp was not cleared",GamblerCard_SUT_Object.getTimeStamp()==null);
        Assert.assertTrue("The list of bets was not cleared",GamblerCard_SUT_Object.getListOfBet()==null);
        Assert.assertTrue("The Gambler assigned status is not reseted to false",GamblerCard_SUT_Object.getAssignedStatus()==false);


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
    //direct Input and direct output
    public void setCredit_OnValidAmount_CreditChangeAndReturnTrue() throws NotificationException {

        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();

        //Act
        Boolean result = GamblerCard_SUT_Object.setCredit(10);

        //Assert
        Assert.assertTrue("The credit is not set correctly", GamblerCard_SUT_Object.getCredit() ==10);
        Assert.assertTrue("It return false incorrectly",result=true);
    }

    /**
     * On Calling setCredit Method Invalid Amount (negative), throw a IllegalExceptionOperation
     */
    @Test
    //Indirect Inputs
    public void setCredit_OvInvalidAmount_ThrowIllegalOperationException(){

        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();

        //Act & Act
        Assertions.assertThrows(NotificationException.class,()->{
            GamblerCard_SUT_Object.setCredit(-1);
        });

    }

    /**
     * On Adding Non Duplicate Bet, The Bet Would Be Added To BetList
     *
     * Check if the number of items in betList has been increased our not.
     */
    @Test
    //Indirect Inputs
    public void addBet_OnAddingNonDuplicateBet_TheBetWouldBeAddedToBetList() throws NotificationException {

        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();
        GamblerCard_SUT_Object.AssignCard(200,Valid_AssignmentMoment);

        //Act
        GamblerCard_SUT_Object.addBet("1");
        GamblerCard_SUT_Object.addBet("2");
        GamblerCard_SUT_Object.addBet("3");
        GamblerCard_SUT_Object.addBet("4");
        //Assert
        Assert.assertTrue("bet was not added successfully", GamblerCard_SUT_Object.getListOfBet().size()==4);

    }

    /**
     * On Adding Duplicate Bet Throw Illegal Operation
     */
    @Test
    //Indirect Inputs
    public void addBet_OnAddingDuplicateBet_ThrowIllegalOperation() throws NotificationException {

        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();
        GamblerCard_SUT_Object.AssignCard(200,Valid_AssignmentMoment);

        //Act
        GamblerCard_SUT_Object.addBet("1");


        //Assert
        Assertions.assertThrows(NotificationException.class, ()->
        {
            GamblerCard_SUT_Object.addBet("1");
        },"The card is adding duplicate bets to correct illegally");

    }


    /**
     * On calling to string method on an unassigned Gambler, the string should show this
     */
    @Test //Direct Output
    public void ToString_OnCallingAnUnAssignedCard_IncludesAllImportantDetailOfGamblercard() throws NotificationException {
        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();

        //Act
        String result = GamblerCard_SUT_Object.toString();

        //Assert
        Assert.assertTrue("The format is not correct", GamblerCard_SUT_Object.toString()=="Card with cardId of "+GamblerCard_SUT_Object.getCardID()+" is unassigned");
    }

    /**
     * On calling to string method on an assigned Gambler, the string includes all the Gambler card details
     */
    @Test //Direct Output
    public void ToString_OnCallingAnAssignedCard_IncludesAllImportantDetailOfGamblercard() throws NotificationException {

        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();
        GamblerCard_SUT_Object.AssignCard(200,Valid_AssignmentMoment);

        //Act
        String result = GamblerCard_SUT_Object.toString();


        //Assert
        Assert.assertTrue("CardId is not included",result.contains(GamblerCard_SUT_Object.getCardID()));
        Assert.assertTrue("Credit is not included",result.contains(Double.toString(GamblerCard_SUT_Object.getCredit())));
        Assert.assertTrue("InitialCredit is not included",result.contains(Double.toString(GamblerCard_SUT_Object.getInitialAmount())));
        Assert.assertTrue("TimeStamp is not included",result.contains(GamblerCard_SUT_Object.getTimeStamp().toString()));
        Assert.assertTrue("Number of Bet is not included",result.contains(Integer.toString(GamblerCard_SUT_Object.getListOfBet().size())));


    }


}