package MaxPay;

import Pages.Dashboard;
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

@RunWith(value = Parameterized.class)

public class TestLoginPositive extends General_MP {

    private String email;
    private String password;

    private static StringBuffer verificationErrors = new StringBuffer();


    @Parameters
    public static Collection testData() {
        return Arrays.asList(
                new Object[][]{

                       /* {"", "Test"}, //invalid email (empty) and invalid password
                        {"", "Test12345"}, //invalid email (empty) and valid password
                        {"   ", "Test"}, //invalid email (spaces) and invalid password
                        {"   ", "Test12345"}, //invalid email (spaces) and valid password
                        {"tsiutsiura1115@gmail.com", ""}, //invalid email  and invalid password (empty)*/
                        /* {"tsiutsiura.test@gmail.com", "Test12345"},  //valid email and password
                        {"tsiutsiura.test@gmail.com", "Test"}, //valid email and invalid password ,
                         {"tsiutsiura", "Test"},  //invalid email (without @) and invalid password*/
                         {"tsiutsiura1115@gmail.com", "Test12345"} //invalid email (doesn't exist in system) and valid password
                }
        );

    }

    public TestLoginPositive(String email, String password) {
        this.email = email;
        this.password = password;
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


//Проверить позитивный сценарий и "Некорректны пароль или email"

        try {

            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginPage.getErrorEmailLocator()));
            assertEquals("Error not matched in field email", "Пожалуйста, введите действующий email адрес", loginPage.errorEmail().toString());


            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginPage.getErrorPasswordLocator()));
            assertEquals("Error not matched in field password", "Пожалуйста, введите пароль", loginPage.errorPassword().toString());

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getErrorEmailOrPasswordLocator()));
            assertEquals("Error not matched, when problem with someone email or password", "Некорректны пароль или email", loginPage.errorEmailOrPassword().toString());

            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dashboard.getControlLocator()));
            assertEquals("You a still on Login page", "https://my-sandbox.maxpay.com/app.php#/app/dashboard", driver.getCurrentUrl().toString());


        } catch (NoSuchElementException e){
            assertEquals("Вы не авторезировались на сайте", "https://my-sandbox.maxpay.com/app.php#/app/dashboard", driver.getCurrentUrl().toString());
            System.out.println("вы авторезированы");
        }
        catch (TimeoutException e) {
            assertEquals("You are still on login page", "https://my-sandbox.maxpay.com/#/signin", driver.getCurrentUrl().toString());
            System.out.println("You are not authorized on site, problem with email or password");

        }


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
