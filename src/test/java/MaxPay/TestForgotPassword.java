package MaxPay;

import MaxPay.Pages.LoginPage_MP;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestForgotPassword extends GeneralForTest {
    @Test
    public void testMoveToForgotPassword (){
        openPage();
        LoginPage_MP loginPage = new LoginPage_MP(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getForgotPasswordLocator()));
        loginPage.goToForgotPassword();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='reminder-email']")));
        assertEquals("URL doesn't matched!!!!", "https://my.maxpay.com/#/forgot", driver.getCurrentUrl().toString());
        driver.quit();
    }
}
