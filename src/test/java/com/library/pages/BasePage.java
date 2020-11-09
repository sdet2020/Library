package com.library.pages;

import com.library.Utilities.ConfigurationReader;
import com.library.Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static String libraryUrl = ConfigurationReader.getProperty("libraryUrl");
}
