package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

   private By loginButtonLocator = By.linkText("LOG IN");
   private By calculatorSubmitButtonLocator = By.xpath("//a[@class='price-calc__btn']");
   private By orderButtonLocator = By.linkText("Order Now");
  // private By pricesButtonLocator = By.linkText("Prices");
   private By pricesButtonLocator = By.xpath("//li[@class ='top_menu__item top_menu__link_prices']");


    private final WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    public By getOrderButtonLocator() {
        return orderButtonLocator;
    }

    public By getPricesButtonLocator() {
        return pricesButtonLocator;
    }

    public HomePage submitLoginBlock() {
        driver.findElement(loginButtonLocator).click();
        return new HomePage(driver);
    }

    public HomePage submitCalculator() {
        driver.findElement(calculatorSubmitButtonLocator).click();
        return new HomePage(driver);
    }
    public OrderForm goToOrderForm() {
        driver.findElement(orderButtonLocator).click();
        return new OrderForm(driver);
    }
    public Prices goToPricesTable() {
        driver.findElement(pricesButtonLocator).click();
        return new Prices(driver);
    }


}
