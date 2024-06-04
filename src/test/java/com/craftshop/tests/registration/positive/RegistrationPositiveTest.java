package com.craftshop.tests.registration.positive;

import com.craftshop.pages.BasePage;
import com.craftshop.pages.HomePage;
import com.craftshop.pages.RegistrationPage;
import com.craftshop.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationPositiveTest extends TestBase {
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void precondition() {
        // new BasePage(driver);
        new HomePage(driver).clickOnRegistrationLink();
        new RegistrationPage(driver);
    }

    @Test(priority = 1)
    public void createUserAccountTest() {
        By locator = By.xpath("//div[contains(text(),'Registered successfully! \uD83D\uDC4C')]");
        registrationPage=new RegistrationPage(driver)
                .enterPersonalData("John", "Smith", "john325@gmail.com", "P12345678")
                .clickOnSubmit();
                registrationPage.isElementPresent(locator,true,100);
    }

}
