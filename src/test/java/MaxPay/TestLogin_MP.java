package MaxPay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public class TestLogin_MP extends General {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 25);

    private String email;
    private String password;

    private static StringBuffer verificationErrors = new StringBuffer();


    @Parameters
    public static Collection testData(){
        return Arrays.asList(
                new Object[][]{
                        {"tsiutsiura.test@gmail.com", "keyfnbr123"}   /*,
                        {"tsiutsiura", "keyfnbr"},
                        {"tsiutsiura1115@gmail.com", "keyfnbr"},
                        {"   ", "keyfnbr"},
                        {"tsiutsiura1115@gmail.com", " "},
                        {"tsiutsiura.test@gmail.com", "keyfnbr"}*/
                }
        );
    }


    public TestLogin_MP(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Test
    public void testLogin() throws Exception {

        driver.get("https://my-sandbox.maxpay.com/#/signin");
        driver.manage().window().maximize();
        sleep(5000);

        LoginPage_MP loginPage = new LoginPage_MP(driver);

        loginPage.typeEmail(email);
       /* loginPage.typePassword(password);
        loginPage.submitLoginPage();

        sleep(5000);
*/
       // assertEquals("This is still login page", "https://my-sandbox.maxpay.com/app.php#/app/dashboard", driver.getCurrentUrl().toString());
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
