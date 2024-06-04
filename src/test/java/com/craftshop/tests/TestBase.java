package com.craftshop.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        driver.get("http://localhost:5173/");
       // driver.get("http://localhost:8080/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }
}
