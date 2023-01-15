package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainBasicPage extends BasePage{

    WebDriver driver;

    By makeAppointmentButton = By.id("btn-make-appointment");


    private MainBasicPage(){ }

    public static MainBasicPage getMainBasicPage(){
        return new MainBasicPage();
    }

    public By getMakeAppointmentButton() {
        return makeAppointmentButton;
    }
}
