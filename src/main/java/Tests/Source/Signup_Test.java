package Tests.Source;

import Source.SignUP_Page;
import Tests.Source.Test_Base.Test_Base;
import org.testng.annotations.Test;

public class Signup_Test extends Test_Base {

    // The Below method which sends and Fills Test Data So If you want to execute process of Sign up Page Can you begin from here
    @Test
    public void testSuccessfullSignup() {

        SignUP_Page SignPage = homePage.GetSignPage();
        SignPage.Fullname("Said Sheble Elsaid Emara");
        SignPage.EmailAddress("Said.emara@gmail.com");
        SignPage.PhoneNum("01013457676");
        SignPage.RegisterBuisness();
        SignPage.StoreName("Flash Business");
        SignPage.SetPassAndConfirm("Said@!!123", "Said@!!123");
        SignPage.Signup();

    }

}
