import org.eclipse.jetty.util.Scanner;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.System.*;

public class SeleniumDemo {

    public static void main(String[] args) {


        WebDriver firefoxDriver= new FirefoxDriver();
        //firefoxDriver.get("https://www.google.com/");
        //firefoxDriver.get("https://www.sinoptik.bg/kiev-ukraine-100703448?location");
        firefoxDriver.get("https://www.bestessay.com/");



     /*   String baseUrl;
        //firefoxDriver.quit();

        //String property = System.getProperty("user.dir")+"/driver/chromedriver";
        //System.setProperty("webdriver.chrome.driver", property);

        WebDriver driver = new ChromeDriver();
        driver.get("http://cd-market.ua/");
        //WebElement go = driver.findElement(By.name("q"));


        driver.quit();*/

    }
}
