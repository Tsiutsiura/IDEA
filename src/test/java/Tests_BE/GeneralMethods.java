package Tests_BE;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralMethods extends Assert {

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
        try {  Thread.sleep(time); } catch (InterruptedException e) {e.printStackTrace(); }
        //неявное ожидание
       /* driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);*/

    }

    public void workWithPopUp() {
        FluentWait wait = new WebDriverWait(GeneralMethods.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='bio_ep_close']")));
        finder("//span[@id='bio_ep_close']").click();
    }


   /* private int indicatorBrowser = 0;

    WebDriver driver;

    public Tests_BE.GeneralMethods(int browser) {
        this.indicatorBrowser = browser;,

        if(indicatorBrowser == 0) {
            this.driver = new FirefoxDriver();
        } else if (indicatorBrowser == 1) {
            this.driver = new ChromeDriver();
        } else {
            System.out.println("browser don`t check");
        }
    }*/

}
