package com.pages;

import com.driverfactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    WebDriver driver  = DriverFactory.getChromeDriver();

    By usernameField = By.id("txt-username");
    By passwordField = By.id("txt-password");
    By loginButton = By.id("btn-login");
    By loginFailedAlert = By.xpath("//p[@class = 'lead text-danger']");

    private LoginPage(){    }

    public static LoginPage getLoginPage(){
        return new LoginPage();
    }

    public void goToLoginPage(){
        driver.findElement(menuToggle).click();
        driver.findElement(loginButtonToggle).click();
    }

    public void doLogin (String login, String password){
        driver.findElement(usernameField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public By getUsernameField() {
        return usernameField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getLoginFailedAlert() {
        return loginFailedAlert;
    }
}
