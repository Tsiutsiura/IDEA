package MaxPay;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General extends Assert {
    public General() {
    }






    public void sleep(int time) {
        //явное ожидание
        try {  Thread.sleep(time); } catch (InterruptedException e) {e.printStackTrace(); }
        //неявное ожидание
        /* driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);*/

    }

}
