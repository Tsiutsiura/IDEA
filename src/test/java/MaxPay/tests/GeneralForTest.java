package MaxPay.tests;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocationContext;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class GeneralForTest extends Assert {
    public GeneralForTest() {
    }

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 25);


    public void sleep(int time) {
        //явное ожидание
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //неявное ожидание
        /* driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);*/

    }

    @Before
    public void openPage() {
        driver.get("https://my.maxpay.com/#/signin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     /*@After
    public void tearDown() {
        //Close the browser
        driver.close();
        String verificationErrorString = verificationErrors.toString();

        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }*/
    }
}