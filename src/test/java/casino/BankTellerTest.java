package casino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Not;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BankTellerTest {
        BankTeller bankTeller;
        IBetLoggingAuthority iBetLoggingAuthority;
        GamblingAuthority gamblingAuthority;
    @BeforeEach
    void beforeEach() {
        iBetLoggingAuthority = mock(IBetLoggingAuthority.class);
        gamblingAuthority = mock(GamblingAuthority.class);
        bankTeller = new BankTeller(iBetLoggingAuthority,gamblingAuthority);
    }

    /**
     * This test checks if CashOut method invokes the ClearCard() method with right parameter.
     * GamblerCard object is mocked and added to the SUT.(Type: indirect input)
     */
    @Test
    void CashOut_ShouldSetAmountToZeroWhenGamblerCashOut() throws NotificationException {
        //arrange
        String gamblerCardId = "a2u7wqe3r4";
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(gamblerCardId);
        bankTeller.addCard(gamblerCard);

        //act
        bankTeller.CashOut(gamblerCardId);

        //assert
        verify(gamblerCard).setCredit(0.0);
    }

    /**
     * If the card Id is not valid. It should return false.
     */
    @Test
    void isGamblerCardValid_ShouldReturnFalseIfCardIsInValid(){
        //arrange
        String validGamblerCardId = "a2u7wqe3r4";
        String InvalidGamblerCardId = "ndu7wqe3r7";
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(validGamblerCardId);
        bankTeller.addCard(gamblerCard);
        //act
        boolean expected = bankTeller.isGamblerCardValid(InvalidGamblerCardId);
        //assert
        assertFalse(expected, "Expected result is false but got true.");
    }

    /**
     *This test checks if the card information is logged.
     * It will verify if the log method is called with right parameters.
     * mocked object of GamblingAuthority class is used to spy the logging of card information.
     * Type: indirect output
     */
    @Test
    void CashOut_MethodShouldLogCardInformation() throws NotificationException {
        //arrange
        String validGamblerCardId = "a2u7wqe3r4";
        String validPath = "/log.txt";
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(validGamblerCardId);
        bankTeller.addCard(gamblerCard);
        //act
        bankTeller.CashOut(validGamblerCardId);
        //assert
        verify(iBetLoggingAuthority).Log(validPath, validGamblerCardId);
    }

    /**
     *if the card is not valid, NotificationException is expected.
     */
    @Test
    void CashOut_ShouldThrowExceptionIfCardIsNotValid() throws NotificationException {
        //arrange
        String validGamblerCardId = "a2u7wqe3r4";
        String InvalidGamblerCardId = "ndu7wqe3r7";
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(validGamblerCardId);
        bankTeller.addCard(gamblerCard);

        //act
        //assert
        assertThrows(NotificationException.class, () -> {
           bankTeller.CashOut(InvalidGamblerCardId);
        },"gamblerCardId is not valid");
    }

    /**
     *This method should return true if it has enough amount with the valid Card number.
     * It uses the mock object of GamblerCard which returns valid card number and amount as specified.
     * Type: indirect input
     */
    @Test
    public void CheckCredit_ShouldReturnTrueIfCardHasEnoughAmountWithValidCardNumber() {
        //arrange
        String validGamblerCardId = "a2u7wqe3r4";
        Double validAmount = 20.0;
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(validGamblerCardId);
        when(gamblerCard.getCredit()).thenReturn(validAmount);
        bankTeller.addCard(gamblerCard);
        //act
        boolean result = bankTeller.checkCredit(validGamblerCardId, validAmount);
        //assert
        assertTrue(result, "return value true expected but false is returned.");
    }

    /**
     *This method should return false if it has enough amount with the valid Card number.
     * It uses the mock object of GamblerCard which returns valid card number and amount as specified.
     * Type: indirect input
     */
    @Test
    public void CheckCredit_ShouldReturnFalseIfCardDoesNotHaveEnoughAmountWithValidCardNumber() {
        //arrange
        String validGamblerCardId = "a2u7wqe3r4";
        Double validAmount = 20.0;
        Double higherAmount = 25.0;
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(validGamblerCardId);
        when(gamblerCard.getCredit()).thenReturn(validAmount);
        bankTeller.addCard(gamblerCard);
        //act
        boolean result = bankTeller.checkCredit(validGamblerCardId, higherAmount); //amount greater than the validAmount is supplied.
        //assert
        assertFalse(result, "return value false expected but true is returned.");
    }


    /**
     * While clearCard() method is invoked at the Bank Teller. It should clear the amount of the card and set it to zero.
     * Type: indirect input
     */
    @Test
    public void clearCard_CardAmountShouldBeZeroAfterCheckingOut() throws NotificationException {
        //arrange
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
     * This method will assure if the amount is added to the card
     * after the gambler deposit certain amount.
     * Type: indirect input
     */
    @Test
    public void deposit_GamblerShouldBeAbleToDepositAmountToTheCard() throws NotificationException {
        //arrange
        String gamblerCardId = "a2u7wqe3r4";
        Double validAmount = 20.0;
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(gamblerCardId);
        bankTeller.addCard(gamblerCard);

        //act
        bankTeller.deposit(gamblerCardId, validAmount);

        //assert
        verify(gamblerCard).setCredit(validAmount);
    }

    /**
     * This test checks if it throws an exception when negative amount is supplied.
     * @throws NotificationException
     * Type: direct input
     */
    @Test
    public void deposit_InputAmountMustNotBeZero_ThrowsException() throws NotificationException {
        //arrange
        String gamblerCardId = "a2u7wqe3r4";
        Double validAmount = -20.0;
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(gamblerCardId);
        bankTeller.addCard(gamblerCard);

        //act
        assertThrows(NotificationException.class, ()-> bankTeller.deposit(gamblerCardId, validAmount), "when negative amount is supplied. NotificationException is expected.");
    }

    /**
     * This method will assure if the amount is deducted from the card
     * after the gambler withdraw certain amount.
     * Type: indirect input
     */
    @Test
    public void withdraw_GamblerShouldBeAbleToWithdrawAmountFromTheCard() throws NotificationException {
        //arrange
        String gamblerCardId = "a2u7wqe3r4";
        Double validAmount = 20.0;
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(gamblerCardId);
        bankTeller.addCard(gamblerCard);

        //act
        bankTeller.withdraw(gamblerCardId, validAmount);

        //assert
        verify(gamblerCard).withdrawCredit(validAmount);
    }
    /**
     * At calling the withdraw() method with higher amount It should throw Exception.
     * It also should not deduct the amount If the amount is more than the amount it has.
     * @throws NotificationException
     */
    @Test
    public void withdraw_GamblerShouldNotBeAbleToWithdrawHigherAmountThanItHas() throws NotificationException {
        //arrange
        String gamblerCardId = "a2u7wqe3r4";
        Double validAmount = 20.0;
        Double higherAmount = 25.0;
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(gamblerCardId);
        when(gamblerCard.getCredit()).thenReturn(validAmount);
        bankTeller.addCard(gamblerCard);

        //act
        //assert
        assertThrows(NotificationException.class, ()->bankTeller.withdraw(gamblerCardId,higherAmount), "Expected: If the amount is higher than the balance. It should throw NotificationException." +
                "Result: No or Another type of exception is thrown. ");
    }

    /**
     * At calling this test method, It will assure if the addBet method is called with right parameter.
     * Mocked objects of Bet and GamblerCard will be used in this case.
     * Type: indirect output
     */
    @Test
    public void addBet_BankTellerShouldBeAbleToAddBetIntoTheCard() throws NotificationException {
        //arrange
        String gamblerCardId = "a2u7wqe3r4";
        String validBetId = "jas54k";
        GamblerCard gamblerCard = mock(GamblerCard.class);
        Bet bet = mock(Bet.class);
        when(bet.getId()).thenReturn(validBetId);
        when(gamblerCard.getCardID()).thenReturn(gamblerCardId);
        bankTeller.addCard(gamblerCard);

        //act
        bankTeller.AddBetToGamblerCard(gamblerCardId, bet);

        //assert
        verify(gamblerCard).addBet(validBetId);
    }

    /**
     *
     */
    @Test
    void addBet_ShouldThrowExceptionIfCardIsNotValid() throws NotificationException {
        //arrange
        String gamblerCardId = "a2u7wqe3r4";
        String invalidGamblerCardId = "jas54k";
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(gamblerCardId);
        Bet bet = mock(Bet.class);
        bankTeller.addCard(gamblerCard);

        //act
        bankTeller.AddBetToGamblerCard(gamblerCardId, bet);
        //assert
        assertThrows(NotificationException.class, ()->bankTeller.AddBetToGamblerCard(invalidGamblerCardId,bet), "Expected: If the gambler card is not valid. It should throw NotificationException." +
                "Result: No or Another type of exception is thrown. ");
    }

    /**
     * At calling this method, If the card is already assigned It should throw exception.
     * Type: indirect input
     */
    @Test
    public void assignCard_BankTellerShouldNotBeAbleToAssignCardWhichIsAlreadyAssigned() {
        //arrange
        String gamblerCardId = "a2u7wqe3r4";
        Double validAmount = 20.0;
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(gamblerCardId);
        bankTeller.addCard(gamblerCard);

        //act
        bankTeller.assignCard(gamblerCardId, validAmount); // assigned already.

        //assert
        assertThrows(NotificationException.class, ()->bankTeller.assignCard(gamblerCardId, validAmount));// trying to assign the sameCard again.
    }

    /**
     * At calling this method, It assigns the card to the gambler.
     * Type: indirect input
     */
    @Test
    public void assignCard_BankTellerShouldBeAbleToAssignCard() {
        //arrange
        String gamblerCardId = "a2u7wqe3r4";
        Double validAmount = 20.0;
        GamblerCard gamblerCard = mock(GamblerCard.class);
        when(gamblerCard.getCardID()).thenReturn(gamblerCardId);
        bankTeller.addCard(gamblerCard);

        //act
        bankTeller.assignCard(gamblerCardId, validAmount);

        //assert
        verify(gamblerCard).setCredit(validAmount);
        verify(gamblerCard).setAssignedStatus();
    }

}