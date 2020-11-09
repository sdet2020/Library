package com.library.stepDefinitions;

import com.library.Utilities.BrowserUtilities;
import com.library.Utilities.ConfigurationReader;
import com.library.Utilities.Driver;
import com.library.pages.BasePage;
import com.library.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("I have navigated to Library Login Page")
    public void i_have_navigated_to_vy_track_login_page() {
        Driver.getDriver().get(BasePage.libraryUrl);
    }

    @When("I enter {string} credentials")
    public void user_enters_credentials(String string) {
        loginPage.login(string);
    }

    @Then("I should land on Library Home Page")
    public void user_should_land_on_library_home_page() {
        BrowserUtilities.wait(1);
        String expectedTitle = "Library";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("Title verification Failed!", expectedTitle, actualTitle);
        Driver.closeDriver();
    }

    @When("I enter invalid {string} and {string} and click login")
    public void i_enter_invalid_and_and_click_login(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should see a message Invalid username or password")
    public void i_should_see_a_message_invalid_username_or_password() {
        String actualErrorMessage = Driver.getDriver().findElement(By.xpath("//*[@id=\"inputEmail-error\"]")).getText();
        String expectedErrorMessage = "Please enter a valid email address.";

        Assert.assertEquals("FAILED! ERROR MESSAGE DOES NOT MATCH!", actualErrorMessage, expectedErrorMessage);

        Driver.closeDriver();
    }


    @When("I enter {string} and {string} and click login")
    public void i_enter_and_and_click_login(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should see {string}")
    public void i_should_see(String currentPageTitle) {
        BrowserUtilities.waitInMills(500);
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("FAILED! Title did not match!", currentPageTitle, actualTitle);
        BrowserUtilities.waitInMills(500);

        Driver.closeDriver();
    }

}
