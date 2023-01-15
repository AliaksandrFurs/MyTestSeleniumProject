import com.BasicPageActionsUtils;
import com.driverfactory.DriverFactory;
import com.pagefactory.PageFactory;
import com.pages.BasePage;
import com.pages.LoginPage;
import com.pages.MainBasicPage;
import com.pages.MakeAppointmentPage;
import dataproviders.LoginDataProviderSuccessfull;
import dataproviders.MakeAppointmentProviderSuccessfull;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MakeAppointmentPageTest extends BaseTest{

    MainBasicPage mainBasicPage = PageFactory.getMainBasicPage();
    LoginPage loginPage = PageFactory.getLoginPage();
    MakeAppointmentPage makeAppointmentPage = PageFactory.getMakeAppointmentPage();
    BasicPageActionsUtils basicPageActionsUtils = BasicPageActionsUtils.getBasicPageActionsUtils();
    MakeAppointmentPage.MakeAppointmentBuilder builder;


    @BeforeClass
    public void navigateTo(){
        driver.findElement(mainBasicPage.getMakeAppointmentButton()).click();
        loginPage.doLogin("John Doe", "ThisIsNotAPassword");
        builder = MakeAppointmentPage.MakeAppointmentBuilder.getNakeAppointmentBuilder();
        BasePage.setAuthorised(true);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getFooterTop()));
    }

    @BeforeMethod(description = "Check UI visibilities")
    public void isDisplayed(){
        basicPageActionsUtils.veifyIsisDisplayed(makeAppointmentPage.getMakeAppointmentLabel());
    }

    @Test(dataProvider = "makeAppointmentDataProviderSuccessfull", dataProviderClass = MakeAppointmentProviderSuccessfull.class,
            description = "Successfull make appointment test")
    public void testMakeAppointmentSuccessfull(String facility, Boolean apply, String programm, String comments, String day){

        builder.facility(facility)
                .hospitalReadmission(apply)
                .healthcareProgram(programm)
                .comments(comments)
                .setDate(day)
                .doAppointment();

    }

    @Test
    public void testMakeAppintmentWithoutDataEntered(){
        builder.doAppointment();
        Assert.assertTrue(driver.findElement(makeAppointmentPage.getDatepickerMenu()).isDisplayed());
    }

}
