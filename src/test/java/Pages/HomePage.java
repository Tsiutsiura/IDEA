package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    By loginButtonLocator = By.linkText("LOG IN");
    By calculatorSubmitButtonLocator = By.xpath("//a[@class='price-calc__btn']");
    By orderButtonLocator = By.linkText("Order Now");


    private final WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    public By getOrderButtonLocator() {
        return orderButtonLocator;
    }

    public HomePage submitLoginBlock() {
        driver.findElement(loginButtonLocator).click();
        return new HomePage(driver);
    }

    public HomePage submitCalculator() {
        driver.findElement(calculatorSubmitButtonLocator).click();
        return new HomePage(driver);
    }
    public HomePage goToOrderForm() {
        driver.findElement(orderButtonLocator).click();
        return new HomePage(driver);
    }



}
