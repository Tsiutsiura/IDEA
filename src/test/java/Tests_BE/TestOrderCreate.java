package Tests_BE;

import Pages.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.annotations.AfterTest;
import java.util.Arrays;
import java.util.Collection;

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
                            {"13", "5", "3", "13"},  /*Tearm Paper, 3pages, 3days, Drama */
                            {"234", "4", "7", "52"}, /*Math, 4days, 15pages, Busines*/
                            {"125", "9", "10", "65"} /*Multiple Choice Questions (Non-time-framed), 6hour, 15pages, Technology*/
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
        openSite("https://www.bestessays.com/");
        sleep(5000);

        //Ожидание поп-апа и его закрытие
        //workWithPopUp();

        //Переход на ОФ и ее заполнение
        HomePage homePage = new HomePage(driver);
        //homePage.submitCalculator();
        homePage.goToOrderForm();
        sleep(5000);

        OrderForm orderForm = new OrderForm(driver);
        orderForm.typeFieldFirstName("test")
                .typeFieldLastName("test")
                .typeFieldEmail("tsiutsiura.test1@gmail.com")
                .typeFieldMobilePhone("44123456789")
                .typeFieldTopic("test order")
                .typeDoctype(doctype)
                .typeUrgency(urgency)
                .typeNumberOfPages(numberOfPage)
                .typeOrderCategory(subjectArea)
                .typeOrderDescription("test order ");
        orderForm.cppOrderForm();
        orderForm.totalOrderForm();
        orderForm.submitOrderForm ();
        sleep(10000);

        Preview preview = new Preview(driver);
        preview.cppOrderForm();
        preview.totalOrderForm();
        preview.submitOrderForm();
        sleep(10000);

        assertEquals("Different totals on OF and Preview",orderForm.getTotalOF(), preview.getTotalPreview());

        Payment payment = new Payment(driver);
        payment.typeNumberCardField()
                .typeMonthField()
                .typeYearField()
                .typeCvvField()
                .typeFirstNameField()
                .typeLastNameField()
                .typeCityField()
                .typeCountryField()
                .typeAddressField()
                .typeZipField()
                .typePhoneField();
        payment.totalPayment().getTotalPayment();
        payment.submitPayment();
        sleep(20000);

        ThankYouPage thankYouPage = new ThankYouPage(driver);
        thankYouPage.viewOrderSummary().getOrderSummary();
        thankYouPage.goToCustomerProfile();
        sleep(5000);

        Dashboard dashboard = new Dashboard (driver);
        dashboard.logOutFromCustomerProfile();

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
