package Pages;

import Tests_BE.GeneralMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.*;

public class OrderForm extends GeneralMethods {

    private By fieldFirstNameLocator = By.xpath("//input[@id='firstname']");
    private By fieldLastNameLocator = By.xpath("//input[@id='lastname']");
    private By fieldEmailLocator = By.xpath("//input[@id='email']");
    private By fieldRetypeEmailLocator = By.xpath("//input[@id='retype_email']");

    private By fieldCountryLocator = By.xpath("//select[@id='country']");
    private By fieldMobilePhoneLocator = By.xpath("//input[@id='phone1_area']");
    private By fieldTopicLocator = By.xpath("//input[@id='topic']");
    private By fieldDoctypeLocator = By.xpath("//select[@id='doctype']");
    private By fieldUrgencyLocator = By.xpath("//select[@id='urgency']");
    private By fieldNumPagesLocator = By.xpath("//select[@id='numpages']");
    private By fieldOrderCategoryLocator = By.xpath("//select[@id='order_category']");
    private By fieldOrderDescriptionLocator = By.xpath("//textarea[@id='details']");
    private By buttonSubmitLocator = By.xpath("//a[@id='js-floatBtn']");

   // private By cppLocator = By.xpath("//div[@id = 'price-per-page-bl']//div [@class ='prices-num-block']");
    private By cppLocator = By.xpath("//span[@id = 'cost_per_page']");
    private By totalLocator = By.xpath("//span[@id='total']");
    private  String cppOF;
    private  String totalOF;

    private WebDriver driver;
    private Actions actions ;
    private Select select ;


    public By getFieldDoctypeLocator() {
        return fieldDoctypeLocator;
    }

    public OrderForm(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);

    }

    public String getCppOF() {
        return cppOF;
    }
    public String getTotalOF() {
        return totalOF;
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
    public OrderForm typeFieldRetypeEmail(String email) {
        driver.findElement(fieldRetypeEmailLocator).sendKeys(email);
        return this;
    }
    public OrderForm typeFieldMobilePhone(String mobilePhone) {
        driver.findElement(fieldMobilePhoneLocator).sendKeys(mobilePhone);
        return this;
    }
    public OrderForm typeFieldCountry(String  value) {

       select= new Select(driver.findElement(fieldCountryLocator));
        select.selectByValue(value);

        /*actions.moveToElement(driver.findElement(fieldCountryLocator))
                .moveToElement(driver.findElement(By.xpath("//select[@id='country']//option[@value='"+value+"']"))).click().build().perform();*/
        return this;
    }
    public OrderForm typeFieldTopic(String topic) {
        driver.findElement(fieldTopicLocator).sendKeys(topic);
        return this;
    }
    public OrderForm typeDoctype(String  value) {
        select= new Select(driver.findElement(fieldDoctypeLocator));
        select.selectByValue(value);

        /*actions.moveToElement(driver.findElement(fieldDoctypeLocator))
                .moveToElement(driver.findElement(By.xpath("//select[@id='doctype']//option[@value='"+value+"']"))).click().build().perform();*/

        sleep(2000);
        return this;
    }
    public OrderForm typeUrgency(String value) {
        select= new Select(driver.findElement(fieldUrgencyLocator));
        select.selectByValue(value);

        /*actions.moveToElement(driver.findElement(fieldUrgencyLocator))
                .moveToElement(driver.findElement(By.xpath("//select[@id='urgency']//option[@value='"+value+"']"))).click().perform();*/
        return this;
    }
    public OrderForm typeNumberOfPages(String value) {
        select= new Select(driver.findElement(fieldNumPagesLocator));
        select.selectByValue(value);

        /*actions.moveToElement(driver.findElement(fieldNumPagesLocator))
                .moveToElement(driver.findElement(By.xpath("//select[@id='numpages']//option[@value='"+value+"']"))).click().perform();*/
        return this;
    }
    public OrderForm typeOrderCategory(String value) {
        select= new Select(driver.findElement(fieldOrderCategoryLocator));
        select.selectByValue(value);

        /*actions.moveToElement(driver.findElement(fieldOrderCategoryLocator))
                .moveToElement(driver.findElement(By.xpath("//select[@id='order_category']//option[@value='"+value+"']"))).click().perform();*/
        return this;
    }
    public OrderForm typeOrderDescription(String orderDescription) {
        driver.findElement(fieldOrderDescriptionLocator).sendKeys(orderDescription);
        return this;
    }
    public OrderForm submitOrderForm() throws InterruptedException {
        driver.findElement(buttonSubmitLocator).click();
        /*actions.moveToElement(driver.findElement(buttonSubmitLocator)).click().perform();*/

        //wait.until(ExpectedConditions.urlMatches("https://www.bestessays.com/order/preview/"));

        return this;
    }
    public OrderForm cppOrderForm() {
        cppOF = driver.findElement(cppLocator).getText();
        System.out.println("CPP on OF = " + cppOF);
        return this;
    }
    public OrderForm totalOrderForm() {
        totalOF = driver.findElement(totalLocator).getText();
        System.out.println("Total on OF = " + totalOF);
        return this;
    }

}
