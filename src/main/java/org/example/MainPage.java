package org.example;

import org.openqa.selenium.By;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private  WebDriverWait wait;
    private By registerButton = By.xpath("//button[@class=\"sol-button sl-action-btn sol-button-primary sol-button-block sol-button-m\"]");
    private By signInButton = By.xpath("//button[@sl-test-data=\"actionButtonsecondary\"]");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public SignUpPage clickRegister()  {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        driver.navigate().to("https://www.sololearn.com/users/signup");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class=\"sl-login-signup__title\"]")));
        return new SignUpPage(driver);
    }

    public LoginPage clickSignIn()  {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        driver.navigate().to("https://www.sololearn.com/users/login");
        return new LoginPage(driver);
    }

}