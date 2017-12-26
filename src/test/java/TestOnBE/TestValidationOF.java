package TestOnBE;

import Pages.OrderForm;
import org.junit.Test;

public class TestValidationOF extends GeneralMethods {
    @Test
    public void testValidationOF() throws InterruptedException {
        openSite("https://www.bestessays.com/order/");
        sleep(5000);

        new OrderForm(driver).typeFieldCountry().submitOrderForm();
        sleep(5000);
        /*actions.moveToElement(finder("//select[@id = 'country']")).moveToElement(finder("//select[@id = 'country']//option[@value]")).click().perform();
        submitOF();
*/
        assertEquals("Enter your first name", finder("//div[@id = 'error_firstname']").getText());
        assertEquals("Enter your last name", finder("//div[@id = 'error_lastname']").getText());
        assertEquals("Enter valid email address", finder("//div[@id = 'error_email']").getText());
        assertEquals("Select country code", finder("//div[@id = 'error_country']").getText());
        assertEquals("Enter valid phone number in the following format: country code - area code - phone number",
                finder("//div[@id = 'error_phone1']").getText());
        assertEquals("Fill in the field", finder("//div[@id = 'error_topic']").getText());
        assertEquals("Select number of pages", finder("//div[@id = 'error_numpages']").getText());
        assertEquals("Select subject area", finder("//div[@id = 'error_order_category']").getText());
        assertEquals("Type order description", finder("//div[@id = 'error_details']").getText());

        driver.quit();
    }
}
