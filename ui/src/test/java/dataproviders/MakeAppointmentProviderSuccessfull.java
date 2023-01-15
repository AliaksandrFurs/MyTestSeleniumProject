package dataproviders;

import org.testng.annotations.DataProvider;

public class MakeAppointmentProviderSuccessfull {

    @DataProvider(name = "makeAppointmentDataProviderSuccessfull")
    public Object[][] dpMethod() {
        boolean apply;
        return new Object [][] { {"Tokyo CURA Healthcare Center", apply = false, "MEDICARE", "TEST", "30"},
                {"Tokyo CURA Healthcare Center", apply = true, "MEDICARE", "TEST", "29"}};
    }
}
