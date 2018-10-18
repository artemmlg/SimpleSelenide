package steps;

import net.thucydides.core.annotations.Step;
import pages.SpotifySignUpPage;

public class SpotifySignUpSteps {
    SpotifySignUpPage spotifySignUpPage;

    @Step
    public void type_email(String email){
        spotifySignUpPage.typeEmail(email);
    }

    @Step
    public void type_confirmation_email(String email){
        spotifySignUpPage.typeConfirmEmail(email);
    }

    @Step
    public void type_password(String password){
        spotifySignUpPage.typePassword(password);
    }

    @Step
    public void type_display_name(String name){
        spotifySignUpPage.typeDisplayName(name);
    }

    @Step
    public void set_date_of_birth(String month, String day, String year){
        spotifySignUpPage.selectMonthForDoB(month);
        spotifySignUpPage.typeDayForDoB(day);
        spotifySignUpPage.typeYearForDoB(year);
    }

    @Step
    public void select_dender(String gender){
        spotifySignUpPage.selectGender(gender);
    }

    @Step
    public void select_share_checkbox(boolean share){
        spotifySignUpPage.clickShareMyDataCheckbox(share);
    }

    @Step
    public void select_sign_up_button(){
        spotifySignUpPage.clickSignUpButton();
    }


}
