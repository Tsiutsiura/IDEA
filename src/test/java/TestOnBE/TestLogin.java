package TestOnBE;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.By;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public  class TestLogin extends GeneralMethods {

    private String email;
    private String password;

    private static StringBuffer verificationErrors = new StringBuffer();
    @Parameters
    public static Collection testData() {
        return Arrays.asList(
                new Object[][]{
                        {"tsiutsiura.test@gmail.com", "keyfnbr123"},
                        {"tsiutsiura", "keyfnbr"},
                        {"tsiutsiura1115@gmail.com", "keyfnbr"},
                        {" ", "keyfnbr"},
                        {"tsiutsiura1115@gmail.com", " "},
                        {"tsiutsiura.test@gmail.com", "keyfnbr"}
                }
        );
    }

    public TestLogin(String e, String p) {
        this.email = e;
        this.password = p;

    }

    @Test
    public void testLogin() throws Exception {
        openSite("https://www.bestessays.com/");

        //Enter Login page
        driver.findElement(By.linkText("Login")).click();
        sleep(5000);
        finder("//input[@id = 'login_email']");
        finder("//input[@id = 'pass']");
        finder("//button[@type = 'submit']").click();
        sleep(5000);
        assertEquals("Login", finder("//div[@class = 'title_text']").getText());

        //Fill the form on login page
        WebElement emailLogin = finder("//li//input[@name = 'email']");
        emailLogin.clear();
        emailLogin.sendKeys(email);

        WebElement passwordLogin = finder("//li//input[@name = 'pass']");
        passwordLogin.clear();
        passwordLogin.sendKeys(password);

        actions.moveToElement(finder("//form//input[@id = 'submit']")).click().perform();
        sleep(5000);

        try {

        assertEquals("https://www.bestessays.com/customer/orders/", driver.getCurrentUrl().toString());

        } catch (Exception e) {
            //Capture and append Exceptions/Errors
            verificationErrors.append(e.toString());

            System.err.println("Assertion Fail "+ verificationErrors.
                    toString());
        }
    }

    @AfterTest
    public void tearDown() {
        //Close the browser
        driver.quit();
        String verificationErrorString = verificationErrors.toString();

        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
