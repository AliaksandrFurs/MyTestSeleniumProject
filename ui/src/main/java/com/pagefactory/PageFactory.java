package com.pagefactory;

import com.pages.BasePage;
import com.pages.LoginPage;
import com.pages.MainBasicPage;
import com.pages.MakeAppointmentPage;

public class PageFactory {

    private static LoginPage loginPageFactory;
    private static MainBasicPage mainBasicPageFactory;
    private static MakeAppointmentPage makeAppointmentPageFactory;

    private PageFactory(){};

    public static LoginPage getLoginPage(){
        if(loginPageFactory == null){
            loginPageFactory = LoginPage.getLoginPage();
        }
        return loginPageFactory;
    }

    public static MainBasicPage getMainBasicPage(){
        if(mainBasicPageFactory == null){
            mainBasicPageFactory = MainBasicPage.getMainBasicPage();
        }
        return mainBasicPageFactory;
    }

    public static MakeAppointmentPage getMakeAppointmentPage(){
        if(makeAppointmentPageFactory == null){
            makeAppointmentPageFactory = MakeAppointmentPage.getMakeAppointmentPage();
        }
        return makeAppointmentPageFactory;
    }

}
