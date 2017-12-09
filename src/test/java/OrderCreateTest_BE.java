import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OrderCreateTest_BE extends GeneralMethodth {

    @Test
    public void createOrder() throws InterruptedException {
        // FirefoxDriver fireFoxDriver = new FirefoxDriver();

        //Открытие сайта
        fireFoxDriver.get("https://www.bestessays.com/");
        fireFoxDriver.manage().window().maximize();


        //Ожидание поп-апа и его закрытие
        FluentWait wait = new WebDriverWait(fireFoxDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='bio_ep_close']")));
        finder("//span[@id='bio_ep_close']").click();

        Actions actions = new Actions(fireFoxDriver);
        actions.moveToElement(finder("//div[@class='Procced  bottomPreOrder clearfix']")).click().perform();

        //Переход на ОФ и ее заполнение
        sleep(5000);

        finder("//input[@id='firstname']").sendKeys("test");
        finder("//input[@id='lastname']").sendKeys("test");
        finder("//input[@id='email']").sendKeys("tsiutsiura.test@gmail.com");
        finder("//input[@id='mobile-phone']").sendKeys("44123456789");
        finder("//input[@id='topic']").sendKeys("test order");

        actions.moveToElement(finder("//select[@id='doctype']")).moveToElement(finder("//select[@id='doctype']//option[@value='13']")).click().perform();
        actions.moveToElement(finder("//select[@id='urgency']")).moveToElement(finder("//select[@id='urgency']//option[@value='5']")).click().perform();
        actions.moveToElement(finder("//select[@id='numpages']")).moveToElement(finder("//select[@id='numpages']//option[@value='3']")).click().perform();

        /*finder("//select[@id='doctype']").click();
        finder("//option[@text='Term Paper']").click();*/

        sleep(10000);
        fireFoxDriver.quit();

    }


}
