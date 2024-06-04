package com.craftshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HomePage extends BasePage {
    protected WebDriver driver;
    public FluentWait <WebDriver> wait;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new FluentWait<>(driver);
    }


    @FindBy(css = "[href='/registration']")
    WebElement registrationLink;
    public void clickOnRegistrationLink() {
        click(registrationLink);
    }

    @FindBy(css = "[href='/login']")
    public  WebElement loginLink;
    public void  clickOnLoginLink() {
       // wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        click(loginLink);

    }

    @FindBy(css = "[href='/']")
    WebElement homeLink;
    public void clickOnHomeLink() {
        click(homeLink);
    }

    public boolean isHomeFormDisplayed() {
        return true;
    }


}
