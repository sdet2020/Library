package com.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LibraryTabsPage extends BasePage{

    @FindBy (xpath = "//span[.='Dashboard']")
    private WebElement dashboard; // tab

    @FindBy(xpath = "//span[.='Users']")
    private WebElement users; // tab

    @FindBy (xpath = "//span[.='Books']")
    private WebElement books; // tab

    public void clickOnPage (String page){
        if (page.equalsIgnoreCase("dashboard")){
            dashboard.click();
        }else if(page.equalsIgnoreCase("users")){
            users.click();
        }else if(page.equalsIgnoreCase("books")){
            books.click();
        }else {
            System.out.println("No such page on Library.com");
        }
    }
}
