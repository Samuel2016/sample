package com.sample.userInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Transactions {

    /**
     * Sample UI test. These methods are meant to be broken up into different classes depending on
     * the automation framework.
     */

    private WebDriver driver;
    private final String url = "https://www.site.com/services/login";
    private final String EMAIL = "samk@github.com";
    private final String PASSWORD = "password";

    @FindBy(id = "inputEmail")
    private WebElement inputEmailField;

    @FindBy(id = "inputPassword")
    private WebElement inputPasswordField;

    @FindBy(id = "rememberId")
    private WebElement rememberIdCheckBox;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    @FindBy(id = "tableId")
    private WebElement tableId;

    @Test(priority = 1)
    public void browser() {

        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.operadriver().setup();
//        WebDriverManager.phantomjs().setup();
//        WebDriverManager.edgedriver().setup();
//        WebDriverManager.iedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Launched browser successfully.");

        driver.get(url);
        System.out.println("url " + url);
    }

    @Test(priority = 2)
    public void userLoginForm() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals("Login", driver.getTitle());
        System.out.println("Page title " + driver.getTitle());

        inputEmailField.sendKeys(EMAIL);
        inputPasswordField.sendKeys(PASSWORD);
        rememberIdCheckBox.click();

        Assert.assertTrue(submitButton.isEnabled());
        submitButton.click();

    }

    @Test(priority = 3)
    public void getRows() {

        List<WebElement> rows = tableId.findElements(By.tagName("tr"));

        // iterate via for-loop
        System.out.println("Row values are displayed below.");
        for (int i = 1; i < rows.size(); i++) {
            System.out.println(rows.get(i));
        }
    }

}
