package MaxPay;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General_MP extends Assert {
    public General_MP() {
    }

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);




    public void sleep(int time) {
        //явное ожидание
        try {  Thread.sleep(time); } catch (InterruptedException e) {e.printStackTrace(); }
        //неявное ожидание
        /* driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);*/

    }

    public void openPage() {
        driver.get("https://my-sandbox.maxpay.com/#/signin");
        driver.manage().window().maximize();
    }
}
