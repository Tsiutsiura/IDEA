package Pages;

import com.sun.javafx.image.BytePixelSetter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class StoreCreditPage {
    private By skipCreditButtonLocator = By.xpath("//input[@id='skip_credit']");

    private WebDriver driver;
    private Actions actions ;

    public StoreCreditPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public StoreCreditPage submitSkipCreditButton() {
        actions.moveToElement(driver.findElement(skipCreditButtonLocator)).click().perform();
        return this;
    }

}
