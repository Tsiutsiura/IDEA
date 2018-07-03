package MaxPay.tests;


import MaxPay.Pages.LoginPage;
import MaxPay.Pages.SignUp;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TestSignUp extends GeneralForTest {


    @Test
    public void testMoveToSignUp() {
        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailLocator()));
        SignUp signUp = loginPage.beginSignUp();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(signUp.getEmailLocator()));
        assertEquals("You a still on Login page", signUp.getURL(), driver.getCurrentUrl().toString());
    }

    @Test
    public void testCreateNewClient() {
        LoginPage loginPage = new LoginPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailLocator()));

        SignUp signUp = loginPage.beginSignUp();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(signUp.getEmailLocator()));

        signUp.enterEmail("test"+Math.round(Math.random()*10000)+"@test.com");
        signUp.enterPassword("Test1234");
        signUp.enterConfirmPassword("Test1234");


        signUp.agreeTerms();
        signUp.agreeEmail();
        signUp.agreeCookies();
        sleep(5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUp.getSubmitButtonLocator()));
      /*  signUp.submitForm();
       assertEquals("You are still on registration form","https://my.maxpay.com/app.php#/app/dashboard", driver.getCurrentUrl().toString());*/

    }
}
