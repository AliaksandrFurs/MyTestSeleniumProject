package dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProviderUnsuccessfull {

    @DataProvider(name = "loginPageDataProviderUnsuccessfull")
    public Object[][] dpMethod() {
        return new Object [][] { {"Alex", "Furs"}, {"X", "Y"} };
    }
}
