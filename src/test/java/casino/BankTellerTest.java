package casino;

import org.junit.jupiter.api.Test;

public class BankTellerTest {


    /**
     *This method should return true if it has enough amount with the valid Card number.
     * It uses the mock object of GamblerCard which returns valid card number and amount as specified.
     * Type: indirect input
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
     * Type: indirect input
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
     * Type: indirect input
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
     * Type: indirect input
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
     * Type: indirect input
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
     * Type: indirect input
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
     * Type: indirect input
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
     * Type: indirect output
     */
    @Test
    public void BankTellerShouldBeAbleToAddBetIntoTheCard() {
        //arrange
        //act
        //assert
    }

    /**
     * At calling this method, If the card is already assigned It should throw exception.
     * Type: indirect input
     */
    @Test
    public void BankTellerMustNotBeAbleToAssignedCardWhichIsAlreadyAssigned() {
        //arrange
        //act
        //assert
    }
}