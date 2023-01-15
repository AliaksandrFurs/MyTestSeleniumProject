package com.pages;

import com.driverfactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Calendar;


public class MakeAppointmentPage extends BasePage{

    WebDriver driver = DriverFactory.getChromeDriver();

    By makeAppointmentLabel = By.xpath("//h2[contains(text(), 'Make Appointment')]");
    By facilityLabel = By.xpath("//label[@for='combo_facility']");
    By facilitySelectBy = By.id("combo_facility");
    By applyCheckbox = By.id("chk_hospotal_readmission");
    By applyLabel = By.xpath("//label[@for='chk_hospotal_readmission']");
    By healthCareLabel = By.xpath("//label[contains(text(), 'Healthcare Program')]");
    By medicareRadio = By.id("radio_program_medicare");
    By medicaidRadio = By.id("radio_program_medicaid");
    By noneRadio = By.id("radio_program_none");
    By medicareLabel = By.xpath("//label[contains(@class, 'radio-inline')]/input[@id='radio_program_medicare']");
    By medicaidLabel = By.xpath("//label[contains(@class, 'radio-inline')]/input[@id='radio_program_medicaid']");
    By noneLabel = By.xpath("//label[contains(@class, 'radio-inline')]/input[@id='radio_program_none']");
    By visitDateSelect = By.id("txt_visit_date");
    By visitDateLabel = By.xpath("//label[@for='txt_visit_date']");
    By commentField = By.id("txt_comment");
    By commentLabel = By.xpath("//label[@for='txt_comment']");
    By bookAppointmentButton = By.id("btn-book-appointment");
    By datepickerMenu = By.xpath("//div[@class = 'datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top']");
    By calendarOpen = By.xpath("//div[@class = 'input-group-addon']");



    // constructor
    private MakeAppointmentPage(){    }

    // get page method
    public static MakeAppointmentPage getMakeAppointmentPage(){
        return new MakeAppointmentPage();
    }

    //getters
    public By getMakeAppointmentLabel() {
        return makeAppointmentLabel;
    }

    public By getFacilitySelect() {
        return facilitySelectBy;
    }

    public By getDatepickerMenu() {
        return datepickerMenu;
    }

    //page methods
    public void doAppointment(){
        driver.findElement(bookAppointmentButton).click();
    }

    //builder class
    public static class MakeAppointmentBuilder extends MakeAppointmentPage{

        Select facilitySelect = new Select(driver.findElement(facilitySelectBy));
        int currentDay = Calendar.DAY_OF_MONTH;

        private MakeAppointmentBuilder() {        }

        public static MakeAppointmentBuilder getNakeAppointmentBuilder(){
            return new MakeAppointmentBuilder();
        }

        public MakeAppointmentBuilder setDate(String day){
            driver.findElement(calendarOpen).click();
            driver.findElement(By.xpath("//table[@class='table-condensed']//td[contains(text()," + '\u0022' + day + '\u0022' + ')' + " and @class='day']")).click();
            return this;
        }

        public MakeAppointmentBuilder facility(String facility){

            switch (facility){
                case "Tokyo CURA Healthcare Center":
                    facilitySelect.selectByVisibleText(facility);
                    break;
                case "Hongkong CURA Healthcare Center":
                    facilitySelect.selectByVisibleText(facility);
                    break;
                case "Seoul CURA Healthcare Center" :
                    facilitySelect.selectByVisibleText(facility);
                    break;
                default:
                    facilitySelect.selectByVisibleText("Tokyo CURA Healthcare Center");
                    break;
            }
            return this;
        }

        public MakeAppointmentBuilder hospitalReadmission(boolean value){
            if(value == true){
                driver.findElement(applyCheckbox).click();
            }
            return this;
        }

        public MakeAppointmentBuilder healthcareProgram (String value){
            switch (value){
                case "MEDICARE":
                    driver.findElement(medicareRadio).click();
                    break;
                case "MEDICAID":
                    driver.findElement(medicaidRadio).click();
                    break;
                case "NONE" :
                    driver.findElement(noneRadio).click();
                    break;
                default:
                    driver.findElement(medicareRadio).click();
                    break;
            }
            return this;
        }

        public MakeAppointmentBuilder comments(String comment){
            driver.findElement(commentField).sendKeys(comment);
            return this;
        }

    }
}
