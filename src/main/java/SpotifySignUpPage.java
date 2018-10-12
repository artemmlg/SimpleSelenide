import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

class SpotifySignUpPage {
    //using CSS selectors for practice
    private By emailField = By.cssSelector("input#register-email");
    private By emailConfirmField = By.cssSelector("input#register-confirm-email");
    private By passwordField = By.cssSelector("input#register-password");
    private By displayNameField = By.cssSelector("input#register-displayname");
    private By dateOfBirthMonthDropDown = By.cssSelector("select#register-dob-month");
    private By dateOfBirthDay = By.cssSelector("input#register-dob-day");
    private By dateOfBirthYear = By.cssSelector("input#register-dob-year");
    private By gender = By.cssSelector("li#li-gender input");
    private By acceptRules = By.cssSelector("input#register-thirdparty");
    private By signUpButton = By.cssSelector("a#register-button-email-submit");

    SpotifySignUpPage openPage() {
        open("/int/signup/");
        return this;
    }

    public SpotifySignUpPage typeEmail(String email) {
        $(emailField).shouldBe(visible).val(email);
        return this;
    }

    public SpotifySignUpPage typeConfirmEmail(String email) {
        $(emailConfirmField).shouldBe(visible).val(email);
        return this;
    }

    public SpotifySignUpPage typePassword(String password) {
        $(passwordField).shouldBe(visible).val(password);
        return this;
    }

    public SpotifySignUpPage typeDisplayName(String name) {
        $(displayNameField).shouldBe(visible).val(name);
        return this;
    }

    public SpotifySignUpPage selectMonthForDoB(String month) {
        $(dateOfBirthMonthDropDown).shouldBe(visible).selectOption(month);
        return this;
    }

    public SpotifySignUpPage typeDayForDoB(String day) {
        $(dateOfBirthDay).shouldBe(visible).val(day);
        return this;
    }

    public SpotifySignUpPage typeYearForDoB(String year) {
        $(dateOfBirthYear).shouldBe(visible).val(year);
        return this;
    }

    public SpotifySignUpPage selectGender(String gender) {
        if (!selected.apply(getElement(this.gender))) {
            $(this.gender).shouldBe(visible).selectRadio(gender.toLowerCase()).click();
        } else {
            System.out.println("Element: " + this.gender.toString() + "is already selected!");
        }
        return this;
    }

    public SpotifySignUpPage clickShareMyDataCheckbox(boolean check) {
        if (!selected.apply(getElement(acceptRules)) & check) {
            $(acceptRules).shouldBe(visible).click();
        } else {
            System.out.println("Element: " + acceptRules.toString() + "is already selected!");
        }
        return this;
    }

    public void clickSignUpButton() {
        $(signUpButton).shouldBe(visible).click();
    }

    /**
     * Errors Handling
     */

    public SelenideElement getErrors(String text) {
        String getErrorWithText = (".//*[@class=\'has-error\' and text()=\"%s\"]");
        return $x(String.format(getErrorWithText, text));
    }

    /**
     * Error Texts
     */

    public enum Errors {
        EMAIL_ALREADY_TAKEN("We're sorry, that email is taken."),
        EMAIL_NOT_MATCH("Email address doesn't match."),
        SHORT_PASSWORD("Your password is too short."),
        EMPTY_DISPLAY_NAME("What should we call you?"),
        INVALID_DAY_OF_DOB("Please enter a valid day of the month."),
        INVALID_YEAR_OF_DOB("Sorry, but you don't meet Spotify's age requirements."),
        MISSING_CAPTCHA("Please confirm you're not a robot.");

        private String error;

        Errors(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }
    }
}