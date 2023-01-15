import com.BasicPageActionsUtils;
import com.pagefactory.PageFactory;
import com.pages.BasePage;
import com.pages.LoginPage;
import com.pages.MainBasicPage;
import com.pages.MakeAppointmentPage;
import dataproviders.LoginDataProviderSuccessfull;
import dataproviders.LoginDataProviderUnsuccessfull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginPageTest extends BaseTest{

    MainBasicPage mainBasicPage = MainBasicPage.getMainBasicPage();
    LoginPage loginPage = PageFactory.getLoginPage();
    MakeAppointmentPage makeAppointmentPage = MakeAppointmentPage.getMakeAppointmentPage();


    @BeforeMethod
    public void navigateTo(){
        driver.findElement(mainBasicPage.getMakeAppointmentButton()).click();
        utils.veifyIsisDisplayed(loginPage.getLoginButton())
                .veifyIsisDisplayed(loginPage.getUsernameField())
                .veifyIsisDisplayed(loginPage.getPasswordField());
        //wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getFooterTop()));
    }
    @AfterMethod()
    public void logout(){
        if(BasePage.isAuthorised() == true){
            BasicPageActionsUtils.logout();
            BasePage.setAuthorised(false);
        }
    }


    @Test(dataProvider = "loginPageDataProviderSuccessfull", dataProviderClass = LoginDataProviderSuccessfull.class,
    description = "Successfull login test")
    public void testLoginSuccessfull(String username, String password){
        loginPage.doLogin(username, password);
        Assert.assertTrue(driver.findElement(makeAppointmentPage.getMakeAppointmentLabel()).isDisplayed());
        BasePage.setAuthorised(true);
    }

    @Test(dataProvider = "loginPageDataProviderUnsuccessfull", dataProviderClass = LoginDataProviderUnsuccessfull.class,
    description = "Unsuccessfull login test")
    public void testLoginUnsuccessfull(String username, String password){
        loginPage.doLogin(username, password);
        Assert.assertTrue(driver.findElement(loginPage.getLoginFailedAlert()).isDisplayed());
        BasePage.setAuthorised(false);
    }
}
