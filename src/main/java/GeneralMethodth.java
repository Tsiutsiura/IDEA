import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeneralMethodth {

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
