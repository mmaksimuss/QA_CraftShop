package com.craftshop.tests.login.positive;

import com.craftshop.pages.BasePage;
import com.craftshop.pages.HomePage;
import com.craftshop.pages.LoginPage;
import com.craftshop.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class LoginModeratorPositiveTests extends TestBase {
    private LoginPage loginPage;

    @BeforeMethod
    public void precondition() {
        new BasePage(driver);
        new HomePage(driver).clickOnLoginLink();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithValidDataTest() {
        By locator = By.xpath("//div[contains(text(),'You have successfully logged in. You have access t')]");
        new LoginPage(driver)
                .enterLoginData("moderator@gmail.com", "Password1234")
                .clickOnSubmit();
        loginPage.isElementPresent(locator, true, 100);
    }
}
