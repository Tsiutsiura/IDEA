package MaxPay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.Thread.sleep;

@RunWith(value = Parameterized.class)

public class TestLoginValidation extends General_MP{
    private String email;
    private String password;

    private static StringBuffer verificationErrors = new StringBuffer();


    @Parameters
    public static Collection testData() {
        return Arrays.asList(
                new Object[][]{
                        {"tsiutsiura.test@gmail.com", "test"}
                }
        );

    }

    public TestLoginValidation(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Test
    public void testLogin() throws Exception {
        openPage();

        LoginPage_MP loginPage = new LoginPage_MP(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailLocator()));

        loginPage.typeEmail(email);
        loginPage.typePassword(password);
        loginPage.submitLoginPage();


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginPage.getErrorEmailOrPasswordLocator()));
        System.out.println(driver.findElement(loginPage.getErrorEmailOrPasswordLocator()));


        /*try {

            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginPage.getErrorEmailOrPasswordLocator()));
            assertEquals("Error not matched", "Password or email are incorrect", loginPage.errorEmailOrPassword().toString());

        } catch (TimeoutException e){
            System.out.println("Customer see just only one error message");
        }*/



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
