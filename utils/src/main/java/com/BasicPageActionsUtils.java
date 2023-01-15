package com;

import com.driverfactory.DriverFactory;
import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasicPageActionsUtils {

    protected static WebDriver driver = DriverFactory.getChromeDriver();

    private BasicPageActionsUtils(){}

    public static BasicPageActionsUtils getBasicPageActionsUtils(){

        return new BasicPageActionsUtils();
    }

    public BasicPageActionsUtils veifyIsisDisplayed (By element){
        Assert.assertTrue(driver.findElement(element).isDisplayed());
        return this;
    }

    public static void logout(){
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.xpath("//nav[@id='sidebar-wrapper']/ul/li[last()]")).click();
    }

    public static Boolean isUserAuthorised(){
        if(BasePage.isAuthorised() == true){
            return true;
        }
        if(BasePage.isAuthorised() == false){
            return false;
        }
        return false;
    }
}
