import com.BasicPageActionsUtils;
import com.driverfactory.DriverFactory;
import com.pagefactory.PageFactory;
import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public static final String URL = "https://katalon-demo-cura.herokuapp.com";
    static WebDriver driver = DriverFactory.getChromeDriver();
    static BasicPageActionsUtils utils = BasicPageActionsUtils.getBasicPageActionsUtils();

    @BeforeSuite(description = "Get Chrome")
    static void setup() {
        driver = DriverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeSuite
    public void goToHome(){
        driver.get(URL);
    }

    @AfterSuite (description = "Close browser", alwaysRun = true)
    static void close (){
        driver.close();
    }

}
