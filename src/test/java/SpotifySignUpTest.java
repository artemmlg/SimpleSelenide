import com.codeborne.selenide.Condition;
import org.junit.Test;

public class SpotifySignUpTest extends BaseTest {
    private SpotifySignUpPage spotifySignUpPage = new SpotifySignUpPage();

    @Test public void testNegativeValuesRegistration(){
    spotifySignUpPage.openPage()
            .typeEmail("asd@asd.com")
            .typeConfirmEmail("sad@sad.com")
            .typePassword("1")
            .typeDisplayName(" ")
            .selectMonthForDoB("December")
            .typeDayForDoB("99")
            .typeYearForDoB("9999")
            .selectGender("Male")
            .clickShareMyDataCheckbox()
            .clickSignUpButton();
        for (SpotifySignUpPage.Errors errorHandler : SpotifySignUpPage.Errors.values()) {
            spotifySignUpPage.getErrors(errorHandler.getError())
                    .shouldBe(Condition.visible)
                    .shouldHave(Condition.text(errorHandler.getError()));
        }
    }
}
