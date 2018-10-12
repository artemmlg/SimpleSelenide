import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.Test;

public class SpotifySignUpTest extends BaseTest {
    private Person person = Fairy.create().person();
    private SpotifySignUpPage spotifySignUpPage = new SpotifySignUpPage();

    @Test public void typeInvalidYear() throws InterruptedException {
    spotifySignUpPage.openPage()
            .typeEmail("asd@asd.com")
            .typeConfirmEmail("sad@sad.com")
            .typePassword("1")
            .typeDisplayName(" ")
            .selectMonthForDoB("December")
            .typeDayForDoB("99")
            .typeYearForDoB("9999")
            .selectGender("Male");
    Thread.sleep(2000);
    }
}
