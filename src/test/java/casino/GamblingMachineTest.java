package casino;


import org.hamcrest.core.Is;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Not;

import java.util.UUID;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
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
     *  on placing a bet when the betRound has already been assigned, throw BetNotificationException
     */
    @Test //Direct Input
    public void placeBet_whentheBetRoundHasAlreadyFinished_ThrowNotificationException() throws Exception {

        //Arrange
        createBetRound_Setup();
        when(game_MockedObject.createBetRound(gamblingMachineSUT_object.listOfBetsOfCurrentRound)).thenReturn(mock(BettingRound.class));

        //Act
        gamblingMachineSUT_object.createBetRound();

        //Assert
        Exception exceptionThrown = Assertions.assertThrows(NotificationException.class,()->{
            gamblingMachineSUT_object.placeBet("test",20,40);});
        Assertions.assertTrue(exceptionThrown.getMessage().equals("Bets cannot be placed after bettingRound being finished"));
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
     * When the bet amount is more than the credit on gambler's card, throw NotificationException
     *
     */
    @Test //Indirect Output
    public void placeBet_gamblerCardDoesNotHaveEnoughBalance_ThrowsBalanceInsufficientNotificationException(){
        //Arrange
        when(bankTeller_MockedObject.getGamblingCard("first")).thenReturn(mock(GamblerCard.class));
        when(bankTeller_MockedObject.checkCredit("first",20)).thenReturn(false);

        //Act and Assert
        Exception exceptionThrown = Assertions.assertThrows(NotificationException.class,()->{
            gamblingMachineSUT_object.placeBet("first",20,20);
        });
        Assertions.assertTrue(exceptionThrown.getMessage().equals("Balance is insufficient for this amount of bet"));
        verify(bankTeller_MockedObject,times(1)).checkCredit("first",20);
    }


    /**
     *  when a GamblerCard wants to put more than one Bet On the specific BetRound, A NotificationException should be throw
     */
    @Test
    //Direct Outputs
    public void placeBet_AGamblerCardPutMoreThanOneBetOnSpecificBetRound_ThrowNotificationException() throws Exception {

        //Arrange
        when(bankTeller_MockedObject.getGamblingCard("first")).thenReturn(mock(GamblerCard.class));
        when(bankTeller_MockedObject.checkCredit("first",20)).thenReturn(true);
        when(bankTeller_MockedObject.getGamblingCard("first").toString()).thenReturn("sth");

        //Act
        gamblingMachineSUT_object.placeBet("first",20,20);

        //Assert
        Exception exceptionThrown = Assertions.assertThrows(NotificationException.class,()->{
            gamblingMachineSUT_object.placeBet("first",20,20);
        });
        Assertions.assertTrue(exceptionThrown.getMessage().equals("It is not possible to put more than one bet per gamblerCard on each Game Round"));

    }

    /**
     * Verify the amount of bet has been subtractedFrom GamblerCard credit
     */
    @Test //Indirect Output & Indirect Input
    public void placeBet_OnHavingEnoughCredit_TheWithdrawMethodWouldBeCalled() throws Exception {

        //Arrange
        createBetRound_Setup();

        //Assert
        verify(bankTeller_MockedObject,times(1)).withdraw("first",20);
    }


    /**
     * On Having All the requirements, A bet instance is created and be added to list of Bets
     */
    @Test //Indirect Output & IndirectInput - Matcher Hamcerast
    public void placeBet_OnHavingValidCardAndEnoughCredit_CreateAndAddBetTotheRoundlistOfBet() throws Exception {
        //Arrange
        createBetRound_Setup();

        //Assert
        assertThat("The bet was not added to list of bets of game round",gamblingMachineSUT_object.getNumberOfBetsInBettingRound(), is(1));
    }


    /**
     * If the listOfBets Of Current Round be empty then it should not not be possible to create a Betting Round
     */
    @Test
    //Direct Input
    public void createBetRound_OnEmptylistOfBetOfCurrentRound_ThrowBetNotificationException(){
        //Act & Assert
        Exception exceptionThrown = Assertions.assertThrows(NotificationException.class,()->{
            gamblingMachineSUT_object.createBetRound();
        });
        Assertions.assertTrue(exceptionThrown.getMessage().equals("It is not possible createBet when there is no bet in betRound"));
    }

    /**
     * Create a betRound mark the Game round status as finished and make it impossible to put another bet.
     */
    @Test //Direct Inputs
    public void createBetRound_WhenTheBetRoundHasNotFinished_MakeBettingImpossible() throws Exception {

        //Arrange
        createBetRound_Setup();
        when(game_MockedObject.createBetRound(gamblingMachineSUT_object.listOfBetsOfCurrentRound)).thenReturn(mock(BettingRound.class));
        //Act
        gamblingMachineSUT_object.createBetRound();

        //Assert
        Assertions.assertTrue(gamblingMachineSUT_object.IsRoundFinished()==true,"The Gambling Machine does not terminate betting option");
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
    public void createBetRound_DuplicateCallingOfMethodWhileBetRoundHasNotBeenProcessed_ThrowNotificationException() throws Exception {
        //Arrange
        when(game_MockedObject.createBetRound(gamblingMachineSUT_object.listOfBetsOfCurrentRound)).thenReturn(mock(BettingRound.class));
        reward_Setup();

        //Act & Assert
        Exception exceptionThrown = Assertions.assertThrows(NotificationException.class,()->{
            gamblingMachineSUT_object.createBetRound();
        });
        Assertions.assertTrue(exceptionThrown.getMessage().equals("It is not possible to start another betRound before this betround being processed"));
    }


    /**
     * throw notificationException on calling of reward method when the game round has not been closed.
     */
    @Test
    public void reward_OnCallingWhenBetRoundHasNotBeenFinished_ThrowNotificationException(){
        //Act & Assert
        Exception exceptionThrown = Assertions.assertThrows(NotificationException.class,()->{
            gamblingMachineSUT_object.reward();
        });
        Assertions.assertTrue(exceptionThrown.getMessage().equals("It is not possible start reward process until having the the GameRound finish"));

    }


    /**
     * Check if the prize of betRound would be sent to gamblerCard by bankTeller
     */
    //Indirect Output
    @Test
    public void reward_OnCall_theBankTellerCallDepositMethodWithCorrectGamblerCardID() throws Exception {

        //Arrange
        GamblerCard card = mock(GamblerCard.class);
        when(card.getCardID()).thenReturn("first");
        when(bankTeller_MockedObject.getGamblingCard("first")).thenReturn(card);
        when(bankTeller_MockedObject.checkCredit("first",20)).thenReturn(true);
        when(bankTeller_MockedObject.getGamblingCard("first").toString()).thenReturn("sth");

        Boolean result = gamblingMachineSUT_object.placeBet("first",20,20);


        BettingRound bettingRound = mock(BettingRound.class);
        when(bettingRound.getWinNr()).thenReturn(20);
        when(game_MockedObject.createBetRound(gamblingMachineSUT_object.listOfBetsOfCurrentRound)).thenReturn(bettingRound);
        gamblingMachineSUT_object.createBetRound();


        //Act
        gamblingMachineSUT_object.reward();

        //Assert
        verify(bankTeller_MockedObject,times(1)).deposit(card.getCardID(),40);

    }

    /**
     * It will make the GamblingMachine Ready Again for another Gaming Round
     */
    //Direct Output
    @Test
    public void reward_OnCallForReward_theGameBecomeReadyForAnotherRound() throws Exception {

        //Arrange
        GamblerCard card = mock(GamblerCard.class);
        when(card.getCardID()).thenReturn("first");
        when(bankTeller_MockedObject.getGamblingCard("first")).thenReturn(card);
        when(bankTeller_MockedObject.checkCredit("first",20)).thenReturn(true);
        when(bankTeller_MockedObject.getGamblingCard("first").toString()).thenReturn("sth");

        Boolean result = gamblingMachineSUT_object.placeBet("first",20,20);


        BettingRound bettingRound = mock(BettingRound.class);
        when(bettingRound.getWinNr()).thenReturn(20);
        when(game_MockedObject.createBetRound(gamblingMachineSUT_object.listOfBetsOfCurrentRound)).thenReturn(bettingRound);
        gamblingMachineSUT_object.createBetRound();


        //Act
        gamblingMachineSUT_object.reward();

        //Assert
        Assertions.assertTrue(gamblingMachineSUT_object.getNumberOfBetsInBettingRound()==0);
        assertThat(gamblingMachineSUT_object.IsRoundFinished(), not(true));

    }




    // A set arrangement that is needed to able to call reward method to avoid Repeating Yourself
    public void reward_Setup() throws Exception {
        when(bankTeller_MockedObject.getGamblingCard("first")).thenReturn(mock(GamblerCard.class));
        when(bankTeller_MockedObject.checkCredit("first",20)).thenReturn(true);
        when(bankTeller_MockedObject.getGamblingCard("first").toString()).thenReturn("sth");
        Boolean result = gamblingMachineSUT_object.placeBet("first",20,20);
        gamblingMachineSUT_object.createBetRound();
    }

    //A set of arrangement that is needed to able to call createBetRound method to avoid Repeating Yourself
    public void createBetRound_Setup() throws Exception {
        when(bankTeller_MockedObject.getGamblingCard("first")).thenReturn(mock(GamblerCard.class));
        when(bankTeller_MockedObject.checkCredit("first",20)).thenReturn(true);
        when(bankTeller_MockedObject.getGamblingCard("first").toString()).thenReturn("sth");
        Boolean result = gamblingMachineSUT_object.placeBet("first",20,20);
    }


}