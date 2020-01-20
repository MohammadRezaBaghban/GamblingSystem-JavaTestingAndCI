package casino;

import org.fest.assertions.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class GamblerCardTest {

    public GamblerCard GamblerCard_SUT_Object;
    public final Timestamp Valid_AssignmentMoment = Timestamp.valueOf(LocalDateTime.now());

    @BeforeEach
    public void Setup(){
        //Arrange
        GamblerCard_SUT_Object = new GamblerCard();
    }

    /**
     * An exciting AssignCard cannot be reassign
     */
    //Direct Input
    @Test
    public void AssignCard_OnAssigningAnAssignedCard_ThrowNotificationException() throws NotificationException {
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
        //Act
        GamblerCard_SUT_Object.AssignCard(200,Valid_AssignmentMoment);


        //Assert

        Assertions.assertTrue(GamblerCard_SUT_Object.getInitialAmount()==200,"The InitialAmount is not being set correctly");
        Assertions.assertTrue(GamblerCard_SUT_Object.getCredit()==200,"The Credit is not being set correctly");
        Assertions.assertTrue(GamblerCard_SUT_Object.getListOfBet().size()==0,"The bet list is not clear correctly");
        Assertions.assertTrue(GamblerCard_SUT_Object.getTimeStamp()==Valid_AssignmentMoment,"The timeStamp is not correctly set");
        Assertions.assertTrue(GamblerCard_SUT_Object.getAssignedStatus() == true,"The Gambler assigned status is set to True");
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
    public void checkOut_CheckOutCardSuccessfully_ResetItsDetails() throws NotificationException {
        //Arrange
        GamblerCard_SUT_Object.AssignCard(100, Valid_AssignmentMoment);

        //Act
        GamblerCard_SUT_Object.checkOut();

        //Assert
        Assertions.assertTrue(GamblerCard_SUT_Object.getInitialAmount()==0,"Initial amount was not rested");
        Assertions.assertTrue(GamblerCard_SUT_Object.getCredit()==0,"The credit was not rested");
        Assertions.assertTrue(GamblerCard_SUT_Object.getTimeStamp()==null,"The timestamp was not cleared");
        Assertions.assertTrue(GamblerCard_SUT_Object.getListOfBet()==null,"The list of bets was not cleared");
        Assertions.assertTrue(GamblerCard_SUT_Object.getAssignedStatus()==false,"The Gambler assigned status is not reseted to false");




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
        //Act
        Boolean result = GamblerCard_SUT_Object.setCredit(10);

        //Assert
        Assertions.assertTrue(GamblerCard_SUT_Object.getCredit() ==10,"The credit is not set correctly");
        Assertions.assertTrue(result=true,"It return false incorrectly");
    }

    /**
     * On Calling setCredit Method Invalid Amount (negative), throw a IllegalExceptionOperation
     */
    @Test
    //Indirect Inputs
    public void setCredit_OvInvalidAmount_ThrowIllegalOperationException(){
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
    //Indirect Inputs - Matcher Hamcerast
    public void addBet_OnAddingNonDuplicateBet_TheBetWouldBeAddedToBetList() throws NotificationException {

        //Arrange
        GamblerCard_SUT_Object.AssignCard(200,Valid_AssignmentMoment);

        //Act
        GamblerCard_SUT_Object.addBet("1");
        GamblerCard_SUT_Object.addBet("2");
        GamblerCard_SUT_Object.addBet("3");
        GamblerCard_SUT_Object.addBet("4");
        //Assert
        assertThat("bet was not added successfully",GamblerCard_SUT_Object.getListOfBet().size(),is(4));


    }

    /**
     * On Adding Duplicate Bet Throw Illegal Operation
     */
    @Test
    //Indirect Inputs
    public void addBet_OnAddingDuplicateBet_ThrowIllegalOperation() throws NotificationException {

        //Arrange
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
        //Act
        String result = GamblerCard_SUT_Object.toString();

        //Assert
        Assertions.assertTrue(GamblerCard_SUT_Object.toString().equals("Card with cardId of "+GamblerCard_SUT_Object.getCardID()+" is unassigned"),"The format is not correct");
    }

    /**
     * On calling to string method on an assigned Gambler, the string includes all the Gambler card details
     */
    @Test //Direct Output - Matcher Hamcerast
    public void ToString_OnCallingAnAssignedCard_IncludesAllImportantDetailOfGamblercard() throws NotificationException {

        //Arrange
        GamblerCard_SUT_Object.AssignCard(200,Valid_AssignmentMoment);

        //Act
        String result = GamblerCard_SUT_Object.toString();


        //Assert
        assertThat("CardId is not included",result,containsString(GamblerCard_SUT_Object.getCardID()));
        assertThat("Credit is not included",result,containsString(Double.toString(GamblerCard_SUT_Object.getCredit())));
        assertThat("InitialCredit is not included",result,containsString(Double.toString(GamblerCard_SUT_Object.getInitialAmount())));
        assertThat("TimeStamp is not included",result,containsString(GamblerCard_SUT_Object.getTimeStamp().toString()));
        assertThat("Number of Bet is not included", result, containsString(Integer.toString(GamblerCard_SUT_Object.getListOfBet().size())));


    }


}