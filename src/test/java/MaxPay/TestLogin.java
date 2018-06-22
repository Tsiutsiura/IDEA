package MaxPay;

import MaxPay.Pages.Dashboard_MP;
import MaxPay.Pages.LoginPage_MP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public class TestLogin extends GeneralForTest {

   private String email;
    private String password;
    private String expectedValue;
    private  String url;

    private static StringBuffer verificationErrors = new StringBuffer();

    @Parameters
    public static Collection testData() {
        return Arrays.asList(
                new Object[][]{

                       {"tsiutsiura1115@gmail.com", "Test12345", "Некорректны пароль или email", "https://my.maxpay.com/#/signin"},
                       {"test.tsiutsiura@gmail.com", "Test", "Некорректны пароль или email", "https://my.maxpay.com/#/signin"},
                       {"", "Test12345", "Пожалуйста, введите действующий email адрес", "https://my.maxpay.com/#/signin"},
                       {"@!$#^%$&%^", "Test12345", "Пожалуйста, введите действующий email адрес", "https://my.maxpay.com/#/signin"},
                       {"test.tsiutsiura@gmail.com", "", "Некорректны пароль или email", "https://my.maxpay.com/#/signin"} ,
                       {"test.tsiutsiura@gmail.com", "Test12345", "Объем", "https://my-sandbox.maxpay.com/app.php#/app/dashboard"}
                }
        );

    }

    public TestLogin(String email, String password, String expectedValue, String url) {
        this.email = email;
        this.password = password;
        this.expectedValue = expectedValue;
        this.url = url;
    }

    @BeforeTest
    public void first(){
        openPage();
    }

    @Test
    public void testLogin() throws Exception {

        openPage();
        LoginPage_MP loginPage = new LoginPage_MP(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailLocator()));

        loginPage.typeEmail(email);
        System.out.println("Email:" + " '" + email + "'");
        loginPage.typePassword(password);
        System.out.println("Password:" + " '" +password +"'");
        Dashboard_MP dashboard =  loginPage.submitLoginPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='"+expectedValue+"']")));
        assertEquals("URL doesn't matched!!!!", url, driver.getCurrentUrl().toString());

    }



    @AfterTest
    public void tearDown() {
        //Close the browser
        driver.close();
        String verificationErrorString = verificationErrors.toString();

        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


}
