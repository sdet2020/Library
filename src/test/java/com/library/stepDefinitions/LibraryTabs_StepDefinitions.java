package com.library.stepDefinitions;

import com.library.Utilities.Driver;
import com.library.pages.BasePage;
import com.library.pages.LibraryTabsPage;
import com.library.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LibraryTabs_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    LibraryTabsPage lsp = new LibraryTabsPage();

    @Given("I have logged in to Library Home Page as a {string}")
    public void i_have_logged_in_to_library_home_page_as_a(String role) {
        Driver.getDriver().get(BasePage.libraryUrl);
        loginPage.login(role);
    }

    @When("I click on {string}")
    public void i_click_on(String page) {
        lsp.clickOnPage(page);
    }
    @Then("I should land on this {string}")
    public void i_should_land_on_this(String expectedUrl) {
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals("FAILED! URL did not match!", expectedUrl, actualUrl);

        Driver.closeDriver();
    }
}
