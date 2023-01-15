import com.BasicPageActionsUtils;
import com.enums.HealthcareProgramEnum;
import com.pagefactory.PageFactory;
import com.pages.MainBasicPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MainBasicPageTest extends BaseTest{

    MainBasicPage mainBasicPage = PageFactory.getMainBasicPage();
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass(description = "Check UI visibilities")
    public void isDisplayed(){
        utils.veifyIsisDisplayed(mainBasicPage.getHeaderBottom())
                .veifyIsisDisplayed(mainBasicPage.getMailLink())
                .veifyIsisDisplayed(mainBasicPage.getFooterTop());

    }

    @Test(description = "Check elements name correction")
    public void correctionNameTest(){
        softAssert.assertEquals(driver.findElement(mainBasicPage.getMakeAppointmentButton()).getText(), "Make Appointment1");
        softAssert.assertEquals(driver.findElement(mainBasicPage.getFooterAdress()).getText(), "Atlanta 550 Pharr Road NE Suite 525\n" +
                "Atlanta, GA 30305");
        softAssert.assertEquals(driver.findElement(mainBasicPage.getMakeAppointmentButton()).getText(), "Make Appointment1");
    }
}
