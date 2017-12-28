package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    By loginButtonLocator = By.linkText("Login");
    By calculatorSubmitButtonLocator = By.xpath("//div[@class='Procced  bottomPreOrder clearfix']");
    By orderButtonLocator = By.linkText("Order");


    private final WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
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
