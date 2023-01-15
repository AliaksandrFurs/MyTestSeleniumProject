import com.BasicPageActionsUtils;
import com.pages.MainBasicPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTestClass extends BaseTest {

    MainBasicPage mainBasicPage = MainBasicPage.getMainBasicPage();
    BasicPageActionsUtils basicPageActionsUtils = BasicPageActionsUtils.getBasicPageActionsUtils();

    @BeforeClass
    public void navigateTo(){
        driver.get(URL);
    }

    @Test
    public void displayedElements(){
        basicPageActionsUtils.veifyIsisDisplayed(mainBasicPage.getHeaderTop())
                .veifyIsisDisplayed(mainBasicPage.getFooterAdress())
                .veifyIsisDisplayed(mainBasicPage.getFooterPhone())
                .veifyIsisDisplayed(mainBasicPage.getFooterTop())
                .veifyIsisDisplayed(mainBasicPage.getMailLink())
                .veifyIsisDisplayed(mainBasicPage.getHeaderBottom());
    }
}
