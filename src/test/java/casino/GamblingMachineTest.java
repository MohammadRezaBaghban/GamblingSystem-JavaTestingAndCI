package casino;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class GamblingMachineTest {

    private GamblingMachine gamblingMachineSUT_object;
    private BankTeller bankTeller_MockedObject;
    private Game game_MockedObject;
    private String Valid_GamblerCard_ID = UUID.randomUUID().toString();


    @BeforeEach
    public void Setup(){
        game_MockedObject = mock(Game.class);
        bankTeller_MockedObject = mock(BankTeller.class);
        gamblingMachineSUT_object = new GamblingMachine(game_MockedObject,bankTeller_MockedObject);
    }

    /**
     * throw BetNotificationException on placing a bet when the betRound has already been assigned
     */
    @Test //Direct Input
    public void placeBet_whentheBetRoundHasAlreadyFinished_ThrowNotificationException() throws NotificationException {

        //Act
        gamblingMachineSUT_object.createBetRound();

        //Assert
        Assertions.assertThrows(NotificationException.class,()->{
            gamblingMachineSUT_object.placeBet("test",20,40);
        },"Bets cannot be placed after bettingRound being finished");

    }



    /**
     * When gamblerCard Is Not Valid then Throw NotificationException
     *
     * <p>
     *     Call the method in BankTeller and give it the inValid Card Credntials
     *     And then an NotificationException  would be thrown.
     * </p>
     */
    @Test //Indirect Output
    public void placeBet_gamblerCardIdIsNotValid_ThrowNotificationException(){
        //Arrange
        when(bankTeller_MockedObject.getGamblingCard("first")).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(NotificationException.class,()->{
            gamblingMachineSUT_object.placeBet("first",20,2);},
                "Invalid GamblerCard place a bet");
    }


    /**
     * A NotificationException should be throw, when a GamblerCard wants to put more than one Bet On the specific BetRound
     */
    @Test
    //Direct Outputs
    public void placeBet_AGamblerCardPutMoreThanOneBetOnSpecificBetRound_ThrowNotificationException(){

        //Arrange
        //when(bankTeller_MockedObject.getGamblingCard("first")).thenReturn(null);

        //Act

        //Assert


    }


    /**
     * When the bet amount is more than the credit on gambler's card, throw NotificationException
     *
     */
    @Test //Indirect Output
    public void placeBet_gamblerCardDoesNotHaveEnoughBalance_ThrowsBalanceInsufficientNotificationException(){

        //Arrange

        //Act

        //Assert


    }


    /**
     * Verify the amount of bet has been subtractedFrom GamblerCard credit
     */
    @Test //Indirect Output
    public void placeBet_OnHavingEnoughCredit_TheWithdrawMethodWouldBeCalled(){

        //Arrange

        //Act

        //Assert

    }


    /**
     * On Having All the requirements, A bet instance is created and be added to list of Bets
     */
    @Test //Indirect Output
    public void placeBet_OnHavingValidCardAndEnoughCredit_CreateAndAddBetTotheRoundlistOfBet(){

        //Arrange

        //Act

        //Assert

    }


    /**
     * Create a betRound make the currentBetRound in FinishedStatus
     */
    @Test //Direct Inputs
    public void createBetRound_WhenTheBetRoundHasNotFinished_MakeBettingImpossible(){
        //Act
        gamblingMachineSUT_object.createBetRound();

        //Assert
        Assertions.assertTrue(gamblingMachineSUT_object.IsRoundFinished()==true,"The Gambling Machine does not terminate betting option");
    }

    /**
     * If the listOfBets Of Current Round be empty then it should not not be possible to create a Betting Round
     */
    @Test
    //Direct Input
    public void createBetRound_OnEmptylistOfBetOfCurrentRound_ThrowBetNotificationException(){

        //Arrange

        //Act

        //Assert

    }


    /**
     *  the GamblingMachine createBetround method can not be called twice
     *
     *  <p>
     *      when the current betRound of GamblingMachine has been assigned,
     *      It should not be possible for requesting to create new one until
     *      the betRound would processed by reward method and new round would be started.
     *  </p>
     */
    @Test
    public void createBetRound_DuplicateCallingOfMethodWhileBetRoundHasNotBeenProcessed_ThrowNotificationException(){

        //Arrange

        //Act

        //Assert

    }


    /**
     * As start the game round, the createBet Round of Game would be called with ListOfBets as its arguments
     */
    @Test
    //Indirect Output
    public void createBetRound_OnHavingListOfBet_CallCreateBettingRoundOfGameWithListOfBets(){

        //Arrange

        //Act

        //Assert

    }


    /**
     * throw notificationException on calling of reward method when the game round has not been closed.
     */
    //Direct Output
    public void reward_OnCallingWhenBetRoundHasNotBeenFinished_ThrowNotificationException(){

        //Arrange

        //Act

        //Assert

    }


    /**
     * It will check the GamblingMachine roundStatus if it is true as representation of starting of new game round
     */
    //Direct Output
    public void reward_OnCallForReward_theGameBecomeReadyForAnotherRound(){

        //Arrange

        //Act

        //Assert
    }


    /**
     * Check if the prize of betRound would be sent to gamblerCard by bankTeller
     */
    //Indirect Output
    public void reward_OnCall_theBankTellerCallDepositMethodWithCorrectGamblerCardID(){

        //Arrange

        //Act

        //Assert

    }


}