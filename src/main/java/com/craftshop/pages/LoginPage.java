package com.craftshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginPage extends BasePage{
    public static final Duration WAIT_SEC = Duration.ofMillis(500);
    static Logger logger=LoggerFactory.getLogger(BasePage.class);
   // public static FluentWait <WebDriver> wait;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isElementPresent(By locator, boolean waitForElement, int timeout) {
        try {
            if (waitForElement) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            }
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @FindBy(id = "email-address")
    WebElement emailInput;
    @FindBy(id = "password")
    WebElement passwordInput;

    public  LoginPage enterLoginData(String email,String password){
        type(emailInput,email);
        type(passwordInput,password);
        return this;
    }
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement submit;
    public LoginPage clickOnSubmit() {
        click(submit);
        return this;
    }

   // @FindBy(xpath = "//div[contains(text(),'Failed to update contact details. Please try again')]")
    //public static WebElement errorMessage;
    public static boolean isLoginFailed() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_SEC);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Failed to update contact details. Please try again')]")));
//            logger.info("Element is present");
//            return true;
            return successMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            logger.error("Element is not present");
            return false;
        }
    }

    @FindBy(xpath = "//div[contains(text(),'You have successfully logged in. You have access t')]")
    static WebElement successMessage;
    public static boolean isLoginSuccesfull() {
        try {
            return successMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLoginFormDisplayed() {
        return true;
    }
}
