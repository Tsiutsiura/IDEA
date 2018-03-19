package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Payment {

    private By totalLocator = By.xpath("//td[@id='order_total']//div [@class ='order_total__sum']");
    private By numberCardLocator = By.xpath("//input[@id = 'cc_number']");

    private By monthFieldLocator = By.xpath("//select[@id = 'exp_month']");
    private By yearFieldLocator = By.xpath("//select[@id = 'exp_year']");
    private By cvvFieldLocator = By.xpath("//input[@id = 'cvv2']");
    private By firstNameFieldLocator = By.xpath("//input[@id = 'firstname']");
    private By lastNameFieldLocator = By.xpath("//input[@id = 'lastname']");
    private By addressFieldLocator = By.xpath("//input[@id = 'address']");
    private By cityFieldLocator = By.xpath("//input[@id = 'city']");
    private By countryFieldLocator = By.xpath("//select[@id = 'country']");
    private By zipFieldLocator = By.xpath("//input[@id = 'zip']");
    private By phoneFieldLocator = By.xpath("//input[@id = 'phone']");
    private By submitButtonLocator = By.xpath("//input[@id = 'submit_billing_form']");
    private  String totalPayment;

    private WebDriver driver;
    private Actions actions ;
    private Select select;

    public Payment(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public Payment typeNumberCardField() {
        driver.findElement(numberCardLocator).sendKeys("4111111111111111");
        return this;
    }
    public Payment typeMonthField() {
        select= new Select(driver.findElement(monthFieldLocator));
        select.selectByValue("1");

        /*actions.moveToElement(driver.findElement(monthFieldLocator))
                .moveToElement(driver.findElement(By.xpath("//select[@id = 'exp_month']//option[@value='1']"))).click().perform();*/
        return this;
    }
    public Payment typeYearField() {
        select=new Select(driver.findElement(yearFieldLocator));
        select.selectByValue("19");

        /*actions.moveToElement(driver.findElement(yearFieldLocator))
                .moveToElement(driver.findElement(By.xpath("//select[@id = 'exp_year']//option[@value='19']"))).click().perform();*/
        return this;
    }
    public Payment typeCvvField() {
        driver.findElement(cvvFieldLocator).sendKeys("123");
        return this;
    }
    public Payment typeFirstNameField() {
        driver.findElement(firstNameFieldLocator).sendKeys("test");
        return this;
    }
    public Payment typeLastNameField() {
        driver.findElement(lastNameFieldLocator).sendKeys("test");
        return this;
    }
    public Payment typeAddressField() {
        driver.findElement(addressFieldLocator).sendKeys("test");
        return this;
    }
    public Payment typeCityField() {
        driver.findElement(cityFieldLocator).sendKeys("South park");
        return this;
    }
    public Payment typeCountryField() {
        select = new Select(driver.findElement(countryFieldLocator));
        select.selectByValue("US");

        /*actions.moveToElement(driver.findElement(countryFieldLocator))
                .moveToElement(driver.findElement(By.xpath("//select[@id = 'country']//option[@value='US']"))).click().perform();*/
        return this;
    }
    public Payment typeZipField() {
        driver.findElement(zipFieldLocator).sendKeys("1234567");
        return this;
    }
    public Payment typePhoneField() {
        driver.findElement(phoneFieldLocator).sendKeys("123456789");
        return this;
    }
    public ThankYouPage submitPayment() {
        actions.moveToElement(driver.findElement(submitButtonLocator)).click().perform();
        return new ThankYouPage(driver);
    }
    public Payment totalPayment() {
        totalPayment = driver.findElement(totalLocator).getText();
        return this;
    }




}
