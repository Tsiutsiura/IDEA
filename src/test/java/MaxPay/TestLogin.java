package MaxPay;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import junitparams.Parameters;
import org.testng.annotations.BeforeTest;

@RunWith(JUnitParamsRunner.class)

public class TestLogin extends General_MP {

    private static StringBuffer verificationErrors = new StringBuffer();


    @BeforeTest
    public void first() {
        openPage();
    }

    @Test
    @Parameters({  "tsiutsiura.test@gmail.com,Test12345"  })
    public void testLoginPositive(String email, String password) throws Exception {

        LoginPage_MP loginPage = new LoginPage_MP(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailLocator()));
        loginPage.typeEmail(email);
        System.out.println("Email:" + " '" + email + "'");
        loginPage.typePassword(password);
        System.out.println("Password:" + " '" + password + "'");
        Dashboard_MP dashboard = loginPage.submitLoginPage();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dashboard.getControlLocator()));
        assertEquals("You a still on Login page", "https://my-sandbox.maxpay.com/app.php#/app/dashboard", driver.getCurrentUrl().toString());

    }
    @Test
    @Parameters({
            "\"\", \"Test\"" ,
            "\"\", \"Test12345\"" ,
            "\"   \", \"Test\""
    })
    public void testLoginNegAllEmpty(String email, String password) throws Exception {

        LoginPage_MP loginPage = new LoginPage_MP(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailLocator()));
        loginPage.submitLoginPage();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginPage.getErrorEmailLocator()));
        assertEquals("Error not matched in field email", "Пожалуйста, введите действующий email адрес", loginPage.errorEmail().toString());
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginPage.getErrorEmailLocator()));
        assertEquals("Error not matched in field email", "Пожалуйста, введите действующий email адрес", loginPage.errorEmail().toString());
    }

    @Test
    @Parameters({
            "\"\", \"Test\"" ,
            "\"\", \"Test12345\"" ,
            "\"   \", \"Test\""
    })
    public void testLoginEmailNeg(String email, String password) throws Exception {

        LoginPage_MP loginPage = new LoginPage_MP(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailLocator()));
        System.out.println("Email:" + " '" + email + "'");
        loginPage.typePassword(password);
        System.out.println("Password:" + " '" + password + "'");
        Dashboard_MP dashboard = loginPage.submitLoginPage();
        loginPage.submitLoginPage();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginPage.getErrorEmailLocator()));
        assertEquals("Error not matched in field email", "Пожалуйста, введите действующий email адрес", loginPage.errorEmail().toString());

    }
    @Test
    @Parameters({
            "\"tsiutsiura1115@gmail.com\", \"\"" ,
            "\"\", \"\"" ,

    })
    public void testLoginPasswordNegative(String email, String password) throws Exception {

        LoginPage_MP loginPage = new LoginPage_MP(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailLocator()));
        loginPage.typeEmail(email);
        System.out.println("Email:" + " '" + email + "'");
        loginPage.typePassword(password);
        System.out.println("Password:" + " '" + password + "'");
        Dashboard_MP dashboard = loginPage.submitLoginPage();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginPage.getErrorEmailLocator()));
        assertEquals("Error not matched in field email", "Пожалуйста, введите действующий email адрес", loginPage.errorEmail().toString());

    }

    @Test
    @Parameters({
            "\"tsiutsiura\", \"Test\"" ,
            "\"tsiutsiura1115@gmail.com\", \"Test12345\""
    })

    public void testLoginNegOneWrong(String email, String password) throws Exception {

        LoginPage_MP loginPage = new LoginPage_MP(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailLocator()));
        loginPage.typeEmail(email);
        System.out.println("Email:" + " '" + email + "'");
        loginPage.typePassword(password);
        System.out.println("Password:" + " '" + password + "'");
        loginPage.submitLoginPage();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getErrorEmailOrPasswordLocator()));
        assertEquals("Error not matched, when problem with someone email or password", "Некорректны пароль или email", loginPage.errorEmailOrPassword().toString());

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
