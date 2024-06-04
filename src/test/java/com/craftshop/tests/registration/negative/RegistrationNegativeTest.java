package com.craftshop.tests.registration.negative;

import com.craftshop.pages.HomePage;
import com.craftshop.pages.RegistrationPage;
import com.craftshop.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.craftshop.pages.BasePage.driver;

public class RegistrationNegativeTest extends TestBase {
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnRegistrationLink();
        new RegistrationPage(driver);
    }


    @Test
    public void createUserAccountWithInvalidNameTest() {
        By locator = By.xpath("//div[contains(text(),'Registration failed. Please try again later.')]");
        registrationPage = new RegistrationPage(driver)
                .enterPersonalData("Джон", "Smith", "john@gmail.com", "S1234567")
                .clickOnSubmit();
        registrationPage.isElementPresent(locator, true, 100);
    }

    @Test
    public void createUserAccountWithInvalidSurnameTest() {
        By locator = By.xpath("//div[contains(text(),'Registration failed. Please try again later.')]");
        registrationPage = new RegistrationPage(driver)
                .enterPersonalData("John", "Smith%$", "john@gmail.com", "Ss12345$")
                .clickOnSubmit();
        registrationPage.isElementPresent(locator, true, 100);
        ;
    }

    @Test
    public void createUserAccountWithInvalidEmailTest() {
        By locator = By.cssSelector("[placeholder='Password *']");
        registrationPage = new RegistrationPage(driver)
                .enterPersonalData("John", "Smith", "john@gmail..", "Ss12345$")
                .clickOnSubmit();
        registrationPage.isElementPresent(locator, true, 100);
    }

    @Test
    public void createUserAccountWithInvalidPasswordTest() {
        By locator = By.xpath("//div[contains(text(),'Registration failed. Please try again later.')]");
       registrationPage= new RegistrationPage(driver)
                .enterPersonalData("John", "Smith", "john@gmail.com", "S1234567890123456789")
                .clickOnSubmit();
        registrationPage.isElementPresent(locator, true, 100);
    }

    @Test
    public void createUserWithExistingEmailTest() {
        By locator = By.xpath("//div[contains(text(),'Registration failed. Please try again later.')]");
        registrationPage= new RegistrationPage(driver)
                .enterPersonalData("John", "Doe", "john325@gmail.com", "P12345678")
                .clickOnSubmit();
        registrationPage.isElementPresent(locator,true,100);

    }
}
