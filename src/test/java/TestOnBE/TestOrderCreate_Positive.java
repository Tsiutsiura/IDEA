package TestOnBE;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TestOrderCreate_Positive extends GeneralMethods {

    /*TestOnBE.GeneralMethods generalMethods = new TestOnBE.GeneralMethods(0);*/

    @Test
    public void testCreateOrder() throws InterruptedException {
        openSite("https://www.bestessays.com/");
        sleep(5000);

        //Ожидание поп-апа и его закрытие
        //workWithPopUp();

        //Переход на ОФ и ее заполнение
        actions.moveToElement(finder("//div[@class='Procced  bottomPreOrder clearfix']")).click().perform();
        sleep(5000);

        String totalOF = workWithOF();

        //Переход на Preview и работа с ней
        String totalPreview = workWithPreview();

        //Проверка совпадения тотала на ОФ и превью
        assertEquals(totalPreview, totalOF);

        //Уход со страницы оплаты кредитом, переход на пеймент
        //workWithPageStoreCredit();

        //заполнение формы оплаты
        String totalPayment = workWithPaymentForm();

        //Проверка Совпадения тотала на ОФ и пейменте
        //assertEquals(totalOF, totalPayment);

        //Thank you page
        workWithThankYouPage();

        driver.close();
    }





}
