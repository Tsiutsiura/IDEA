import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class OrderCreateTest_BE extends GeneralMethodth {

    @Test
    public void createOrder() throws InterruptedException {

        //Открытие сайта
        fireFoxDriver.get("https://www.bestessays.com/");
        fireFoxDriver.manage().window().maximize();

        sleep(5000);
        /*//Ожидание поп-апа и его закрытие
        FluentWait wait = new WebDriverWait(fireFoxDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='bio_ep_close']")));
        finder("//span[@id='bio_ep_close']").click();*/

        //Переход на ОФ и ее заполнение
        Actions actions = new Actions(fireFoxDriver);
        actions.moveToElement(finder("//div[@class='Procced  bottomPreOrder clearfix']")).click().perform();

        sleep(5000);

        finder("//input[@id='firstname']").sendKeys("test");
        finder("//input[@id='lastname']").sendKeys("test");
        finder("//input[@id='email']").sendKeys("tsiutsiura.test@gmail.com");
        finder("//input[@id='mobile-phone']").sendKeys("44123456789");
        finder("//input[@id='topic']").sendKeys("test order");

        actions.moveToElement(finder("//select[@id='doctype']"))
                .moveToElement(finder("//select[@id='doctype']//option[@value='13']")).click().perform();
        actions.moveToElement(finder("//select[@id='urgency']"))
                .moveToElement(finder("//select[@id='urgency']//option[@value='5']")).click().perform();
        actions.moveToElement(finder("//select[@id='numpages']"))
                .moveToElement(finder("//select[@id='numpages']//option[@value='3']")).click().perform();
        actions.moveToElement(finder("//select[@id='order_category']"))
                .moveToElement(finder("//select[@id='order_category']//option[@value='13']")).click().perform();
        finder("//textarea[@id='details']").sendKeys("test order ");

        String cppOF = finder("//div[@id = 'price-per-page-bl']//div [@class ='prices-num-block']").getText();
        System.out.println( "CPP = " + cppOF);

        String totalOF = finder("//div[@id='price-total-bl']//div [@class ='prices-num-block']").getText();
        System.out.println( "Total on OF = " + totalOF );

        //Переход на Preview и работа с ней
        actions.moveToElement(finder("//input[@id='submit_order_form']")).click().perform();


        String cppPreview = finder("//div[@id = 'price-per-page-bl']//div [@class ='prices-num-block']").getText();
        System.out.println( "CPP = " + cppPreview);

        String totalPreview = finder("//div[@id='price-total-bl']//div [@class ='prices-num-block']").getText();
        System.out.println( "Total on OF = " + totalPreview );


        cppPreview.equals(cppOF);
        totalPreview.equals(totalOF);
        sleep(10000);
        actions.moveToElement(finder("//div[@class ='button-block-submit']//input[@class='edit_order_proceed']")).click().perform();
        sleep(10000);
        actions.moveToElement(finder("//input[@id='skip_credit']")).click().perform();


        sleep(10000);
        fireFoxDriver.quit();

    }


}
