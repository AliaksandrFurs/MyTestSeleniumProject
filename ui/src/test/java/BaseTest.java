import com.BasicPageActionsUtils;
import com.CommonUtils;
import com.driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static final String URL = "https://katalon-demo-cura.herokuapp.com";
    static WebDriver driver = DriverFactory.getChromeDriver();
    static BasicPageActionsUtils utils = BasicPageActionsUtils.getBasicPageActionsUtils();
    Properties prop;

    {
        try {
            prop = CommonUtils.readPropertiesFile("C:\\Users\\37529\\IdeaProjects\\MyTestSeleniumProject\\credentials.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
