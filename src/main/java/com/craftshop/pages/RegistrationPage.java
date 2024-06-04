package com.craftshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationPage extends  BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css ="[name='firstName']")
    WebElement nameField;
    @FindBy(css = "[name='lastName']")
    WebElement surNameField;
    @FindBy(css = "[placeholder='Email *']")
    WebElement emailField;
    @FindBy(css = "[placeholder='Password *']")
    WebElement passwordField;
    @FindBy(css = "[placeholder='Repeat password *']")
    WebElement repeatPasswordField;


    public RegistrationPage enterPersonalData(String name, String surname, String email, String password) {
        type(nameField,name);
        type(surNameField,surname);
        type(emailField,email);
        type(passwordField,password);
        type(repeatPasswordField,password);
        return this;
    }
    @FindBy(xpath = "//button[contains(text(),'Send')]")
    WebElement submit;

    public RegistrationPage clickOnSubmit() {
        click(submit);
        return this;
    }

    @FindBy(xpath = "//div[contains(text(),'You have successfully logged in. You have access t')]")
    WebElement successTitle;

    public RegistrationPage verifySuccessTitle(String title) {
        Assert.assertTrue(shouldHaveText(successTitle,title,20));
        return this;
    }

    @FindBy(xpath = "//div[contains(text(),'Failed to update contact details. Please try again')]")
    WebElement errorMessage;
    public RegistrationPage verifyNotSuccessTitle(String title) {
        Assert.assertTrue(shouldHaveText(errorMessage,title,30));
        return this;
    }
    public static boolean isRegistrationFailed() {
        return true;
    }

    public boolean isRegistrationFormDisplayed() {
        return true;
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
}
