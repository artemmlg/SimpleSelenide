import org.junit.Test;
import pages.SpotifySignUpPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class SpotifySignUpTest extends BaseTest {
    private SpotifySignUpPage spotifySignUpPage = new SpotifySignUpPage();

    @Test
    public void testNegativeValuesRegistration() {
        spotifySignUpPage.openPage()
                .typeEmail("asd@asd.com")
                .typeConfirmEmail("sad@sad.com")
                .typePassword("1")
                .typeDisplayName(" ")
                .selectMonthForDoB("December")
                .typeDayForDoB("99")
                .typeYearForDoB("9999")
                .selectGender("Male")
                .clickShareMyDataCheckbox(true)
                .clickSignUpButton();
        //Assertions
        for (SpotifySignUpPage.Errors errorHandler : SpotifySignUpPage.Errors.values()) {
            spotifySignUpPage.getErrors(errorHandler.getError())
                    .shouldBe(visible)
                    .shouldHave(text(errorHandler.getError()));
        }
    }
}
