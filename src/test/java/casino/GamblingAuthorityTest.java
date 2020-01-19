package casino;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GamblingAuthorityTest {
    private List<String> uniqueToken = new ArrayList<>();
    /**
     * This test method check if it returns unique token string.
     * Type: direct output
     */
    @Test
    @RepeatedTest(9)
    public void getToken_ShouldReturnUniqueTokenString() throws NotificationException {
        //arrange
        boolean isUnique = true;
        GamblingAuthority authority = new GamblingAuthority();
        BettingRound round = mock(BettingRound.class);

        //act
        String result = authority.getToken(round);
        if(uniqueToken.contains(result))
            isUnique=false;
        this.uniqueToken.add(result);

        //assert
        assertTrue(isUnique,"Token generated by getToken() is not unique.");
    }

    /**
     * Checks if the method throws exception when null value of BettingRound is submitted.
     * @throws NotificationException
     */
    @Test
    void getToken_BettingRoundMustNotBeNull_throwsException() throws NotificationException {
        //arrange
        GamblingAuthority authority = new GamblingAuthority();
        //act
        //assert
        assertThrows(NotificationException.class, ()->authority.getToken(null), "No exception or Another type of exception is thrown.");
    }

    /**
     * This method should check if addBet() method adds bet object to the list.
     */
    @Test
    public void addBet_ShouldAddBetToTheList() {
        //arrange
        GamblingAuthority authority = new GamblingAuthority();
        Bet bet = mock(Bet.class);

        //act
        authority.addBet(bet);

        //assert
        assertTrue(authority.getBetList().size()>0);
    }

    /**
     *
     */
    @Test
    void addBet_BetCannotBeNull_throwNullPointerException() {
        //arrange
        GamblingAuthority authority = new GamblingAuthority();
        //act
        //assert
        assertThrows(NullPointerException.class, ()->authority.addBet(null),"Bet cannot be null.");
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