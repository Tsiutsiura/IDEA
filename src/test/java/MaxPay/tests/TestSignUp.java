package MaxPay.tests;


import MaxPay.Pages.LoginPage;
import MaxPay.Pages.SignUp;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TestSignUp extends GeneralForTest{


    @Test
    public void testMoveToSignUp(){
        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailLocator()));
        SignUp signUp = loginPage.beginSignUp();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(signUp.getEmailLocator()));
         assertEquals("You a still on Login page", signUp.getURL(), driver.getCurrentUrl().toString());
    }

    @Test
    public void testCreateNewClient (){
        LoginPage loginPage = new LoginPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailLocator()));

       SignUp signUp = loginPage.beginSignUp();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(signUp.getEmailLocator()));

       /* signUp.enterEmail("test");
        signUp.enterPassword("test");
        signUp.enterConfirmPassword("test");*/

       sleep(20);
        signUp.agreeTerms();
        wait.until(ExpectedConditions.elementToBeSelected(signUp.getAgreeTermsCheckboxLocator()));
        signUp.agreeEmail();
        wait.until(ExpectedConditions.elementToBeSelected(signUp.getAgreeEmailLocator()));
        signUp.agreeCookies();
        wait.until(ExpectedConditions.elementToBeSelected(signUp.getAgreeCookiesLocator()));

    }
}
