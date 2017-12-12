import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class OrderCreateTest_BE extends GeneralMethods {

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

        //Проверка совпадения тотала на ОФ и превью
        assertEquals (totalPreview, totalOF);

        //Переход на страницу оплаты кредитом
        sleep(10000);
        actions.moveToElement(finder("//div[@class ='button-block-submit']//input[@class='edit_order_proceed']")).click().perform();

        //Уход со страницы оплаты кредитом, переход на пеймент
        sleep(10000);
        actions.moveToElement(finder("//input[@id='skip_credit']")).click().perform();

        //заполнение формы оплаты
        String totalPayment = finder("//td[@id='order_total']//div [@class ='order_total__sum']").getText();
        System.out.println( "Total on Payment = " + totalPayment );

        //Проверка Совпадения тотала на ОФ и пейменте
        assertEquals(totalOF, totalPayment);

        finder("//input[@id = 'cc_number']").sendKeys("4111111111111111");
        actions.moveToElement(finder("//select[@id = 'exp_month']")).click().moveToElement(finder("//select[@id = 'exp_month']//option[@value='1']"));
        actions.moveToElement(finder("//select[@id = 'exp_year']")).click().moveToElement(finder("//select[@id = 'exp_year']//option[@value='19']"));
        finder("//input[@id = 'cvv2']").sendKeys("123");
        finder("//input[@id = 'firstname']").sendKeys("test");
        finder("//input[@id = 'lastname']").sendKeys("test");
        finder("//input[@id = 'address']").sendKeys("test");
        finder("//input[@id = 'city']").sendKeys("South park");
        finder("//input[@id = 'city']").sendKeys("South park");
        actions.moveToElement(finder("//select[@id = 'country']")).click().moveToElement(finder("//select[@id = 'country']//option[@value='US']"));
        finder("//input[@id = 'zip']").sendKeys("1234567");
        finder("//input[@id = 'phone']").sendKeys("123456789");
        actions.moveToElement(finder("//input[@id = 'submit_billing_form']")).click();

        //Thank you page
        String orderNumber = finder("//div [@class ='order-summary']").getText();
        System.out.println( "Order summary= " + orderNumber );


        sleep(10000);
        fireFoxDriver.quit();

    }


}
