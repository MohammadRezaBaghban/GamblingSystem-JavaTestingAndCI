package casino;

import org.junit.jupiter.api.Test;

public class GamblingMachineTest {

    /**
     * Placing a bet when the betRound has been assigned throw BetExeption
     */
    @Test //Direct Input
    public void PlaceBet_theBetRoundHasBeenAlreadyAssigned_ThrowBetException(){

    }

    /**
     * When gamblerCard Is Not Valid then Throw Illegal Argument Exception
     *
     * <p>
     *     Call the method in BankTeller and give it the inValid Card Credntials
     *     And then an Illegal Argument Exception would be thrown.
     * </p>
     */
    @Test //Indirect Output
    public void PlaceBet_gamblerCardIdIsNotValid_ThrowIllegalArgumentException(){

    }

    /**
     * When the bet amount is more than the credit on gambler's card, throw exception
     */
    @Test //Indirect Output
    public void PlaceBet_gamblerCardDoesNotHaveEnoughBalance_ThrowsBalanceInsufficientException(){

    }

    /**
     * Verify the amount of bet has been substractedFrom GamblerCard credit
     */
    @Test //Indirect Output
    public void PlaceBet_OnHavingEnoughCredit_TheWithdrawMethodWouldBeCalled(){

    }

    /**
     * On Having All the requirements, A bet instance is created and be added to list of Bets
     */
    @Test //Indirect Output
    public void PlaceBet_OnHavingValidCardAndEnoughCredit_CreateAndAddBetTotheRoundlistOfBet(){

    }

    /**
     * If the listOfBets Of Current Round be empty then it should not not be possible to create a Betting Round
     */
    @Test
    //Direct Input
    public void createBetRound_OnEmptylistOfBetOfCurrentRound_ThrowBetException(){

    }

    /**
     * As start the game round, the createBet Round of Game would be called with ListOfBets as its arguments
     */
    @Test
    //Indirect Outpus
    public void createBetRound_OnHavingListOfBet_CallCreateBettingRoundOfGameWithListOfBets(){

    }

    /**
     *
     */
}