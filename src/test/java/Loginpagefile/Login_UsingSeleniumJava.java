package Loginpagefile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_UsingSeleniumJava {
    private WebDriver driver;

    public Login_UsingSeleniumJava(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        // Locate the elements and perform actions using Selenium
        WebElement emailField = driver.findElement(By.id("loginId"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));

        // Fill in the fields and click the login button
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
