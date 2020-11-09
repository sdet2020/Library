package com.library.pages;

import com.library.Utilities.BrowserUtilities;
import com.library.Utilities.ConfigurationReader;
import com.library.Utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    @FindBy (id = "inputEmail")
    private WebElement usernameInput;

    @FindBy (id = "inputPassword")
    private WebElement passwordInput;

    @FindBy (xpath = "//title")
    private WebElement pageTitle;

    private String username = ConfigurationReader.getProperty("librarianEmail");
    private String password = ConfigurationReader.getProperty("librarianPassword");

    public void login (String role) {
        String librarianEmail = ConfigurationReader.getProperty("librarianEmail");
        String librarianPassword = ConfigurationReader.getProperty("librarianPassword");

        String libraryStudentEmail = ConfigurationReader.getProperty("libraryStudentEmail");
        String libraryStudentPassword = ConfigurationReader.getProperty("libraryStudentPassword");

        if (role.equalsIgnoreCase("librarian")) {
            usernameInput.sendKeys(librarianEmail);
            passwordInput.sendKeys(librarianPassword + Keys.ENTER);
        } else if (role.equalsIgnoreCase("student")) {
            usernameInput.sendKeys(libraryStudentEmail);
            passwordInput.sendKeys(libraryStudentPassword + Keys.ENTER);
        }
        BrowserUtilities.wait(1);
    }

    public String pageTitle(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        String actualTitle = pageTitle.getText();
        return actualTitle;
    }

    public void login(String username, String password){
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password+Keys.ENTER);
    }

}
