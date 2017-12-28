package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ThankYouPage {

    private By orderSummaryLocator = By.xpath("//div [@class ='order-summary']");
    By customerProfileButtonLocator = By.linkText("My profile");
    private String orderSummary;

    private WebDriver driver;
    private Actions actions ;

    public ThankYouPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public String getOrderSummary() {
        return orderSummary;
    }

    public ThankYouPage viewOrderSummary() {
        orderSummary = driver.findElement(orderSummaryLocator).getText();
        System.out.println(orderSummary);
        return this;
    }

    public HomePage goToCustomerProfile() {
        driver.findElement(customerProfileButtonLocator).click();
        return new HomePage(driver);
    }

}
