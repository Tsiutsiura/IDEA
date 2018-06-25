package MaxPay.tests;

import MaxPay.Pages.Dashboard;
import MaxPay.Pages.LoginPage;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


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

//                       {"tsiutsiura1115@gmail.com", "Test12345", "Некорректны пароль или email", "https://my.maxpay.com/#/signin"},
//                       {"test.tsiutsiura@gmail.com", "Test", "Некорректны пароль или email", "https://my.maxpay.com/#/signin"},
//                       {"", "Test12345", "Пожалуйста, введите действующий email адрес", "https://my.maxpay.com/#/signin"},
//                       {"@!$#^%$&%^", "Test12345", "Пожалуйста, введите действующий email адрес", "https://my.maxpay.com/#/signin"},
                      {"test.tsiutsiura@gmail.com", "test", "Некорректны пароль или email", "https://my.maxpay.com/#/signin"} ,
                        //                       {"test.tsiutsiura@gmail.com", "Test12345", "Объем выплат клиентам", "https://my-sandbox.maxpay.com/app.php#/app/dashboard"}
                }
        );

    }

    public TestLogin(String email, String password, String expectedValue, String url) {
        this.email = email;
        this.password = password;
        this.expectedValue = expectedValue;
        this.url = url;
    }


    @Test
    public void testLogin() throws Exception {

        /*openPage();*/
        LoginPage loginPage = new LoginPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailLocator()));

        loginPage.typeEmail(email);
        System.out.println("Email:" + " '" + email + "'");
        loginPage.typePassword(password);
        System.out.println("Password:" + " '" +password +"'");
        Dashboard dashboard =  loginPage.submitLoginPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text()='Некорректны пароль или email']")));
        assertEquals("URL doesn't matched!!!!", url, driver.getCurrentUrl().toString());


    }






}
