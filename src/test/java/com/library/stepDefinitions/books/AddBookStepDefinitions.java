package com.library.stepDefinitions.books;

import com.library.Utilities.Driver;
import com.library.pages.books.AddBookPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;

public class AddBookStepDefinitions {
    AddBookPage addBookPage = new AddBookPage();

    @When("I navigate to {string} page")
    public void navigates_to_page(String string) {
        addBookPage.navigateTo(string);
    }

    @When("I click on Add Book button")
    public void user_clicks_on_add_book_button() {
        addBookPage.clickAddBookBtn();
        addBookPage.fillOutBookForm();
    }
    @Then("I should be able to create a Book")
    public void user_should_be_able_to_create_a_book() {
        ArrayList<String> expectedBookInfo = addBookPage.expectedBookInfo();
        ArrayList<String> actualBookInfo = addBookPage.actualBookInfo();

        System.out.println("Expected Book Information: "+expectedBookInfo);
        System.out.println("Actual Book information: "+actualBookInfo);

        Assert.assertEquals("Book Info verification Failed!", expectedBookInfo, actualBookInfo);

        Driver.closeDriver();
    }

}
