package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class OrderForm {

    private By fieldFirstNameLocator = By.xpath("//input[@id='firstname']");
    private By fieldLastNameLocator = By.xpath("//input[@id='lastname']");
    private By fieldEmailLocator = By.xpath("//input[@id='email']");
    private By fieldCountryLocator = By.xpath("//select[@id = 'country']");
    private By fieldMobilePhoneLocator = By.xpath("//input[@id='mobile-phone']");
    private By fieldTopicLocator = By.xpath("//input[@id='topic']");
    private By fieldDoctypeLocator = By.xpath("//select[@id='doctype']");
    private By fieldUrgencyLocator = By.xpath("//select[@id='urgency']");
    private By fieldNumPagesLocator = By.xpath("//select[@id='numpages']");
    private By fieldOrderCategoryLocator = By.xpath("//select[@id='order_category']");
    private By fieldOrderDescriptionLocator = By.xpath("//textarea[@id='details']");
    private By buttonSubmitLocator = By.xpath("//input[@id='submit_order_form']");
    private By cppLocator = By.xpath("//div[@id = 'price-per-page-bl']//div [@class ='prices-num-block']");
    private By totalLocator = By.xpath("//div[@id='price-total-bl']//div [@class ='prices-num-block']");
    public static String cppOF;
    public static String totalOF;

    private WebDriver driver;
    private Actions actions ;

    public OrderForm(WebDriver driver) {

        this.driver = driver;
        actions = new Actions(driver);
    }
    public OrderForm typeFieldFirstName(String firstName) {
        driver.findElement(fieldFirstNameLocator).sendKeys(firstName);
        return this;
    }
    public OrderForm typeFieldLastName(String lastName) {
        driver.findElement(fieldLastNameLocator).sendKeys(lastName);
        return this;
    }
    public OrderForm typeFieldEmail(String email) {
        driver.findElement(fieldEmailLocator).sendKeys(email);
        return this;
    }
    public OrderForm typeFieldMobilePhone(String mobilePhone) {
        driver.findElement(fieldMobilePhoneLocator).sendKeys(mobilePhone);
        return this;
    }
    public OrderForm typeFieldCountry() {
        actions.moveToElement(driver.findElement(fieldCountryLocator))
                .moveToElement(driver.findElement(By.xpath("//select[@id = 'country']//option[@value]"))).click().perform();
        return this;
    }
    public OrderForm typeFieldTopic(String topic) {
        driver.findElement(fieldTopicLocator).sendKeys(topic);
        return this;
    }
    public OrderForm typeDoctype() {
        actions.moveToElement(driver.findElement(fieldDoctypeLocator)).moveToElement(driver.findElement(By.xpath("//select[@id='doctype']//option[@value='13']"))).click().build().perform();
        return this;
    }
    public OrderForm typeUrgency() {
        actions.moveToElement(driver.findElement(fieldUrgencyLocator))
                .moveToElement(driver.findElement(By.xpath("//select[@id='urgency']//option[@value='5']"))).click().perform();
        return this;
    }
    public OrderForm typeNumberOfPages() {
        actions.moveToElement(driver.findElement(fieldNumPagesLocator))
                .moveToElement(driver.findElement(By.xpath("//select[@id='numpages']//option[@value='3']"))).click().perform();
        return this;
    }
    public OrderForm typeOrderCategory() {
        actions.moveToElement(driver.findElement(fieldOrderCategoryLocator))
                .moveToElement(driver.findElement(By.xpath("//select[@id='order_category']//option[@value='13']"))).click().perform();
        return this;
    }
    public OrderForm typeOrderDescription(String orderDescription) {
        driver.findElement(fieldOrderDescriptionLocator).sendKeys(orderDescription);
        return this;
    }
    public OrderForm submitOrderForm() {
        actions.moveToElement(driver.findElement(buttonSubmitLocator)).click().perform();
        return this;
    }
    public String cppOrderForm() {
         driver.findElement(cppLocator).getText();
        System.out.println("Total on OF = " + cppOF);
        return cppOF;
    }
    public String totalOrderForm() {
        driver.findElement(totalLocator).getText();
        System.out.println("Total on OF = " + totalOF);
        return totalOF;
    }

}
