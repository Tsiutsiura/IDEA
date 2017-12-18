import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GeneralMethods extends Assert {

   /* private int indicatorBrowser = 0;

    WebDriver driver;

    public GeneralMethods(int browser) {
        this.indicatorBrowser = browser;,

        if(indicatorBrowser == 0) {
            this.driver = new FirefoxDriver();
        } else if (indicatorBrowser == 1) {
            this.driver = new ChromeDriver();
        } else {
            System.out.println("browser don`t check");
        }
    }*/

    public GeneralMethods() {
    }

    static WebDriver driver = new FirefoxDriver();

    public void openSite(String s) {
        driver.get(s);
        driver.manage().window().maximize();
    }


    public WebElement finder(String st) {
        return driver.findElement(By.xpath(st));
    }

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


}
