import org.eclipse.jetty.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeneralMethods {

   /* private int browser;

    public GeneralMethods(int browser) {
        this.browser = browser;

        switch (this.browser){
            case 0:
                FirefoxDriver fireFoxDriver = new FirefoxDriver();
            case 1:
                ChromeDriver chromeDriver = new ChromeDriver();
        }
    }*/



    FirefoxDriver fireFoxDriver = new FirefoxDriver();

        public WebElement finder(String st){
            return   fireFoxDriver.findElement(By.xpath(st));
        }

        public void sleep(int time) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


}
