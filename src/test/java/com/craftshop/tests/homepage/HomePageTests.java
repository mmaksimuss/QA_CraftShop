package com.craftshop.tests.homepage;

import com.craftshop.pages.HomePage;
import com.craftshop.pages.LoginPage;
import com.craftshop.pages.RegistrationPage;
import com.craftshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    private HomePage homePage;

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(driver);


    }


    @Test
    public void testNavigationToLoginPage() {
        homePage.clickOnLoginLink();
        Assert.assertTrue(new LoginPage(driver).isLoginFormDisplayed(), "Login form is not displayed");
    }

    @Test
    public void testNavigationToRegistrationPage() {
        homePage.clickOnRegistrationLink();
         Assert.assertTrue(new RegistrationPage(driver).isRegistrationFormDisplayed(), "Registration form is not displayed");
    }

    @Test
    public void testNavigationToHomePage() {
        homePage.clickOnHomeLink();
        Assert.assertTrue(homePage.isHomeFormDisplayed(), "Home form is not displayed");
    }

}
