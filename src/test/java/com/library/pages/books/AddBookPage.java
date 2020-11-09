package com.library.pages.books;

import com.library.Utilities.BrowserUtilities;
import com.library.Utilities.Driver;
import com.library.pages.BasePage;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;

public class AddBookPage extends BasePage {

    @FindBy (xpath = "//span[text()='Dashboard']")
    private WebElement dashboardPage; // a page withing library.com

    @FindBy (xpath = "//span[text()='Books']")
    private WebElement booksPage; // a page withing library.com

    @FindBy (xpath = "//span[text()='Users']")
    private WebElement usersPage; // a page withing library.com

    @FindBy (xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")
    private WebElement addBookBtn;

    // Book Form Fields
    @FindBy (xpath = "//input[@placeholder='Book Name']")
    private WebElement bookNameField;

    @FindBy (xpath = "//input[@placeholder='Author']")
    private WebElement bookAuthorField;

    @FindBy (xpath = "//input[@placeholder='ISBN']")
    private WebElement bookIsbnField;

    @FindBy (xpath = "//input[@placeholder='Year']")
    private WebElement bookYearField;

    @FindBy (xpath = "//button[.='Save changes']")
    private WebElement saveChangesBtn;

    @FindBy (xpath = "//input[@class='form-control input-sm input-small input-inline']")
    private WebElement searchBox;

    public void navigateTo (String pageName) {
        if (pageName.equalsIgnoreCase("dashboard")) {
            dashboardPage.click();
        } else if (pageName.equalsIgnoreCase("users")) {
            usersPage.click();
        } else if (pageName.equalsIgnoreCase("books")) {
            booksPage.click();
        } else {
            System.out.println("Could not find such page to navigate to! Check page name!");
        }
    }

    public void clickAddBookBtn(){
        BrowserUtilities.wait(1);
        addBookBtn.click();
        BrowserUtilities.wait(1);
    }

    private String bookName = "Three cups of tea";
    private String bookAuthor = "Isa";
    private String ISBN = "11222";
    private String bookYear = "2020";

    public void fillOutBookForm () {
        bookNameField.clear();
        bookNameField.sendKeys(bookName);
        bookAuthorField.click();
        bookAuthorField.sendKeys(bookAuthor);
        bookIsbnField.click();
        bookIsbnField.sendKeys(ISBN);
        bookYearField.click();
        bookYearField.sendKeys(bookYear);
        BrowserUtilities.wait(2);
        saveChangesBtn.click();
    }

    public ArrayList<String> expectedBookInfo() {
        ArrayList<String> expectedBookInfo = new ArrayList<>();
        expectedBookInfo.addAll(Arrays.asList(ISBN, bookName, bookAuthor, "Action and Adventure", bookYear));
        return expectedBookInfo;
    }



    public ArrayList<String> actualBookInfo () {
        ArrayList<String> bookInfo = new ArrayList<>();
        BrowserUtilities.wait(1);
        searchBox.sendKeys(bookName);
        BrowserUtilities.wait(1);
        for (int i=2; i<7; i++) {
            bookInfo.add(Driver.getDriver().findElement(By.xpath("//td[.='"+bookYear+"']/../td["+i+"]")).getText());
        }
        return bookInfo;
    }


}
