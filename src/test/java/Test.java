import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    @org.junit.Test
    public void test() {

        WebDriver driver = new ChromeDriver();
        driver.get ("https://my-sandbox.maxpay.com/#/signin");
        driver.manage().window().maximize();
        try {  Thread.sleep(15000); } catch (InterruptedException e) {e.printStackTrace(); }
    }
}
