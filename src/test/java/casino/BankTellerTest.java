package casino;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTellerTest {

    @Before
    public void setUp() throws Exception {
    }

    /**
     *This method should return true if it has enough amount with the valid Card number.
     * It uses the mock object of GamblerCard which returns valid card number and amount as specified.
     */
    @Test
    public void ShouldReturnTrueIfCardHasEnoughAmountWithValidCardNumber() {
        //arrange
        //act
        //assert
    }

    /**
     *This method should return false if it has enough amount with the valid Card number.
     * It uses the mock object of GamblerCard which returns valid card number and amount as specified.
     */
    @Test
    public void ShouldReturnFalseIfCardDoesNotHaveEnoughAmountWithValidCardNumber() {
        //arrange
        //act
        //assert
    }

    /**
     * This method checks if the given card number is invalid it should throw an exception.
     * It uses the mock object of GamblerCard which returns valid card number.
     * @throws Exception
     */
    @Test
    public void ShouldThrowExceptionIfInvalidCardNumberIsSupplied() throws Exception {
        //arrange
        //act
        //assert
    }

    /**
     * While Gambler checks out at the Bank Teller. It should clear the amount of the card and set it to zero so the card can
     * be reused.
     */
    @Test
    public void CardAmountShouldBeZeroAfterCheckingOut() {
        //arrange
        //act
        //assert
    }

    /**
     * This method will assure if the amount is added to the card
     * after the gambler deposit certain amount.
     */
    @Test
    public void GamblerShouldBeAbleToDepositAmountToTheCard() {
        //arrange
        //act
        //assert
    }

    /**
     * This method will assure if the amount is deducted from the card
     * after the gambler withdraw certain amount.
     */
    @Test
    public void GamblerShouldBeAbleToWithdrawAmountFromTheCard() {
        //arrange
        //act
        //assert
    }
    /**
     * At calling the withdraw() method with higher amount It should throw Exception.
     * It also should not deduct the amount If the amount is more than the amount it has.
     */
    @Test
    public void GamblerShouldNotBeAbleToWithdrawHigherAmountThanItHas() {
        //arrange
        //act
        //assert
    }

    /**
     * At calling this test method, It will assure if the addBet method is called with right parameter.
     * Mocked objects of Bet and GamblerCard will be used in this case.
     */
    @Test
    public void BankTellerShouldBeAbleToAddBetIntoTheCard() {
        //arrange
        //act
        //assert
    }

    /**
     * At calling this method, If the card is already assigned It should throw exception.
     */
    @Test
    public void BankTellerMustNotBeAbleToAssignedCardWhichIsAlreadyAssigned() {
        //arrange
        //act
        //assert
    }
}