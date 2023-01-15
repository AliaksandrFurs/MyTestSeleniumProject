package dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProviderSuccessfull {

    @DataProvider(name = "loginPageDataProviderSuccessfull")
    public Object[][] dpMethod() {
        return new Object [][] { {"John Doe", "ThisIsNotAPassword"} };
    }
}
