package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;
    private static boolean isAuthorised = false;

    By headerTop = By.xpath("//h1[contains(text(), 'CURA Healthcare Service')]");
    By headerBottom = By.xpath("//h3[contains(text(), 'We Care About Your Health')]");
    By footerTop = By.xpath("//strong[contains(text(), 'CURA Healthcare Service')]");
    By footerAdress = By.xpath("//p[contains(text(), 'Atlanta 550 Pharr Road NE Suite 525')]");
    By footerPhone = By.xpath("//i[@class='fa fa-phone fa-fw']");
    By mailLink = By.xpath("//a[contains(text(), 'info@katalon.com')]");
    By menuToggle = By.id("menu-toggle");
    By logoutButtonToggle = By.xpath("//a[contains(text(),'Logout')]");
    By loginButtonToggle = By.xpath("//a[contains(text(),'Login')]");

    public static boolean isAuthorised() {
        return isAuthorised;
    }

    public static void setAuthorised(boolean authorised) {
        isAuthorised = authorised;
    }

    public BasePage() {
        this.driver = driver;
    }

    public By getHeaderTop() {
        return headerTop;
    }

    public By getHeaderBottom() {
        return headerBottom;
    }

    public By getFooterTop() {
        return footerTop;
    }

    public By getFooterAdress() {
        return footerAdress;
    }

    public By getFooterPhone() {
        return footerPhone;
    }

    public By getMailLink() {
        return mailLink;
    }

    public By getMenuToggle() {
        return menuToggle;
    }

    public By getLogoutButtonToggle() {
        return logoutButtonToggle;
    }
}
