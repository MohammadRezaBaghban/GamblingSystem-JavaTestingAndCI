package casino;

import org.junit.jupiter.api.Test;

public class GamblingAuthorityTest {
    /**
     * This test method check if it returns unique token string.
     * Type: direct output
     */
    @Test
    public void getToken_ShouldReturnUniqueTokenString() {
        //arrange
        //act
        //assert
    }

    /**
     * Checks if the method throws exception when null value of BettingRound is submitted.
     * @throws NotificationException
     */
    @Test
    void getToken_BettingRoundMustNotBeNull_throwsException() throws NotificationException {
        //arrange
        //act
        //assert
    }

    /**
     * This method should check if addBet() method adds bet object to the list.
     * Type: indirect output
     */
    @Test
    public void addBet_ShouldAddBetToTheList() {
        //arrange
        //act
        //assert
    }

    /**
     * Checks if the method throws exception when null value of BettingRound is submitted.
     * @throws NotificationException
     */
    @Test
    public void addBet_BetMustNotBeNull() throws NotificationException {
        //arrange
        //act
        //assert
    }

    /**
     * This method should check if addBettingRound() method adds to the list.
     * Type: indirect output
     */
    @Test
    public void addBettingRound_ShouldAddBettingRoundToTheList() {
        //arrange
        //act
        //assert
    }

    /**
     * This method should check if getWinNo() method returns the number.
     * Type: direct output
     */
    @Test
    public void getWinNo_ShouldReturnWinNumber() {
        //arrange
        //act
        //assert
    }

    /**
     *This method checks if the log method is called with the right parameter.
     *
     */
    @Test
    void log_ShouldLogTokenRequest() {

    }

    /**
     * This method checks if the request is logged with the right parameter.
     */
    @Test
    void log_ShouldLogGetWinNumberRequest() {
    }
}