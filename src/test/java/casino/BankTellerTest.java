package casino;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BankTellerTest {
    /**
     * This test checks if CashOut method invokes the ClearCard() method with right parameter.
     * GamblerCard object is mocked and added to the SUT.(Type: indirect input)
     */
    @Test
    void CashOut_ShouldSetAmountToZeroWhenGamblerCashOut() throws NotificationException {
        //arrange
        IBetLoggingAuthority iBetLoggingAuthority = mock(IBetLoggingAuthority.class);
        GamblingAuthority gamblingAuthority = mock(GamblingAuthority.class);
        BankTeller bankTeller = new BankTeller(iBetLoggingAuthority,gamblingAuthority);

        String gamblerCardId = "a2u7wqe3r4";
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(gamblerCardId);
        bankTeller.addCard(gamblerCard);

        //act
        bankTeller.clearCard(gamblerCardId);

        //assert
        verify(gamblerCard).setCredit(0.0);
    }

    /**
     * If the card Id is not valid. It should throw an exception.
     * @throws NotificationException
     */
    @Test
    void CashOut_ShouldThrowExceptionIfCardIsInValid() throws NotificationException {
        //arrange
        //act
        //assert
    }

    /**
     *This test checks if the card information is logged.
     * It will verify if the log method is called with right parameters.
     * mocked object of GamblingAuthority class is used to spy the logging of card information.
     * Type: indirect output
     */
    @Test
    void CashOut_MethodShouldLogCardInformation() {

    }


    /**
     *This method should return true if it has enough amount with the valid Card number.
     * It uses the mock object of GamblerCard which returns valid card number and amount as specified.
     * Type: indirect input
     */
    @Test
    public void CheckCredit_ShouldReturnTrueIfCardHasEnoughAmountWithValidCardNumber() {
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
    public void CheckCredit_ShouldReturnFalseIfCardDoesNotHaveEnoughAmountWithValidCardNumber() {
        //arrange
        //act
        //assert
    }

    /**
     * This method checks if the given card number is invalid it should throw an exception.
     * It uses the mock object of GamblerCard which returns valid card number.
     * Type: indirect input
     * @throws NotificationException
     */
    @Test
    public void isValid_ShouldThrowExceptionIfCardNumberIsInvalid() throws NotificationException {
        //arrange
        //act
        //assert
    }

    /**
     * While clearCard() method is invoked at the Bank Teller. It should clear the amount of the card and set it to zero.
     * Type: indirect input
     */
    @Test
    public void clearCard_CardAmountShouldBeZeroAfterCheckingOut() {
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
    public void deposit_GamblerShouldBeAbleToDepositAmountToTheCard() {
        //arrange
        //act
        //assert
    }

    /**
     * This test checks if it throws an exception when negative amount is supplied.
     * @throws NotificationException
     * Type: direct input
     */
    @Test
    public void deposit_InputAmountMustNotBeZero_ThrowsException() throws NotificationException {
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
    public void deposit_GamblerShouldBeAbleToWithdrawAmountFromTheCard() {
        //arrange
        //act
        //assert
    }
    /**
     * At calling the withdraw() method with higher amount It should throw Exception.
     * It also should not deduct the amount If the amount is more than the amount it has.
     * Type: indirect input
     * @throws Exception
     */
    @Test
    public void withdraw_GamblerShouldNotBeAbleToWithdrawHigherAmountThanItHas() throws Exception {
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
    public void addBet_BankTellerShouldBeAbleToAddBetIntoTheCard() {
        //arrange
        //act
        //assert
    }

    /**
     * At calling this method, If the card is already assigned It should throw exception.
     * Type: indirect input
     */
    @Test
    public void assignCard_BankTellerShouldNotBeAbleToAssignCardWhichIsAlreadyAssigned() {
        //arrange
        //act
        //assert
    }

    /**
     * At calling this method, It assigns the card to the gambler.
     * Type: indirect input
     */
    @Test
    public void assignCard_BankTellerShouldBeAbleToAssignCard() {
        //arrange
        //act
        //assert
    }

}