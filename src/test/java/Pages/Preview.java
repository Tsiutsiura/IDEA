package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;



public class Preview {
    private By buttonSubmitLocator = By.xpath("//div[@class ='button-block-submit']//input[@class='edit_order_proceed']");
    private By cppLocator = By.xpath("//div[@id = 'price-per-page-bl']//div [@class ='prices-num-block']");
    private By totalLocator = By.xpath("//div[@id='price-total-bl']//div [@class ='prices-num-block']");
    private String cppPreview;
    private String totalPreview;

    private WebDriver driver;
    private Actions actions ;

    public Preview(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public String getCppPreview() {
        return cppPreview;
    }
    public String getTotalPreview() {
        return totalPreview;
    }

    public Preview submitOrderForm() {
        actions.moveToElement(driver.findElement(buttonSubmitLocator)).click().perform();
        return this;
    }
    public Preview cppOrderForm() {
        cppPreview = driver.findElement(cppLocator).getText();
        System.out.println("CPP on preview = " + cppPreview);
        return this;
    }
    public Preview totalOrderForm() {
        totalPreview = driver.findElement(totalLocator).getText();
        System.out.println("Total on preview = " + totalPreview);
        return this;
    }

}
