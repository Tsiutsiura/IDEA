package Pages;

import Tests_BE.GeneralMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Yulia.Tsyutsyura on 19.03.2018.
 */
public class Prices extends GeneralMethods {
    private WebDriver driver;
    private Actions actions;
    private Select select;

    private By fieldDoctypeLocator = By.xpath("//select[@id='set-doctype']");
    private By fieldSubjectLocator = By.xpath("//select[@id='set-category']");
    private By fieldNumberOfPagesLocator = By.xpath("//input[@id='pages_count']");
    private By ButtonCurrencyCAD = By.linkText("CAD");
    private By ButtonCurrencyUSD = By.linkText("USD");
    private By ButtonCurrencyGBP = By.linkText("GBP");
    private By ButtonCurrencyEUR = By.linkText("EUR");
    private By ActiveCurrencyLocator = By.xpath("//a[@class = 'price_table__currency-link active']");
    private By pricesLocator ;


    public Prices(WebDriver driver) {
        this.driver = driver;
    }

    public Prices selectDoctype(String value) {
        if (value != "125" && value != "82"){
            pricesLocator = By.xpath("//a[@class='pcolum_1 with_ff']");
        }else {
            pricesLocator = By.xpath("//a[@class='pcolum_1']");

        }
        select = new Select(driver.findElement(fieldDoctypeLocator));
        select.selectByValue(value);
        return this;
    }

    public Prices selectSubject(String value) {

        select = new Select(driver.findElement(fieldSubjectLocator));
        select.selectByValue(value);

        return this;

    }

    public By getFieldDoctypeLocator() {
        return fieldDoctypeLocator;
    }

    public By getFieldSubjectLocator() {
        return fieldSubjectLocator;
    }

    public By getFieldNumberOfPagesLocator() {
        return fieldNumberOfPagesLocator;
    }

    public By getPricesLocator() {
        return pricesLocator;
    }

    public Prices typeNumberOfPages(String value) {
        WebElement field = driver.findElement(fieldNumberOfPagesLocator);
        field.clear();
        field.sendKeys(value);
        return this;
    }

    public Prices cklickOnButtonCAD() {
        driver.findElement(ButtonCurrencyCAD).click();
        return this;
    }

    public Prices cklickOnButtonUSD() {
        driver.findElement(ButtonCurrencyUSD).click();
        return this;
    }

    public Prices cklickOnButtonGBP() {
        driver.findElement(ButtonCurrencyGBP).click();
        return this;
    }

    public Prices cklickOnButtonEUR() {
        driver.findElement(ButtonCurrencyEUR).click();
        return this;
    }

    public String findActiveCurrency() {
        String actualCurrency = driver.findElement(ActiveCurrencyLocator).getText();
        return actualCurrency;
    }

    public Prices showPrices() {

        String price = driver.findElement( pricesLocator).getText();
        System.out.println(price);
        return this;
    }
}
