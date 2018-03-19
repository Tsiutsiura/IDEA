package Tests_BE;

import Pages.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

@RunWith(value = Parameterized.class)

public class TestOrderCreate extends GeneralMethods {

    private String doctype;
    private String urgency;
    private String numberOfPage;
    private String subjectArea;

    private static StringBuffer verificationErrors = new StringBuffer();

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(
                new Object[][]{
                        //{"13", "5", "3", "13"},  /*Tearm Paper, 3pages, 3days, Drama */
                        //{"234", "4", "7", "52"}, /*Math, 4days, 15pages, Busines*/
                        {"125", "9", "10", "65"} /*Multiple Choice Questions (Non-time-framed), 6hour, 10pages, Technology*/
                        //{"0", "9", "10", "65"} /*Essay, 6hour, 10pages, Technology*/
                }
        );
    }

    public TestOrderCreate(String doctype, String urgency, String numberOfPage, String subjectArea) {
        this.doctype = doctype;
        this.urgency = urgency;
        this.numberOfPage = numberOfPage;
        this.subjectArea = subjectArea;
    }


    @Test
    public void testCreateOrder() throws InterruptedException {
        openSite("https://ca.bestessays.com/");
        sleep(2000);

        //Ожидание поп-апа и его закрытие
        //workWithPopUp();

        //Переход на ОФ и ее заполнение
        HomePage homePage = new HomePage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getOrderButtonLocator()));
        //homePage.submitCalculator();
        homePage.goToOrderForm();
        //sleep(5000);

        OrderForm orderForm = new OrderForm(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderForm.getFieldDoctypeLocator()));
        orderForm.typeDoctype(doctype);
        orderForm.typeFieldFirstName("test");
        orderForm.typeFieldLastName("test");
        orderForm.typeFieldEmail("tsiutsiura.test1@gmail.com");
        orderForm.typeFieldRetypeEmail("tsiutsiura.test1@gmail.com");
        orderForm.typeFieldCountry("192");
        orderForm.typeFieldMobilePhone("3213121312345");
        orderForm.typeFieldTopic("test order");
        orderForm.typeUrgency(urgency);
        orderForm.typeNumberOfPages(numberOfPage);
        orderForm.typeOrderCategory(subjectArea);
        orderForm.typeOrderDescription("test order ");
        orderForm.cppOrderForm();
        orderForm.totalOrderForm();
        Preview preview = orderForm.submitOrderForm();

        //Preview preview = new Preview(driver);

        sleep(5000);
        // wait.until(((JavascriptExecutor)driver).executeScript());

        preview.cppOrderForm();
        preview.totalOrderForm();
        Payment payment = preview.submitOrderForm();

        //sleep(5000);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'billing__h']")));
        assertEquals("Different totals on OF and Preview", orderForm.getTotalOF(), preview.getTotalPreview());

        //Payment payment = new Payment(driver);
        payment.typeNumberCardField();
        payment.typeMonthField();
        payment.typeYearField();
        payment.typeCvvField();
        payment.typeFirstNameField();
        payment.typeLastNameField();
        payment.typeCityField();
        payment.typeCountryField();
        payment.typeAddressField();
        payment.typeZipField();
        payment.typePhoneField();
        payment.totalPayment().getTotalPayment();
        ThankYouPage thankYouPage =  payment.submitPayment();
        sleep(20000);


        //ThankYouPage thankYouPage = new ThankYouPage(driver);
        thankYouPage.viewOrderSummary().getOrderSummary();
/*        thankYouPage.goToCustomerProfile();
        sleep(5000);

        Dashboard dashboard = new Dashboard(driver);
        dashboard.logOutFromCustomerProfile();*/
    }

    @AfterTest
    public void tearDown() {
        //Close the browser
        driver.close();
        String verificationErrorString = verificationErrors.toString();

        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


}
