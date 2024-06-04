package com.craftshop.tests.login.negative;

import com.craftshop.pages.BasePage;
import com.craftshop.pages.HomePage;
import com.craftshop.pages.LoginPage;
import com.craftshop.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginNegativeTests extends TestBase {
    //public WebDriver driver;
    private LoginPage loginPage;
    public BasePage basePage;

    @BeforeMethod
    public void precondition() {
        basePage = new BasePage(driver);
        new HomePage(driver).clickOnLoginLink();
        loginPage=new LoginPage(driver);
    }


    @Test
    public void loginWithInvalidPasswordTest() {
        By locator = By.xpath("//div[contains(text(),'Ensure the correctness of the entered data')]");
        new LoginPage(driver)
                .enterLoginData("john@gmail.com", "S0123456789123456789")
                .clickOnSubmit();
                loginPage.isElementPresent(locator, true, 100);

    }

    @Test
    public void loginWithInvalidEmailTest() {
        By locator = By.cssSelector("[placeholder='Email']");
        new LoginPage(driver)
                .enterLoginData("john@gmail..", "P12345678")
                .clickOnSubmit()
                .isElementPresent(locator, true, 100);

    }
}


