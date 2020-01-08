package casino;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Date;
import static org.junit.Assert.*;

public class GamblingMachineTest {


    /**
     * throw BetNotificationException on placing a bet when the betRound has already been assigned
     */
    @Test //Direct Input
    public void placeBet_theBetRoundHasBeenAlreadyAssigned_ThrowNotificationException(){

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

    }

    /**
     * A NotificationException should be throw, when a GamblerCard wants to put more than one Bet On the specific BetRound
     */
    @Test
    //Direct Outputs
    public void placeBet_AGamblerCardPutMoreThanOneBetOnSpecificBetRound_ThrowNotificationException(){

    }


    /**
     * When the bet amount is more than the credit on gambler's card, throw NotificationException
     *
     */
    @Test //Indirect Output
    public void placeBet_gamblerCardDoesNotHaveEnoughBalance_ThrowsBalanceInsufficientNotificationException(){

    }


    /**
     * Verify the amount of bet has been subtractedFrom GamblerCard credit
     */
    @Test //Indirect Output
    public void placeBet_OnHavingEnoughCredit_TheWithdrawMethodWouldBeCalled(){

    }


    /**
     * On Having All the requirements, A bet instance is created and be added to list of Bets
     */
    @Test //Indirect Output
    public void placeBet_OnHavingValidCardAndEnoughCredit_CreateAndAddBetTotheRoundlistOfBet(){

    }


    /**
     * If the listOfBets Of Current Round be empty then it should not not be possible to create a Betting Round
     */
    @Test
    //Direct Input
    public void createBetRound_OnEmptylistOfBetOfCurrentRound_ThrowBetNotificationException(){

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

    }


    /**
     * As start the game round, the createBet Round of Game would be called with ListOfBets as its arguments
     */
    @Test
    //Indirect Output
    public void createBetRound_OnHavingListOfBet_CallCreateBettingRoundOfGameWithListOfBets(){

    }


    /**
     * throw notificationException on calling of reward method when the game round has not been closed.
     */
    //Direct Output
    public void reward_OnCallingWhenBetRoundHasNotBeenFinished_ThrowNotificationException(){

    }


    /**
     * It will check the GamblingMachine roundStatus if it is true as representation of starting of new game round
     */
    //Direct Output
    public void reward_OnCallForReward_theGameBecomeReadyForAnotherRound(){}


    /**
     * Check if the prize of betRound would be sent to gamblerCard by bankTeller
     */
    //Indirect Output
    public void reward_OnCall_theBankTellerCallDepositMethodWithCorrectGamblerCardID(){

    }


}