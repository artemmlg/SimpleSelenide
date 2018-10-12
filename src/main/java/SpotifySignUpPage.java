import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class SpotifySignUpPage {
    //using CSS selectors for practice
    private By emailField = By.cssSelector("input#register-email");
    private By emailConfirmField = By.cssSelector("input#register-confirm-email");
    private By passwordField = By.cssSelector("input#register-password");
    private By displayNameField = By.cssSelector("input#register-displayname");
    private By dateOfBirthMonthDropDown = By.cssSelector("select#register-dob-month");
    private By dateOfBirthDay = By.cssSelector("input#register-dob-day");
    private By dateOfBirthYear = By.cssSelector("input#register-dob-year");
    private By gender = By.cssSelector("li#li-gender");
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
        $(this.gender).shouldBe(visible).selectRadio(gender.toLowerCase());
        return this;
    }
}
