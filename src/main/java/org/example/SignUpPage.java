package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By emailField = By.xpath("//input[@id=\"email\"]");
    private By passwordField = By.xpath("//input[@id=\"password\"]");
    private By nameField = By.xpath("//input[@name=\"name\"]");
    private By signUpButton = By.xpath("//button[@class=\"sol-button sl-login-signup-form__action sol-button-primary sol-button-block sol-button-m\"]");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage enterEmail(String email) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        return this;
    }

    public SignUpPage  enterName(String name) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        return this;
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }
    public String getEmail() {
        return driver.findElement(emailField).getAttribute("value");
    }
}

