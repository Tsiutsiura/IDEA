package TestOnBE;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GeneralMethods extends Assert {

   /* private int indicatorBrowser = 0;

    WebDriver driver;

    public TestOnBE.GeneralMethods(int browser) {
        this.indicatorBrowser = browser;,

        if(indicatorBrowser == 0) {
            this.driver = new FirefoxDriver();
        } else if (indicatorBrowser == 1) {
            this.driver = new ChromeDriver();
        } else {
            System.out.println("browser don`t check");
        }
    }*/

    public GeneralMethods() {
    }

    static WebDriver driver = new FirefoxDriver();
    static Actions actions = new Actions(GeneralMethods.driver);

    public void openSite(String s) {
        driver.get(s);
        driver.manage().window().maximize();
    }

    public WebElement finder(String st) {
        return driver.findElement(By.xpath(st));
    }

    public void sleep(int time) {
        //явное ожидание
        try {  Thread.sleep(time); } catch (InterruptedException e) {e.printStackTrace(); }
        //неявное ожидание
       /* driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);*/

    }

    public void workWithPopUp() {
        FluentWait wait = new WebDriverWait(GeneralMethods.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='bio_ep_close']")));
        finder("//span[@id='bio_ep_close']").click();
    }

    /*public String workWithOF() {
        WebElement fieldFirstName = finder("//input[@id='firstname']");
        WebElement fieldLastName = finder("//input[@id='lastname']");
        WebElement fieldEmail = finder("//input[@id='email']");
        WebElement fieldMobilePhone = finder("//input[@id='mobile-phone']");
        WebElement fieldTopic = finder("//input[@id='topic']");
        WebElement fieldDoctype = finder("//select[@id='doctype']");

        fieldFirstName.sendKeys("test");
        fieldLastName.sendKeys("test");
        fieldEmail.sendKeys("tsiutsiura.test1@gmail.com");
        fieldMobilePhone.sendKeys("44123456789");
        fieldTopic.sendKeys("test order");
        actions.moveToElement(fieldDoctype).moveToElement(finder("//select[@id='doctype']//option[@value='13']")).click().perform();

        WebElement fieldUrgency = finder("//select[@id='urgency']");
        actions.moveToElement(fieldUrgency).moveToElement(finder("//select[@id='urgency']//option[@value='5']")).click().perform();
        WebElement fieldNumPages = finder("//select[@id='numpages']");
        actions.moveToElement(fieldNumPages).moveToElement(finder("//select[@id='numpages']//option[@value='3']")).click().perform();
        WebElement fieldOrderCategory = finder("//select[@id='order_category']");
        actions.moveToElement(fieldOrderCategory).moveToElement(finder("//select[@id='order_category']//option[@value='13']")).click().perform();
        WebElement fieldOrderDescription = finder("//textarea[@id='details']");
        fieldOrderDescription.sendKeys("test order ");

        String cppOF = finder("//div[@id = 'price-per-page-bl']//div [@class ='prices-num-block']").getText();
        System.out.println("CPP = " + cppOF);

        String totalOF = finder("//div[@id='price-total-bl']//div [@class ='prices-num-block']").getText();
        System.out.println("Total on OF = " + totalOF);

        submitOF();

        sleep(5000);
        return totalOF;
    }

    public void submitOF() {
        WebElement buttonSubmit = finder("//input[@id='submit_order_form']");
        actions.moveToElement(buttonSubmit).click().perform();
        sleep(5000);
    }
*/
    public String workWithPreview() {
        String cppPreview = finder("//div[@id = 'price-per-page-bl']//div [@class ='prices-num-block']").getText();
        System.out.println("CPP = " + cppPreview);

        String totalPreview = finder("//div[@id='price-total-bl']//div [@class ='prices-num-block']").getText();
        System.out.println("Total on OF = " + totalPreview);

        sleep(5000);
        actions.moveToElement(finder("//div[@class ='button-block-submit']//input[@class='edit_order_proceed']")).click().perform();

        sleep(5000);
        return totalPreview;
    }

    public void workWithPageStoreCredit() {
        actions.moveToElement(finder("//input[@id='skip_credit']")).click().perform();
        sleep(5000);
    }

    public String workWithPaymentForm() {
        String totalPayment = finder("//td[@id='order_total']//div [@class ='order_total__sum']").getText();
        System.out.println("Total on Payment = " + totalPayment);

        finder("//input[@id = 'cc_number']").sendKeys("4111111111111111");
        actions.moveToElement(finder("//select[@id = 'exp_month']")).click()
                .moveToElement(finder("//select[@id = 'exp_month']//option[@value='1']")).click().perform();
        actions.moveToElement(finder("//select[@id = 'exp_year']")).click()
                .moveToElement(finder("//select[@id = 'exp_year']//option[@value='19']")).click().perform();
        finder("//input[@id = 'cvv2']").sendKeys("123");
        finder("//input[@id = 'firstname']").sendKeys("test");
        finder("//input[@id = 'lastname']").sendKeys("test");
        finder("//input[@id = 'address']").sendKeys("test");
        finder("//input[@id = 'city']").sendKeys("South park");
        actions.moveToElement(finder("//select[@id = 'country']")).click().moveToElement(finder("//select[@id = 'country']//option[@value='US']")).click().perform();
        finder("//input[@id = 'zip']").sendKeys("1234567");
        finder("//input[@id = 'phone']").sendKeys("123456789");
        actions.moveToElement(finder("//input[@id = 'submit_billing_form']")).click().perform();

        sleep(30000);

        return totalPayment;
    }

    public void workWithThankYouPage() {
        System.out.println(GeneralMethods.driver.getCurrentUrl());
        String orderNumber = finder("//div [@class ='order-summary']").getText();
        System.out.println(orderNumber);
        sleep(5000);
    }
}
