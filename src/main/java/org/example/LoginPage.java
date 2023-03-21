package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By emailField = By.xpath("//input[@id=\"email\"]");
    private By passwordField = By.xpath("//input[@id=\"password\"]");
    private By loginButton = By.xpath("//button[@class=\"sol-button sl-login-login-form__action sol-button-primary sol-button-block sol-button-m\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage enterEmail(String email)  {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public LoginPage enterEmailFromSignUpPage(SignUpPage signUpPage)  {
        String email = signUpPage.getEmail();
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
}