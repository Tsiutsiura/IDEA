package TestOnBE;

import Pages.HomePage;
import Pages.OrderForm;
import org.junit.Test;


public class TestOrderCreate_Positive extends GeneralMethods {

    /*TestOnBE.GeneralMethods generalMethods = new TestOnBE.GeneralMethods(0);*/

    @Test
    public void testCreateOrder() throws InterruptedException {
        openSite("https://www.bestessays.com/");
        sleep(5000);

        //Ожидание поп-апа и его закрытие
        //workWithPopUp();

        //Переход на ОФ и ее заполнение
        HomePage homePage = new HomePage(driver);
        homePage.submiCalculator();
        sleep(5000);

        OrderForm orderForm = new OrderForm(driver);
        orderForm.typeFieldFirstName("test")
                .typeFieldLastName("test")
                .typeFieldEmail("tsiutsiura.test1@gmail.com")
                .typeFieldMobilePhone("44123456789")
                .typeFieldTopic("test order")
                .typeDoctype()
                .typeUrgency()
                .typeNumberOfPages()
                .typeOrderCategory()
                .typeOrderDescription("test order ");
        orderForm.cppOrderForm();
        orderForm.totalOrderForm();
        System.out.println("CPP = " + orderForm.cppOF + ", Total on OF = " + orderForm.totalOF);

        orderForm.submitOrderForm ();

        //Переход на ОФ и ее заполнение
        /*actions.moveToElement(finder("//div[@class='Procced  bottomPreOrder clearfix']")).click().perform();*/

        /*String totalOF = workWithOF();

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
        workWithThankYouPage();*/


    }





}
